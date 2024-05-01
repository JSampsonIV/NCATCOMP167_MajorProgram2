/*
John Sampson
3-21-2024
COMP 167-004
A plain lawnmower by itself,
this class is used as the parent for many of the other classes
*/
public abstract class Mower{
    //instance variables
    private String manufacturer, serialNumber;//these are declared on the same line to save space
    private int year;

    //constructors
    public Mower(){
        this.manufacturer = null;
        this.year = 0;
        this.serialNumber = null;
    }
    public Mower(String maker, int yearMade, String serialNum){
        this.manufacturer = maker;
        this.year = yearMade;
        this.serialNumber = serialNum;
    }

    //mutators
    public void setManufacturer(String maker){
        this.manufacturer = maker;
    }
    public void setYear(int yearMade){
        this.year = yearMade;
    }
    public void setSerialNumber(String serialNum){
        this.serialNumber = serialNum;
    }

    //accessors
    public String getManufacturer(){
        return this.manufacturer;
    }
    public int getYear(){
        return this.year;
    }
    public String getSerialNumber(){
        return this.serialNumber;
    }

    public String toString(){
        String mowerTypeChar;
        if (this instanceof LawnTractor){
            if (this instanceof CommercialMower){
                mowerTypeChar = "C";
            }
            else {
                mowerTypeChar = " L";
            }
        }
        else if (this instanceof GasPoweredMower){
            mowerTypeChar = "G";
        }
        else if (this instanceof PushReelMower){
            mowerTypeChar = "P";
        }
        else {
            mowerTypeChar = "#";
        }
        return this.manufacturer + "\n" +
                this.year + "\n" +
                this.serialNumber + "\n" +
                mowerTypeChar;
    }
}
