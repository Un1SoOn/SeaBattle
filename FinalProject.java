package Practic.Final;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Random r1 = new Random();
        int turn = r1.nextInt(1, 3);
        PlayerField field1 = new PlayerField(new String[10][10]);
        System.out.println("������ ���� � ������� ���, ��� ���������� �������� ���� ���!");
        System.out.print("������ �����, ");
        field1.startGame();
        PlayerField field2 = new PlayerField(new String[10][10]);
        System.out.print("������ �����, ");
        field2.startGame();

        if (turn == 1) {
            System.out.println("������ ����������� ������� ����� ����� " + field1.getName());
            System.out.println("���� ����� ����������� ���� �������, ��� ��������� �� ������������! \n������ ����������� ��������!");
            field1.addShips(field1);
            System.out.println("������ ������� ����������� ����� " + field2.getName() + "\n���� ����� ����������� ���� �������, ��� ��������� �� ������������!");
            field2.addShips(field2);
        } else {
            System.out.println("������ ����������� ������� ����� ����� " + field2.getName());
            System.out.println("���� ����� ����������� ���� �������, ��� ��������� �� ������������! \n������ ����������� ��������!");
            field2.addShips(field2);
            System.out.println("������ ������� ����������� ����� " + field1.getName() + "\n���� ����� ����������� ���� �������, ��� ��������� �� ������������!");
            field1.addShips(field1);
        }

        turn = r1.nextInt(1, 3);
        if (turn == 1) {
            System.out.println("������ ��������!");
            System.out.println("������ ����� �������� ����� " + field1.getName());
            field1.shot(field1, field2);
        } else {
            System.out.println("������ ��������!");
            System.out.println("������ ����� �������� ����� " + field2.getName());
            field2.shot(field2, field1);
        }
    }
}