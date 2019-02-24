package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderRepository extends CrudRepository<Order,Integer> {

}
