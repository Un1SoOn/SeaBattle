package Practic.Final;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Random r1 = new Random();
        int turn = r1.nextInt(1, 3);
        PlayerField field1 = new PlayerField(new String[10][10]);
        System.out.println("Начнем игру в морской бой, вам необходимо написать ваше имя!");
        System.out.print("Первый игрок, ");
        field1.startGame();
        PlayerField field2 = new PlayerField(new String[10][10]);
        System.out.print("Второй игрок, ");
        field2.startGame();

        if (turn == 1) {
            System.out.println("Первым расставлять корабли будет игрок " + field1.getName());
            System.out.println("Пока игрок расставляет свои корабли, его противник не подглядывает! \nНачнем расстановку кораблей!");
            field1.addShips(field1);
            System.out.println("Теперь корабли расставляет игрок " + field2.getName() + "\nПока игрок расставляет свои корабли, его противник не подглядывает!");
            field2.addShips(field2);
        } else {
            System.out.println("Первым расставлять корабли будет игрок " + field2.getName());
            System.out.println("Пока игрок расставляет свои корабли, его противник не подглядывает! \nНачнем расстановку кораблей!");
            field2.addShips(field2);
            System.out.println("Теперь корабли расставляет игрок " + field1.getName() + "\nПока игрок расставляет свои корабли, его противник не подглядывает!");
            field1.addShips(field1);
        }

        turn = r1.nextInt(1, 3);
        if (turn == 1) {
            System.out.println("Начнем сражение!");
            System.out.println("Первым будет стрелять игрок " + field1.getName());
            field1.shot(field1, field2);
        } else {
            System.out.println("Начнем сражение!");
            System.out.println("Первым будет стрелять игрок " + field2.getName());
            field2.shot(field2, field1);
        }
    }
}