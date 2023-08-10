package com.example.coomunicator.demo.communcitcator.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "communicatio_model")
public class CommunicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communication_model_id")
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdOne() {
        return idOne;
    }

    public void setIdOne(int idOne) {
        this.idOne = idOne;
    }

    public int getIdTwo() {
        return idTwo;
    }

    public void setIdTwo(int idTwo) {
        this.idTwo = idTwo;
    }


    @Column(name = "id_one")
    public int idOne;

    @Column(name = "id_two")
    public int idTwo;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "communication_model_id")
    private List<MessageModel> messages = new ArrayList<>();

	public List<MessageModel> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageModel> messages) {
		this.messages = messages;
	}
    
    
}
