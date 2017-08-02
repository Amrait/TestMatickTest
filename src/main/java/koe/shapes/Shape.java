package koe.shapes;

import java.text.DecimalFormat;

public abstract class Shape {
    //для форматування
    protected DecimalFormat decimalFormat = new DecimalFormat("#.###");
    private Colors color;
    private double perimeter;
    private String name;
    private double area;

    public Colors getColor(){
        return color;
    }
    public void setColor(Colors _color){
        color = _color;
    }
    //getter'и
    public double getPerimeter(){
        return perimeter;
    }
    public double getArea(){
        return area;
    }
    protected void setPerimeter(double _perimeter){
        perimeter = _perimeter;
    }
    protected void setArea(double _area){
        area = _area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //Обрахунок периметра, у класах-нащадках буде реалізований відповідно
    public abstract void calculatePerimeter();
    //Обрахунок площі, у класах-нащадках буде реалізований відповідно
    public abstract void calculateArea();
}
