package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetPersonBankAccont {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Person person = entityManager.find(Person.class, 1);
		if(person != null)
		{
			System.out.println("Person Id  :"+person.getId());
			System.out.println("Person Name  :"+person.getName());
			System.out.println("Person Email  :"+person.getEmail());
			System.out.println("Person Password  :"+person.getPassword());
			System.out.println("--------------------------------------");
			List<BankAccount> list = person.getAccount();
			for(BankAccount bankAccount : list)
			{
				System.out.println("Account Id  :"+bankAccount.getId());
				System.out.println("Account Number  :"+bankAccount.getAccNumber());
				System.out.println("Account Holder Name  :"+bankAccount.getName());
				System.out.println("Account Holder Phone  :"+bankAccount.getPhone());
				System.out.println("-------------------------------------------------");
			}
		}
		else
		{
			System.out.println("No data is found");
		}
	}
}
