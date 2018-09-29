package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* The Elevator moves passengers between Floors
************************************************************/

import java.io.IOException;

public class Elevator {

    private static final int CAPACITY = 10;
    private int currentFloor;
    private boolean directionUp;
    private Building myBuilding;
 
/** Initializes the current floor, and direction.
* Class variables description - 
* A constant, (i.e., a static final field), for the number of floors in the building.
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* An array-valued field for tracking, each floor, and # passengers destined for that floor. 
*/
 public Elevator(Building building) {
        this.currentFloor = 1;
        this.directionUp = true;
        this.myBuilding = building;
    }

	
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public boolean getDirectionUp() {
        return this.directionUp;
    }

/**
* The "move" method increments/decrements the current floor. 
* The Elevator moves one floor at a time.
* Modifies the direction of travel, if the ground floor or top floor has been reached.
* Clears the array entry tracking the number of passengers destined for the floor.
* Prints out the status of the Elevator.
*
*/
    public void move() {

        myBuilding.getFloor(this.currentFloor).clearNumPass();
        System.out.println("Current" + this.currentFloor);
        System.out.println(myBuilding.getFloor(this.currentFloor).getIsWaitingArray());

        // if(myBuilding.getFloor(this.currentFloor).getIsWaitingArray() == true) {
        //     try {
        //         this.boardPassenger(1);
        //     }
        //     catch(ElevatorFullException e) {
        //         this.move();
        //     }
        // }

        if (currentFloor == 1) {
            this.directionUp = true;
        }    

        if (currentFloor == Building.FLOORS) {
            this.directionUp = false;
        }

        if (directionUp == true) {
            this.currentFloor++;
        }    

        else {
            this.currentFloor--;
        }

        System.out.println(this.toString());

    }

/**
* The "boardPassenger" method adds to the Elevator one passenger destined for the indicated floor.
*
*/

    public void boardPassenger(int destinationFloorNumber) throws ElevatorFullException {
        if(myBuilding.getTotalPass() >= CAPACITY) {
            throw new ElevatorFullException("Elevator is at full capacity. Please wait for the elevator to return.");
        }
        else {
            myBuilding.getFloor(destinationFloorNumber).setNumPass();
        }
    }

    public String toString(){
        return "Floor "+getCurrentFloor()+" Dir: "+getDirectionUp()+" NumPass: "+myBuilding.getTotalPass();

    }


}