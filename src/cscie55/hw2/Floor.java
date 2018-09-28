package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* Represents one of the floors that the Elevator can visit
************************************************************/

import java.util.stream.*;

public class Floor {

    /*private static final int FLOORS = 7;*/
    private static final int CAPACITY = 10;
    private int currentFloor;
    private int numWaiting;
    private boolean direction;
    private int numPassDest[] = new int[FLOORS];
 
/** Initializes the current floor, and direction.
* Class variables description - 
* A constant, (i.e., a static final field), for the number of floors in the building.
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* An array-valued field for tracking, each floor, and # passengers destined for that floor. 
*/
 public Floor() {
        this.currentFloor = 1;
        this.numWaiting = 0;
        this.direction = true;
    }

	
    public int getPassengersWaiting() {

        return this.currentFloor;

    }
	
    public int getNumPass() {

        return IntStream.of(this.numPassDest).sum();

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

        System.out.println(this.toString());

        if (currentFloor == 1) {
            this.direction = true;
        }    

        if (currentFloor == FLOORS) {
            this.direction = false;
        }

        if (direction == true) {
            this.currentFloor++;
        }    

        else {
            this.currentFloor--;
        }

        this.numPassDest[currentFloor - 1] = 0;


    }