/*
John Sampson
3-21-2024
COMP 167-004
Holds the data for a lawnmower's engine.
This class is aggregated into many other classes
*/
public class Engine{
    //instance variables
    private String manufacturer;
    private double horsePower;
    private int cylinders;

    //constructors
    public Engine(){
        this.manufacturer = "";
        this.horsePower = 0.0;
        this.cylinders = 0;
    }
    public Engine(String maker, double hPower, int numCylinders){
        this.manufacturer = maker;
        this.horsePower = hPower;
        this.cylinders = numCylinders;
    }

    //mutators
    public void setManufacturer(String maker) {
        this.manufacturer = maker;
    }
    public void setHoursePower(double hPower) {
        this.horsePower = hPower;
    }
    public void setCylinders(int numCylinders) {
        this.cylinders = numCylinders;
    }

    //accessors
    public String getManufacturer() {
        return manufacturer;
    }
    public double getHoursePower() {
        return horsePower;
    }
    public int getCylinders() {
        return cylinders;
    }

    //Because so many other classes have an Engine object as one of their attributes,
    //I wanted to add an extra message to note that the engine info is being printed
    public String toString(){
        return this.manufacturer + "\n" +
                this.horsePower + "\n" +
                this.cylinders;
    }
}