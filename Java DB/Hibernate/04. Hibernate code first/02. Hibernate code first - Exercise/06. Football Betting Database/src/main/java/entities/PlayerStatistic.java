package entities;

import entities.Game;
import entities.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "player_statistics")
public class PlayerStatistic implements Serializable {

    private Game game;

    private Player player;

    private Integer scoredGoals;

    private Integer playerAssists;

    private Integer playedMinutes;

    public PlayerStatistic() {
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes")
    public Integer getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(Integer playedMinutes) {
        this.playedMinutes = playedMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerStatistic)) return false;
        PlayerStatistic that = (PlayerStatistic) o;
        return Objects.equals(game.getDateTime(), that.game.getDateTime()) &&
                Objects.equals(player.getName(), that.player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(game.getDateTime(), player.getName());
    }
}