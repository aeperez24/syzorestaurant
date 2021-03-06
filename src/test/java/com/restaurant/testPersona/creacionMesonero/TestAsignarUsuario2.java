package com.restaurant.testPersona.creacionMesonero;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.SyzoRestrntApplication;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class TestAsignarUsuario2 {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SyzoRestrntApplication.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        
        PersonaService perserv=ctx.getBean(PersonaServiceImpl.class);
        Persona persona=perserv.getPersonaByIdentificacion("v-20500316");
        Usuario user=perserv.getUsuarioByUserName("aeperez1");
        perserv.setUsuario(persona, user);
        
        
         persona=perserv.getPersonaByIdentificacion("v-20500317");
        user=perserv.getUsuarioByUserName("aeperez2");
        perserv.setUsuario(persona, user);
        
        persona=perserv.getPersonaByIdentificacion("v-20500318");
        user=perserv.getUsuarioByUserName("aeperez3");
        perserv.setUsuario(persona, user);

	}
}
