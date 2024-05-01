/*
John Sampson
3-21-2024
COMP 167-004
Creating multiple classes that hold the data of lawnmowers,
and using inheritance to branch off the different kinds of lawnmowers
This class represents a warehouse of lawnmowers for sale,
and allows customers to look for mowers that fit their qualifications
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MowerWareHouse {
    //instance variables
    private String storeName;
    private ArrayList<Mower> mowers;

    //constructors
    public MowerWareHouse(){
        this.storeName = "";
        this.mowers = new ArrayList<Mower>();
    }
    public MowerWareHouse(String nameOfStore, ArrayList<Mower> listOfMowers){
        this.storeName = nameOfStore;
        this.mowers = listOfMowers;
    }

    //mutators
    public void setStoreName(String nameOfStore) {
        this.storeName = nameOfStore;
    }
    public void setMowers(ArrayList<Mower> listOfMowers) {
        this.mowers = listOfMowers;
    }
    //add or remove a mower at a specific index
    public void addMower(Mower mowerToAdd){
        mowers.add(mowerToAdd);
    }
    public void removeMower(int indexOfMower){
        mowers.remove(indexOfMower);
    }
    //change a specific mower
    public void setMower(int index, Mower mower){
        mowers.set(index, mower);
    }

    //accessors
    public String getStoreName() {
        return this.storeName;
    }
    public ArrayList<Mower> getMowers() {
        return this.mowers;
    }
    //accessor for a specific mower
    public Mower getMower(int index){
        return mowers.get(index);
    }
    //get the size of the ArrayList
    public int getNumMowers(){
        return mowers.size();
    }

    //file read and write methods
    public void readMowerData(String inputFileName) throws FileNotFoundException{//reads the data from a given file
        System.out.println("reading " + inputFileName);
        File fileOpener = new File(inputFileName);
        Scanner fileReader = new Scanner(fileOpener);
        //store name
        storeName = fileReader.nextLine();
        while (fileReader.hasNext()) {
            //mower class properties
            String mowerMaker = fileReader.nextLine();
            int yearMade = fileReader.nextInt();
            String serialNum = fileReader.next();

            //mower subclass from file
            char mowerType = fileReader.next().charAt(0);
            fileReader.nextLine();//I had issues with the pointer staying at the end of the line, so the nextLine

            //subclass properties
            switch (mowerType) {//I originally used an if-else structure, but this is a little more concise
                case 'L' -> {//brackets prevent errors due to variable scope
                    String engineMaker = fileReader.nextLine();
                    double hPower = fileReader.nextDouble();
                    int numCylinders = fileReader.nextInt();
                    fileReader.nextLine();
                    Engine engine = new Engine(engineMaker, hPower, numCylinders);
                    String tractorModel = fileReader.nextLine();
                    double tractorDeckWidth = fileReader.nextDouble();
                    LawnTractor lawnTractor = new LawnTractor(mowerMaker, yearMade, serialNum, engine, tractorModel, tractorDeckWidth);
                    mowers.add(lawnTractor);
                }
                case 'C' -> {
                    String engineMaker = fileReader.nextLine();
                    double hPower = fileReader.nextDouble();
                    int numCylinders = fileReader.nextInt();
                    fileReader.nextLine();
                    Engine engine = new Engine(engineMaker, hPower, numCylinders);
                    String tractorModel = fileReader.nextLine();
                    double tractorDeckWidth = fileReader.nextDouble();
                    double mowerOperatingHours = fileReader.nextDouble();
                    boolean hasZeroTurnRadius = fileReader.nextBoolean();
                    CommercialMower commercialMower = new CommercialMower(mowerMaker, yearMade, serialNum, engine, tractorModel, tractorDeckWidth, mowerOperatingHours, hasZeroTurnRadius);
                    mowers.add(commercialMower);
                }
                case 'G' -> {
                    double mowerCutWidth = fileReader.nextDouble();
                    double mowerWheelDiameter = fileReader.nextDouble();
                    fileReader.nextLine();
                    String engineMaker = fileReader.nextLine();
                    double hPower = fileReader.nextDouble();
                    fileReader.nextLine();
                    int numCylinders = fileReader.nextInt();
                    Engine engine = new Engine(engineMaker, hPower, numCylinders);
                    boolean isSelfPropelled = fileReader.nextBoolean();
                    GasPoweredMower gasPoweredMower = new GasPoweredMower(mowerMaker, yearMade, serialNum, mowerCutWidth, mowerWheelDiameter, engine, isSelfPropelled);
                    mowers.add(gasPoweredMower);
                }
                case 'P' -> {
                    double mowerCutWidth = fileReader.nextDouble();
                    double mowerWheelDiameter = fileReader.nextDouble();
                    int numberOfWheels = fileReader.nextInt();
                    PushReelMower pushReelMower = new PushReelMower(mowerMaker, yearMade, serialNum, mowerCutWidth, mowerWheelDiameter, numberOfWheels);
                    mowers.add(pushReelMower);
                }
            }
            fileReader.nextLine();//there's an input mismatch error caused by getting a not nextLine
        }
        fileReader.close();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your choice of Mower to get its information.");//prompt the user for what type of mower they want to see
        System.out.println("Enter \"L\" for Lawn Tractor, \"C\" for Commercial Mower, \"G\" for Gas Powered Mower, \"P\" for Push Reel Mower, or \"S\" to Stop.");
        String userInput = scnr.nextLine();
        while (!userInput.equalsIgnoreCase("S")) {//equalsIgnoreCase is used to avoid capitalisation
            switch (userInput) {
                case "l":
                case "L":
                    for (Mower mower : mowers) {
                        if (mower instanceof LawnTractor) {//if the current mower is also a LawnTractor object
                            System.out.println(mower);
                        }
                    }
                    System.out.println("Enter your next choice. Enter \"L\" for Lawn Tractor, \"C\" for Commercial Mower, \"G\" for Gas Powered Mower, \"P\" for Push Reel Mower, or \"S\" to Stop.");
                    userInput = scnr.nextLine();
                    break;
                case "c":
                case "C":
                    for (Mower mower : mowers) {
                        if (mower instanceof CommercialMower) {//if the current mower is also a CommercialMower object
                            System.out.println(mower);
                        }
                    }
                    System.out.println("Enter your next choice. Enter \"L\" for Lawn Tractor, \"C\" for Commercial Mower, \"G\" for Gas Powered Mower, \"P\" for Push Reel Mower, or \"S\" to Stop.");
                    userInput = scnr.nextLine();
                    break;
                case "g":
                case "G":
                    for (Mower mower : mowers) {
                        if (mower instanceof GasPoweredMower) {//if the current mower is also a GasPoweredMower object
                            System.out.println(mower);
                        }
                    }
                    System.out.println("Enter your next choice. Enter \"L\" for Lawn Tractor, \"C\" for Commercial Mower, \"G\" for Gas Powered Mower, \"P\" for Push Reel Mower, or \"S\" to Stop.");
                    userInput = scnr.nextLine();
                    break;
                case "p":
                case "P":
                    for (Mower mower : mowers) {
                        if (mower instanceof PushReelMower) {//if the current mower is also a PushReelMower object
                            System.out.println(mower);
                        }
                    }
                    System.out.println("Enter your next choice. Enter \"L\" for Lawn Tractor, \"C\" for Commercial Mower, \"G\" for Gas Powered Mower, \"P\" for Push Reel Mower, or \"S\" to Stop.");
                    userInput = scnr.nextLine();
                    break;
                default:
                    System.out.println("Invalid input. Please enter your choice again.");
                    userInput = scnr.nextLine();
                    break;
            }
        }
    }
    public void saveMowerData(String outputFileName) throws IOException{//saves user-inputted data to a file
        System.out.println("Saving mower data to " + outputFileName);
        FileOutputStream saveFile = new FileOutputStream(outputFileName);
        PrintWriter writeToFile = new PrintWriter(saveFile);
        for (int i = 0; i<mowers.size(); i++) {
            writeToFile.println(mowers.get(i));
        }
        writeToFile.close();
    }

    public String toString() {
        String allMowers = "";
        for (Mower mower : this.mowers){
            allMowers += mower.toString() + "\n";
        }
        return this.storeName + "\n" +
                allMowers;
    }
}
