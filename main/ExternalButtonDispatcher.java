package main;

public class ExternalButtonDispatcher {
    ElevatorController elevatorController;
    public ExternalButtonDispatcher(ElevatorController elevatorController)
    {
        this.elevatorController = elevatorController;
    }
    public ExternalButtonDispatcher()
    {
        //
    }
    public void acceptNewRequest(Direction curDirection,int newFloor)
    {
        System.out.println("New Request External Direction : "+curDirection+" Floor : "+newFloor);
        int curFloor = this.elevatorController.elevator.currentFloor;
        Direction curElevatorDirection = this.elevatorController.elevator.dir;
        if(curElevatorDirection == Direction.UP)
        {
            if(curDirection == Direction.UP&&curFloor<=newFloor)
            {
                this.elevatorController.addRequest(new Request(newFloor,curDirection));
            }
            else if(curDirection == Direction.UP&&curFloor>newFloor)
            {
                this.elevatorController.addRequest(new Request(newFloor,Direction.DOWN));
            }
            else if(curDirection == Direction.DOWN)
            {
                this.elevatorController.addRequest(new Request(newFloor,curDirection));
            }
        }
        else
        {
            if(curDirection == Direction.UP)
            {
                this.elevatorController.addRequest(new Request(newFloor,curDirection));
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
}
