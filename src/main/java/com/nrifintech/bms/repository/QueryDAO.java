package com.nrifintech.bms.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Configuration
@PropertySource("classpath:reportQuerySQL.properties")

@Repository
public class QueryDAO {
	@Autowired
	private Environment env;

	@PersistenceContext
	private EntityManager em;

	public List<Object[]> routeMigration(Date d1, Date d2) {

		Query query = em.createNativeQuery(String.format(env.getProperty("routeMigration.sql")));
		query.setParameter(1, d1);
		query.setParameter(2, d2);
		return query.getResultList();

	}

	public List<Object[]> revenuePerBus(Date d1, Date d2) {

		Query query = em.createNativeQuery(String.format(env.getProperty("revenuePerBus.sql")));
		query.setParameter(1, d1);
		query.setParameter(2, d2);
		return query.getResultList();

	}

	public List<Object[]> perBusData(Date d1, Date d2) {

		Query query = em.createNativeQuery(String.format(env.getProperty("perBusData.sql")));
		query.setParameter(1, d1);
		query.setParameter(2, d2);
		return query.getResultList();

	}

}
