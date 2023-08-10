package com.example.coomunicator.demo.communcitcator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coomunicator.demo.communcitcator.model.loginmodel;

public interface loginrepo  extends JpaRepository<loginmodel, Long>{
	loginmodel findByEmail(String email);
	loginmodel findByPassword(String password);
}
