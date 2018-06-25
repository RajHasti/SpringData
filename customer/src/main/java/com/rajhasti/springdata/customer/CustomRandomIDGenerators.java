package com.rajhasti.springdata.customer;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIDGenerators implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor si, Object obj) throws HibernateException {
		int id = 0;
		Random random = new Random();

		id = random.nextInt(100000);

		return new Long(id);
	}

}
