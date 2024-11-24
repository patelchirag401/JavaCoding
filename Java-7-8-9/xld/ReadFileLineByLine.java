package com.xld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        // Define the file path
       // String filePath = "D:\\gitopenjdk\\esb_smsproxy\\app.bw\\SMS_Proxy\\SharedResources\\Schema\\SOA\\Account\\BillHistory.xsd"; // Replace with the path to your file
        HashSet<String> serviceList = new HashSet<String>();
		try {
			
			
			String[] usernames = { "name=\"userName\"", "name=\"newUsername\"", "name=\"oldUsername\"",
					"name=\"accountUsername\"", "name=\"userName\"" };
			
			
			String folderPath = "D:\\gitopenjdk\\esb_smsproxy\\app.bw\\SMS_Proxy\\SharedResources\\Schema\\SOA\\Subscription"; // Replace with the path to your folder

	        // Create a File object for the folder
	        File folder = new File(folderPath);

	        // Check if the path represents a directory
	        if (folder.isDirectory()) {
	            // List all files in the directory
	            File[] files = folder.listFiles();

	            if (files != null) {
	                // Loop through the files and print their names
	                for (File file : files) {
	                   // System.out.println(file.getName());
	                    
	                 // Open the file for reading using a BufferedReader
	        			BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));

	        			// Read and process each line in the file
	        			String line;
	        			while ((line = reader.readLine()) != null) {
	        				// Process the line here

	        				for (String username : usernames) {
	        					if (line.toLowerCase().contains(username.toLowerCase())) {
	        						//System.out.println(line);
	        						
	        						serviceList.add(file.getName());
	        						break;
	        					}
	        				}

	        			}
	        			

	        			// Close the BufferedReader
	        			reader.close();
	                }
	            }
	        } else {
	            System.out.println("Not a directory.");
	        }
			
			
			
			for(String serviceName : serviceList) {
				 System.out.println(serviceName);
			}
			

		} catch (IOException e) {
            e.printStackTrace();
        }
    }
}