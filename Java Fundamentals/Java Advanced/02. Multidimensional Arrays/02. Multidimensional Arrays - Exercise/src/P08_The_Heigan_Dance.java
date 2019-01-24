import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08_The_Heigan_Dance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double dmgToBoss = Double.parseDouble(reader.readLine());

        Player player = new Player();
        player.Position = new int[] {7, 7};
        player.HP = 18500;
        player.Dmg = dmgToBoss;
        player.IsHitByCloud = false;

        double bossHP = 3000000;
        String spell = "";

        while (true){
            //check if the player is hit by Cloud
            if (player.IsHitByCloud){
                player.HP -= 3500;
                player.IsHitByCloud = false;
            }

            bossHP -= player.Dmg;

            if (isGameOver(player, bossHP, spell)){
               break;
            }

            String[] attack = reader.readLine().split(" ");
            spell = attack[0];
            int hitRow = Integer.parseInt(attack[1]);
            int hitCol = Integer.parseInt(attack[2]);

            if (isCellReached(player.Position[0], player.Position[1], hitRow, hitCol) && isPlayerDamaged(player, hitRow, hitCol)){

                switch (spell)
                {
                    case "Cloud":
                        player.HP -= 3500;
                        player.IsHitByCloud = true;
                        break;
                    case "Eruption":
                        player.HP -= 6000;
                        break;
                    default:
                        break;
                }
            }
            if (isGameOver(player, bossHP, spell)){
                break;
            }
        }


    }

    private static boolean isPlayerDamaged(Player player, int hitRow, int hitCol) {
        if (player.Position[0] > 0 &&
                !isCellReached(player.Position[0] - 1, player.Position[1], hitRow, hitCol)) // Try move Up
        {
            player.Position[0]--;
            return false;
        }

        if (player.Position[1] + 1 < 15 && // Dancing area is 15 by 15 matrix
                !isCellReached(player.Position[0], player.Position[1] + 1, hitRow, hitCol)) // Try move Right
        {
            player.Position[1]++;
            return false;
        }

        if (player.Position[0] + 1 < 15 && // Dancing area is 15 by 15 matrix
                !isCellReached(player.Position[0] + 1, player.Position[1], hitRow, hitCol)) // Try move Down
        {
            player.Position[0]++;
            return false;
        }

        if (player.Position[1] > 0 &&
                !isCellReached(player.Position[0], player.Position[1] - 1, hitRow, hitCol)) // Try move Left
        {
            player.Position[1]--;
            return false;
        }

        return true;
    }

    private static boolean isCellReached(int cellRow, int cellCol, int hitRow, int hitCol) {
        return (cellRow >= hitRow - 1) && (cellRow <= hitRow + 1) && (cellCol >= hitCol - 1) && (cellCol <= hitCol + 1);
    }

    private static boolean isGameOver(Player player, double bossHP, String spell) {
        if (player.HP <= 0 || bossHP <= 0){
            if (spell.equals("Cloud")){
                spell = "Plague Cloud";
            }

            if  (bossHP > 0){
                System.out.println(String.format("Heigan: %.2f",bossHP));
            }else {
                System.out.println("Heigan: Defeated!");
            }

            if (player.HP > 0){
                System.out.println(String.format("Player: %d", player.HP));
            }else {
                System.out.println(String.format("Player: Killed by %s", spell));
            }

            System.out.println(String.format("Final position: %d, %d", player.Position[0], player.Position[1]));

            return true;
        }
        return false;
    }

    static class Player {
        public int[] Position;

        public int HP;

        public double Dmg;

        public boolean IsHitByCloud;

        public Player() {

        }

    }
}
