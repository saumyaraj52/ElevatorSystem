package main;

public class ExternalButton {
    Direction direction;
    ExternalButtonDispatcher externalButtonDispatcher;
     public ExternalButton (ExternalButtonDispatcher externalButtonDispatcher)
     {
         this.externalButtonDispatcher = externalButtonDispatcher;
     }


}
