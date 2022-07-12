package Practic.Final;

import java.util.Scanner;

public class Four {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int x4;
    private int y4;

    //конструктор


    public Four(PlayerField field) {
        try {
            Scanner s1 = new Scanner(System.in);
            String[] lineStr;
            String line = s1.nextLine();
            lineStr = line.split(",");
            x1 = Integer.parseInt(lineStr[0]);
            y1 = Integer.parseInt(lineStr[1]);
            x2 = Integer.parseInt(lineStr[2]);
            y2 = Integer.parseInt(lineStr[3]);
            x3 = Integer.parseInt(lineStr[4]);
            y3 = Integer.parseInt(lineStr[5]);
            x4 = Integer.parseInt(lineStr[6]);
            y4 = Integer.parseInt(lineStr[7]);

            if(lineStr.length != 8){
                System.out.println("У четырехпалубного корабля должно быть 8 координат!");
                removeCoordinates(field);
            }

        } catch (ArrayIndexOutOfBoundsException id) {
            System.out.println("У четырехпалубного корабля должно быть 8 координат!");
            removeCoordinates(field);
        }
        if(getX1() < 0 | getX1() > 9 | getY1() < 0 | getY1() > 9 | getX2() < 0 | getX2() > 9 | getY2() < 0 | getY2() > 9 |
                getX3() < 0 | getX3() > 9 | getY3() < 0 | getY3() > 9 | getX4() < 0 | getX4() > 9 | getY4() < 0 | getY4() > 9 ) {
            System.out.println("Координаты корабля должны быть в пределе от 0 до 9!");
            removeCoordinates(field);
        }
        if(getX1() == getX2() & getX1() == getX3() & getX1() == getX4()){
            if(getY1() == getY2() | getY1() == getY3() | getY1() == getY4() | getY2() == getY3() | getY2() == getY4() | getY3() == getY4()) {
                System.out.println("У двух частей корабля не могут быть одинаковые координаты!");
                removeCoordinates(field);
            }
        }
        if(getY1() == getY2() & getY1() == getY3() & getY1() == getY4()){
            if(getX1() == getX2() | getX1() == getX3() | getX1() == getX4() | getX2() == getX3() | getX2() == getX4() | getX3() == getX4()) {
                System.out.println("У двух частей корабля не могут быть одинаковые координаты!");
                removeCoordinates(field);
            }
        }
        if(getX1() == getX2() & getY2() == getY1() + 1 | getY2() == getY1() - 1) {
            if(getX3() == getX1() & getY3() == getY1() - 1 | getY3() == getY1() + 1 | getY3() == getY1() + 2 | getY3() == getY1() - 2) {
                if(getX4() == getX1() & getY4() ==  getY1() + 3 | getY4() == getY1() - 3 | getY4() ==  getY1() + 2 | getY4() == getY1() - 2 |
                        getY4() ==  getY1() + 1 | getY4() == getY1() - 1) {

                } else {
                    System.out.println("Части корабля не могут находиться в отдельно!");
                    removeCoordinates(field);
                }
            } else {
                System.out.println("Части корабля не могут находиться в отдельно!");
                removeCoordinates(field);
            }
        } else if (getY1() == getY2() & getX2() == getX1() + 1 | getX2() == getX1() - 1){
            if(getY3() == getY1() & getX3() == getX1() + 1 | getX3() == getX1() - 1 | getX3() == getX1() + 2 | getX3() == getX1() - 2) {
                if(getY4() == getY1() & getX4() == getX1() + 3 | getX4() == getX1() - 3 | getX3() == getX1() + 2 | getX3() == getX1() - 2 |
                        getX3() == getX1() + 1 | getX3() == getX1() - 1) {

                } else {
                    System.out.println("Части корабля не могут находиться в отдельно!");
                    removeCoordinates(field);
                }
            } else {
                System.out.println("Части корабля не могут находиться в отдельно!");
                removeCoordinates(field);
            }
        } else {
            System.out.println("Части корабля не могут находиться в отдельно!");
            removeCoordinates(field);
        }

        //выставление ареола и корабля
        //корабль не касается углов
        if(getX1() != 0 & getX1() != 9 & getX4() != 0 & getX4() != 9 & getY1() != 0 & getY1() != 9 & getY4() != 0 & getY4() != 9){
            if(getX1() == getX4()){
                if(getY1() < getY4()){
                    for(int i = getY1() - 1; i <= getY1() + 4; i++){
                        for(int j = getX1() - 1; j <= getX1() + 1; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
                if(getY1() > getY4()){
                    for(int i = getY1() - 1; i <= getY1() + 1; i++){
                        for(int j = getX4() - 1; j <= getX4() + 4; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }
            if(getY1() == getY4()){
                if(getX1() < getX4()){
                    for(int i = getY1() - 1; i <= getY1() + 1; i++){
                        for(int j = getX1() - 1; j <= getX1() + 4; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
                if(getX1() > getX4()){
                    for(int i = getY4() - 1; i <= getY4() + 4; i++){
                        for(int j = getX1() - 1; j <= getX1() + 1; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }

        }

        //четырехпалубный корабль стоит в углу
        //левый верхний угол
        if(getX1() == 0 & getY1() == 0){
            if(getX2() == 1) {
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 0){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 0 && getY4() == 0){
            if(getX3() == 1) {
                for(int i = getY4(); i <= getY4() + 1; i++){
                    for(int j = getX4(); j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 0){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //левый нижний угол
        if(getX1() == 0 & getY1() == 9){
            if(getX2() == 0){
                for(int i = getY1() - 4; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 1){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 0 & getY4() == 9){
            if(getX3() == 0){
                for(int i = getY4() - 4; i <= getY4(); i++){
                    for(int j = getX4(); j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 1){
                for(int i = getY4() - 1; i <= getY4(); i++){
                    for(int j = getX4(); j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //правый нижний угол
        if(getX1() == 9 & getY1() == 9){
            if(getX2() == 8){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 4; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 9){
                for(int i = getY1() - 4; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 9 & getY4() == 9){
            if(getX3() == 8){
                for(int i = getY4() - 1; i <= getY4(); i++){
                    for(int j = getX4() - 4; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 9){
                for(int i = getY4() - 4; i <= getY4(); i++){
                    for(int j = getX4() - 1; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //правый верхний угол
        if(getX1() == 9 & getY1() == 0){
            if(getX2() == 9){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 8){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 4; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 9 & getY4() == 0){
            if(getX3() == 9){
                for(int i = getY4(); i <= getY4() + 4; i++){
                    for(int j = getX4() - 1; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 8){
                for(int i = getY4(); i <= getY4() + 1; i++){
                    for(int j = getX4() - 4; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }


        //четырехпалубный всеми палубами касается края
        //левый край
        if(getX1() == 0 & getX4() == 0 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 9){
            if(getY1() < getY4()){
                for(int i = getY1() - 1; i<=getY1() + 4; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY4()){
                for(int i = getY4() - 1; i <= getY4() + 4; i++){
                    for(int j = getX4(); j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //правый край
        if(getX1() == 9 & getX4() == 9 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 9){
            if(getY1() < getY4()){
                for(int i = getY1() - 1; i <= getY1() + 4; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY4()){
                for(int i = getY4() - 1; i <= getY4() + 4; i++){
                    for(int j = getX4() - 1; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //верхний край
        if(getY1() == 0 & getY4() == 0 & getX1() != 0 & getX4() != 9 & getX1() != 9 & getX4() != 9){
            if(getX1() < getX4()){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX4()){
                for(int i = getY4(); i <= getY4() + 1; i++){
                    for(int j = getX4() - 1; j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //нижний край
        if(getY1() == 9 & getY4() == 9 & getX1() != 0 & getX4() != 9 & getX1() != 9 & getX4() != 9){
            if(getX1() < getX4()){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX4()){
                for(int i = getY4() - 1; i <= getY4(); i++){
                    for(int j = getX4() - 1; j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается края одной палубой
        //корабль касается левого края
        if(getX1() == 0 & getX4() != 0 | getX4() == 0 & getX1() != 0 & getX2() != 0 & getX3() != 0 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 0){
            if(getX1() == 0){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX4() == 0){
                for(int i = getY4() - 1; i <= getY4() + 1; i++){
                    for(int j = getX4(); j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается правого края
        if(getX1() == 9 | getX4() == 9 & getX2() != 9 & getX3() != 9 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 0){
            if(getX1() == 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 4; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX4() == 9){
                for(int i = getY4() - 1; i <= getY4() + 1; i++){
                    for(int j = getX4() - 4; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается верхнего края
        if(getY1() == 0 & getY4() != 0 | getY4() == 0 | getY1() != 0 & getY2() != 0 & getY3() != 0 & getX1() != 0 & getX1() != 9 & getX4() != 0 & getX4() != 9){
            if(getY1() == 0){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY4() == 0){
                for(int i = getY4(); i <= getY4() + 4; i++){
                    for(int j = getX4() - 1; j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается нижнего края
        if(getY1() == 9 | getY4() == 9 & getY2() != 9 & getY3() != 9 & getX1() != 0 & getX1() != 9 & getX4() != 0 & getX4() != 9){
            if(getY1() == 9){
                for(int i = getY1() - 4; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY4() == 9){
                for(int i = getY4() - 4; i <= getY4(); i++){
                    for(int j = getX4() - 1; j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
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
            x2 = Integer.parseInt(lineStr[2]);
            y2 = Integer.parseInt(lineStr[3]);
            x3 = Integer.parseInt(lineStr[4]);
            y3 = Integer.parseInt(lineStr[5]);
            x4 = Integer.parseInt(lineStr[6]);
            y4 = Integer.parseInt(lineStr[7]);

            if(lineStr.length != 8){
                System.out.println("У четырехпалубного корабля должно быть 8 координат!");
                removeCoordinates(field);
            }

        } catch (ArrayIndexOutOfBoundsException id) {
            System.out.println("У четырехпалубного корабля должно быть 8 координат!");
            removeCoordinates(field);
        }
        if(getX1() < 0 | getX1() > 9 | getY1() < 0 | getY1() > 9 | getX2() < 0 | getX2() > 9 | getY2() < 0 | getY2() > 9 |
                getX3() < 0 | getX3() > 9 | getY3() < 0 | getY3() > 9 | getX4() < 0 | getX4() > 9 | getY4() < 0 | getY4() > 9 ) {
            System.out.println("Координаты корабля должны быть в пределе от 0 до 9!");
            removeCoordinates(field);
        }
        if(getX1() == getX2() & getX1() == getX3() & getX1() == getX4()){
            if(getY1() == getY2() | getY1() == getY3() | getY1() == getY4() | getY2() == getY3() | getY2() == getY4() | getY3() == getY4()) {
                System.out.println("У двух частей корабля не могут быть одинаковые координаты!");
                removeCoordinates(field);
            }
        }
        if(getY1() == getY2() & getY1() == getY3() & getY1() == getY4()){
            if(getX1() == getX2() | getX1() == getX3() | getX1() == getX4() | getX2() == getX3() | getX2() == getX4() | getX3() == getX4()) {
                System.out.println("У двух частей корабля не могут быть одинаковые координаты!");
                removeCoordinates(field);
            }
        }
        if(getX1() == getX2() & getY2() == getY1() + 1 | getY2() == getY1() - 1) {
            if(getX3() == getX1() & getY3() == getY1() - 1 | getY3() == getY1() + 1 | getY3() == getY1() + 2 | getY3() == getY1() - 2) {
                if(getX4() == getX1() & getY4() ==  getY1() + 3 | getY4() == getY1() - 3 | getY4() ==  getY1() + 2 | getY4() == getY1() - 2 |
                        getY4() ==  getY1() + 1 | getY4() == getY1() - 1) {

                } else {
                    System.out.println("Части корабля не могут находиться в отдельно!");
                    removeCoordinates(field);
                }
            } else {
                System.out.println("Части корабля не могут находиться в отдельно!");
                removeCoordinates(field);
            }
        } else if (getY1() == getY2() & getX2() == getX1() + 1 | getX2() == getX1() - 1){
            if(getY3() == getY1() & getX3() == getX1() + 1 | getX3() == getX1() - 1 | getX3() == getX1() + 2 | getX3() == getX1() - 2) {
                if(getY4() == getY1() & getX4() == getX1() + 3 | getX4() == getX1() - 3 | getX3() == getX1() + 2 | getX3() == getX1() - 2 |
                        getX3() == getX1() + 1 | getX3() == getX1() - 1) {

                } else {
                    System.out.println("Части корабля не могут находиться в отдельно!");
                    removeCoordinates(field);
                }
            } else {
                System.out.println("Части корабля не могут находиться в отдельно!");
                removeCoordinates(field);
            }
        } else {
            System.out.println("Части корабля не могут находиться в отдельно!");
            removeCoordinates(field);
        }

        //выставление ареола и корабля
        //корабль не касается углов
        if(getX1() != 0 & getX1() != 9 & getX4() != 0 & getX4() != 9 & getY1() != 0 & getY1() != 9 & getY4() != 0 & getY4() != 9){
            if(getX1() == getX4()){
                if(getY1() < getY4()){
                    for(int i = getY1() - 1; i <= getY1() + 4; i++){
                        for(int j = getX1() - 1; j <= getX1() + 1; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
                if(getY1() > getY4()){
                    for(int i = getY1() - 1; i <= getY1() + 1; i++){
                        for(int j = getX4() - 1; j <= getX4() + 4; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }
            if(getY1() == getY4()){
                if(getX1() < getX4()){
                    for(int i = getY1() - 1; i <= getY1() + 1; i++){
                        for(int j = getX1() - 1; j <= getX1() + 4; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
                if(getX1() > getX4()){
                    for(int i = getY4() - 1; i <= getY4() + 4; i++){
                        for(int j = getX1() - 1; j <= getX1() + 1; j++){
                            field.getField()[i][j] = String.valueOf(Ships.AREAL);
                        }
                    }
                    field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                    field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                    return;
                }
            }

        }

        //четырехпалубный корабль стоит в углу
        //левый верхний угол
        if(getX1() == 0 & getY1() == 0){
            if(getX2() == 1) {
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 0){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 0 && getY4() == 0){
            if(getX3() == 1) {
                for(int i = getY4(); i <= getY4() + 1; i++){
                    for(int j = getX4(); j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 0){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //левый нижний угол
        if(getX1() == 0 & getY1() == 9){
            if(getX2() == 0){
                for(int i = getY1() - 4; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 1){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1(); j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 0 & getY4() == 9){
            if(getX3() == 0){
                for(int i = getY4() - 4; i <= getY4(); i++){
                    for(int j = getX4(); j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 1){
                for(int i = getY4() - 1; i <= getY4(); i++){
                    for(int j = getX4(); j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //правый нижний угол
        if(getX1() == 9 & getY1() == 9){
            if(getX2() == 8){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 4; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 9){
                for(int i = getY1() - 4; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 9 & getY4() == 9){
            if(getX3() == 8){
                for(int i = getY4() - 1; i <= getY4(); i++){
                    for(int j = getX4() - 4; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 9){
                for(int i = getY4() - 4; i <= getY4(); i++){
                    for(int j = getX4() - 1; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }

        //правый верхний угол
        if(getX1() == 9 & getY1() == 0){
            if(getX2() == 9){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX2() == 8){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 4; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        if(getX4() == 9 & getY4() == 0){
            if(getX3() == 9){
                for(int i = getY4(); i <= getY4() + 4; i++){
                    for(int j = getX4() - 1; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX3() == 8){
                for(int i = getY4(); i <= getY4() + 1; i++){
                    for(int j = getX4() - 4; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }


        //четырехпалубный всеми палубами касается края
        //левый край
        if(getX1() == 0 & getX4() == 0 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 9){
            if(getY1() < getY4()){
                for(int i = getY1() - 1; i<=getY1() + 4; i++){
                    for(int j = getX1(); j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY4()){
                for(int i = getY4() - 1; i <= getY4() + 4; i++){
                    for(int j = getX4(); j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //правый край
        if(getX1() == 9 & getX4() == 9 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 9){
            if(getY1() < getY4()){
                for(int i = getY1() - 1; i <= getY1() + 4; i++){
                    for(int j = getX1() - 1; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY1() > getY4()){
                for(int i = getY4() - 1; i <= getY4() + 4; i++){
                    for(int j = getX4() - 1; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //верхний край
        if(getY1() == 0 & getY4() == 0 & getX1() != 0 & getX4() != 9 & getX1() != 9 & getX4() != 9){
            if(getX1() < getX4()){
                for(int i = getY1(); i <= getY1() + 1; i++){
                    for(int j = getX1() - 1; j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX4()){
                for(int i = getY4(); i <= getY4() + 1; i++){
                    for(int j = getX4() - 1; j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //нижний край
        if(getY1() == 9 & getY4() == 9 & getX1() != 0 & getX4() != 9 & getX1() != 9 & getX4() != 9){
            if(getX1() < getX4()){
                for(int i = getY1() - 1; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX1() > getX4()){
                for(int i = getY4() - 1; i <= getY4(); i++){
                    for(int j = getX4() - 1; j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается края одной палубой
        //корабль касается левого края
        if(getX1() == 0 & getX4() != 0 | getX4() == 0 & getX1() != 0 & getX2() != 0 & getX3() != 0 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 0){
            if(getX1() == 0){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1(); j <= getX1() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX4() == 0){
                for(int i = getY4() - 1; i <= getY4() + 1; i++){
                    for(int j = getX4(); j <= getX4() + 4; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается правого края
        if(getX1() == 9 | getX4() == 9 & getX2() != 9 & getX3() != 9 & getY1() != 0 & getY4() != 9 & getY1() != 9 & getY4() != 0){
            if(getX1() == 9){
                for(int i = getY1() - 1; i <= getY1() + 1; i++){
                    for(int j = getX1() - 4; j <= getX1(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getX4() == 9){
                for(int i = getY4() - 1; i <= getY4() + 1; i++){
                    for(int j = getX4() - 4; j <= getX4(); j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается верхнего края
        if(getY1() == 0 & getY4() != 0 | getY4() == 0 | getY1() != 0 & getY2() != 0 & getY3() != 0 & getX1() != 0 & getX1() != 9 & getX4() != 0 & getX4() != 9){
            if(getY1() == 0){
                for(int i = getY1(); i <= getY1() + 4; i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY4() == 0){
                for(int i = getY4(); i <= getY4() + 4; i++){
                    for(int j = getX4() - 1; j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
        //корабль касается нижнего края
        if(getY1() == 9 | getY4() == 9 & getY2() != 9 & getY3() != 9 & getX1() != 0 & getX1() != 9 & getX4() != 0 & getX4() != 9){
            if(getY1() == 9){
                for(int i = getY1() - 4; i <= getY1(); i++){
                    for(int j = getX1() - 1; j <= getX1() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
            if(getY4() == 9){
                for(int i = getY4() - 4; i <= getY4(); i++){
                    for(int j = getX4() - 1; j <= getX4() + 1; j++){
                        field.getField()[i][j] = String.valueOf(Ships.AREAL);
                    }
                }
                field.getField()[getY1()][getX1()] = String.valueOf(Ships.SHIP);
                field.getField()[getY2()][getX2()] = String.valueOf(Ships.SHIP);
                field.getField()[getY3()][getX3()] = String.valueOf(Ships.SHIP);
                field.getField()[getY4()][getX4()] = String.valueOf(Ships.SHIP);
                return;
            }
        }
    }

    //set/get методы
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }
}
