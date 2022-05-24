package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		person.setName("Prashi");
		person.setEmail("prashi@mail.com");
		person.setPassword("Prashi123");
		person.setPhone(98765432);
		
		BankAccount bankaccount1 = new BankAccount();
		bankaccount1.setAccNumber(9876);
		bankaccount1.setName("Karnataka Bank");
		bankaccount1.setPhone(98765432);
		
		BankAccount bankaccount2 = new BankAccount();
		bankaccount2.setAccNumber(9765);
		bankaccount2.setName("SBI Bank");
		bankaccount2.setPhone(98765432);
		
		BankAccount bankaccount3 = new BankAccount();
		bankaccount3.setAccNumber(3456);
		bankaccount3.setName("Cenara Bank");
		bankaccount3.setPhone(98765432);
		
		List<BankAccount> list = new ArrayList<BankAccount>();
		list.add(bankaccount1);
		list.add(bankaccount2);
		list.add(bankaccount3);
		
		person.setAccount(list);
		
		entityTransaction.begin();
		entityManager.persist(bankaccount1);
		entityManager.persist(bankaccount2);
		entityManager.persist(bankaccount3);
		entityManager.persist(person);
		entityTransaction.commit();
	}
}
