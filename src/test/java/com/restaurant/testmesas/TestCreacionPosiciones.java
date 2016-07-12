package com.restaurant.testmesas;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.SyzoRestrntApplication;
import com.restaurant.servicios.MesaService;
import com.restaurant.servicios.MesaServiceImpl;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class TestCreacionPosiciones {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SyzoRestrntApplication.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        
        MesaService messerv=ctx.getBean(MesaServiceImpl.class);
        //creacion de  posiciones 
        messerv.createPosicion(1, 1);
        messerv.createPosicion(1, 2);
        messerv.createPosicion(1, 3);
        messerv.createPosicion(1, 4);
        
        
        //creacion de mesas
        
        
        messerv.createMesa(messerv.getPosicion(1, 1));
        messerv.createMesa(messerv.getPosicion(1, 2));
        messerv.createMesa(messerv.getPosicion(1, 3));
        messerv.createMesa(messerv.getPosicion(1, 4));
        
        

	}
}
