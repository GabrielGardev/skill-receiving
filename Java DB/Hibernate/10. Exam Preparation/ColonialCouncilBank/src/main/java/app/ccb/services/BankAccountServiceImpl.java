package app.ccb.services;

import app.ccb.domain.dtos.BankAccountImportDto;
import app.ccb.domain.dtos.BankAccountRootImportDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Client;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.ClientRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private static final String BANK_ACCOUNTS_XML_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\ColonialCouncilBank\\src\\main\\resources\\files\\xml\\bank-accounts.xml";
    private final FileUtil fileUtil;
    private final BankAccountRepository bankAccountRepository;
    private final ClientRepository clientRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    @Autowired
    public BankAccountServiceImpl(FileUtil fileUtil, BankAccountRepository bankAccountRepository, ClientRepository clientRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.bankAccountRepository = bankAccountRepository;
        this.clientRepository = clientRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean bankAccountsAreImported() {
        return this.bankAccountRepository.count() != 0;
    }

    @Override
    public String readBankAccountsXmlFile() throws IOException {
        return this.fileUtil.readFile(BANK_ACCOUNTS_XML_FILE_PATH);
    }

    @Override
    public String importBankAccounts() throws JAXBException{

        StringBuilder importResult = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(BankAccountRootImportDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        BankAccountRootImportDto bankAccountRootImportDto = (BankAccountRootImportDto) unmarshaller.unmarshal(new File(BANK_ACCOUNTS_XML_FILE_PATH));

        for (BankAccountImportDto bankAccountImportDto : bankAccountRootImportDto.getBankAccountImportDtos()) {

            if (!this.validationUtil.isValid(bankAccountImportDto)) {

                importResult.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());

                continue;
            }

            Client client = this.clientRepository
                    .getByFullName(bankAccountImportDto.getClientName())
                    .orElse(null);

            if (client == null) {
                importResult.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());
                continue;
            }

            BankAccount bankAccount = this.modelMapper.map(bankAccountImportDto, BankAccount.class);
            bankAccount.setClient(client);

            this.bankAccountRepository.saveAndFlush(bankAccount);

            importResult.append(String.format("Successfully imported Bank Account - %s.", bankAccount.getAccountNumber()))
                    .append(System.lineSeparator());

        }

        return importResult.toString().trim();

    }
}
