/**
 * Created by Admin on 08.03.2016.
 */
public class BattleField {
    private Player playerOne;
    private Player playerTwo;
    private int varibleForOne = 0;
    private int varibleForTwo = 0;
    private int currentBasKetNumberPlayerOne = 0;
    private int currentBasKetNumberPlayerTwo = 0;
    private int leftSteps = 0;
    public BattleField() {
        playerOne = new Player();
        playerTwo = new Player();

    }

    public int getCurrentBasKetNumberPlayerOne() {
        return currentBasKetNumberPlayerOne;
    }

    public int getCurrentBasKetNumberPlayerTwo() {
        return currentBasKetNumberPlayerTwo;
    }

    public void cardsPlayerOne() {
        for (int i = 0; i < 9; i++) {
            playerOne.setBalls(i, 9);
        }

    }

    public void cardsPlayerTwo() {
        for (int i = 0; i < 9; i++) {
            playerTwo.setBalls(i, 9);

        }

    }

    public void cardsReadPlayerOne() {
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + playerOne.getBalls(i) + " |");
        }
    }

    public void cardsReadPlayerTwo() {
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + playerTwo.getBalls(i) + " |");
        }

    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    /*Логика первого игрока*/
    public void mainLogicPlayerOne(int numberCell) {
        int currentVarInCell = playerOne.getBalls(numberCell);
        varibleForOne = numberCell + currentVarInCell;
         int minus = 9 - numberCell;
        for (int z = 0; z < minus; z++) {
            playerOne.setBalls(numberCell ,1);
            if(z == 0){
                /*были проблемы с перекидование шариков , в одну ячейку прибовлялось 2 шарика*/
                //playerOne.setBalls(numberCell+z, playerOne.getBalls(numberCell+ z) + 1);
            }else {
                playerOne.setBalls(numberCell+z, playerOne.getBalls(numberCell+ z) + 1);
            }
            leftSteps =varibleForOne-z-numberCell-1;
        }
        System.out.println(leftSteps);
        twos(leftSteps);
    }
    /*Логика второго игрока*/
    public void mainLogicPlayerTwo(int numberCell) {

        int currentVarInCell = playerTwo.getBalls(numberCell);
        varibleForTwo = numberCell + currentVarInCell;
        int minus = 9 - numberCell;
        for (int z = 0; z < minus; z++) {
            playerTwo.setBalls(numberCell ,1);
            if(z == 0){
                /*были проблемы с перекидование шариков , в одну ячейку прибовлялось 2 шарика*/
                //playerOne.setBalls(numberCell+z, playerOne.getBalls(numberCell+ z) + 1);
            }else {
                playerTwo.setBalls(numberCell+z, playerTwo.getBalls(numberCell+ z) + 1);
            }

            leftSteps =varibleForTwo-z-numberCell-1;
        }
        System.out.println(leftSteps);
        ones(leftSteps);

    }

    /*тут теперь просто расскидываем шарики , используеться рекурсия*/
    /*ячейки первого игрока*/
    private void ones(int x) {
        int s = x;
        if(s < 9){
            for (int z = 0; z < x; z++) {
                playerOne.setBalls(z, playerOne.getBalls(z) + 1);
                s--;/*лиюо дискремент*/
                  /*обнуляеет ячейку если она равна 0*/
                if(playerOne.getBalls(x-1)%2 == 0){
                    /*Копим в казне шарики*/
                    playerTwo.setKingBalls(0 , playerOne.getBalls(x-1));
                    currentBasKetNumberPlayerTwo += playerTwo.getKingBalls(0);
                    playerOne.setBalls(x-1 ,0);
                }
            }
        }else{
            for (int z = 0; z < 9; z++) {
                playerOne.setBalls(z, playerOne.getBalls(z) + 1);
                s--;/*лиюо дискремент*/
            }
        }
        System.out.println(s+ "на первом");

        if (s > 0) {
                twos(s);
            }else{
               // System.exit(0);
            }
    }
    /*ячейки второго игрока*/
    private void twos(int x) {
        int s = x;
        if(s < 9){
            for (int z = 0; z < x; z++) {
                playerTwo.setBalls(z, playerTwo.getBalls(z) + 1);
                s--;/*лиюо дискремент*/
                /*обнуляеет ячейку если она равна 0*/
                if(playerTwo.getBalls(x-1)%2 == 0){
                    playerOne.setKingBalls(0 , playerTwo.getBalls(x-1));
                    currentBasKetNumberPlayerOne += playerOne.getKingBalls(0);
                    playerTwo.setBalls(x-1 ,0);
                }
            }
        }else {
            for (int z = 0; z < 9; z++) {
                playerTwo.setBalls(z, playerTwo.getBalls(z) + 1);
                s--;
            }
        }
        if (s >0) {
                ones(s);
            }else{
               //System.exit(0);
            }
    }

    }

