package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobile {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 2);
		
		if (mobile != null) {
			System.out.println("Mobile name is: " + mobile.getName());
			System.out.println("Mobile Cost is: " + mobile.getCost());
			System.out.println("-------------------------------------");
			List<Sim> sims = mobile.getSims();
			for (Sim sim : sims) {
				System.out.println("Sim ID: " + sim.getId());
				System.out.println("Sim Provider: " + sim.getProvider());
				System.out.println("Sim type: " + sim.getType());
				System.out.println("===================================");
			}
		} else {
			System.out.println("No Data is available for the given id");
		}

	}
}
