package koe.shapes;

//оскільки в ТЗ було сказано, що в інформації про трикутник має бути гіпотенуза,
//це звужує даний клас до прямокутного трикутника
public class RightTriangle extends Shape {
    private double firstLeg; //перший катет
    private double secondLeg; //другий катет
    private double hypotenuse; //гіпотенуза

    //висоти, опущені, відповідно, на first, second, third side
    private double altitude; //висота, опущена на гіпотенузу
    private double bisector; //бісектриса, опущена на гіпотенузу
    private double median; //медіана, опущена на гіпотенузу

    public RightTriangle(double _firstLeg, double _secondLeg, Colors _color){
        //встановлення значення катетів
        setFirstLeg(_firstLeg);
        setSecondLeg(_secondLeg);

        //прорахунок усіх інших значень за наявними
        setHypotenuse();
        calculateArea();
        calculatePerimeter();
        setAltitude();
        setBisector();
        setMedian();
        setName("прямокутний трикутник");
        setColor(_color);
    }
    @Override
    public void calculatePerimeter(){
        super.setPerimeter(firstLeg+secondLeg+hypotenuse);
    }
    @Override
    public void calculateArea(){
        super.setArea((firstLeg*secondLeg)/2);
    }
    @Override
    public String toString(){
        return "Фігура: " + getName() +
                "; перший катет = " + decimalFormat.format(getFirstLeg()) +
                " см.; другий катет = " + decimalFormat.format(getSecondLeg())+
                " см.; гіпотенуза = " + decimalFormat.format(getHypotenuse()) +
                " см.;\n медіана, опущена на гіпотенузу = " + decimalFormat.format(getMedian()) +
                " см.; висота, опущена на гіпотенузу = " + decimalFormat.format(getAltitude()) +
                " см.; бісектриса, проведена з прямого кута = " + decimalFormat.format(getBisector()) +
                " см.; периметр = " + decimalFormat.format(getPerimeter())+
                " см.; площа = " + decimalFormat.format(getArea()) +
                " см.кв.; колір = " + getColor().name()+
                ".";
    }

    public double getFirstLeg() {
        return firstLeg;
    }

    public void setFirstLeg(double firstLeg) {
        this.firstLeg = firstLeg;
    }

    public double getSecondLeg() {
        return secondLeg;
    }

    public void setSecondLeg(double secondLeg) {
        this.secondLeg = secondLeg;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    private void setHypotenuse() {
        this.hypotenuse = Math.sqrt(firstLeg*firstLeg + secondLeg*secondLeg);
    }

    public double getAltitude() {
        return altitude;
    }

    private void setAltitude() {
        this.altitude = (firstLeg*secondLeg)/hypotenuse;
    }

    public double getBisector() {
        return bisector;
    }

    private void setBisector() {
        this.bisector = (Math.sqrt(2)*(firstLeg*secondLeg)/(firstLeg+secondLeg));
    }

    public double getMedian() {
        return median;
    }

    private void setMedian() {
        this.median = hypotenuse/2;
    }
}
