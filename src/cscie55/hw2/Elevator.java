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

        int numWaitingOnFloor = myBuilding.getFloor(this.currentFloor).getPassengersWaiting();
        System.out.println("Waiting " + numWaitingOnFloor);
        // System.out.println("Waiting on Floor 1 " + myBuilding.getFloor(1).getPassengersWaiting());
        int spareCapacity = CAPACITY - this.getPassengers();
        int numToBoard = Math.min(spareCapacity, numWaitingOnFloor);
        System.out.println("Board this many " + spareCapacity);
        if(numWaitingOnFloor > 0 && this.getPassengers() < CAPACITY) {     // loop to board the persons waiting on a floor 
            System.out.println("inside catch");
            for (int i = 0; i < numToBoard; i++) {   // will only board waiting people up to the capacity limit
                // System.out.println(i);
                try {
                    // if (this.currentFloor == 1) {               // instructions state waiting passengers on
                    //     this.boardPassenger(Building.FLOORS);   // first floor go to higher floor
                    //     myBuilding.getFloor(this.currentFloor).clearIsWaitingArray(); // for each person boarded, decrement waiting array   
                    // }                                           
                    // else {
                    //     this.boardPassenger(1);                 // people waiting on higher floors go to floor 1.
                    //     myBuilding.getFloor(this.currentFloor).clearIsWaitingArray(); // for each person boarded, decrement waiting array  
                    // }
                    this.boardPassenger(1);
                    myBuilding.getFloor(this.currentFloor).clearIsWaitingArray();
                }
                catch(ElevatorFullException e) {
                    this.move();
                }
            }
            
        }

        

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
        if(this.getPassengers() >= CAPACITY) {
            myBuilding.getFloor(this.currentFloor).waitForElevator(); // passengers who can't board because of full capacity get placed in the wait for elevator queue
            throw new ElevatorFullException("Elevator is at full capacity. Please wait for the elevator to return.");
        }
        else {
            myBuilding.getFloor(destinationFloorNumber).setNumPass();
        }
    }

    public int getPassengers() {
        int tempSum = 0;
        for (Floor tempFloor : myBuilding.allFloorsArray) {
            tempSum = tempSum + tempFloor.getNumPass(); 
        }
        return tempSum;
    }

    public String toString(){
        return "Floor "+getCurrentFloor()+" Dir: "+getDirectionUp()+" NumPass: "+getPassengers();

    }

}