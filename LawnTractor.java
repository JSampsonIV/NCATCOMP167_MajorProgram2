/*
John Sampson
3-21-2024
COMP 167-004
A class for riding mowers.
*/
public class LawnTractor extends Mower{
    //instance variables
    private Engine engine;
    private String model;
    private double deckWidth;

    //constructors
    public LawnTractor(){
        super();//calls the parent's constructor without parameters
        this.engine = new Engine();
        this.model = "";
        this.deckWidth = 0.0;
    }
    public LawnTractor(String maker, int yearMade, String serialNum, Engine tractorEngine, String tractorModel, double tractorDeckWidth){
        super(maker, yearMade, serialNum);//calls the parent's constructor with parameters
        this.engine = tractorEngine;
        this.model = tractorModel;
        this.deckWidth = tractorDeckWidth;
    }

    //mutators
    public void setEngine(Engine tractorEngine){
        this.engine = tractorEngine;
    }
    public void setModel(String tractorModel){
        this.model = tractorModel;
    }
    public void setDeckWidth(double tractorDeckWidth){
        this.deckWidth = tractorDeckWidth;
    }

    //accessors
    public Engine getEngine(){
        return this.engine;
    }
    public String getModel(){
        return this.model;
    }
    public double getDeckWidth(){
        return deckWidth;
    }

    public String toString(){
        //engine's toString is called directly in this toString for formatting
        //the super.toString is also called to print the data not contained within this class
        return super.toString() + "\n" +
                this.engine.toString() + "\n" +
                this.model + "\n" +
                this.deckWidth;
    }
}
