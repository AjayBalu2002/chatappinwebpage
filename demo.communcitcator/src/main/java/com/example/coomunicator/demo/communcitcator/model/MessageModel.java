package com.example.coomunicator.demo.communcitcator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "message_model")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getKeey() {
		return keey;
	}

	public void setKeey(int keey) {
		this.keey = keey;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public int keey;
	
	public String mess;
	
	

    @ManyToOne
    @JoinColumn(name = "communication_model_id")
    private CommunicationModel communicationModel;
}
