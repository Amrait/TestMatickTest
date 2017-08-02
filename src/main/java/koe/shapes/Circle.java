package koe.shapes;

public class Circle extends Shape {
    private double radius;
    private final float PI = 3.1415f;

    public Circle(double _radius, Colors _color){
        //На данному етапі, виконання програми буде зупинено через Exception,
        //якщо значення радіусу буде меншим за нуль. На разі, не перехоплюється,
        //адже в програмі числа генеруються випадково у заданому інтервалі, який не включатиме нуль.
        setRadius(_radius);
        setColor(_color);
        calculatePerimeter();
        calculateArea();
        setName("коло");
    }
    @Override
    public void calculatePerimeter(){
        super.setPerimeter(2*radius*PI);
    }
    @Override
    public void calculateArea(){
        super.setArea(PI*radius*radius);
    }
    @Override
    public String toString(){
        return  "Фігура: " + getName() +
                "; радіус = " + decimalFormat.format(getRadius()) +
                " см.; периметр = " + decimalFormat.format(getPerimeter())+
                " см.; площа = " + decimalFormat.format(getArea()) +
                " см.кв.; колір = " + getColor().name()+
                ".";
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) throws IllegalArgumentException{
        if (radius>0) {
            this.radius = radius;
        }
        else {
            throw new IllegalArgumentException("Радіус кола не може бути меншим за 0!");
        }
    }
}
