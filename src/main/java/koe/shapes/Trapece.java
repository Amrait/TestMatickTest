package koe.shapes;

public class Trapece extends Shape {
    private double upperBase;
    private double rightLeg;
    private double lowerBase;
    private double leftLeg;

    //Right-to-Left diagonal
    private double RTLdiagonal;
    //Left-to-Right diagonal
    private double LTRdiagonal;
    private double altitude;
    private double midsegment;

    public Trapece (double _upperBase, double _lowerBase, double _rightLeg, double _leftLeg, Colors _color){
        //якщо трапеція з такими сторонами може існувати
        if (checkExistence(_upperBase, _lowerBase, _rightLeg, _leftLeg)){
            //Встановлення сторін та основ
            upperBase = _upperBase;
            lowerBase = _lowerBase;
            rightLeg = _rightLeg;
            leftLeg = _leftLeg;

            //прорахунок середньої лінії, висоти, діагоналей
            setMidsegment();
            setAltitude();
            setRTLdiagonal();
            setLTRdiagonal();

            //встановлення кольору, периметру, площі, назви
            setColor(_color);
            calculatePerimeter();
            calculateArea();
            setName("трапеція");
        }
        else {
            throw new IllegalArgumentException("Трапеція з заданими параметрами не може існувати! " +
                    "Імовірно, фігура з такими сторонами - квадрат, прямокутник або паралелограм.");
        }
    }
    @Override
    public void calculatePerimeter(){
        super.setPerimeter(upperBase + rightLeg + lowerBase + leftLeg);
    }
    @Override
    public void calculateArea(){
            super.setArea(midsegment* altitude);
    }
    @Override
    public String toString(){
        return "Фігура: " + getName() +
                " см.; верхня основа = " + decimalFormat.format(getUpperBase())+
                " см.; права сторона = " + decimalFormat.format(getRightLeg())+
                " см.; нижня основа = " + decimalFormat.format(getLowerBase())+
                " см.; ліва сторона = " + decimalFormat.format(getLeftLeg())+
                " см.;\n середня лінія = " + decimalFormat.format(getMidsegment())+
                " см.; висота = " + decimalFormat.format(getAltitude())+
                " см.;\n діагональ з нижнього правого кута у верхній лівий = " + decimalFormat.format(getRTLdiagonal())+
                " см.; діагональ з нижнього лівого кута у верхній правий = " + decimalFormat.format(getLTRdiagonal())+
                " см.;\n периметр = " + decimalFormat.format(getPerimeter())+
                " см.; площа = " + decimalFormat.format(getArea()) +
                " см.кв.; колір = " + getColor().name()+
                ".";
    }
    private boolean checkExistence(double _uBase, double _lBase, double _rLeg, double _lLeg){
        return (Math.abs(_rLeg-_lLeg) < Math.abs(_lBase-_uBase)
                && Math.abs(_lBase-_uBase) < _rLeg+_lLeg);
    }

    public double getUpperBase() {
        return upperBase;
    }
    public double getRightLeg() {
        return rightLeg;
    }

    public double getLowerBase() {
        return lowerBase;
    }

    public double getLeftLeg() {
        return leftLeg;
    }

    public double getRTLdiagonal() {
        return RTLdiagonal;
    }

    private void setRTLdiagonal() {
        this.RTLdiagonal = Math.sqrt((upperBase*upperBase +
                           leftLeg*leftLeg -
                           2*upperBase*Math.sqrt((leftLeg*leftLeg - altitude * altitude))));
    }

    public double getLTRdiagonal() {
        return LTRdiagonal;
    }

    private void setLTRdiagonal() {
        this.LTRdiagonal = Math.sqrt((upperBase*upperBase +
                        rightLeg*rightLeg -
                        2*upperBase*Math.sqrt((rightLeg*rightLeg - altitude * altitude))));
    }

    public double getAltitude() {
        return altitude;
    }

    private void setAltitude() {
        this.altitude = Math.sqrt((-upperBase + lowerBase + leftLeg + rightLeg)*
                (upperBase - lowerBase + leftLeg + rightLeg)*
                (upperBase - lowerBase + leftLeg - rightLeg)*
                (upperBase - lowerBase - leftLeg + rightLeg))/
                (2*Math.abs(lowerBase - upperBase));
    }

    public double getMidsegment() {
        return midsegment;
    }

    private void setMidsegment() {
        this.midsegment = (upperBase+lowerBase)/2;
    }
}
