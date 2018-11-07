package com.madlad.dataviewer.utils;

import org.hibernate.Hibernate;

public class HibernateUtils {

	@SuppressWarnings("unchecked")
	public static <T> T unproxy(T object, Class<T> clazz) {
		if(clazz.isAssignableFrom(object.getClass())) {
			return (T) Hibernate.unproxy(object);
		}
		return object;
	}
	
}
