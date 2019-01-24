package softuni.ebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.ebank.repositories.BankAccountRepository;

import java.security.Principal;

@Controller
public class HomeController {
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public HomeController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("view","index");
        return "fragments/layout";

    }
    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public String home(Principal principal, Model model){
        model.addAttribute("username",principal.getName());
        model.addAttribute("accounts", this.bankAccountRepository.findAllByOwnerUsername(principal.getName()));
        model.addAttribute("view","home");
        return "fragments/layout";
    }
}
