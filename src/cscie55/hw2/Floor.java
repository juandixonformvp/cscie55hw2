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
* A constant, (i.e., a static final field), for the number of floors in the building.
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* An array-valued field for tracking, each floor, and # passengers destined for that floor. 
*/
    public Floor(Building building, int floorNumber) {
        this.numPass = 0;
        this.myFloorNumber = floorNumber + 1; // add 1 because it is initialized by an index to an array
    }

    public int getPassengersWaiting() {
        return this.isWaitingArray[this.myFloorNumber - 1];
    }

    public void setNumPass() {
        this.numPass++;
    }

    public void clearNumPass() {
        this.numPass = 0;
    }
    
    public void clearIsWaitingArray() {
        this.isWaitingArray[this.myFloorNumber - 1]--;
    }

    public int getNumPass() {
        return this.numPass;
    }

    public int getFloorNumber() {
        return this.myFloorNumber;
    }

/**
* The "move" method increments/decrements the current floor. 
* The Elevator moves one floor at a time.
* Modifies the direction of travel, if the ground floor or top floor has been reached.
* Clears the array entry tracking the number of passengers destined for the floor.
* Prints out the status of the Elevator.
*
*/
    public void waitForElevator() {
        this.isWaitingArray[this.myFloorNumber - 1]++;
    }

}