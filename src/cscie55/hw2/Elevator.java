package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* The Elevator moves passengers between Floors
************************************************************/

import java.io.IOException;

public class Elevator {

    public static final int CAPACITY = 10;
    private int currentFloor;
    private boolean directionUp;
    private Building myBuilding;
 
/** Initializes the current floor, and direction.
* Class variables description - 
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* A field for tracking the Building instance. 
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
* Modifies the direction of travel, if the ground floor or top floor has been reached.
* Clears the array entry tracking the number of passengers destined for the floor.
* Checks to see if there are passengers waiting on the current floor and boards them.
* Prints out the status of the Elevator.
*
*/
    public void move() {

        System.out.println("Before move: "+this.toString());    // checks status of elevator after boarding and before moving on
        // Next block of code is unchanged from HW1, basic move functionality
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
         
        myBuilding.getFloor(this.currentFloor).clearNumPass();  // empties passengers who should get off on current floor
        int numWaitingOnFloor = myBuilding.getFloor(this.currentFloor).getPassengersWaiting(); // counts number of waiting passengers
        if(numWaitingOnFloor > 0 && this.getPassengers() < CAPACITY) {  // loop to board the persons waiting on a floor 
            for (int i = 0; i < numWaitingOnFloor; i++) {               // will only board waiting people up to the capacity limit
                try {
                    this.boardPassenger(1);                         // people waiting go to floor 1.
                    myBuilding.getFloor(this.currentFloor).clearIsWaitingArray(); // for each person boarded, decrement waiting array  
                }
                catch(ElevatorFullException e) {
                    break;
                }
            }   
        }

    }

/**
* The "boardPassenger" method adds to the Elevator one passenger destined for the indicated floor.
*
*/
    public void boardPassenger(int destinationFloorNumber) throws ElevatorFullException {
        if(this.getPassengers() >= CAPACITY) {
            throw new ElevatorFullException("Elevator is at full capacity. Please wait for the elevator to return.");
        }
        else {
            myBuilding.getFloor(destinationFloorNumber).setNumPass();
        }
    }

/**
* The "getPassengers" method returns the total number of persons currently in the elevator.
*
*/    
    public int getPassengers() {
        int tempSum = 0;
        for (Floor tempFloor : myBuilding.allFloorsArray) {
            tempSum = tempSum + tempFloor.getNumPass(); 
        }
        return tempSum;
    }

    public String toString(){
        return "Floor: "+getCurrentFloor()+" Dir: "+getDirectionUp()+" NumPass: "+getPassengers();

    }

}