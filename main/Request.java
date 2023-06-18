package main;

public class Request {
    Direction dir;
    int floorNum;

    public Request(int id,Direction dir)
    {
        this.floorNum = id;
        this.dir = dir;
    }

}
