package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exceptions.ValidationException;
import com.luxoft.springaop.lab5.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectsTest {
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

	private AbstractApplicationContext context;


	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
	}
	
	@Test
	public void testLogging() {
		createPersonWithAge(50);
	}

	private void createPersonWithAge(int age) {
		Person person = (Person) context.getBean("person");
		person.setAge(age);
	}

	@Test(expected = ValidationException.class)
	public void testValidation() {
		createPersonWithAge(101);
	}
}
