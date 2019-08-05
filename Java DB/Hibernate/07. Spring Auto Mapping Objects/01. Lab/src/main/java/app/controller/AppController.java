package app.controller;

import app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
@Transactional
public class AppController implements CommandLineRunner {

    private EmployeeService employeeService;
    private BufferedReader reader;


    @Autowired
    public AppController(EmployeeService employeeService, BufferedReader reader) {
        this.employeeService = employeeService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {

        String input = reader.readLine();
        System.out.println(this.employeeService.addListOfEmployees(input));

    }

    private void createEmployee() throws IOException {

        String tokens = this.reader.readLine();
        this.employeeService.persist(tokens);
    }
}
