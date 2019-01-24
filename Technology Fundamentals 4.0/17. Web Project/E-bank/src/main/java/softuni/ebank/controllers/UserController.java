package softuni.ebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.ebank.bindingModels.UserBindingModel;
import softuni.ebank.entities.Role;
import softuni.ebank.entities.Transaction;
import softuni.ebank.entities.User;
import softuni.ebank.repositories.RoleRepository;
import softuni.ebank.repositories.TransactionRepository;
import softuni.ebank.repositories.UserRepository;

import java.security.Principal;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TransactionRepository transactionRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          TransactionRepository transactionRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.transactionRepository = transactionRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    private void seedRolesInDb() {
        if (this.roleRepository.count() == 0) {
            Role role = new Role();
            role.setAuthority("USER");
            this.roleRepository.save(role);
        }
    }

    private boolean registerUser(UserBindingModel userBindingModel) {
        User user = this.userRepository.findByUsername(userBindingModel.getUsername());
        if (user != null) {
            return false;
        } else if (!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
            return false;
        }

        this.seedRolesInDb();

        Role role = this.roleRepository.findByAuthority("USER");
        if (role == null) {
            return false;
        }

        user = new User();
        user.setUsername(userBindingModel.getUsername());
        user.setEmail(userBindingModel.getEmail());
        user.setPassword(this.bCryptPasswordEncoder.encode(userBindingModel.getPassword()));
        user.getAuthorities().add(role);

        this.userRepository.save(user);

        return true;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String register(@ModelAttribute("userBindingModel")UserBindingModel userBindingModel,
                           Model model){
        model.addAttribute("userBindingModel", userBindingModel);
        model.addAttribute("view", "users/register-user");

        return "fragments/layout";
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public String registerConfirm(@ModelAttribute("userBindingModel")UserBindingModel userBindingModel,
                           Model model){
        if (!this.registerUser(userBindingModel)){
            model.addAttribute("userBindingModel", userBindingModel);
            model.addAttribute("view", "users/register-user");
            return "fragments/layout";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login(@ModelAttribute("userBindingModel")UserBindingModel userBindingModel,
                        Model model){
        model.addAttribute("userBindingModel", userBindingModel);
        model.addAttribute("view", "users/login-user");

        return "fragments/layout";
    }

    @GetMapping("/transactions")
    @PreAuthorize("isAuthenticated()")
    public String listTransactions(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        model.addAttribute("view", "users/transactions");
        model.addAttribute("transactions",
                this.transactionRepository.findAll().stream()
        .filter(t -> t.getFrom().getOwner().getUsername().equals(principal.getName())
        || t.getTo().getOwner().getUsername().equals(principal.getName()))
        .sorted(Comparator.comparing(Transaction::getType))
        .collect(Collectors.toList()));

        return "fragments/layout";
    }
}
