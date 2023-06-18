package main;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ElevatorController {
    Elevator elevator;
    PriorityQueue<Request> requestPriorityQueueUp;
    PriorityQueue<Request> requestPriorityQueueDown;

    /*private TreeSet<Request> currentJobs ;
    private TreeSet<Request> upPendingJobs;
    private TreeSet<Request> downPendingJobs;*/

    ArrayList<Request> upRequest;
    ArrayList<Request> downRequest;

    public ElevatorController(Elevator elevator)
    {
        this.requestPriorityQueueDown = new PriorityQueue<>((p1,p2)->p2.floorNum- p1.floorNum);
        this.requestPriorityQueueUp = new PriorityQueue<>((p1,p2)->p1.floorNum- p2.floorNum);
        this.upRequest = new ArrayList<>();
        this.downRequest = new ArrayList<>();
        this.elevator = elevator;
        //this.upPendingJobs = new TreeSet<>();
        //this.downPendingJobs = new TreeSet<>();
        //this.currentJobs = new TreeSet<>();
    }


    public void addRequest(Request request)
    {
        //check if on the way
        //System.out.println("Current Direction : "+this.elevator.dir);
        //System.out.println("Current Floor : "+this.elevator.currentFloor);
        if(this.elevator.dir == Direction.UP)
        {
            if(request.dir == Direction.UP&&this.elevator.currentFloor <=request.floorNum)
            {
                this.requestPriorityQueueUp.add(request);
            }
            else if(request.dir == Direction.UP&&this.elevator.currentFloor >request.floorNum)
            {
                this.upRequest.add(request);
            }
            else
            {
                this.downRequest.add(request);
            }
        }
        else {
            if(request.dir == Direction.DOWN&&this.elevator.currentFloor >=request.floorNum)
            {
                this.requestPriorityQueueDown.add(request);
            }
            else if(request.dir == Direction.DOWN&&this.elevator.currentFloor <request.floorNum)
            {
                this.downRequest.add(request);
            }
            else {
                this.upRequest.add(request);
            }
        }
        System.out.println("Up Queue size() : " + this.requestPriorityQueueUp.size());
        System.out.println("Down Queue size() : " + this.requestPriorityQueueDown.size());
        System.out.println("Down Request size() : " + this.downRequest.size());
        System.out.println("Up Request size() : " + this.upRequest.size());
    }

    public int totalRequest()
    {
        int ans =0;
        ans+= requestPriorityQueueUp.size();;
        ans+=requestPriorityQueueDown.size();
        ans+= upRequest.size();
        ans+= downRequest.size();
        return ans;
    }
    public void moveElevator() throws InterruptedException
    {
        System.out.println("The Elevator has started functioning");
        while(true)
        {
            //System.out.println("Up Queue size() : " + this.requestPriorityQueueUp.size());
            //System.out.println("Down Queue size() : " + this.requestPriorityQueueDown.size());
            //System.out.println("Down Request size() : " + this.downRequest.size());
            //System.out.println("Up Request size() : " + this.upRequest.size());
            if (this.elevator.dir == Direction.UP)
            {
                while (this.requestPriorityQueueUp.size()>0)
                {
                    //System.out.println("Up Queue size() : " + this.requestPriorityQueueUp.size());
                    //check if on the way
                    System.out.println("Current Direction : "+this.elevator.dir);
                    System.out.println("Current Floor : "+this.elevator.currentFloor);
                    Request currentRequest = this.requestPriorityQueueUp.poll();
                    this.elevator.move(currentRequest);
                }

                while (!this.requestPriorityQueueDown.isEmpty())
                {
                    System.out.println("Down Queue size() : " + this.requestPriorityQueueDown.size());
                    Request currentRequest = this.requestPriorityQueueDown.poll();
                    this.elevator.move(currentRequest);
                }
            }
            else
            {
                while (!this.requestPriorityQueueDown.isEmpty())
                {
                    Request currentRequest = this.requestPriorityQueueDown.poll();
                    this.elevator.move(currentRequest);
                }
                while (!this.requestPriorityQueueUp.isEmpty())
                {
                    Request currentRequest = this.requestPriorityQueueUp.poll();
                    this.elevator.move(currentRequest);
                }
            }
            for (int i = 0; i < this.upRequest.size(); i++) {
                this.requestPriorityQueueUp.add(this.upRequest.get(i));
            }
            this.upRequest.clear();

            for (int i = 0; i < this.downRequest.size(); i++) {
                this.requestPriorityQueueDown.add(this.downRequest.get(i));
            }
            this.downRequest.clear();
        }
    }
}
