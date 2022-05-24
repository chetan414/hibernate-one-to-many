package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteAccount {
public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserAccount account = entityManager.find(UserAccount.class, 2);
		List<Page> pages = account.getPage();
		
		entityTransaction.begin();
		for(Page page : pages) {
			entityManager.remove(page);
		}
		entityManager.remove(account);
		entityTransaction.commit();
	}
}
