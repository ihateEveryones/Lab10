package com.cb.repository;


import com.cb.model.Users_Phone_Number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPhoneNumberRepository extends JpaRepository<Users_Phone_Number, Integer> {
    @Query("SELECT u FROM Users_Phone_Number u WHERE u.delete=false ")
    List<Users_Phone_Number> findAll();
    Optional<Users_Phone_Number> findById(Integer id);
}
