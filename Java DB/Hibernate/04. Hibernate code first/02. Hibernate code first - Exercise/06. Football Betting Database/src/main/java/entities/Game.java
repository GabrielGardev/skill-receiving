package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private Date dateTime;
    private double homeWinBetRate;
    private double awayWinBetRate;
    private double drawBetRate;
    private Round round;
    private Competition competition;


    public Game() {
    }

    public Game(Team homeTeam, Team awayTeam,
                int homeGoals, int awayGoals,
                Date dateTime, double homeWinBetRate,
                double awayWinBetRate, double drawBetRate,
                Round round, Competition competition) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.dateTime = dateTime;
        this.homeWinBetRate = homeWinBetRate;
        this.awayWinBetRate = awayWinBetRate;
        this.drawBetRate = drawBetRate;
        this.round = round;
        this.competition = competition;
    }

    @ManyToOne
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    @Column(name = "away_team_goals")
    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Column(name = "date_time")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "home_team_win_bet_rate")
    public double getHomeWinBetRate() {
        return homeWinBetRate;
    }

    public void setHomeWinBetRate(double homeWinBetRate) {
        this.homeWinBetRate = homeWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate")
    public double getAwayWinBetRate() {
        return awayWinBetRate;
    }

    public void setAwayWinBetRate(double awayWinBetRate) {
        this.awayWinBetRate = awayWinBetRate;
    }

    @Column(name = "draw_game_bet_rate")
    public double getDrawBetRate() {
        return drawBetRate;
    }

    public void setDrawBetRate(double drawBetRate) {
        this.drawBetRate = drawBetRate;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
