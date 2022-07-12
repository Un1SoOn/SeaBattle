package Practic.Final;

import java.util.Arrays;
import java.util.Scanner;

public class PlayerField {
    private String[][] field = new String[10][10];
    private String name;
    private int counter = 0;

    Four four1;
    Three three1;
    Three three2;
    Two two1;
    Two two2;
    Two two3;
    One one1;
    One one2;
    One one3;
    One one4;

    public PlayerField(String[][] field) {
        this.field = field;
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field.length; j++){
                field[i][j] = String.valueOf(Ships.EMPTY);
            }
        }
    }

    public void startGame(){
        Scanner s1 = new Scanner(System.in);
        System.out.println("введите имя, с которым вы продолжите игру: ");
        name = s1.nextLine();
    }

    public void addShips(PlayerField field1){
        System.out.println("Введите координаты четырехпалубного корабля (формат x1,y1,x2,y2,x3,y3,x4,y4): " );
        four1 = new Four(field1);
        field1.printField();

        System.out.println("Введите координаты первого трехпалубного корабля (формат x1,y1,x2,y2,x3,y3): ");
        three1 = new Three(field1);
        field1.printField();

        System.out.println("Введите координаты второго трехпалубного корабля (формат x1,y1,x2,y2,x3,y3): ");
        three2 = new Three(field1);
        field1.printField();

        System.out.println("Введите координаты первого двухпалубного корабля (формат x1,y1,x2,y2): ");
        two1 = new Two(field1);
        field1.printField();

        System.out.println("Введите координаты второго двухпалубного корабля (формат x1,y1,x2,y2): ");
        two2 = new Two(field1);
        field1.printField();

        System.out.println("Введите координаты третьего двухпалубного корабля (формат x1,y1,x2,y2): ");
        two3 = new Two(field1);
        field1.printField();

        System.out.println("Введите координаты первого однопалубного корабля (формат x1,y1): ");
        one1 = new One(field1);
        field1.printField();

        System.out.println("Введите координаты второго однопалубного корабля (формат x1,y1): ");
        one2 = new One(field1);
        field1.printField();

        System.out.println("Введите координаты третьего однопалубного корабля (формат x1,y1): ");
        one3 = new One(field1);
        field1.printField();

        System.out.println("Введите координаты четвертого однопалубного корабля (формат x1,y1): ");
        one4 = new One(field1);
        field1.printField();
    }

    public void shot(PlayerField field1, PlayerField field2){
        int x = 0;
        int y = 0;
        try {
            System.out.println("Введите координаты для выстрела: ");
            Scanner s1 = new Scanner(System.in);
            String[] lineStr;
            String line = s1.nextLine();
            lineStr = line.split(",");
            x = Integer.parseInt(lineStr[0]);
            y = Integer.parseInt(lineStr[1]);

            if(lineStr.length != 2){
                System.out.println("Для выстрела нужно две координаты!");
                shot(field1, field2);
            }

            if(x < 0 | x > 9 | y < 0 | y > 9) {
                System.out.println("Координаты выстрела могут быть только в промежутке от 0 до 9!");
                shot(field1, field2);
            }
        } catch (ArrayIndexOutOfBoundsException id){
            System.out.println("Для выстрела нужно две координаты!");
            shot(field1, field2);
        }

        if(field2.getField()[y][x].equals(String.valueOf(Ships.BROKEN))){
            System.out.println("В это место уже стреляли!");
            shot(field1, field2);
        }
        if(field2.getField()[y][x].equals(String.valueOf(Ships.EMPTY)) || field2.getField()[y][x].equals(String.valueOf(Ships.AREAL))) {
            field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
            System.out.println("Мимо!");
            System.out.println(field2.getName() + ", твой ход!");
            shot(field2, field1);
        }
        if(field2.getField()[y][x].equals(String.valueOf(Ships.SHIP))){
            counter = getCounter() + 1;
            if(x == four1.getX1() & y == four1.getY1() || x == four1.getX2() & y == four1.getY2() ||
                    x == four1.getX3() & y == four1.getY3() || x == four1.getX4() & y == four1.getY4()){
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                if(field2.getField()[four1.getY1()][four1.getX1()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[four1.getY2()][four1.getX2()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[four1.getY3()][four1.getX3()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[four1.getY4()][four1.getX4()].equals(String.valueOf(Ships.SHIP))) {
                    System.out.println("Попал!");
                    shot(field1, field2);
                } else {
                    System.out.println("Утопил!");
                    if(field2.getCounter() == 20){
                        System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                    } else {
                        shot(field1, field2);
                    }
                }
            }
            if (x == three1.getX1() & y == three1.getY1() || x == three1.getX2() & y == three1.getY2() ||
            x == three1.getX3() & y == three1.getY3()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                if(field2.getField()[three1.getY1()][three1.getX1()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[three1.getY2()][three1.getX2()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[three1.getY3()][three1.getX3()].equals(String.valueOf(Ships.SHIP))) {
                    System.out.println("Попал!");
                    shot(field1, field2);
                } else {
                    System.out.println("Утопил!");
                    if(field2.getCounter() == 20){
                        System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                    } else {
                        shot(field1, field2);
                    }
                }
            }
            if (x == three2.getX1() & y == three2.getY1() || x == three2.getX2() & y == three2.getY2() ||
                    x == three2.getX3() & y == three2.getY3()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                if(field2.getField()[three2.getY1()][three2.getX1()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[three2.getY2()][three2.getX2()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[three2.getY3()][three2.getX3()].equals(String.valueOf(Ships.SHIP))) {
                    System.out.println("Попал!");
                    shot(field1, field2);
                } else {
                    System.out.println("Утопил!");
                    if(field2.getCounter() == 20){
                        System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                    } else {
                        shot(field1, field2);
                    }
                }
            }
            if (x == two1.getX1() & y == two1.getY1() || x == two1.getX2() & y == two1.getY2()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                if(field2.getField()[two1.getY1()][two1.getX1()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[two1.getY2()][two1.getX2()].equals(String.valueOf(Ships.SHIP))) {
                    System.out.println("Попал!");
                    shot(field1, field2);
                } else {
                    System.out.println("Утопил!");
                    if(field2.getCounter() == 20){
                        System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                    } else {
                        shot(field1, field2);
                    }
                }
            }
            if (x == two2.getX1() & y == two2.getY1() || x == two2.getX2() & y == two2.getY2()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                if(field2.getField()[two2.getY1()][two2.getX1()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[two2.getY2()][two2.getX2()].equals(String.valueOf(Ships.SHIP))) {
                    System.out.println("Попал!");
                    shot(field1, field2);
                } else {
                    System.out.println("Утопил!");
                    if(field2.getCounter() == 20){
                        System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                    } else {
                        shot(field1, field2);
                    }
                }
            }
            if (x == two3.getX1() & y == two3.getY1() || x == two3.getX2() & y == two3.getY2()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                if(field2.getField()[two3.getY1()][two3.getX1()].equals(String.valueOf(Ships.SHIP)) ||
                        field2.getField()[two3.getY2()][two3.getX2()].equals(String.valueOf(Ships.SHIP))) {
                    System.out.println("Попал!");
                    shot(field1, field2);
                } else {
                    System.out.println("Утопил!");
                    if(field2.getCounter() == 20){
                        System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                    } else {
                        shot(field1, field2);
                    }
                }
            }
            if (x == one1.getX1() & y == one1.getY1()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                System.out.println("Утопил!");
                if(field2.getCounter() == 20){
                    System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                } else {
                    shot(field1, field2);
                }
            }
            if (x == one2.getX1() & y == one2.getY1()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                System.out.println("Утопил!");
                if(field2.getCounter() == 20){
                    System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!");
                } else {
                    shot(field1, field2);
                }
            }
            if (x == one3.getX1() & y == one3.getY1()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                System.out.println("Утопил!");
                if(field2.getCounter() == 20){
                    System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!\nПоздравляем!!!");
                } else {
                    shot(field1, field2);
                }
            }
            if (x == one4.getX1() & y == one4.getY1()) {
                field2.getField()[y][x] = String.valueOf(Ships.BROKEN);
                System.out.println("Утопил!");
                if(field2.getCounter() == 20){
                    System.out.println("Все корабли противника уничтожены, " + field1.getName() + ", ты победил!\nПоздравляем!!!");
                } else {
                    shot(field1, field2);
                }
            }
        }
    }

    public void printField(){
        for(int i = 0; i < getField().length; i++){
            for(int j = 0; j < getField().length; j++){
            }
            System.out.println(Arrays.toString(field[i]).replace("[", "").replace(",","").replace("]", ""));
        }
    }

    public String[][] getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }
}
