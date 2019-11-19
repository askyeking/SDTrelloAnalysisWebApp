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

class InstructorTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Instructor instructor;
	
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
		instructor = em.find(Instructor.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		instructor = null;
	}
	@Test
	void test() {
		
		assertEquals(instructor.getName(),"testInstructor");
		assertEquals(instructor.isActive(), true);
		assertEquals(instructor.getTopicList().size(), 1);
	}

}
