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

class TopicTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Topic topic;
	
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
		topic = em.find(Topic.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		topic = null;
	}
	@Test
	void test() {
		assertEquals(topic.getName(),"topicName");
		assertEquals(topic.getDescription(),"topicDescription");
		assertEquals(topic.getDayOfProgram(),"12");
		assertEquals(topic.getCohort(),"23");
		assertEquals(topic.getUnit(),"1");
		assertEquals(topic.getLengthInMin(),60);
		assertEquals(topic.getInstructors().size(), 1);
		assertEquals(topic.getCsvFile().getFileName(), "fileName");
	}

}
