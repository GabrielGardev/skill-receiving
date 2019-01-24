import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_Quests_Journal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        while (true){
           String[] line = scanner.nextLine().split(" - ");
           if (line[0].equals("Retire!")){
               break;
           }
           String cmd = line[0];

           if (cmd.equals("Start")){
               String quest = line[1];

               if (journal.contains(quest) == false){
                   journal.add(quest);
               }
           }else if (cmd.equals("Complete")){
               String quest = line[1];

               if (journal.contains(quest)){
                   journal.remove(quest);
               }
           }else if (cmd.equals("Side Quest")){
               String[] currentQuests = line[1].split(":");
               String quest = currentQuests[0];
               String sideQ = currentQuests[1];

               if (journal.contains(quest)){
                   if (journal.contains(sideQ) == false){
                     int index =  journal.indexOf(quest);

                     journal.add(index + 1, sideQ);
                   }
               }
           }else if (cmd.equals("Renew")){
               String quest = line[1];

               if (journal.contains(quest)){
                   journal.remove(quest);
                   journal.add(quest);
               }
           }
        }
        System.out.println(String.join(", ", journal));
    }
}
