package P4_Teamwork_projects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("-");
            String creator = line[0];
            String teamName = line[1];
            Team team = new Team(teamName, creator, new ArrayList<>());

            boolean hadTeamName = false;
            boolean hadCreatorName = false;
            if (teams.size() >= 1) {
                for (Team team1 : teams) {
                    if (team1.getName().contains(teamName)) {
                        System.out.println(String.format("Team %s was already created!", teamName));
                        hadTeamName = true;
                        break;
                    }
                }
                if (hadTeamName){
                    continue;
                }
                for (Team team1 : teams) {
                    if (team1.getCreator().contains(creator)) {
                        System.out.println(String.format("%s cannot create another team!", creator));
                        hadCreatorName = true;
                        break;
                    }
                }
                if (hadCreatorName){
                    continue;
                }
                    teams.add(team);
                    System.out.println(String.format("Team %s has been created by %s!",
                            team.getName(), team.getCreator()));

            } else {
                teams.add(team);
                System.out.println(String.format("Team %s has been created by %s!",
                        team.getName(), team.getCreator()));
            }
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end of assignment")) {
                break;
            }
            String[] line = input.split("->");

            String user = line[0];
            String teamName = line[1];

            boolean teamExist = false;
            for (Team team : teams) {
                if (team.getName().equals(teamName)) {
                    teamExist = true;
                }
            }

            if (!teamExist) {
                System.out.println(String.format("Team %s does not exist!", teamName));
                continue;
            }

            boolean memberExist = false;
            for (Team team : teams) {
                if (team.getCreator().equals(user)){
                    System.out.println(String.format("Member %s cannot join team %s!",user, teamName));
                    memberExist = true;
                    break;
                }
                for (var member : team.getMembers()) {
                    if (member.equals(user)){
                        System.out.println(String.format("Member %s cannot join team %s!",user, teamName));
                        memberExist = true;
                        break;
                    }
                }
                if (memberExist){
                    break;
                }
            }
            if (memberExist){
                continue;
            }
            for (Team team : teams) {
                if (team.getName().equals(teamName)){
                    team.getMembers().add(user);
                    break;
                }
            }
        }

        teams.stream()
                .filter(x -> x.getMembers().size() > 0)
                .sorted((a ,b) -> {
                    int size1 = b.getMembers().size();
                    int size2 = a.getMembers().size();

                    if (size1 - size2 == 0){
                        return a.getName().compareTo(b.getName());
                    }
                    return Integer.compare(size1, size2);
                }).forEach(x -> {
            System.out.println(x.getName());
            System.out.println(String.format("- %s", x.getCreator()));
                    x.getMembers().stream()
                            .sorted(String::compareTo)
                            .forEach(m -> {
                                System.out.println(String.format("-- %s", m));
                            });
        });
        System.out.println("Teams to disband:");
        teams.stream()
                .filter(x -> x.getMembers().size() == 0)
                .sorted(Comparator.comparing(Team::getName))
                .forEach(x -> {
                    System.out.println(x.getName());
                });
    }
}
