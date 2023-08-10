package com.example.coomunicator.demo.communcitcator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coomunicator.demo.communcitcator.model.CommunicationModel;

public interface communicationrepo extends JpaRepository<CommunicationModel, Long>  {

}
