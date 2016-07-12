package com.restaurant.dao;

import org.springframework.data.repository.CrudRepository;
import com.restaurant.modelo.*;

public interface ItemDao extends CrudRepository<Item, Long> {

}
