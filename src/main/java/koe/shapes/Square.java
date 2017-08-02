package koe.shapes;

public class Square extends Shape{
    private double side;
    private double diagonal;

    public Square(double _side, Colors _color){
        setSide(_side);
        setColor(_color);
        calculatePerimeter();
        calculateArea();
        setDiagonal();
        setName("квадрат");
    }
    @Override
    public void calculatePerimeter(){
        super.setPerimeter(4*side);
    }
    @Override
    public void calculateArea(){
        super.setArea(side*side);
    }
    @Override
    public String toString(){
        return "Фігура: " + getName() +
                "; сторона = " + decimalFormat.format(getSide()) +
                " см.; діагональ = " + decimalFormat.format(getDiagonal())+
                " см.; периметр = " + decimalFormat.format(getPerimeter())+
                " см.; площа = " + decimalFormat.format(getArea()) +
                " см.кв.; колір = " + getColor().name()+
                ".";
    }

    public double getDiagonal() {
        return diagonal;
    }

    private void setDiagonal() {
        this.diagonal = Math.sqrt(side*side*2);
    }
    public double getSide() {
        return side;
    }

    private void setSide(double side) throws IllegalArgumentException{
        if (side>0) {
            this.side = side;
        }
        else {
            throw new IllegalArgumentException("Сторона квадрата не може бути меншою за 0!");
        }
    }
}
