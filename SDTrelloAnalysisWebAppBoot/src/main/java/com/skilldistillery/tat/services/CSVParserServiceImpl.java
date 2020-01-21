package com.skilldistillery.tat.services;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.skilldistillery.tat.entities.Topic;

public class CSVParserServiceImpl implements CSVParserService {

	public List<Topic> getTopics(String pathAndFileName) {
		
		
		
		
		/*Topic
		 * int id
		 * String name
		 * String description
		 * String dayOfProgram
		 * String cohort
		 * String unit
		 * int lengthInMin
		 * List<Instructor> instructors
		 * LocalDate dateLectured
		 * TrelloCsvFile csvFile
		 */
		
		
		List<Topic> parsedTopics = new ArrayList<Topic>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(pathAndFileName));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by the names assigned to each column
				String topicName = csvRecord.get("Card Name");
				String instructors = csvRecord.get("Labels");
				String[] instructorArray = instructors.split("\\s\\([^\\)]+\\)[,]?");
				List<String> instructorList = Arrays.asList(instructorArray);
				LocalDate dateLectured  = parseDateString(csvRecord.get("List Name"));
				

				Topic topic = new Topic(instructorList, dateLectured, topicName);
				parsedTopics.add(topic);
//				System.out.println(topic);
//				System.out.println("Record No - " + csvRecord.getRecordNumber());
//				System.out.println("---------------");
//				System.out.println("Topic Name : " + topicName);
//				System.out.println("Instructors : " + Arrays.deepToString(instructorArray));
//				System.out.println("Date : " + date);
//				System.out.println("---------------\n\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parsedTopics;
	}
	
	
	
	public LocalDate parseDateString(String dateToParse) {
		// EXAMPLE DATA FROM CSV: "Day 1 - Wed June 27"
		// TALK TO ROB ABOUT START/END DATE CARD
		
		
		return null;
	}
	
	
	
}
