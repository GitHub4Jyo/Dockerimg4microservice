package com.learn.microservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.learn.microservices")
/**
 * This file is to replace the spring-context.xml
 * In latest version of spring, no need to have any xml in our web application
 * all xml configuration can be handled using annotations
 * @author jyoth
 *
 *
 *<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <mvc:annotation-driven />

    <context:component-scan base-package="net.viralpatel.spring" /> 

    <bean id="jspViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <mvc:default-servlet-handler />

</beans>
 */
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver getViewResolver() {
		System.out.println("**************** Spring-context.xml ******** ViewResolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	 @Bean
	    public ResourceBundleMessageSource messageSource() {
	        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
	        // Load property in message/validator.properties
	        rb.setBasenames(new String[] { "messages/validator" });
	        return rb;
	    }
	 
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
	        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/").setCachePeriod(31556926);
	        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/").setCachePeriod(31556926);
	    }
	    
	 
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	 
}
