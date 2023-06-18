package main;

import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floorList;
    int MAX_FLOOR;
    ExternalButtonDispatcher externalButtonDispatcher;

    public Building(int floors,ExternalButtonDispatcher externalButtonDispatcher)
    {
        this.MAX_FLOOR = floors;
        this.externalButtonDispatcher = externalButtonDispatcher;
        this.floorList = new ArrayList<>();
        for(int i=0;i<=floors;i++)
        	this.floorList.add(new Floor(i,externalButtonDispatcher));
    }
}
