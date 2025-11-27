package com.faces.ch02.project.service;

import java.util.List;

import com.faces.ch02.project.model.Message;

import jakarta.ejb.Stateless;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Stateless
public class MessageService {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	public MessageService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitName");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
	}
	
	
	public void create(Message message) {
		
		try {
			transaction.begin();
			entityManager.persist(message);
			entityManager.flush();
			entityManager.refresh(message);
			transaction.commit();
		}
		catch(Exception ex) {
			if (transaction.isActive()) {
	            transaction.rollback();
	        }
			ex.printStackTrace();
		}
	}
	
	public List<Message> list(){
		return entityManager
				.createNamedQuery("Message.getAll")
				.getResultList();
	}
}
