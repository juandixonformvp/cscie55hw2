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

            try {
                elevator.boardPassenger(7);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(7);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(6);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(6);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(5);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(5);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(4);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(4);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(5);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(5);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(6);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(6);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(7);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
            try {
                elevator.boardPassenger(7);
            }
            catch(ElevatorFullException e) {
                elevator.move();
            }
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