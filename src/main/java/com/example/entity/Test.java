package com.example.entity;

import lombok.Getter;
import lombok.Setter;

public class Test {

	public Test() {
	}

	public Test(String name) {
		this.name = name;
	}

	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String name;

}
