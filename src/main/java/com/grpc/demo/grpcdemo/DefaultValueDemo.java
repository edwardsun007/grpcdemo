package com.grpc.demo.grpcdemo;

import com.grpcdemo.models.Person;

/**
 *  Created By esun
 *  Date: 7/30/23
 * */
public class DefaultValueDemo {

  public static void main(String[] args) {
    Person person = Person.newBuilder().build();

    System.out.println(
      "City : " + person.getAddress().getCity() // it will print city:    which shows blank as default value
    );

    System.out.println(
      person.hasAddress() // protobuf doesn't have null, default value is blank, this print false
    );


  }
}
