package cscie55.hw2;

/************************************************************ 
* HW2, Part I -  
* The Elevator moves passengers between Floors
************************************************************/

import java.util.stream.*;
import java.io.IOException;

public class Elevator {

    private static final int CAPACITY = 10;
    private int currentFloor;
    private boolean directionUp;
    private int numPassDest[] = new int[FLOORS];
 
/** Initializes the current floor, and direction.
* Class variables description - 
* A constant, (i.e., a static final field), for the number of floors in the building.
* A field for tracking the Elevator's current floor. 
* A field for tracking the Elevator's direction of travel.
* An array-valued field for tracking, each floor, and # passengers destined for that floor. 
*/
 public Elevator() {
        this.currentFloor = 1;
        this.directionUp = true;
    }

	
    public int getCurrentFloor() {

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
    public void move() {

        System.out.println(this.toString());

        if (currentFloor == 1) {
            this.directionUp = true;
        }    

        if (currentFloor == FLOORS) {
            this.directionUp = false;
        }

        if (directionUp == true) {
            this.currentFloor++;
        }    

        else {
            this.currentFloor--;
        }

        this.numPassDest[currentFloor - 1] = 0;


    }

/**
* The "boardPassenger" method adds to the Elevator one passenger destined for the indicated floor.
*
*/
    public void boardPassenger(int destinationFloor) throws ElevatorFullException {
        try {
            List<String> lines = Files.readAllLines(filePath, charset);

            for (String line : lines) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e);
            throw new ElevatorFullException("My Cephalopod... He's Gone!", e.getCause());
       }
       finally{
          // this block ALWAYS fires, with or w/o an exception.
          System.out.println("Ultimately, it is a thing accomplished!");
       }    
    }

    public String toString(){
        return "[Floor "+getCurrentFloor()+": "+getNumPass()+" passengers]";

    }


}