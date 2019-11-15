package com.skilldistillery.tat.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instructor {
	// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private boolean active;
	
	@ManyToMany
	@JoinTable(name = "instructor_topic", 
		joinColumns = @JoinColumn(name = "instructor_id"), 
		inverseJoinColumns = @JoinColumn(name = "topic_id"))
	@JsonIgnore
	private List<Topic> topicsList;

	//CTORS
	public Instructor() {
		super();
	}

	public Instructor(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}

	//METHODS
	//TODO: write add/removes for List<Topic>
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Topic> getTopicList() {
		return topicsList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicsList = topicList;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", active=" + active + ", topicList=" + topicsList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((topicsList == null) ? 0 : topicsList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		if (active != other.active)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (topicsList == null) {
			if (other.topicsList != null)
				return false;
		} else if (!topicsList.equals(other.topicsList))
			return false;
		return true;
	}
	
	
	
	
	
	

}
