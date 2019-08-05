package softuni.accountsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import softuni.accountsystem.repositories.AccountRepository;

import java.math.BigDecimal;
@Service
@Primary
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        int i = accountRepository.findById(id).get().getBalance().subtract(money).compareTo(BigDecimal.ZERO);
        if (!accountRepository.existsAccountById(id)
                || i > 0){
            //pass
        }else {
            accountRepository
                    .findById(id)
                    .get()
                    .setBalance(accountRepository
                            .findById(id).get()
                            .getBalance()
                            .subtract(money));
        }

    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        if(money.compareTo(BigDecimal.ZERO) > 0
                && accountRepository.findById(id).get().getUser().getId() == id){
            //transfers money
        }
    }
}
