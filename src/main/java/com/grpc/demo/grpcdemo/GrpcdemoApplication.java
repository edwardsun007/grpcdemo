package com.grpc.demo.grpcdemo;

import com.grpcdemo.models.Person;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcdemoApplication {

	public static void main(String[] args) throws IOException {
//		Person sam = Person.newBuilder()
//			.setName("sam")
//			.setAge(10)
//			.build();

		Path path = Paths.get("sam.ser"); // convert a string or sequence of string into a Path
		// This will create a file in project root directory called sam.ser / serialize
//		Files.write(path, sam.toByteArray()); // This write the sam instance as bytearray into the file


		byte[] bytes = Files.readAllBytes(path); // read the bytes array / deserialize
		Person newSam = Person.parseFrom(bytes);
		System.out.println(newSam);
//		System.out.println(Edward.equals(sam));
		// .equals is shallow check on value for each field of Person instance, if both instance have same values for each
		// field , it will consider equal
		/*
		* .equals cannot be override in protobuf generated class
		* you will have to create separate utility class
		* */
//		SpringApplication.run(GrpcdemoApplication.class, args);

	}

}
