package cscie55.hw2;

public class myTest {

    /** Creates an Elevator object then tests the class.
    * 
    * 
    */    
        public static void main(String[] argv){
            System.out.println("");
            System.out.println("testing");
            
        // Don't board any passengers. Just check that the elevator moves up and down correctly.
        // System.out.println("Checking movement only");
        // Building building = new Building();
        // Elevator elevator = building.getElevator();
        // int expectedFloorNumber = 1;
        // // Go to the top
        // while (expectedFloorNumber < Building.FLOORS) {
        //     elevator.move();
        //     expectedFloorNumber++;
        // }
        // // Go back to the bottom
        // while (expectedFloorNumber > 1) {
        //     elevator.move();
        //     expectedFloorNumber--;
        // }
        // System.out.println("End Checking movement only");

    // Check that passengers get on and off correctly.
    
        // Building building = new Building();
        // Elevator elevator = building.getElevator();
        // // Add passengers and disembark them on the way up
        // System.out.println("Checking Disembark");
        // try {
        //     elevator.boardPassenger(3);
        // }
        // catch(ElevatorFullException e) {
        //     elevator.move();
        // }
        // try {
        //     elevator.boardPassenger(4);
        // }
        // catch(ElevatorFullException e) {
        //     elevator.move();
        // }
        // try {
        //     elevator.boardPassenger(4);
        // }
        // catch(ElevatorFullException e) {
        //     elevator.move();
        // }
        // try {
        //     elevator.boardPassenger(6);
        // }
        // catch(ElevatorFullException e) {
        //     elevator.move();
        // }
        // try {
        //     elevator.boardPassenger(6);
        // }
        // catch(ElevatorFullException e) {
        //     elevator.move();
        // }
        // try {
        //     elevator.boardPassenger(6);
        // }
        // catch(ElevatorFullException e) {
        //     elevator.move();
        // }
        // elevator.move();
        // elevator.move();
        // elevator.move();
        // elevator.move();
        // elevator.move();
        // elevator.move();
        // System.out.println("End Checking Disembark");
    

    // // Check that passengers on higher floors can call and board the elevator, and then
    // // disembark on the ground floor.
    //     Building building = new Building();
    //     Elevator elevator = building.getElevator();
    //     System.out.println("Checking higher floors can call and board");
    //     building.getFloor(3).waitForElevator();
    //     building.getFloor(3).waitForElevator();
    //     building.getFloor(6).waitForElevator();
    //     building.getFloor(6).waitForElevator();
    //     building.getFloor(6).waitForElevator();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     elevator.move();
    //     System.out.println("End checking higher floors can call and board");

    // Check handling of a full elevator.
        Building building = new Building();
        Elevator elevator = building.getElevator();
        // Have enough people waiting on the 4th floor to exceed elevator capacity by 50%
        System.out.println("Checking 4th Full");
        int waiting = (int) (Elevator.CAPACITY * 1.5);
        for (int i = 0; i < waiting; i++) {
            building.getFloor(4).waitForElevator();
        }
        // Move to 4, checking state
        elevator.move();
        elevator.move();
        elevator.move();
        // Should have filled the elevator, leaving people on 4
        // Get to the ground floor
        while (elevator.getCurrentFloor() != 1) {
            elevator.move();
            if (elevator.getCurrentFloor() == 1) {
            } else {
            }
        }
        // Go back to 4
        while (elevator.getCurrentFloor() != 4) {
            elevator.move();
            if (elevator.getCurrentFloor() == 4) {
                // Check to see that the remaining passengers boarded
            } else {
            }
        }
        System.out.println("End Checking 4th Full");
    }
}