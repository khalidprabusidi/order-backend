package com.kps.orderbackend;

import com.kps.orderbackend.model.Balloon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrderBackendApplication {

	public static void main(String[] args) {
		System.out.println("------ hello -------");

		Balloon red = new Balloon("Red"); // memory reference = 50
		Balloon blue = new Balloon("Blue"); // memory reference = 100

		swap(red, blue);
		System.out.println("After the swap method executes:");
		System.out.println("`red` color value = " + red.getColor());
		System.out.println("`blue` color value = " + blue.getColor());

		changeValue(blue);
		System.out.println("After the changeValue method executes:");
		System.out.println("`blue` color value = " + blue.getColor());

		SpringApplication.run(OrderBackendApplication.class, args);
	}

	// Generic swap method
	public static void swap(Balloon o1, Balloon o2){
		o1.setColor("Blue");
		o2.setColor("Red");
		Balloon temp = o1;
		o1 = o2;
		o2 = temp;
	}

	private static void changeValue(Balloon balloon) { // balloon = 100
		balloon.setColor("Red"); // balloon = 100
		balloon = new Balloon("Green"); // balloon = 200
		balloon.setColor("Blue"); // balloon = 200
	}

}
