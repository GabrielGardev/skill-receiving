package bankaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        while (true){
            String[] line = reader.readLine().split(" ");
            String command = line[0];

            String result = "";
            if (command.equals("End")){
                break;
            }

            switch (command){
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    result = "Account ID" + account.getId() + " created";
                    break;
                case "Deposit":
                    int accountId = Integer.parseInt(line[1]);
                    double amount = Double.parseDouble(line[2]);

                    if (accounts.containsKey(accountId)){
                        BankAccount currentAccount = accounts.get(accountId);
                        currentAccount.deposit(amount);
                        accounts.put(accountId, currentAccount);

                        result = String.format("Deposited %.0f to ID%d", amount, accountId);
                    }else {
                        result = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(line[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int Id = Integer.parseInt(line[1]);
                    int years = Integer.parseInt(line[2]);

                    if (accounts.containsKey(Id)){
                        BankAccount currentAccount = accounts.get(Id);

                        double interestRate = currentAccount.getInterestRate(years);

                        result = String.format("%.2f",interestRate);
                    }else {
                        result = "Account does not exist";
                    }
                    break;

            }
            if (!result.equals("")){
                System.out.println(result);
            }
        }
    }
}
