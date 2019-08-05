package softuni.accountsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import softuni.accountsystem.models.Account;
import softuni.accountsystem.models.User;
import softuni.accountsystem.repositories.AccountRepository;
import softuni.accountsystem.repositories.UserRepository;
import softuni.accountsystem.services.AccountServiceImpl;
import softuni.accountsystem.services.UserServiceImpl;

import java.math.BigDecimal;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User example = new User();
        example.setUsername("example");
        example.setAge(20);

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));

        example.getAccounts().add(account);
        userService.registerUser(example);

        accountService.withdrawMoney(new BigDecimal(20000), account.getId());
        accountService.transferMoney(new BigDecimal(20000), 1L);
    }
}
