package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PhoneRepository extends CrudRepository<Phone,Integer> {
    @Query("select p from Phone p where free_phone_amount>?1")
    Iterable<Phone> findByFree_phone_amountGreaterThan(Integer Amount);
    @Query("select p from Phone p where p.name=?1 and p.firmware_name=?2 and p.firmware_version=?3")
    Phone findByNameAndFirmware_nameAndFirmware_version(String name, String firmware_name, String firmware_version);
}
