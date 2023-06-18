package main;
class ProcessJobWorker implements Runnable {
    private ElevatorController elevatorController;


    public ProcessJobWorker(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void run() {
        /**
         * start the elevator
         */
        try {
            this.elevatorController.moveElevator();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}