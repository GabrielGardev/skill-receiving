package P04_Mordors_Cruelty_Plan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {

    }

    public void eatFood(String food){
        switch (food.toLowerCase()){
            case "cram":
                this.foodPoints += 2;
                break;
            case "lembas":
                this.foodPoints += 3;
                break;
            case "apple":
            case "melon":
                this.foodPoints += 1;
                break;
            case "honeycake":
                this.foodPoints += 5;
                break;
            case "mushrooms":
                this.foodPoints -= 10;
                break;
            default:
                this.foodPoints -= 1;
                break;
        }
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }

    public String getMood(){
        String mood;

        if (this.foodPoints > 15) {
            mood = "JavaScript";
        } else if (this.foodPoints > -1) {
            mood = "Happy";
        } else if (this.foodPoints >= -5) {
            mood = "Sad";
        } else {
            mood = "Angry";
        }

        return mood;
    }
}
