package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Entities.Order;
import com.snoopgame.application.Entities.Phone;
import com.snoopgame.application.Entities.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("select o from Order o order by o.id desc")
    Iterable<Order> findAllOrderByIdDesc();

    Iterable<Order> findByStatus(Status status);

    Iterable<Order> findByEmployee(Employee employee);

    Iterable<Order> findByPhone(Phone phone);

    Iterable<Order> findByPhoneInAndStatus(Iterable<Phone> phones, Status status);

    Iterable<Order> findByEmployeeAndStatus(Employee employee, Status status);

    Iterable<Order> findByPhoneAndStatus(Phone phone, Status status);

    @Query("select o from Order o where o.employee=?1 and o.phone=?2 and o.date_start=?3")
    Order findByEmployeeAndPhoneAndDate_start(Employee employee, Phone phone, String date_start);
}
