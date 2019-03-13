package P06_Football_Team_Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }
            String[] command = line.split(";");
            String teamName = command[1];

            switch (command[0]) {
                case "Team":
                    Team team = new Team(teamName);
                    teams.putIfAbsent(teamName, team);
                    break;
                case "Add":
                    if (!teams.containsKey(teamName)) {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                        continue;
                    }
                    int endurance = Integer.parseInt(command[3]);
                    int sprint = Integer.parseInt(command[4]);
                    int dribble = Integer.parseInt(command[5]);
                    int passing = Integer.parseInt(command[6]);
                    int shooting = Integer.parseInt(command[7]);

                    Player player = new Player();
                    try {
                         player = new Player(command[2], endurance, sprint, dribble, passing, shooting);

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    teams.get(teamName).addPlayer(player);
                    break;
                case "Remove":
                    if (!teams.containsKey(teamName)){
                        System.out.println(String.format("Team %s does not exist.", teamName));
                        continue;
                    }

                    try {
                        teams.get(teamName).removePlayer(command[2]);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teams.containsKey(teamName)) {
                        System.out.println(String.format("Team %s does not exist.", teamName));
                        continue;
                    }
                    System.out.println(String.format("%s - %d", teamName,
                            Math.round(teams.get(teamName).getRating())));
                    break;
            }
        }
    }
}
