package com.restaurant.dao;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.modelo.*;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}
