package OOPSLAB;

interface Vehicle {
     void start();
     void stop ();
}

class Car implements Vehicle{
    public void start(){
        System.out.println("Vehicle started");
    }
    public void stop(){
        System.out.println("Vehicle stopped");
    }
}

public class Interfaces {
    static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }
}