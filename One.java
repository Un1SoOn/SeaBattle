package Practic.Final;

import java.util.Scanner;

public class One {
    Scanner s1 = new Scanner(System.in);
    private int x1;
    private int y1;


    //конструктор
    public One(PlayerField field) throws ArrayIndexOutOfBoundsException {
        try {
            Scanner s1 = new Scanner(System.in);
            String[] lineStr;
            String line = s1.nextLine();
            lineStr = line.split(",");
            x1 = Integer.parseInt(lineStr[0]);
            y1 = Integer.parseInt(lineStr[1]);

            if(lineStr.length != 2){
                System.out.println("У однопалубного корабля должно быть 2 координаты!");
                removeCoordinates(field);
            }

        } catch (ArrayIndexOutOfBoundsException id) {
            System.out.println("У однопалубного корабля должно быть 2 координаты!");
            removeCoordinates(field);
        }

        if(getX1() < 0 | getX1() > 9 | getY1() < 0 | getY1() > 9) {
            System.out.println("Координаты корабля должны быть в пределе от 0 до 9!");
            removeCoordinates(field);
        }
        if(field.getField()[getY1()][getX1()].equals(String.valueOf(Ships.AREAL))){
            System.out.println("Расстояние между кораблями должно быть не меньше 1 клетки!");
            removeCoordinates(field);
        }
        if(field.getField()[getY1()][getX1()].equals(String.valueOf(Ships.EMPTY))){
            if(getX1() == 0 && getY1() == 0){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 9 && getY1() == 0){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 0 && getY1() == 9){
                for(int i = getY1() - 1;i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 9 && getY1() == 9){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 0 && getY1() != 0 && getY1() != 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 9 & getY1() != 0 && getY1() != 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getY1() == 0 && getX1() != 0 && getX1() != 9){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getY1() == 9 && getX1() != 0 && getX1() != 9){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() != 0 && getX1() != 9 && getY1() != 0 && getY1() != 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
        }
    }

    public void removeCoordinates(PlayerField field){
        try {
            System.out.println("Введите верные координаты!");
            Scanner s1 = new Scanner(System.in);
            String[] lineStr;
            String line = s1.nextLine();
            lineStr = line.split(",");
            x1 = Integer.parseInt(lineStr[0]);
            y1 = Integer.parseInt(lineStr[1]);

            if(lineStr.length != 2){
                System.out.println("У однопалубного корабля должно быть 2 координаты!");
                removeCoordinates(field);
            }

        } catch (ArrayIndexOutOfBoundsException id) {
            System.out.println("У однопалубного корабля должно быть 2 координаты!");
            removeCoordinates(field);
        }

        if(x1 < 0 | x1 > 9 | y1 < 0 | y1 > 9) {
            System.out.println("Координаты корабля должны быть в пределе от 0 до 9!");
            removeCoordinates(field);
        }

        if(field.getField()[getY1()][getX1()].equals(String.valueOf(Ships.AREAL))){
            System.out.println("Расстояние между кораблями должно быть не меньше 1 клетки!");
            removeCoordinates(field);
        }

        //выставление корабля и ареола

        if(field.getField()[getY1()][getX1()].equals(String.valueOf(Ships.EMPTY))){
            if(getX1() == 0 && getY1() == 0){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 9 && getY1() == 0){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 0 && getY1() == 9){
                for(int i = getY1() - 1;i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 9 && getY1() == 9){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 0 && getY1() != 0 && getY1() != 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() == 9 & getY1() != 0 && getY1() != 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getY1() == 0 && getX1() != 0 && getX1() != 9){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getY1() == 9 && getX1() != 0 && getX1() != 9){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
            if(getX1() != 0 && getX1() != 9 && getY1() != 0 && getY1() != 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
            }
        }
    }


    //set/get методы
    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    @Override
    public String toString() {
        return getX1() + " " + getY1();
    }
}
