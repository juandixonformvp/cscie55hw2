package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* Keeps track of one Elevator and multiple Floor
************************************************************/

import java.util.stream.*;

public class Building {

    public static final int FLOORS = 7;
    public Elevator myElevator;
    public Floor allFloorsArray[] = new Floor[FLOORS];
 
/** Initializes the current floor, and direction.
* Class variables description - 
* A constant, (i.e., a static final field), for the number of floors in the building.
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* An array-valued field for tracking, each floor, and # passengers destined for that floor. 
*/
 public Building() {
        this.myElevator = new Elevator(this);
        for (int i = 0; i < FLOORS; i++) {
            allFloorsArray[i] = new Floor(this, i); 
        }
    }

	
    public Floor getFloor(int floorNumber) {
        return this.allFloorsArray[floorNumber - 1];
    }
	
    public Elevator getElevator() {
        return this.myElevator;
    }

}