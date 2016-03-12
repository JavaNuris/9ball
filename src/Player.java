/**
 * Created by Admin on 08.03.2016.
 */
public class Player {

    private String name;
    private int[] cells = new int[9];
    private int[] basket = new int [1];

    public int[] getKing() {
        return basket;
    }

    public int[] getCells() {
        return cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalls(int cell, int value) {

        cells[cell] = value;
    }
    public void setKingBalls(int basketCell , int value){
        basket[basketCell] = value;
    }
    public int getBalls(int cell) {
        return cells[cell];
    }
    public int getKingBalls(int kingCell){
        return basket[kingCell];
    }
}
