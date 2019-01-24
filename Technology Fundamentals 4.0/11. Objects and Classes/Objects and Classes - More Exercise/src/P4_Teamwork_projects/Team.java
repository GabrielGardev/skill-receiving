package P4_Teamwork_projects;

import java.util.List;

public class Team {
    private String Name;
    private String Creator;
    private List<String> Members;

    public Team(String name, String creator, List<String> members) {
        Name = name;
        Creator = creator;
        Members = members;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public List<String> getMembers() {
        return Members;
    }

    public void setMembers(List<String> members) {
        Members = members;
    }
}
