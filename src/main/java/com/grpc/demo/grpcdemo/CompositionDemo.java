package com.grpc.demo.grpcdemo;

import com.grpcdemo.models.Address;
import com.grpcdemo.models.Car;
import com.grpcdemo.models.Person;
import java.util.ArrayList;

/**
 *  Created By esun
 *  Date: 7/24/23
 * */
public class CompositionDemo {
  public static void main(String[] args){
    Address add = Address.newBuilder()
      .setPostbox(123)
      .setCity("Atlanta")
      .build();

    Car accord = Car.newBuilder()
      .setMake("Honda")
      .setModel("Accord")
      .setYear(2023)
      .build();

    Car civic = Car.newBuilder()
      .setMake("Honda")
      .setModel("Civic")
      .setYear(2015)
      .build();

    ArrayList<Car> cars = new ArrayList<Car>();
    cars.add(accord);
    cars.add(civic);

    Person sam = Person.newBuilder()
      .setName("Sam")
      .setAge(25)
      .setAddress(add)
      .addAllCar(cars)
      .build();

    System.out.println(sam);
  }
}
