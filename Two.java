package Practic.Final;

import java.util.Scanner;

public class Two {
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //�����������
    public Two(PlayerField field) throws ArrayIndexOutOfBoundsException {
        try {
            Scanner s1 = new Scanner(System.in);
            String[] lineStr;
            String line = s1.nextLine();
            lineStr = line.split(",");
            x1 = Integer.parseInt(lineStr[0]);
            y1 = Integer.parseInt(lineStr[1]);
            x2 = Integer.parseInt(lineStr[2]);
            y2 = Integer.parseInt(lineStr[3]);

            if(lineStr.length != 4){
                System.out.println("� ������������� ������� ������ ���� 2 ����������!");
                removeCoordinates(field);
            }

        } catch (ArrayIndexOutOfBoundsException id) {
            System.out.println("� ������������� ������� ������ ���� 2 ����������!");
            removeCoordinates(field);
        }
        if(getX1() < 0 | getX1() > 9 | getY1() < 0 | getY1() > 9 | getX2() < 0 | getX2() > 9 | getY2() < 0 | getY2() > 9) {
            System.out.println("���������� ������� ������ ���� � ������� �� 0 �� 9!");
            removeCoordinates(field);
        }
        if(getX1() == getX2()){
            if(getY1() == getY2()) {
                System.out.println("� ���� ������ ������� �� ����� ���� ���������� ����������!");
                removeCoordinates(field);
            }
        }
        if(getY1() == getY2()){
            if(getX1() == getX2()) {
                System.out.println("� ���� ������ ������� �� ����� ���� ���������� ����������!");
                removeCoordinates(field);
            }
        }
        if(field.getField()[getY1()][getX1()].equals(String.valueOf(Ships.AREAL)) | field.getField()[getY2()][getX2()].equals(String.valueOf(Ships.AREAL))){
            System.out.println("���������� ����� ��������� ������ ���� �� ������ 1 ������!");
            removeCoordinates(field);
        }
        if(getX1() == getX2()) {
            if(getY2() != getY1() + 1 & getY2() != getY1() - 1){
                System.out.println("����� ������� �� ����� ���� ����������� ���������!");
                removeCoordinates(field);
            }
        }
        if(getY1() == getY2()){
            if(getX2() != getX1() + 1 & getX2() != getX1() - 1){
                System.out.println("����� ������� �� ����� ���� ����������� ���������!");
                removeCoordinates(field);
            }
        }

        //����������� ������ � �������
        //������� �� �������� �����
        if(getX1() != 0 & getX2() != 0 & getX1() != 9 & getX2() != 9 & getY1() != 0 & getY1() != 9 & getY2() != 0 & getY2() != 9){
            if(getY1() == getY2()){
                if(getX1() < getX2()){
                    for(int i = getY1() - 1; i <= getY1() + 1; i++){
                        for(int j = getX1() - 1; j <= getX1() + 2; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    return;
                }
                if(getX2() < getX1()){
                    for(int i = getY2() - 1; i <= getY2() + 1; i++){
                        for(int j = getX2() - 1; j <= getX2() + 2; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }
            if(getX1() == getX2()){
                if(getY1() < getY2()){
                    for(int i = getY1() - 1; i <= getY1() + 2; i++){
                        for(int j = getX1() - 1; j <= getX1() + 1; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }
            if(getY1() > getY2()){
                for(int i = getY2() - 1; i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //������� ����� � ����
        //����� ������� ����
        if(getX1() == 0 & getY1() == 0){
            if(getX2() == 0){
                for(int i = getY1(); i <= getY1() + 2; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 1){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 0 & getY2() == 0){
            if(getX1() == 0){
                for(int i = getY2(); i <= getY2() + 2; i++){
                    for(int j = getX2(); j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 1){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //����� ������ ����
        if(getX1() == 0 & getY1() == 9){
            if(getX2() == 0){
                for(int i = getY1() - 2; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 1){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 0 & getY2() == 9){
            if(getX1() == 0){
                for(int i = getY2() - 2; i <= getY2(); i++){
                    for(int j = getX2(); j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 1){
                for(int i = getY2() - 1; i <= getY2(); i++){
                    for(int j = getX2(); j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ������ ����
        if(getX1() == 9 & getY1() == 9){
            if(getX2() == 8){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 2; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 9){
                for(int i = getY1() - 3; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 9 & getY2() == 9){
            if(getX1() == 8){
                for(int i = getY2() - 1; i <= getY2(); i++){
                    for(int j = getX2() - 2; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 9){
                for(int i = getY2() - 2; i <= getY2(); i++){
                    for(int j = getX2() - 1; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ������� ����
        if(getX1() == 9 & getY1() == 0){
            if(getX2() == 9){
                for(int i = getY1(); i <= getY1() + 2; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 8){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 2; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 9 & getY2() == 0){
            if(getX1() == 9){
                for(int i = getY2(); i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 8){
                for(int i = getY2(); i <= getY2() + 1; i++){
                    for(int j = getX2() - 2; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //����� �������� �������� ����
        //����� ����
        if(getX1() == 0 & getX2() == 0 & getY1() != 0 & getY2() != 0 & getY1() != 9 & getY2() != 9){
            if(getY1() < getY2()){
                for(int i = getY1() - 1; i<=getY1() + 2; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY2()){
                for(int i = getY2() - 1; i <= getY2() + 2; i++){
                    for(int j = getX2(); j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ����
        if(getX1() == 9 & getX2() == 9 & getY1() != 0 & getY2() != 0 & getY1() != 9 & getY2() != 9){
            if(getY1() < getY2()){
                for(int i = getY1() - 1; i <= getY1() + 2; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY2()){
                for(int i = getY2() - 1; i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� ����
        if(getY1() == 0 & getY2() == 0 & getX1() != 0 & getX2() != 0 & getX1() != 9 & getX2() != 9){
            if(getX1() < getX2()){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX2()){
                for(int i = getY2(); i <= getY2() + 1; i++){
                    for(int j = getX2() - 1; j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ����
        if(getY1() == 9 & getY2() == 9 & getX1() != 0 & getX2() != 0 & getX1() != 9 & getX2() != 9){
            if(getX1() < getX2()){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX2()){
                for(int i = getY2() - 1; i <= getY2(); i++){
                    for(int j = getX2() - 1; j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //������� �������� ���� ����� �������
        //������� �������� ������ ����
        if(getX1() == 0 & getX2() == 1 | getX2() == 0 & getX1() == 1 & getY1() != 0 & getY2() != 9 & getY1() != 9 & getY2() != 0){
            if(getX1() == 0){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 0){
                for(int i = getY2() - 1; i <= getY2() + 1; i++){
                    for(int j = getX2(); j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� �������� ������� ����
        if(getX1() == 9 & getX2() == 8| getX2() == 9 & getX1() != 8 & getY1() != 0 & getY2() != 9 & getY1() != 9 & getY2() != 0){
            if(getX1() == 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 2; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 9){
                for(int i = getY2() - 1; i <= getY2() + 1; i++){
                    for(int j = getX2() - 2; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� �������� �������� ����
        if(getY1() == 0 & getY2() == 1 | getY2() == 0 & getY1() == 1 & getX1() != 0 & getX1() != 9 & getX2() != 0 & getX2() != 9){
            if(getY1() == 0){
                for(int i = getY1(); i <= getY1() + 2; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY2() == 0){
                for(int i = getY2(); i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� �������� ������� ����
        if(getY1() == 9 | getY2() == 9 & getX1() != 0 & getX1() != 9 & getX2() != 0 & getX2() != 9){
            if(getY1() == 9){
                for(int i = getY1() - 3; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY2() == 9){
                for(int i = getY2() - 2; i <= getY2(); i++){
                    for(int j = getX2() - 1; j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
    }

    public void removeCoordinates(PlayerField field) {
        try {
            System.out.println("������� ������ ����������!");
            Scanner s1 = new Scanner(System.in);
            String[] lineStr;
            String line = s1.nextLine();
            lineStr = line.split(",");
            x1 = Integer.parseInt(lineStr[0]);
            y1 = Integer.parseInt(lineStr[1]);
            x2 = Integer.parseInt(lineStr[2]);
            y2 = Integer.parseInt(lineStr[3]);

            if(lineStr.length != 4){
                System.out.println("� ������������� ������� ������ ���� 2 ����������!");
                removeCoordinates(field);
            }

        } catch (ArrayIndexOutOfBoundsException id) {
            System.out.println("� ������������� ������� ������ ���� 2 ����������!");
            removeCoordinates(field);
        }
        if(getX1() < 0 | getX1() > 9 | getY1() < 0 | getY1() > 9 | getX2() < 0 | getX2() > 9 | getY2() < 0 | getY2() > 9) {
            System.out.println("���������� ������� ������ ���� � ������� �� 0 �� 9!");
            removeCoordinates(field);
        }
        if(getX1() == getX2()){
            if(getY1() == getY2()) {
                System.out.println("� ���� ������ ������� �� ����� ���� ���������� ����������!");
                removeCoordinates(field);
            }
        }
        if(getY1() == getY2()){
            if(getX1() == getX2()) {
                System.out.println("� ���� ������ ������� �� ����� ���� ���������� ����������!");
                removeCoordinates(field);
            }
        }
        if(field.getField()[getY1()][getX1()].equals(String.valueOf(Ships.AREAL)) | field.getField()[getY2()][getX2()].equals(String.valueOf(Ships.AREAL))){
            System.out.println("���������� ����� ��������� ������ ���� �� ������ 1 ������!");
            removeCoordinates(field);
        }
        if(getX1() == getX2()) {
            if(getY2() != getY1() + 1 & getY2() != getY1() - 1){
                System.out.println("����� ������� �� ����� ���� ����������� ���������!");
                removeCoordinates(field);
            }
        }
        if(getY1() == getY2()){
            if(getX2() != getX1() + 1 & getX2() != getX1() - 1){
                System.out.println("����� ������� �� ����� ���� ����������� ���������!");
                removeCoordinates(field);
            }
        }

        //����������� ������ � �������
        //������� �� �������� �����
        if(getX1() != 0 & getX2() != 0 & getX1() != 9 & getX2() != 9 & getY1() != 0 & getY1() != 9 & getY2() != 0 & getY2() != 9){
            if(getY1() == getY2()){
                if(getX1() < getX2()){
                    for(int i = getY1() - 1; i <= getY1() + 1; i++){
                        for(int j = getX1() - 1; j <= getX1() + 2; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    return;
                }
                if(getX2() < getX1()){
                    for(int i = getY2() - 1; i <= getY2() + 1; i++){
                        for(int j = getX2() - 1; j <= getX2() + 2; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }
            if(getX1() == getX2()){
                if(getY1() < getY2()){
                    for(int i = getY1() - 1; i <= getY1() + 2; i++){
                        for(int j = getX1() - 1; j <= getX1() + 1; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }
            if(getY1() > getY2()){
                for(int i = getY2() - 1; i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //������� ����� � ����
        //����� ������� ����
        if(getX1() == 0 & getY1() == 0){
            if(getX2() == 0){
                for(int i = getY1(); i <= getY1() + 2; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 1){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 0 & getY2() == 0){
            if(getX1() == 0){
                for(int i = getY2(); i <= getY2() + 2; i++){
                    for(int j = getX2(); j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 1){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //����� ������ ����
        if(getX1() == 0 & getY1() == 9){
            if(getX2() == 0){
                for(int i = getY1() - 2; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 1){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 0 & getY2() == 9){
            if(getX1() == 0){
                for(int i = getY2() - 2; i <= getY2(); i++){
                    for(int j = getX2(); j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 1){
                for(int i = getY2() - 1; i <= getY2(); i++){
                    for(int j = getX2(); j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ������ ����
        if(getX1() == 9 & getY1() == 9){
            if(getX2() == 8){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 2; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 9){
                for(int i = getY1() - 3; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 9 & getY2() == 9){
            if(getX1() == 8){
                for(int i = getY2() - 1; i <= getY2(); i++){
                    for(int j = getX2() - 2; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 9){
                for(int i = getY2() - 2; i <= getY2(); i++){
                    for(int j = getX2() - 1; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ������� ����
        if(getX1() == 9 & getY1() == 0){
            if(getX2() == 9){
                for(int i = getY1(); i <= getY1() + 2; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 8){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 2; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX2() == 9 & getY2() == 0){
            if(getX1() == 9){
                for(int i = getY2(); i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() == 8){
                for(int i = getY2(); i <= getY2() + 1; i++){
                    for(int j = getX2() - 2; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //����� �������� �������� ����
        //����� ����
        if(getX1() == 0 & getX2() == 0 & getY1() != 0 & getY2() != 0 & getY1() != 9 & getY2() != 9){
            if(getY1() < getY2()){
                for(int i = getY1() - 1; i<=getY1() + 2; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY2()){
                for(int i = getY2() - 1; i <= getY2() + 2; i++){
                    for(int j = getX2(); j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ����
        if(getX1() == 9 & getX2() == 9 & getY1() != 0 & getY2() != 0 & getY1() != 9 & getY2() != 9){
            if(getY1() < getY2()){
                for(int i = getY1() - 1; i <= getY1() + 2; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY2()){
                for(int i = getY2() - 1; i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� ����
        if(getY1() == 0 & getY2() == 0 & getX1() != 0 & getX2() != 0 & getX1() != 9 & getX2() != 9){
            if(getX1() < getX2()){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX2()){
                for(int i = getY2(); i <= getY2() + 1; i++){
                    for(int j = getX2() - 1; j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������ ����
        if(getY1() == 9 & getY2() == 9 & getX1() != 0 & getX2() != 0 & getX1() != 9 & getX2() != 9){
            if(getX1() < getX2()){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX2()){
                for(int i = getY2() - 1; i <= getY2(); i++){
                    for(int j = getX2() - 1; j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //������� �������� ���� ����� �������
        //������� �������� ������ ����
        if(getX1() == 0 & getX2() == 1 | getX2() == 0 & getX1() == 1 & getY1() != 0 & getY2() != 9 & getY1() != 9 & getY2() != 0){
            if(getX1() == 0){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 0){
                for(int i = getY2() - 1; i <= getY2() + 1; i++){
                    for(int j = getX2(); j <= getX2() + 2; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� �������� ������� ����
        if(getX1() == 9 & getX2() == 8| getX2() == 9 & getX1() != 8 & getY1() != 0 & getY2() != 9 & getY1() != 9 & getY2() != 0){
            if(getX1() == 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 2; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 9){
                for(int i = getY2() - 1; i <= getY2() + 1; i++){
                    for(int j = getX2() - 2; j <= getX2(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� �������� �������� ����
        if(getY1() == 0 & getY2() == 1 | getY2() == 0 & getY1() == 1 & getX1() != 0 & getX1() != 9 & getX2() != 0 & getX2() != 9){
            if(getY1() == 0){
                for(int i = getY1(); i <= getY1() + 2; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY2() == 0){
                for(int i = getY2(); i <= getY2() + 2; i++){
                    for(int j = getX2() - 1; j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //������� �������� ������� ����
        if(getY1() == 9 | getY2() == 9 & getX1() != 0 & getX1() != 9 & getX2() != 0 & getX2() != 9){
            if(getY1() == 9){
                for(int i = getY1() - 3; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY2() == 9){
                for(int i = getY2() - 2; i <= getY2(); i++){
                    for(int j = getX2() - 1; j <= getX2() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
    }


    //set/get ������
    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX1() {
        return x1;
    }

    public String toString() {
        return getX1() + " " + getY1() + " " + getX2() + " " + getY2();
    }
}
