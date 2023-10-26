package com.example.springboot.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

public enum Category {
	    WINDOWS(0),
	    CHROMEBOOKS(1),
	    MACBOOKS(2),
	    GAMING(3),
	    ULTRABOOK(4),
	    TWOINONE(5);

	 private int value;
	 private static Map map = new HashMap<>();
	 
	 private Category(int value) {
		 this.value = value;
	 }
	 static {
		 for (Category category : Category.values()) {
			 map.put(category.value, category);
		 }
	
	}
	 public static Category valueOf(int category) {
		 return (Category) map.get(category);
	 }
	 public int getValue() {
		 return value;
	 }
}
