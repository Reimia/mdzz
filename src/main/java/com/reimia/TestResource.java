package com.reimia;

import org.springframework.web.bind.annotation.PostMapping;

public interface TestResource {

	@PostMapping("")
	void test();

}
