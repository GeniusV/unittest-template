package com.geniusver.hello.unittest;

/**
 * Created by GeniusV on 2019-08-24.
 */
public class Car {
    private int price;

    public Car() {
    }

    public Car(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Car createCar() {
        Car car = new Car();
        car.setPrice(1000);
        return car;
    }

}
