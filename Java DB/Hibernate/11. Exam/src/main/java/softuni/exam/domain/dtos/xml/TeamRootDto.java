package softuni.exam.domain.dtos.xml;

import softuni.exam.domain.entities.Team;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamRootDto {

    @XmlElement(name = "team")
    private TeamDto[] teams;

    public TeamDto[] getTeams() {
        return teams;
    }

    public void setTeams(TeamDto[] teams) {
        this.teams = teams;
    }
}
