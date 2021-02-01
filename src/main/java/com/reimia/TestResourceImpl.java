package com.reimia;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResourceImpl implements TestResource{

	@Override
	public void test() {
		System.out.println("this is test");
	}
}
