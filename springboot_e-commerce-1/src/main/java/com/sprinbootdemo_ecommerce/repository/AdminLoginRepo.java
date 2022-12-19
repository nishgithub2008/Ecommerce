package com.sprinbootdemo_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprinbootdemo_ecommerce.entity.AdminLogin;

@Repository
public interface AdminLoginRepo extends JpaRepository<AdminLogin, String> {

}
