package app.ccb.services;

import app.ccb.domain.dtos.ClientImportDto;
import app.ccb.domain.entities.Card;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.ClientRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientServiceImpl implements ClientService {

    private final static String CLIENTS_JSON_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\clients.json";

    private final ClientRepository clientRepository;

    private final EmployeeRepository employeeRepository;

    private final FileUtil fileUtil;

    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, EmployeeRepository employeeRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean clientsAreImported() {
        return this.clientRepository.count() != 0;
    }

    @Override
    public String readClientsJsonFile() throws IOException {
        return this.fileUtil.readFile(CLIENTS_JSON_FILE_PATH);
    }

    @Override
    public String importClients(String clients) {
        StringBuilder importResult = new StringBuilder();

        ClientImportDto[] clientImportDtos = this.gson.fromJson(clients, ClientImportDto[].class);

        for (ClientImportDto clientImportDto : clientImportDtos) {

            if (!this.validationUtil.isValid(clientImportDto)) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Employee employee = this.employeeRepository.findByFullName(clientImportDto.getAppointedEmployee()).orElse(null);

            if (employee == null) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Client clientEntity = this.clientRepository
                    .getByFullName(String.format("%s %s", clientImportDto.getFirstName(), clientImportDto.getLastName()))
                    .orElse(null);

            if (clientEntity != null) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Client client = this.modelMapper.map(clientImportDto, Client.class);
            client.setFullName(String.format("%s %s", clientImportDto.getFirstName(), clientImportDto.getLastName()));
            client.getEmployees().add(employee);

            this.clientRepository.saveAndFlush(client);

            importResult.append(String.format("Successfully imported Client - %s", client.getFullName()))
                    .append(System.lineSeparator());
        }


        return importResult.toString().trim();
    }

    @Override
    public String exportFamilyGuy() {

        StringBuilder exportResult = new StringBuilder();

        Client familyGuy = this.clientRepository.exportFamilyGuy();

        exportResult.append("Full Name: ")
                .append(familyGuy.getFullName())
                .append(System.lineSeparator())
                .append("Age: ")
                .append(familyGuy.getAge())
                .append(System.lineSeparator())
                .append("Bank Account: ")
                .append(familyGuy.getBankAccount().getAccountNumber())
                .append(System.lineSeparator());

        for (Card card : familyGuy.getBankAccount().getCards()) {

            exportResult.append("   Card Number: ")
                    .append(card.getCardNumber())
                    .append(System.lineSeparator())
                    .append("   Card status: ")
                    .append(card.getCardStatus())
                    .append(System.lineSeparator());
        }


        return exportResult.toString().trim();
    }
}
