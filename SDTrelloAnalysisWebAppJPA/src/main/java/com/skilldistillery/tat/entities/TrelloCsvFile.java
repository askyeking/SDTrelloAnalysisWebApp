package com.skilldistillery.tat.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;

@Entity
@Table(name="trello_csv_file")
public class TrelloCsvFile {
	//FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "path_and_file_name")
	private String pathAndFileName;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "start_date_string")
	private String startDateString;
	
	@Column(name = "end_date_string")
	private String endDateString;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="csvFile", cascade = CascadeType.PERSIST)
	List<Topic> topics;

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public TrelloCsvFile() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPathAndFileName() {
		return pathAndFileName;
	}

	public void setPathAndFileName(String pathAndFileName) {
		this.pathAndFileName = pathAndFileName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	@Override
	public String toString() {
		return "TrelloCsvFile [id=" + id + ", fileName=" + fileName + ", pathAndFileName=" + pathAndFileName
				+ ", startDateString=" + startDateString + ", endDateString=" + endDateString + ", topics=" + topics
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endDateString == null) ? 0 : endDateString.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + id;
		result = prime * result + ((pathAndFileName == null) ? 0 : pathAndFileName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startDateString == null) ? 0 : startDateString.hashCode());
		result = prime * result + ((topics == null) ? 0 : topics.hashCode());
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
		TrelloCsvFile other = (TrelloCsvFile) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endDateString == null) {
			if (other.endDateString != null)
				return false;
		} else if (!endDateString.equals(other.endDateString))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id != other.id)
			return false;
		if (pathAndFileName == null) {
			if (other.pathAndFileName != null)
				return false;
		} else if (!pathAndFileName.equals(other.pathAndFileName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startDateString == null) {
			if (other.startDateString != null)
				return false;
		} else if (!startDateString.equals(other.startDateString))
			return false;
		if (topics == null) {
			if (other.topics != null)
				return false;
		} else if (!topics.equals(other.topics))
			return false;
		return true;
	}
	
	

	
	
	
	
	
}
