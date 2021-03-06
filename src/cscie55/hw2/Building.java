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
 
/** Initializes an array of "Floor" instances
* Class variables description - 
* A constant, (i.e., a static final field), for the number of floors in the building.
* An Elevator instance
* An array that contains "Floor" instances 
*/
 public Building() {
        this.myElevator = new Elevator(this);
        for (int i = 0; i < FLOORS; i++) {
            allFloorsArray[i] = new Floor(this, i); // note that floor can be zero
        }
    }

    public Floor getFloor(int floorNumber) {
        return this.allFloorsArray[floorNumber - 1];
    }
	
    public Elevator getElevator() {
        return this.myElevator;
    }

}