/*
John Sampson
3-21-2024
COMP 167-004
A class for any lawnmower you walk behind.
This class is also inherited from by a few classes
*/
public class WalkBehindMower extends Mower{
    //instance variables
    private double cutWidth, wheelDiameter;//the instance variables are declared together to save space

    //constructors
    public WalkBehindMower(){
        super();//calls the parent's constructor without parameters
        this.cutWidth = 0.0;
        this.wheelDiameter = 0.0;
    }
    public WalkBehindMower(String maker, int yearMade, String serialNum, double mowerCutWidth, double mowerWheelDiameter){
        super(maker, yearMade, serialNum);//calls the parent's constructor with parameters
        this.cutWidth = mowerCutWidth;
        this.wheelDiameter = mowerWheelDiameter;
    }

    //mutators
    public void setCutWidth(double mowerCutWidth) {
        this.cutWidth = mowerCutWidth;
    }
    public void setWheelDiameter(double MowerWheelDiameter) {
        this.wheelDiameter = MowerWheelDiameter;
    }

    //accessors
    public double getCutWidth() {
        return cutWidth;
    }
    public double getWheelDiameter() {
        return wheelDiameter;
    }

    public String toString() {
        return super.toString() + "\n" +
                this.cutWidth + "\n" +
                this.wheelDiameter;
    }
}
