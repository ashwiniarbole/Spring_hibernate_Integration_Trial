package com.scp.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scp.dao.PersonDAO;
import com.scp.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person p1 = new Person();
		p1.setName("Ashh"); 
		p1.setCountry("India");
		personDAO.save(p1);
		
		Person p2 = new Person("Lary","USA");
		personDAO.save(p2);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		//context.close();	
	}
}
