import java.util.Scanner;

/**
 * Created by Admin on 08.03.2016.
 */
public class Main  {
    static BattleField battleField;
    static int  s = 0;
    public static void main(String [] args) {
        battleField = new BattleField();
        battleField.playerDate();

        for(int i = 0; i <=8 ; i++){
            System.out.print(" "+battleField.getPlayerOne().getBalls(i)+" |");
        }
        System.out.println();
        System.out.println("-------------------------------------");
        for(int i = 0; i <=8 ; i++){
            System.out.print(" "+battleField.getPlayerTwo().getBalls(i)+" |");
        }
        System.out.println();
        System.out.println("Казна");
        System.out.println("Первый игрок :" + battleField.getPlayerBoxOne());
        System.out.println("Второй игрок :" + battleField.getPlayerBoxTwo());

        while (true) {
            s++;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите целое число: ");
            if (sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                System.out.println(s);
                if(s%2 == 0)
                    battleField.mainLogicGame(battleField.getPlayerTwo(), sc.nextInt());
                else if(s%2 == 1)
                    battleField.mainLogicGame(battleField.getPlayerOne(), sc.nextInt());
                for(int  i = 0; i<=8 ; i++){
                    System.out.print(" "+battleField.getPlayerOne().getBalls(i)+" |");
                }
                System.out.println();
                System.out.println("-------------------------------------");
                for(int  i = 0; i<=8 ; i++){
                    System.out.print(" "+battleField.getPlayerTwo().getBalls(i)+" |");
                }
                System.out.println();
                System.out.println("Казна");
                System.out.println("Первый игрок :" + battleField.getPlayerBoxOne());
                System.out.println("Второй игрок :" + battleField.getPlayerBoxTwo());
                 } else {
                System.out.println("Вы ввели не целое число");
            }
        }
    }

    }


