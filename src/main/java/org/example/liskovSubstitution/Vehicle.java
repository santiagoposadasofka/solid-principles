package org.example.liskovSubstitution;

abstract class Vehicle {
    protected int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public abstract void startEngine();
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(int maxSpeed, int numberOfDoors) {
        this.maxSpeed = maxSpeed;
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(int maxSpeed, boolean hasSidecar) {
        this.maxSpeed = maxSpeed;
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started");
    }
}

class VehicleTest {
    public static void main(String[] args) {
        Vehicle car = new Car(120, 4);
        car.startEngine();
        Vehicle motorcycle = new Motorcycle(80, false);
        motorcycle.startEngine();
    }
}