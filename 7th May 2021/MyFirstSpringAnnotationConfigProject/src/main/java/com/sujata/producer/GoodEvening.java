package com.sujata.producer;

import org.springframework.stereotype.Component;
/*if you will not give the name of the component
 * then the name of the component will b same as that of class but in camelCase
 */
@Component("mrng")
public class GoodEvening implements Greet {

	@Override
	public void wish(String name) {
		System.out.println("Good Evening "+name);

	}

}
