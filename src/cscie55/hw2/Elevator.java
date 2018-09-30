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

        System.out.println(this.toString());

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

        int numWaitingOnFloor = myBuilding.getFloor(this.currentFloor).getPassengersWaiting();
        int spareCapacity = CAPACITY - this.getPassengers();
        // System.out.println("Floor: " + getCurrentFloor() + " Num Waiting: " + numWaitingOnFloor + " Spare: " + spareCapacity + " Num inside: " + this.getPassengers());

        myBuilding.getFloor(this.currentFloor).clearNumPass();

        // System.out.println("Floor: " + getCurrentFloor() + " Num Waiting: " + numWaitingOnFloor + " Spare: " + spareCapacity + " Num inside: " + this.getPassengers());

        
        // System.out.println("Floor: " + getCurrentFloor() + " Num Waiting: " + numWaitingOnFloor + " Spare: " + spareCapacity + " Num inside: " + this.getPassengers());
        int numToBoard = Math.min(spareCapacity, numWaitingOnFloor);    // will board the number of people of waiting, or the spare capacity, whichever is the lesser value
        if(numWaitingOnFloor > 0 && this.getPassengers() < CAPACITY) {  // loop to board the persons waiting on a floor 
            System.out.println("Inside for loop");
            for (int i = 0; i < numWaitingOnFloor; i++) {                      // will only board waiting people up to the capacity limit
                try {
                    if (this.currentFloor == 1) {                       // instructions state waiting passengers on
                        this.boardPassenger(Building.FLOORS);           // first floor go to higher floor
                        myBuilding.getFloor(this.currentFloor).clearIsWaitingArray(); // for each person boarded, decrement waiting array   
                        System.out.println("Inside Try Block");
                    }                                           
                    else {
                        System.out.println("Inside else " + this.getPassengers());
                        this.boardPassenger(1);                         // people waiting on higher floors go to floor 1.
                        myBuilding.getFloor(this.currentFloor).clearIsWaitingArray(); // for each person boarded, decrement waiting array  
                    }
                    System.out.println("Exit else " + this.getPassengers());
                }
                catch(ElevatorFullException e) {
                    System.out.println("Inside catch " + this.getPassengers());
                    break;
                    // this.move();
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
            myBuilding.getFloor(this.currentFloor).waitForElevator(); // passengers who can't board because of full capacity get placed in the wait for elevator queue
            System.out.println("Inside Exception");
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