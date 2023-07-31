package com.grpc.demo.grpcdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpcdemo.models.Person;
import json.JsonPerson;

/**
 *  Perf Test Class
 *  Date: 7/21/23
 * */
public class PerformanceTest {
  public static void main(String[] args){

    JsonPerson person = new JsonPerson();
    person.setName("sam");
    person.setAge(10);
    ObjectMapper mapper = new ObjectMapper();

    // json serialize and deserialize lambda method
    Runnable json = () -> {
      try {
        byte[] bytes = mapper.writeValueAsBytes(person); // serialize into byte so that it can be sent over network
        JsonPerson person1 = mapper.readValue(bytes, JsonPerson.class); // de-serialize back into Java object
      } catch (Exception e) {
        e.printStackTrace();
      }
    };

    // protobuf
    Person sam = Person.newBuilder()
      .setName("sam")
      .setAge(10)
      .build();

    // protobuf serialize and deserialize lambda method
    Runnable proto = () -> {
      try {
        byte[] bytes = sam.toByteArray(); // serialize into byte so that it can be sent over network
        Person sam1 = Person.parseFrom(bytes); // de-serialize back into Java object
      } catch (Exception e) {
        e.printStackTrace();
      }
    };

    for (int i=0; i<10; i++){
      runPerformanceTest(json, "JSON");
      runPerformanceTest(proto, "PROTO");
    }

  }

  private static void runPerformanceTest(Runnable runnable, String method){
    long time1 = System.currentTimeMillis();
    for(int i=0; i<1000000; i++){
      runnable.run();
    }
    long time2 = System.currentTimeMillis();
    System.out.println(
      method + " took: " + (time2 - time1) + " ms");
  }
}
