package com.luxoft.springaop.lab5.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CountryImpl implements Serializable, Country {
	private static final long serialVersionUID = 1L;

	private int id;
    private String name;
    private String codeName;


    public CountryImpl(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public CountryImpl(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }
}
