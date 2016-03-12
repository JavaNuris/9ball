/**
 * Created by Admin on 08.03.2016.
 */
public class BattleField {
    private Player playerOne;
    private Player playerTwo;
    private int varibleForOne = 0;

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
    public void mainLogicPlayer(Player player ,int numberCell) {
        int currentVarInCell = player.getBalls(numberCell);
        varibleForOne = numberCell + currentVarInCell;
         int minus = 9 - numberCell;

        if(currentVarInCell == 1){
            player.setBalls(numberCell , 0);
            player.setBalls(numberCell+1 , player.getBalls(numberCell+1)+1);
        }
        else if(currentVarInCell == 0){
            player.setBalls(numberCell , 0);
        }else {
        for (int z = 0; z < minus; z++) {
            if(z == 0){
            }else {
                player.setBalls(numberCell ,1);
                player.setBalls(numberCell+z, player.getBalls(numberCell+ z) + 1);
            }
            leftSteps =varibleForOne-z-numberCell-1;
        }
        System.out.println(leftSteps);
        if(player == getPlayerOne())
        twos(leftSteps);
        else if(player == getPlayerTwo()) {
            ones(leftSteps);
        }}
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

