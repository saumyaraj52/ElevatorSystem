package main;

public class Elevator {
    Display display;
    InternalButton internalButton;
    Status status;

    int currentFloor;
    Direction dir;

    public Elevator(int floors,InternalButtonDispatcher internalButtonDispatcher)
    {
        this.display = new Display();
        this.internalButton = new InternalButton(floors,internalButtonDispatcher);
        this.status = Status.IDLE;
        this.currentFloor = 0;
        this.dir = Direction.UP;
    }

    public void pressButton(int id)
    {
        this.internalButton.internalButtonDispatcher.acceptNewRequest(id);
    }
    public void move(Request request) throws InterruptedException {
        System.out.print("Current Floor Number: "+this.currentFloor);
        System.out.println("  Floor Number: "+request.floorNum+"  Direction: "+request.dir);
        int newFloor = request.floorNum;
        Direction newDirection = request.dir;
        if(newDirection == Direction.UP) {
            for (int i = this.currentFloor + 1; i <= newFloor; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("We have reached floor -- " + i);
                this.currentFloor = i;
                this.status = Status.MOVING;
            }
        }
        else {
            for (int i = this.currentFloor - 1; i >= newFloor; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("We have reached floor -- " + i);
                this.currentFloor = i;
                this.status = Status.MOVING;
            }
        }
        //this.status = Status.MOVING;
        this.dir = newDirection;
        //Thread.sleep(1000);
        //this.currentFloor = newFloor;
    }
}

