package com.sujata.model.service;

import com.sujata.bean.MyNumbers;

public class MyCalculatorServiceImpl implements MyCalculatorService {

	@Override
	public int sum(MyNumbers numbers) {
		return numbers.getNumber1()+numbers.getNumber2();
	}

	@Override
	public int difference(MyNumbers numbers) {
		return numbers.getNumber1()-numbers.getNumber2();
	}

	@Override
	public int multiply(MyNumbers numbers) {
		return numbers.getNumber1()*numbers.getNumber2();
	}

	@Override
	public int divide(MyNumbers numbers) {
		return numbers.getNumber1()/numbers.getNumber2();
	}

}
