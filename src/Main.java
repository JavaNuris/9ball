import java.util.Scanner;

/**
 * Created by Admin on 08.03.2016.
 */
public class Main  {



    public static void main(String [] args) {
        BattleField battleField = new BattleField();

        battleField.cardsPlayerOne();
        battleField.cardsPlayerTwo();
        battleField.cardsReadPlayerOne();
        System.out.println();
        System.out.print("-------------------------------------");
        System.out.println();
        battleField.cardsReadPlayerTwo();
        System.out.println();
        System.out.println();
        System.out.println("Казна");
        System.out.println("Первый игрок: " + battleField.getCurrentBasKetNumberPlayerTwo());
        System.out.println("Второй игрок: " + battleField.getCurrentBasKetNumberPlayerOne());
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите целое число: ");
            if (sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
                // считывает целое число с потока ввода и сохраняем в переменную
                battleField.mainLogicPlayerTwo(sc.nextInt());
                battleField.mainLogicPlayerOne(sc.nextInt());
                battleField.cardsReadPlayerOne();
                System.out.println();
                System.out.print("-------------------------------------");
                System.out.println();
                battleField.cardsReadPlayerTwo();
                System.out.println();
                System.out.println();
                System.out.println("Казна");
                System.out.println("Первый игрок: " + battleField.getCurrentBasKetNumberPlayerTwo());
                System.out.println("Второй игрок: " + battleField.getCurrentBasKetNumberPlayerOne());
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
    }
    }

