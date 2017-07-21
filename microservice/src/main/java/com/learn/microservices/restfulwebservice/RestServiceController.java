package com.learn.microservices.restfulwebservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServiceController {

	/**
	 * Service url http://localhost:8080/greeting?name=
	 * o/p {"id":1,"content":"Hello, World!"}
	 * @param name
	 * @return
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam (value="name", defaultValue="World") String name) {
		return new Greeting(45773, String.format("Hello %s !", name));
	}
}
