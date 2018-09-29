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
            int expectedFloorNumber = 1;
            elevator.boardPassenger(6);
            elevator.boardPassenger(6);
            elevator.boardPassenger(6);
            elevator.move();
            elevator.boardPassenger(4);
            elevator.boardPassenger(4);
            elevator.move();
            elevator.move();
            elevator.boardPassenger(3);
           
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
            
        }
        
    }