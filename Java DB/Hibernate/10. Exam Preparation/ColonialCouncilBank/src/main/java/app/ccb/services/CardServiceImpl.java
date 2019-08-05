package app.ccb.services;

import app.ccb.domain.dtos.CardImportDto;
import app.ccb.domain.dtos.CardRootImportDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Card;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.CardRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class CardServiceImpl implements CardService {

    private static final String CARDS_XML_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\ColonialCouncilBank\\src\\main\\resources\\files\\xml\\cards.xml";

    private final CardRepository cardRepository;

    private final FileUtil fileUtil;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, BankAccountRepository bankAccountRepository) {
        this.cardRepository = cardRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Boolean cardsAreImported() {
        return this.cardRepository.count() != 0;
    }

    @Override
    public String readCardsXmlFile() throws IOException {

        return this.fileUtil.readFile(CARDS_XML_FILE_PATH);
    }

    @Override
    public String importCards() throws JAXBException {

        StringBuilder importResult = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(CardRootImportDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        CardRootImportDto cardRootImportDto = (CardRootImportDto) unmarshaller.unmarshal(new File(CARDS_XML_FILE_PATH));

        for (CardImportDto cardImportDto : cardRootImportDto.getCardImportDtos()) {

            if (!this.validationUtil.isValid(cardImportDto)) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            BankAccount bankAccount = this.bankAccountRepository.getByAccountNumber(cardImportDto.getAccountNumber()).orElse(null);

            if (bankAccount == null) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }


            Card card = this.modelMapper.map(cardImportDto, Card.class);
            card.setBankAccount(bankAccount);

            this.cardRepository.saveAndFlush(card);

            importResult.append(String.format("Successfully imported Card - %s", card.getCardNumber()))
                    .append(System.lineSeparator());
        }

        return importResult.toString().trim();

    }
}
