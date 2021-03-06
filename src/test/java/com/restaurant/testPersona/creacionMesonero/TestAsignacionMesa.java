package com.restaurant.testPersona.creacionMesonero;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restaurant.SyzoRestrntApplication;
import com.restaurant.modelo.Mesa;
import com.restaurant.modelo.Mesonero;
import com.restaurant.modelo.Persona;
import com.restaurant.modelo.Usuario;
import com.restaurant.servicios.ClienteService;
import com.restaurant.servicios.ClienteServiceImpl;
import com.restaurant.servicios.MesaService;
import com.restaurant.servicios.MesaServiceImpl;
import com.restaurant.servicios.MesonerosService;
import com.restaurant.servicios.MesonerosServiceImpl;
import com.restaurant.servicios.PersonaService;
import com.restaurant.servicios.PersonaServiceImpl;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class TestAsignacionMesa {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SyzoRestrntApplication.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        String identificacion="v-20500317";
        MesonerosService mesoserv=ctx.getBean(MesonerosServiceImpl.class);
        MesaService mesaserv=ctx.getBean(MesaServiceImpl.class);
        Mesonero mesonero=mesoserv.getMesoneroByIdentificacion(identificacion);
        mesoserv.activarMesonero(mesonero);
        mesoserv.asignarMesa(mesoserv.getMesoneroByIdentificacion(identificacion),mesaserv.getMesaInPosicion(1, 1));
        mesoserv.asignarMesa(mesoserv.getMesoneroByIdentificacion(identificacion),mesaserv.getMesaInPosicion(1, 2));
        mesoserv.asignarMesa(mesoserv.getMesoneroByIdentificacion(identificacion),mesaserv.getMesaInPosicion(1, 3));
        mesoserv.desasignarMesa(mesoserv.getMesoneroByIdentificacion(identificacion), mesaserv.getMesaInPosicion(1, 2));

	}
}
