package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* Represents one of the floors that the Elevator can visit
************************************************************/

import java.util.stream.*;

public class Floor {

    public int isWaitingArray[] = new int[Building.FLOORS];
    public int numPass;
    public int myFloorNumber;
 
/** Initializes the current floor, and direction.
* Class variables description - 
* Number of passengers on the floor.
* The Floor number (cannot be zero). 
* An array for tracking the number of people waiting on the floor.
*/
    public Floor(Building building, int floorNumber) {
        this.numPass = 0;
        this.myFloorNumber = floorNumber + 1; // add 1 because it is initialized by an index to an array
    }

    public int getPassengersWaiting() {
        return this.isWaitingArray[this.myFloorNumber - 1];
    }

    protected void setNumPass() {
        this.numPass++;
    }

    protected void clearNumPass() {
        this.numPass = 0;
    }
    
    protected void clearIsWaitingArray() {     // as waiting passengers board, it is necessary to decrement the isWaitingArray
        this.isWaitingArray[this.myFloorNumber - 1]--;
    }

    protected int getNumPass() {
        return this.numPass;
    }

    protected int getFloorNumber() {
        return this.myFloorNumber;
    }

/**
* This method basically "summons" the elevator. 
* Increments the isWaitingArray.
*
*/
    public void waitForElevator() {
        this.isWaitingArray[this.myFloorNumber - 1]++;
    }

}