package koe.main;

import koe.shapes.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Олексій on 01.08.2017.
 */
public class Application {
    //звичайного масиву цілком вистачить
    private Shape[] shapes;
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
    public void run(){
        generateShapesArray();
        System.out.println("Вітаємо в генераторі фігур. Було згенеровано "+shapes.length + " фігур." +
                " Ось які фігури було згенеровано абсолютно випадково:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(i+1 + ". " + shapes[i].toString());
            System.out.println("----------");
        }
    }

    private void generateShapesArray() {
        int size = ThreadLocalRandom.current().nextInt(1, 101);//межі від 1 включно до 101 виключно
        shapes = new Shape[size];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = generateShape();
        }
    }
    private Shape generateShape(){
        int RGN = ThreadLocalRandom.current().nextInt(1,5);
        Shape shape = null;
        switch (RGN){
            case 1:
                shape = generateCircle();
                break;
            case 2:
                shape = generateRightTriangle();
                break;
            case 3:
                shape = generateSquare();
                break;
            case 4:
                shape = generateTrapece();
                break;
        }
        return shape;
    }
    private Circle generateCircle(){
        Colors color = Colors.values()[ThreadLocalRandom.current().nextInt(0,Colors.values().length)];
        double radius = ThreadLocalRandom.current().nextDouble(0.01, 100.01);
        return new Circle(radius,color);
    }
    private RightTriangle generateRightTriangle(){
        Colors color = Colors.values()[ThreadLocalRandom.current().nextInt(0,Colors.values().length)];
        double firstLeg = ThreadLocalRandom.current().nextDouble(0.01, 100.01);
        double secondLeg = ThreadLocalRandom.current().nextDouble(0.01, 100.01);
        return new RightTriangle(firstLeg,secondLeg,color);
    }
    private Square generateSquare(){
        Colors color = Colors.values()[ThreadLocalRandom.current().nextInt(0,Colors.values().length)];
        double side = ThreadLocalRandom.current().nextDouble(0.01, 100.01);
        return new Square(side,color);
    }
    private Trapece generateTrapece(){
        Colors color = Colors.values()[ThreadLocalRandom.current().nextInt(0,Colors.values().length)];
        //генерація сторін трапеції за умовами саме трапеції
        //набір нерівностей для існування трапеції:
        //|d-c| < |b-a| < d+c, де a - верхня основа, b - нижня основа, c - ліва сторона, d - права сторона
        double lowerBase = ThreadLocalRandom.current().nextDouble(0.01, 100.01);
        double upperBase = ThreadLocalRandom.current().nextDouble(0.01, lowerBase);
        double rightLeg = ThreadLocalRandom.current().nextDouble(0.01, Math.abs(lowerBase-upperBase));
        double bound = (Math.abs(lowerBase-upperBase)-rightLeg>0) ? Math.abs(lowerBase-upperBase)-rightLeg : 0.01;
        double leftLeg = ThreadLocalRandom.current().nextDouble(bound, Math.abs(lowerBase-upperBase));

        return new Trapece(upperBase,lowerBase,rightLeg,leftLeg,color);
    }
}
