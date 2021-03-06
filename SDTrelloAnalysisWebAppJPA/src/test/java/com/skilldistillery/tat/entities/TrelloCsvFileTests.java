package com.skilldistillery.tat.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrelloCsvFileTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private TrelloCsvFile file;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("tatpu");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		file = em.find(TrelloCsvFile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		file = null;
	}

	@Test
	void test() {
		assertEquals(file.getFileName(),"fileName");
		assertEquals(file.getPathAndFileName(),"pathAndFileName");
		assertEquals(file.getStartDate().toString(),"2024-12-01 06:12:24.0");
		assertEquals(file.getEndDate().toString(),"2024-12-31 06:12:24.0");
		assertEquals(file.getTopics().size(), 1);
	}

}
