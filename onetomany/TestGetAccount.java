package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetAccount {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserAccount account = entityManager.find(UserAccount.class, 1);
		
		if(account != null) {
			System.out.println("Name is: "+account.getName());
			System.out.println("Email is: "+account.getEmail());
			System.out.println("Mobile Number is: "+account.getMobile());
			System.out.println("----------------------------------");
			
			List<Page> pages = account.getPage();
			
			for (Page page : pages) {
				System.out.println("ID: " + page.getId());
				System.out.println("Name: " + page.getName());
				System.out.println("Description: "+ page.getDescription());
				System.out.println("Title: "+page.getTitle());
				System.out.println("===================================");
			}
		} else {
			System.out.println("No Data is available for the given id");
		}
			
	}
}
