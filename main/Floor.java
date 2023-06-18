package main;

public class Floor {
    ExternalButton externalButton;
    int id;

    public Floor(int floorId,ExternalButtonDispatcher externalButtonDispatcher)
    {
        this.externalButton = new ExternalButton(externalButtonDispatcher);
        this.id = floorId;
    }

    public void pressButton(Direction dir)
    {
        this.externalButton.externalButtonDispatcher.acceptNewRequest(dir,this.id);
    }
}
