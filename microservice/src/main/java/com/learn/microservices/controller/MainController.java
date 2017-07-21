package com.learn.microservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	/**
	 * Access this page using jetty with url http://localhost:8080/home
	 * with tomcat using usr localhost:8080/microservice-0.0.1-SNAPSHOT/home
	 * @return
	 */
	@RequestMapping("/home")
	public String homePage() {
		System.out.println("/home will call homePage.jsp present in WEB-INF folder...!");
		return "homePage";
	}
}
