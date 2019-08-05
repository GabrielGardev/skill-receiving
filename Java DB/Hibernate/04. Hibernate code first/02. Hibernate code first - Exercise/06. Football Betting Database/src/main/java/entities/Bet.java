package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {
    private BigDecimal betMoney;
    private Date dateAndTimeOfBet;
    private User user;

    public Bet() {
    }

    public Bet(BigDecimal betMoney, Date dateAndTimeOfBet, User user) {
        this.betMoney = betMoney;
        this.dateAndTimeOfBet = dateAndTimeOfBet;
        this.user = user;
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time")
    public Date getDateAndTimeOfBet() {
        return dateAndTimeOfBet;
    }

    public void setDateAndTimeOfBet(Date dateAndTimeOfBet) {
        this.dateAndTimeOfBet = dateAndTimeOfBet;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
