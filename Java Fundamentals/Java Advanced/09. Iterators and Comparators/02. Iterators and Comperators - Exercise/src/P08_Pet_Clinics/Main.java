package P08_Pet_Clinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());

        HashMap<String , Clinic> clinics = new HashMap<>();
        HashMap<String , Pet> pets = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] cmd = reader.readLine().split("\\s+");
            String command = cmd[0];

            if (command.equals("Create")){
                if (cmd[1].equals("Pet")){
                    Pet pet = new Pet(cmd[2], Integer.parseInt(cmd[3]), cmd[4]);
                    pets.putIfAbsent(cmd[2], pet);
                }else if (cmd[1].equals("Clinic")){
                    try {
                        Clinic clinic = new Clinic(cmd[2], Integer.parseInt(cmd[3]));
                        clinics.putIfAbsent(cmd[2], clinic);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }else if (command.equals("Add")){
                System.out.println(clinics.get(cmd[2]).add(pets.get(cmd[1])));
            }else if (command.equals("Release")){
                System.out.println(clinics.get(cmd[1]).release());
            }else if (command.equals("HasEmptyRooms")){
                System.out.println(clinics.get(cmd[1]).hasEmptyRooms());
            }else if (command.equals("Print")){
                if (cmd.length == 2){
                    Print(clinics.get(cmd[1]));
                }else {
                    Print(clinics.get(cmd[1]), Integer.parseInt(cmd[2]) - 1);
                }
            }
        }
    }

    private static void Print(Clinic clinic, int room) {
            if (clinic.getRooms()[room] == null){
                System.out.println("Room empty");
            }else {
                System.out.println(clinic.getRooms()[room].toString());
            }
    }

    private static void Print(Clinic clinic) {
        for (int i = 0; i < clinic.getRooms().length; i++) {
            Print(clinic, i);
        }
    }
}
