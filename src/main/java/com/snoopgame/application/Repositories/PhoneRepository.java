package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PhoneRepository extends CrudRepository<Phone,Long> {
    @Query("select p from Phone p where free_phone_amount>?1")
    Iterable<Phone> findByFree_phone_amountGreaterThan(Integer Amount);
}
