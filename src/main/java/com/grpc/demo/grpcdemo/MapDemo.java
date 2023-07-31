package com.grpc.demo.grpcdemo;

import com.grpcdemo.models.BodyStyle;
import com.grpcdemo.models.Car;
import com.grpcdemo.models.Dealer;

/**
 *  Created By esun
 *  Date: 7/26/23
 * */
public class MapDemo {
  public static void main(String[] args) {
    Car accord = Car.newBuilder()
      .setMake("Honda")
      .setModel("Accord")
      .setBodyStyle(BodyStyle.COUPE)
      .setYear(2023)
      .build();

    Car civic = Car.newBuilder()
      .setMake("Honda")
      .setModel("Civic")
      .setBodyStyle(BodyStyle.SUV)
      .setYear(2015)
      .build();

    // { int :  Car instance }
    Dealer newDealer = Dealer.newBuilder()
      .putModel(2000, civic)
      .putModel(2020, accord).build();

    System.out.println(
      newDealer.getModelOrThrow(2020).getBodyStyle()
//      newDealer.getModelMap()
//      newDealer.getModelOrDefault(2019, accord) // if key not exist, it will use a default value passed
    );

//      (newDealer.getModelOrThrow(2001));

  }
}
