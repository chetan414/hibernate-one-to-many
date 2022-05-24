package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccountPage {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		List<Page> pages = new ArrayList();
		
		UserAccount account = new UserAccount();
		account.setEmail("Bunny@gmail.com");
		account.setPassword("bunny123");
		account.setMobile("9876543210");
		account.setName("Bunny");
		
		Page page = new Page();
		page.setDescription("Private Account");
		page.setName("faceBook");
		page.setTitle("Trolls Macha");
		
		Page page2 = new Page();
		page2.setDescription("Drinking do not distunb");
		page2.setName("jdfbgl");
		page2.setTitle("aclbadkc");
		
		pages.add(page);
		pages.add(page2);
		
		account.setPage(pages);
		
		entityTransaction.begin();
		entityManager.persist(page);
		entityManager.persist(page2);
		entityManager.persist(account);
		entityTransaction.commit();
	}
}
