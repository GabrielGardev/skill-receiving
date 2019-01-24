package softuni.ebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softuni.ebank.bindingModels.BankAccountBindingModel;
import softuni.ebank.entities.BankAccount;
import softuni.ebank.entities.Transaction;
import softuni.ebank.entities.User;
import softuni.ebank.repositories.BankAccountRepository;
import softuni.ebank.repositories.TransactionRepository;
import softuni.ebank.repositories.UserRepository;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/accounts")
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public BankAccountController(BankAccountRepository bankAccountRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBankAccount(@ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel,
                                    Principal principal, Model model){
        bankAccountBindingModel.setUsername(principal.getName());
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("view", "accounts/create-account");

        return "fragments/layout";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBankAccountConfirm(@ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel,
                                     Model model){
        if (!this.createAccount(bankAccountBindingModel)) {
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            model.addAttribute("view", "accounts/create-account");

            return "fragments/layout";
        }
        return "redirect:/home";
    }

    private BankAccountBindingModel extractAccountForTransaction(Long id) {
        BankAccount bankAccount = this.bankAccountRepository.findById(id).orElse(null);

        if (bankAccount == null) {
            throw new IllegalArgumentException("Invalid Bank Account!");
        }

        BankAccountBindingModel bankAccountBindingModel = new BankAccountBindingModel();
        bankAccountBindingModel.setId(id);
        bankAccountBindingModel.setUsername(bankAccount.getOwner().getUsername());
        bankAccountBindingModel.setIban(bankAccount.getIban());

        return bankAccountBindingModel;
    }

    private boolean depositAmount(BankAccountBindingModel bankAccountBindingModel) {
        BankAccount bankAccount = this.bankAccountRepository.findById(bankAccountBindingModel.getId()).orElse(null);

        if (bankAccount == null) {
            return false;
        } else if (bankAccountBindingModel.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        bankAccount.setBalance(bankAccount.getBalance().add(bankAccountBindingModel.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setType("DEPOSIT");
        transaction.setFrom(bankAccount);
        transaction.setTo(bankAccount);
        transaction.setAmount(bankAccountBindingModel.getAmount());
        this.transactionRepository.save(transaction);

        this.bankAccountRepository.save(bankAccount);
        return true;
    }

    private boolean createAccount(BankAccountBindingModel bankAccountBindingModel) {
        if (bankAccountBindingModel.getIban() == null || bankAccountBindingModel.getIban().equals("")) {
            return false;
        }

        User user = this.userRepository.findByUsername(bankAccountBindingModel.getUsername());

        if (user == null) {
            return false;
        }

        BankAccount bankAccount = new BankAccount();
        bankAccount.setOwner(user);
        bankAccount.setIban(bankAccountBindingModel.getIban());
        bankAccount.setBalance(BigDecimal.ZERO);

        this.bankAccountRepository.save(bankAccount);
        return true;
    }

    @GetMapping("/deposit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deposit(@PathVariable("id")Long id,Model model){
        BankAccountBindingModel bankAccountBindingModel = this.extractAccountForTransaction(id);
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("view", "accounts/deposit");

        return "fragments/layout";
    }

    @PostMapping("/deposit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String depositConfirm(@PathVariable("id")Long id,Model model,
                                 @ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel){
        if (!this.depositAmount(bankAccountBindingModel)){
            model.addAttribute("view", "accounts/deposit");
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

            return "fragments/layout";
        }
        return "redirect:/home";
    }

    @GetMapping("/withdraw/{id}")
    public String withdraw(@PathVariable("id")Long id,Model model){
        BankAccountBindingModel bankAccountBindingModel = this.extractAccountForTransaction(id);
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("view", "accounts/withdraw");

        return "fragments/layout";
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawConfirm(@PathVariable("id")Long id, Model model,
                                  @ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel){
        if (!this.withdrawAmount(bankAccountBindingModel)){
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            model.addAttribute("view", "accounts/withdraw");

            return "fragments/layout";
        }

        return "redirect:/home";
    }

    private boolean withdrawAmount(BankAccountBindingModel bankAccountBindingModel){

        BankAccount bankAccount = this.bankAccountRepository.findById(bankAccountBindingModel.getId()).orElse(null);

        if (bankAccount == null){
            return false;
        }else if (bankAccountBindingModel.getAmount().compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }else if (bankAccount.getBalance().compareTo(bankAccountBindingModel.getAmount()) < 0){
            return false;
        }

        bankAccount.setBalance(bankAccount.getBalance().subtract(bankAccountBindingModel.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setType("WITHDRAW");
        transaction.setFrom(bankAccount);
        transaction.setTo(bankAccount);
        transaction.setAmount(bankAccountBindingModel.getAmount());

        this.transactionRepository.save(transaction);
        this.bankAccountRepository.save(bankAccount);
        return true;
    }

    @GetMapping("/transfer/{id}")
    @PreAuthorize("isAuthenticated()")
    public String transfer(@PathVariable("id")Long id, Model model){
        BankAccountBindingModel bankAccountBindingModel = this.extractAccountForTransaction(id);
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("bankAccounts", this.bankAccountRepository.findAll().
                stream().filter(ba -> !ba.getId().equals(id)).collect(Collectors.toList()));
        model.addAttribute("view", "accounts/transfer");

        return "fragments/layout";
    }

    @PostMapping("/transfer/{id}")
    @PreAuthorize("isAuthenticated()")
    public String transferConfirm(@PathVariable("id")Long id, Model model,
                                  @ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel){
        if (!this.transferAmount(bankAccountBindingModel)){
            model.addAttribute("view", "accounts/transfer");

            return "fragments/layout";
        }
        return "redirect:/home";
    }

    private boolean transferAmount(BankAccountBindingModel bankAccountBindingModel) {
        BankAccount from = this.bankAccountRepository.findById(bankAccountBindingModel.getId()).orElse(null);
        BankAccount to = this.bankAccountRepository.findById(bankAccountBindingModel.getReceiverId()).orElse(null);

        if (from == null || to == null) {
            return false;
        }else if (bankAccountBindingModel.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        from.setBalance(from.getBalance().subtract(bankAccountBindingModel.getAmount()));

        if (from.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        to.setBalance(to.getBalance().add(bankAccountBindingModel.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setType("TRANSFER");
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setAmount(bankAccountBindingModel.getAmount());


        this.transactionRepository.save(transaction);
        this.bankAccountRepository.save(from);
        this.bankAccountRepository.save(to);
        return true;
    }

}
