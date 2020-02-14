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
		csvService.createTrelloCSVFile("SD24_Unit1.csv");
	}

	public TrelloCsvFile createTrelloCSVFile(String fileName) {
		TrelloCsvFile csv = new TrelloCsvFile();
		// hardcoded filepath value will be replaced with aws csv folder location for
		// production
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
		String cohortDates;
		for (CSVRecord csvRecord : csvParser) {
			if (csvRecord.get("Card Name").equals("Topic Name (00)")) {
				System.out.println(csvRecord.get("Card Name"));
				continue;
			}
			if ((cohortDates = csvRecord.get("Card Name")).contains("Unit Dates:")) {
				System.out.println(csvRecord.get("Card Name"));
				Pattern datePattern = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}");
				Matcher matcher = datePattern.matcher(csvRecord.get("Card Name"));
				// startAndEndDate list index 0 is start date 1 is end date
				List<String> startAndEndDate = new ArrayList<>();
				String yearBegin = "";
				String yearEnd = "";
				while (matcher.find()) {
					String matchedDate = matcher.group();
					startAndEndDate.add(matchedDate);
					//TODO convert date string in startAndEndDate list
					//     then set them in the csvfile passed into this method
					
					
					
					System.out.println(matchedDate);
					
				}
				continue;
			}
			// Accessing values by the names assigned to each column
			String topicName = csvRecord.get("Card Name");
			String instructors = csvRecord.get("Labels");
			String[] instructorArray = instructors.split("\\s\\([^\\)]+\\)[,]?");
			// generate instructors for the topic
			List<String> instructorStrings = Arrays.asList(instructorArray);
			List<Instructor> instructorList = new ArrayList<>();
			for (String instructorName : instructorStrings) {
				// may need instructor id to persist to join table
				Instructor instructor = new Instructor(instructorName);
				instructorList.add(instructor);
			}
			LocalDate dateLectured = parseDateString(csvRecord.get("List Name"));

			Topic topic = new Topic(topicName, instructorList, dateLectured, trelloFile);
			parsedTopics.add(topic);
		}
		return parsedTopics;
	}

	public LocalDate parseDateString(String dateToParse) {
		// EXAMPLE DATA FROM CSV: "Day 1 - Wed 11/6"
		// TALK TO ROB ABOUT START/END DATE CARD
		Pattern datePattern = Pattern.compile("\\d{1,2}\\/\\d{1,2}");
		Matcher matcher = datePattern.matcher(dateToParse);
		String monthDayString = "";
		LocalDate monthDay = null;
		if (matcher.find()) {
		monthDayString = matcher.group();
		}
		System.out.println(monthDayString);
		
		//TODO Convert String into LocalDate before returning
		return monthDay;
	}

}
