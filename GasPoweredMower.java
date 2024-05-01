/*
John Sampson
3-21-2024
COMP 167-004
A class that holds the data for gas-powered lawnmowers,
including the data for its engine
*/
public class GasPoweredMower extends WalkBehindMower{
    //instance variables
    private Engine engine;
    private boolean selfPropelled;

    //constructors
    public GasPoweredMower(){
        super();//calls the parent's constructor without parameters
        this.engine = new Engine();
        selfPropelled = false;
    }
    public GasPoweredMower(String maker, int yearMade, String serialNum, double mowerCutWidth, double mowerWheelDiameter, Engine mowerEngine, boolean isSelfPropelled){
        super(maker, yearMade, serialNum, mowerCutWidth, mowerWheelDiameter);//calls the parent's constructor with parameters
        this.engine = mowerEngine;
        selfPropelled = isSelfPropelled;
    }

    //mutators
    public void setEngine(Engine mowerEngine) {
        this.engine = mowerEngine;
    }
    public void setSelfPropelled(boolean isSelfPropelled) {
        this.selfPropelled = isSelfPropelled;
    }

    //accessors
    public Engine getEngine() {
        return this.engine;
    }
    public boolean isSelfPropelled() {
        return this.selfPropelled;
    }

    public String toString() {
        return super.toString() + "\n" +
                this.engine.toString() + "\n" +
                this.selfPropelled;
    }
}
