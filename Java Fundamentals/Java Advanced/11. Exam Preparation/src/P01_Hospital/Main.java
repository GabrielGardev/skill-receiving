package P01_Hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Department{
        public String name;
        public String[][] roomsAndBeds;

        public Department(String name) {
            this.roomsAndBeds = new String[20][3];
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, List<String>> doctorsPatients = new TreeMap<>();
        LinkedHashMap<String, Department> departments = new LinkedHashMap<>();

        while (true){
            String[] line = reader.readLine().split("\\s+");
            if (line[0].equals("Output")){
                break;
            }
            String departmentName = line[0];
            String doctor = line[1] + " " + line[2];
            String patient = line[3];

            if (!departments.containsKey(departmentName)){
                Department department = new Department(departmentName);
                fillDepartment(department.roomsAndBeds, patient);
                departments.put(departmentName, department);
            }else {
                fillDepartment(departments.get(departmentName).roomsAndBeds, patient);
            }

            doctorsPatients.putIfAbsent(doctor, new ArrayList<>());
            doctorsPatients.get(doctor).add(patient);
        }


        while (true) {
            String[] command = reader.readLine().split("\\s+");
            if (command[0].equals("End")){
                break;
            }

            if (command.length > 1) {
                try {
                    int room = Integer.parseInt(command[1]);
                    String department = command[0];
                    if (departments.containsKey(department)) {
                        printPatientsForExactRoom(departments.get(department), room - 1);
                    }
                } catch (Exception e) {
                    String doctor = command[0] + " " + command[1];
                    if (doctorsPatients.containsKey(doctor)) {
                        doctorsPatients.get(doctor)
                                .stream()
                                .sorted(String::compareTo)
                                .forEach(System.out::println);
                    }
                }
            } else {
                //department
                if (departments.containsKey(command[0])) {
                    Department currentDep = departments.get(command[0]);
                    printPatients(currentDep.roomsAndBeds);
                }
            }
        }
    }

    private static void printPatientsForExactRoom(Department department, int room) {
        String[] exactRoom = department.roomsAndBeds[room];
        Arrays.stream(exactRoom)
                .filter(Objects::nonNull)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    private static void printPatients(String[][] rooms) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 3; j++) {
                if (rooms[i][j] != null) {
                    System.out.println(rooms[i][j]);
                } else {
                    return;
                }
            }
        }
    }

    private static void fillDepartment(String[][] roomsAndBeds, String patient) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 3; j++) {
                if (roomsAndBeds[i][j] == null){
                    roomsAndBeds[i][j] = patient;
                    return;
                }
            }
        }
    }
}
