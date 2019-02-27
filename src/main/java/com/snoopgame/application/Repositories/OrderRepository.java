package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public interface OrderRepository extends CrudRepository<Order,Integer> {
    Iterable<Order> findByStatuses(Set<Status>statuses);
    Iterable<Order> findByPhoneInAndStatuses(Iterable<Phone> phones, Set<Status>statuses);
}
