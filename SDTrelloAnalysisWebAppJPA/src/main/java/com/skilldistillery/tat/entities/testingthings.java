package com.skilldistillery.tat.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testingthings {

	
	ProcessBuilder processBuilder = new ProcessBuilder();

	public static void main(String[] args) {
		
			testingthings tt = new testingthings();
			tt.run();

	}
	
	
	public void run() {
		
		
		processBuilder.command("bash","-c","ls ~");
		
		try {

			Process process = processBuilder.start();

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				System.exit(0);
			} else {
				//abnormal...
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
