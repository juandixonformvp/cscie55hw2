package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* Keeps track of one Elevator and multiple Floor
************************************************************/

import java.util.stream.*;

public class Building {

    private static final int FLOORS = 7;
    private Elevator myElevator;
    private int myFloor[] = new int[FLOORS];
 
/** Initializes the current floor, and direction.
* Class variables description - 
* A constant, (i.e., a static final field), for the number of floors in the building.
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* An array-valued field for tracking, each floor, and # passengers destined for that floor. 
*/
 public Building() {
        this.myElevator = new Elevator();
        this.direction = true;
    }

	
    public int getFloor(int floorNumber) {

        return this.myFloor[floorNumber - 1];

    }
	
    public Elevator getElevator() {

        return this.myElevator;

    }

/**
* The "move" method increments/decrements the current floor. 
* The Elevator moves one floor at a time.
* Modifies the direction of travel, if the ground floor or top floor has been reached.
* Clears the array entry tracking the number of passengers destined for the floor.
* Prints out the status of the Elevator.
*
*/

}