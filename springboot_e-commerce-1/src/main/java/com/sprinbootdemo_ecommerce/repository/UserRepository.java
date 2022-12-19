package com.sprinbootdemo_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprinbootdemo_ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}

