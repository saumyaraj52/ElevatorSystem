package main;

public class ElevatorSystem {
    public static void main(String[] args) throws InterruptedException {
        InternalButtonDispatcher internalButtonDispatcher = new InternalButtonDispatcher();
        ExternalButtonDispatcher externalButtonDispatcher=new ExternalButtonDispatcher();
        Building building = new Building(10,externalButtonDispatcher);
        Elevator elevator = new Elevator(10,internalButtonDispatcher);
        ElevatorController elevatorController = new ElevatorController(elevator);
        internalButtonDispatcher.elevatorController = elevatorController;
        externalButtonDispatcher.elevatorController = elevatorController;

        building.floorList.get(5).pressButton(Direction.UP);
        elevator.internalButton.internalButtonDispatcher.acceptNewRequest(8);
        building.floorList.get(2).pressButton(Direction.DOWN);
        elevator.internalButton.internalButtonDispatcher.acceptNewRequest(0);

        ProcessJobWorker processJobWorker = new ProcessJobWorker(elevatorController);
        Thread t2 = new Thread(processJobWorker);
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread.sleep(9000);
        building.floorList.get(3).pressButton(Direction.UP);
        elevator.internalButton.internalButtonDispatcher.acceptNewRequest(5);
        //building.floorList.get(5).pressButton(Direction.DOWN);
        //building.floorList.get(2).pressButton(Direction.UP);
        //building.floorList.get(3).pressButton(Direction.UP);


        /**
         * Pass job to the elevator
         */
        /*new Thread(new AddJobWorker(elevatorController, request1)).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        System.out.println("Done");
    }
}

