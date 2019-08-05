package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bet_games")
public class BetGame implements Serializable {
    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;

    public BetGame(Game game, Bet bet, ResultPrediction resultPrediction) {
        this.game = game;
        this.bet = bet;
        this.resultPrediction = resultPrediction;
    }

    public BetGame() {
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @ManyToOne
    @JoinColumn(name = "result_prediction", referencedColumnName = "id")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game.getDateTime(), bet.getDateAndTimeOfBet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetGame)) return false;
        BetGame that = (BetGame) o;
        return Objects.equals(game.getDateTime(), that.game.getDateTime()) &&
                Objects.equals(bet.getDateAndTimeOfBet(), that.bet.getDateAndTimeOfBet());
    }
}
