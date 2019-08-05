package entities;

import javax.persistence.*;

@Entity(name = "players")
public class Player extends BaseEntityWithName{
    private int squadNumber;
    private Team team;
    private Position position;
    private boolean isCurrentlyInjured;

    public Player() {
    }

    public Player(String name, int squadNumber, Team team, Position position, boolean isCurrentlyInjured) {
        super(name);
        this.squadNumber = squadNumber;
        this.team = team;
        this.position = position;
        this.isCurrentlyInjured = isCurrentlyInjured;
    }

    @Column(name = "squad_number")
    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "is_injured")
    public boolean isCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setCurrentlyInjured(boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
    }
}
