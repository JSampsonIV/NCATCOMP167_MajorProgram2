/*
John Sampson
3-21-2024
COMP 167-004
A class for one of those mowers that's just a cylinder with wheels.
I've never seen one of these in real (reel) life.
*/
public class PushReelMower extends WalkBehindMower{
    //instance variable
    private int numWheels;

    //constructors
    public PushReelMower(){
        super();//calls the parent's constructor without parameters
        this.numWheels = 0;
    }
    public PushReelMower(String maker, int yearMade, String serialNum, double mowerCutWidth, double mowerWheelDiameter, int numberOfWheels){
        super(maker, yearMade, serialNum, mowerCutWidth, mowerWheelDiameter);//calls the parent's constructor with parameters
        this.numWheels = numberOfWheels;
    }

    //mutator
    public void setNumWheels(int numberOfWheels) {
        this.numWheels = numberOfWheels;
    }

    //accessor
    public int getNumWheels() {
        return this.numWheels;
    }

    public String toString() {
        return super.toString() + "\n" +
                this.numWheels;
    }
}
