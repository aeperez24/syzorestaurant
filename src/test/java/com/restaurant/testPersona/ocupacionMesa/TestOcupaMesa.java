package com.restaurant.testPersona.ocupacionMesa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.SyzoRestrntApplication;
import com.restaurant.modelo.Cliente;
import com.restaurant.modelo.Mesa;
import com.restaurant.servicios.ClienteService;
import com.restaurant.servicios.ClienteServiceImpl;
import com.restaurant.servicios.MesaService;
import com.restaurant.servicios.MesaServiceImpl;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class TestOcupaMesa {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SyzoRestrntApplication.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
       
        String identificacion="v-20500316";
        ClienteService cls=ctx.getBean(ClienteServiceImpl.class);
        MesaService mss=ctx.getBean(MesaServiceImpl.class);
        Cliente cliente=cls.getClienteByIdentificacion(identificacion);
        Mesa mesa=mss.getMesaInPosicion(1, 1);
        cls.asignClienteMesa(cliente, mesa);
        

	}
}
