package com.snoopgame.application.Repositories;

import com.snoopgame.application.Entities.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PhoneRepository extends CrudRepository<Phone,Integer> {

}
