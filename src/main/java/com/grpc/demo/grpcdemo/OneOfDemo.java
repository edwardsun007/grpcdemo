package com.grpc.demo.grpcdemo;

import com.grpcdemo.models.Credentials;
import com.grpcdemo.models.EmailCredentials;
import com.grpcdemo.models.PhoneOTP;

/**
 *  Created By esun
 *  Date: 7/30/23
 * */
public class OneOfDemo {

  private static void login(Credentials credentials) {

    // getModeCase is from protobuf
    switch (credentials.getModeCase()){
      case EMAILMODE:
        System.out.println(
          credentials.getEmailMode()
        );
        break;

      case PHONEMODE:
        System.out.println(
          credentials.getPhoneMode()
        );
        break;
    }




  }

  public static void main(String[] args) {
    EmailCredentials emailCredentials = EmailCredentials.newBuilder()
      .setEmail("grpclearner@gmail.com")
      .setPassword("admin123")
      .build();

    PhoneOTP phoneOTP = PhoneOTP.newBuilder()
      .setNumber(1231231234)
      .setCode(456)
      .build();


    // in OneOf protobuf, it can only use one of this, in the following code, we set both, 2nd one will erase the first .setEmailMode
    Credentials credentials = Credentials.newBuilder()
        .setPhoneMode(phoneOTP)
        .setEmailMode(emailCredentials)
        .build();
    login(credentials);
  }


}
