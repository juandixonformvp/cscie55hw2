package cscie55.hw2;

public class myTest {

    /** Creates an Elevator object then tests the class.
    * 
    * 
    */    
        public static void main(String[] argv){
            System.out.println("");
            System.out.println("testing");
            Building building = new Building();
            Elevator elevator = building.getElevator();

            building.getFloor(1).waitForElevator();
            building.getFloor(1).waitForElevator();
            building.getFloor(2).waitForElevator();
            building.getFloor(2).waitForElevator();
            building.getFloor(3).waitForElevator();
            building.getFloor(3).waitForElevator();
            building.getFloor(4).waitForElevator();
            building.getFloor(4).waitForElevator();
            building.getFloor(5).waitForElevator();
            building.getFloor(5).waitForElevator();
            building.getFloor(6).waitForElevator();
            building.getFloor(6).waitForElevator();
            building.getFloor(7).waitForElevator();
            building.getFloor(7).waitForElevator();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();
            elevator.move();

            // try {
            //     elevator.boardPassenger(3);
            // }
            // catch(ElevatorFullException e) {
            //     elevator.move();
            // }
            // try {
            //     elevator.boardPassenger(3);
            // }
            // catch(ElevatorFullException e) {
            //     elevator.move();
            // }
            // elevator.move();
            // elevator.move();
            // elevator.move();
            // elevator.move();
            
        }
        
    }