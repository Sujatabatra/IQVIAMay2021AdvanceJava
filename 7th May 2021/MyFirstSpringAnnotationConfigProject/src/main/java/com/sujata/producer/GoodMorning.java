package com.sujata.producer;

import org.springframework.stereotype.Component;

@Component("eve")
public class GoodMorning implements Greet {

	@Override
	public void wish(String name) {
		System.out.println("Good Morning "+name);

	}

}
