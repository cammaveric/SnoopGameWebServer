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

    Iterable<Order> findByStatuses(Set<Status> statuses);

    Iterable<Order> findByEmployee(Employee employee);

    Iterable<Order> findByPhone(Phone phone);

    Iterable<Order> findByPhoneInAndStatuses(Iterable<Phone> phones, Set<Status> statuses);

    Iterable<Order> findByEmployeeAndStatuses(Employee employee, Set<Status> statuses);

    Iterable<Order> findByPhoneAndStatuses(Phone phone, Set<Status> statuses);

    @Query("select o from Order o where o.employee=?1 and o.phone=?2 and o.date_start=?3")
    Order findByEmployeeAndPhoneAndDate_start(Employee employee, Phone phone, String date_start);
}
