/**
 * Created by Admin on 08.03.2016.
 */
public class BattleField {
    private Player playerOne;
    private Player playerTwo;

    private  int playerBoxOne ;
    private  int playerBoxTwo;

private  int varible;
    public BattleField(){
        playerOne = new Player();
        playerTwo = new Player();
    }

    public Player getPlayerOne() {
        return playerOne;
    }
    public int getPlayerBoxOne() {
        return playerBoxOne;
    }

    public int getPlayerBoxTwo() {
        return playerBoxTwo;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }

    public  void playerDate(){
        for(int i = 0; i<=8 ; i++){
            playerOne.setBalls(i ,9);
            playerTwo.setBalls(i , 9);
        }
    }
    public void mainLogicGame(Player player , int currentBox) {
        int currentValue = player.getBalls(currentBox);
        varible = currentBox + currentValue - 8 -2;
        int minus = 8 - currentBox;
        if (currentBox == 8 && player.getBalls(currentBox) == 1) {
            if (player == playerOne) {
                playerOne.setBalls(currentBox, 0);
                playerTwo.setBalls(0, playerTwo.getBalls(0) + 1);
                if (playerTwo.getBalls(0) % 2 == 0) {
                    playerOne.setKingBall(0 , playerOne.getBalls(0));
                    playerBoxOne +=playerOne.getKingBalls(0);
                    playerTwo.setBalls(0, 0);

                }
            } else if (player == playerTwo) {
                playerTwo.setBalls(currentBox, 0);
                playerOne.setBalls(0, playerOne.getBalls(0) + 1);
                if (playerOne.getBalls(0) % 2 == 0) {
                    playerTwo.setKingBall(0 , playerTwo.getBalls(0));
                    playerBoxTwo +=playerTwo.getKingBalls(0);
                    playerOne.setBalls(0, 0);
                }
            }
        }

        if (player.getBalls(currentBox) == 1) {
            player.setBalls(currentBox, 0);
            player.setBalls(currentBox + 1, player.getBalls(currentBox + 1) + 1);
        } else if (player.getBalls(currentBox) == 0) {
            player.setBalls(currentBox, 0);
        } else {
            player.setBalls(currentBox, 1);
            for (int i = 0; i <= minus; i++) {
                if (i == 0) {
                    player.setBalls(currentBox + i, player.getBalls(currentBox + i));
                } else {
                    player.setBalls(currentBox + i, player.getBalls(currentBox + i) + 1);
                }
            }
        }
        if(player == playerOne)
            onesOne(varible);
        else if(player == playerTwo)
            onesTwo(varible);

    }
    public void onesTwo(int x){
        {
            int s = x;
            if (s <= 8) {
                for (int i = 0; i <= x; i++) {
                    playerOne.setBalls(i, playerOne.getBalls( i) + 1);
                    if(playerOne.getBalls(x)%2 == 0){
                        playerTwo.setKingBall(0 , playerOne.getBalls(x));
                        playerBoxTwo +=playerTwo.getKingBalls(0);
                        playerOne.setBalls(x ,0);
                    }
                    s--;
                }
            } else if (s > 8) {
                for (int i = 0; i <= 8; i++) {
                    playerOne.setBalls(i, playerOne.getBalls(i) + 1);
                    s--;
                }
            }
            if (s >= 0) {
                twosTwo(s);
            } else {
                System.out.println("Завершило");
            }
        }


    }

    public void twosTwo(int x){
        {
            int s = x;
            if (s <= 8) {
                for (int i = 0; i <= x; i++) {
                    playerTwo.setBalls(i, playerTwo.getBalls( i) + 1);
                    s--;
                }
            }else if(s> 8){
                for(int i = 0; i <=8 ; i++){
                    playerTwo.setBalls(i ,playerTwo.getBalls(i)+1);
                    s--;
                }

            }
            if(s >= 0){
                onesOne(s);
            }else {
                System.out.println("Завершило");
            }
        }

    }

    public void onesOne(int x) {
        int s = x;
        if (s <= 8) {
            for (int i = 0; i <= x; i++) {
                playerTwo.setBalls(i, playerTwo.getBalls( i) + 1);
                if(playerTwo.getBalls(x)%2 == 0){
                    playerOne.setKingBall(0 , playerTwo.getBalls(x));
                    playerBoxOne +=playerOne.getKingBalls(0);
                    playerTwo.setBalls(x ,0);
                }
                s--;
            }
        } else if (s > 8) {
            for (int i = 0; i <= 8; i++) {
                playerTwo.setBalls(i, playerTwo.getBalls(i) + 1);
                s--;
            }
        }
        if (s >= 0) {
            twosOne(s);
        } else {
            System.out.println("Завершило");
        }
    }

    public void twosOne(int x) {
        int s = x;
        if (s <= 8) {
            for (int i = 0; i <= x; i++) {
                playerOne.setBalls(i, playerOne.getBalls( i) + 1);
                s--;
            }
        }else if(s> 8){
            for(int i = 0; i <=8 ; i++){
                playerOne.setBalls(i ,playerOne.getBalls(i)+1);
                s--;
            }

        }
        if(s >= 0){
            onesOne(s);
        }else {
            System.out.println("Завершило");
        }
    }
}

