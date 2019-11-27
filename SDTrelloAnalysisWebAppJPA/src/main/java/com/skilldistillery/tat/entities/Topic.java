package com.skilldistillery.tat.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {
	// F i e l d s
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String description;
	
	@Column(name = "day_of_program")
	private String dayOfProgram;
	
	private String cohort;
	
	private String unit;
	
	@Column(name = "length_in_min")
	private int lengthInMin;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "topicsList")
	private List<Instructor> instructors;
	
	@Column(name = "date_lectured")
	private Date dateLectured;
	
	@ManyToOne
	@JoinColumn(name="trello_csv_file_id")
	private TrelloCsvFile csvFile;

	//CTOR
	public Topic() {
		super();
	}
	
	public TrelloCsvFile getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(TrelloCsvFile csvFile) {
		this.csvFile = csvFile;
	}

	// GETTERS N SETTERS
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDayOfProgram() {
		return dayOfProgram;
	}

	public void setDayOfProgram(String dayOfProgram) {
		this.dayOfProgram = dayOfProgram;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getLengthInMin() {
		return lengthInMin;
	}

	public void setLengthInMin(int lengthInMin) {
		this.lengthInMin = lengthInMin;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	

	public Date getDateLectured() {
		return dateLectured;
	}

	public void setDateLectured(Date dateLectured) {
		this.dateLectured = dateLectured;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + ", dayOfProgram=" + dayOfProgram
				+ ", cohort=" + cohort + ", unit=" + unit + ", lengthInMin=" + lengthInMin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cohort == null) ? 0 : cohort.hashCode());
		result = prime * result + ((dayOfProgram == null) ? 0 : dayOfProgram.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((instructors == null) ? 0 : instructors.hashCode());
		result = prime * result + lengthInMin;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Topic other = (Topic) obj;
		if (cohort == null) {
			if (other.cohort != null)
				return false;
		} else if (!cohort.equals(other.cohort))
			return false;
		if (dayOfProgram == null) {
			if (other.dayOfProgram != null)
				return false;
		} else if (!dayOfProgram.equals(other.dayOfProgram))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (instructors == null) {
			if (other.instructors != null)
				return false;
		} else if (!instructors.equals(other.instructors))
			return false;
		if (lengthInMin != other.lengthInMin)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	
	
	
	
	
}