package com.cb.repository;


import com.cb.model.Tariff_Name;

import com.cb.model.Users_Phone_Number;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TariffNameRepository extends CrudRepository<Tariff_Name, Integer> {
    List<Tariff_Name> findAll();
    Optional<Tariff_Name> findById(Integer id);
}
