package com.restaurant.testProducto;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.SyzoRestrntApplication;
import com.restaurant.modelo.Cliente;
import com.restaurant.modelo.Item;
import com.restaurant.modelo.Mesa;
import com.restaurant.servicios.ClienteService;
import com.restaurant.servicios.ClienteServiceImpl;
import com.restaurant.servicios.MesaService;
import com.restaurant.servicios.MesaServiceImpl;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;
import com.restaurant.servicios.ProductosService;
import com.restaurant.servicios.ProductosServiceImpl;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class TestCreacionProductos {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SyzoRestrntApplication.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
       
        ProductosService prserv=ctx.getBean(ProductosServiceImpl.class);
        prserv.createItem("P1", "Pizza Margarita", "Pizza con muchas cosas", Item.PLATOPRINCIPAL);
        prserv.agregarPresentacion("P1", "Individual", 1000);
        prserv.agregarPresentacion("P1", "Mediana", 1500);
        prserv.agregarPresentacion("P1", "Familiar", 2000);
        

	}
}
