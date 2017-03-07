package com.example.hello;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		list.add("Ravi");
		list.stream().forEach(a -> System.out.println(a));
	}

}
