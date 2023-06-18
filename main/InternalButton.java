package main;

import java.util.ArrayList;
import java.util.List;

public class InternalButton {
    List<Integer> floors;
    InternalButtonDispatcher internalButtonDispatcher;

    public InternalButton(int noOfFloors,InternalButtonDispatcher internalButtonDispatcher)
    {
        this.floors = new ArrayList<>(noOfFloors);
        this.internalButtonDispatcher = internalButtonDispatcher;
    }

    /*public void pressButton(int id)
    {
        if(id<floors.size())
        {
            //this.internalButtonDispatcher.acceptNewRequest(new Request(id));
        }
    }*/


}
