package main;

public class InternalButtonDispatcher {

    ElevatorController elevatorController;

    public InternalButtonDispatcher(ElevatorController elevatorController)
    {
        this.elevatorController = elevatorController;
    }
    public InternalButtonDispatcher()
    {

    }

    public void acceptNewRequest(int newFloor)
    {
        System.out.println("New Request Internal Floor : "+newFloor);
        int curFloor = this.elevatorController.elevator.currentFloor;
        Direction curDirection = this.elevatorController.elevator.dir;
        if(curDirection == Direction.UP&&curFloor<=newFloor)
        {
            this.elevatorController.addRequest(new Request(newFloor,curDirection));
        }
        else if(curDirection == Direction.UP&&curFloor>newFloor)
        {
            this.elevatorController.addRequest(new Request(newFloor,Direction.DOWN));
        }
        else if(curDirection == Direction.DOWN&&curFloor>=newFloor)
        {
            this.elevatorController.addRequest(new Request(newFloor,curDirection));
        }
        else
        {
            this.elevatorController.addRequest(new Request(newFloor, Direction.UP));
        }
    }
}
