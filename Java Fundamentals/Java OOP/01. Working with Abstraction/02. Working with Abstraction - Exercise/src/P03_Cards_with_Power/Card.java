package P03_Cards_with_Power;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calculatePower(){
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }
}
