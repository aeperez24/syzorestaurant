package com.restaurant.testPersona.creacionMesonero;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.SyzoRestrntApplication;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class TestPersona2 {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SyzoRestrntApplication.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
       String n1="eloy";
        String n2="perez";
        String identificacion="v-20500317";
        PersonaService perserv=ctx.getBean(PersonaServiceImpl.class);
        perserv.createPersona(n1, n2,identificacion);
       

	}
}
