package com.luxoft.springaop.lab5.model;

import lombok.Data;

import java.util.List;

@Data
public class UsualPerson implements Person {
    private int id;
    private String name;
    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;


    /* (non-Javadoc)
	 * @see lab.model.Person1#sayHello(lab.model.Person)
	 */
    @Override
	public void sayHello(Person person) {
    }
}