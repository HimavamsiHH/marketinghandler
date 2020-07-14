package com.marketing.engine.controller;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WelcomeController
{
	@RequestMapping("/")
	public String index() {
		return "Spring Boot Example";
	}

	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/marketing").setViewName("/index.html");
		registry.addViewController("/dashboardSuperadmin").setViewName("/dashboardadmin.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}*/

}
