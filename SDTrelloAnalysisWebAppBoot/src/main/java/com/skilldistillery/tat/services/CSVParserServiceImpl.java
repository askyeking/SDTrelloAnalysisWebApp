package com.skilldistillery.tat.services;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.skilldistillery.tat.entities.Instructor;
import com.skilldistillery.tat.entities.Topic;
import com.skilldistillery.tat.entities.TrelloCsvFile;


public class CSVParserServiceImpl implements CSVParserService {
	
	
	public static void main(String[] args) {
		CSVParserServiceImpl csvService = new CSVParserServiceImpl();
		csvService.parseDateString("Day 1 - Wed 11/6");
	}

	public TrelloCsvFile createTrelloCSVFile(String fileName) {
		TrelloCsvFile csv = new TrelloCsvFile();
		//hardcoded filepath value will be replaced with aws csv folder location for production
		csv.setPathAndFileName("src/main/resources/static/" + fileName);
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csv.getPathAndFileName()));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			csv.setTopics(createTopics(csv, csvParser));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return csv;
	}

	public List<Topic> createTopics(TrelloCsvFile trelloFile, CSVParser csvParser) {

		/*
		 * Topic int id String name String description String dayOfProgram String cohort
		 * String unit int lengthInMin List<Instructor> instructors LocalDate
		 * dateLectured TrelloCsvFile csvFile
		 */

		List<Topic> parsedTopics = new ArrayList<Topic>();
		for (CSVRecord csvRecord : csvParser) {
			// Accessing values by the names assigned to each column
			String topicName = csvRecord.get("Card Name");
			String instructors = csvRecord.get("Labels");
			String[] instructorArray = instructors.split("\\s\\([^\\)]+\\)[,]?");
			//generate instructors for the topic
			List<String> instructorStrings = Arrays.asList(instructorArray);
			List<Instructor> instructorList = new ArrayList<>();
			for (String instructorName : instructorStrings) {
				//may need instructor id to persist to join table
				Instructor instructor = new Instructor(instructorName);
				instructorList.add(instructor);
			}
			LocalDate dateLectured = parseDateString(csvRecord.get("List Name"));

			Topic topic = new Topic(topicName, instructorList, dateLectured, trelloFile);
			parsedTopics.add(topic);
//				System.out.println(topic);
//				System.out.println("Record No - " + csvRecord.getRecordNumber());
//				System.out.println("---------------");
//				System.out.println("Topic Name : " + topicName);
//				System.out.println("Instructors : " + Arrays.deepToString(instructorArray));
//				System.out.println("Date : " + date);
//				System.out.println("---------------\n\n");

		}
		return parsedTopics;
	}

	public LocalDate parseDateString(String dateToParse) {
		// EXAMPLE DATA FROM CSV: "Day 1 - Wed 11/6"
		// TALK TO ROB ABOUT START/END DATE CARD
		Pattern datePattern = Pattern.compile("\\d{1,2}\\/\\d{1,2}");
		Matcher matcher = datePattern.matcher(dateToParse);
		if(matcher.find()) {
			System.out.println(matcher.group());
		}
		
		
		return null;
	}

}
