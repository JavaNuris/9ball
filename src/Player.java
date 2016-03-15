import Ball.Ball;

/**
 * Created by Admin on 08.03.2016.
 */
public class Player {

    private String name;
    private Ball[] balls = new Ball[9];
    private Ball[] basket = new Ball[1];
    public Ball[] getCells() {
        return balls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalls(int cell, int value) {
        balls[cell] = new Ball(value);
    }
    public void setKingBall(int basketCell , int value){
        basket[basketCell] = new Ball(value);
    }

    public int getBalls(int cell) {
        return balls[cell].getDateNumber() ;
    }

    public int getKingBalls(int kingCell){
        return  basket[kingCell].getDateNumber();
    }

}
