/*
John Sampson
3-21-2024
COMP 167-004
This class is for those lawnmowers that companies use,
or I think also any riding mower. I don't know enough about the world of lawnmowers.
*/
public class CommercialMower extends LawnTractor{
    //instance variables
    private double operatingHours;
    private boolean zeroTurnRadius;

    //constructors
    public CommercialMower(){
        super();//calls the parent's constructor without parameters
        this.operatingHours = 0.0;
        this.zeroTurnRadius = false;
    }
    public CommercialMower(String maker, int yearMade, String serialNum, Engine tractorEngine, String tractorModel, double tractorDeckWidth, double mowerOperatingHours, boolean hasZeroTurnRadius){
        super(maker, yearMade, serialNum, tractorEngine, tractorModel, tractorDeckWidth);//calls the parent's constructor with parameters
        this.operatingHours = mowerOperatingHours;
        this.zeroTurnRadius = hasZeroTurnRadius;
    }

    //mutators
    public void setOperatingHours(double mowerOperatingHours){
        this.operatingHours = mowerOperatingHours;
    }
    public void setZeroTurnRadius(boolean hasZeroTurnRadius){
        this.zeroTurnRadius = hasZeroTurnRadius;
    }

    //accessors
    public double getOperatingHours(){
        return this.operatingHours;
    }
    public boolean isZeroTurnRadius(){
        return this.zeroTurnRadius;
    }

    public String toString(){
        return super.toString() + "\n" +
                this.operatingHours + "\n" +
                this.zeroTurnRadius;
    }
}
