package com.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
public class ReadingJSON {
   public static void main(String args[]) {
      //Creating a JSONParser object
      JSONParser jsonParser = new JSONParser();
      try {
         //Parsing the contents of the JSON file
        // JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("D:\\Docs\\backup\\Sprint work\\KAfka\\messages_main.thirdpartybilling.accountmanagement.errors_180.json"));
      //   String id = (String) jsonObject.get("ID");
        
    	  FileInputStream fileInputStream = null;
    	  String data="";
    	  String filename = "D:\\Docs\\backup\\Sprint work\\KAfka\\Radhika\\messages_main.thirdpartybilling.accountmanagement_P1.errors_393.json";
    	  StringBuffer stringBuffer = new StringBuffer("");
    	  
    	 // Path path = Paths.get("D:\\Docs\\backup\\Sprint work\\KAfka\\Radhika\\01.txt");
    	  File path = new File("D:\\\\Docs\\\\backup\\\\Sprint work\\\\KAfka\\\\Radhika\\\\P1.errors_393.json");
    	  FileWriter wr = new FileWriter(path);
    	  
    	  
    	  try{
    	      fileInputStream=new FileInputStream(filename);
    	      int i;
    	      while((i=fileInputStream.read())!=-1)
    	      {
    	          stringBuffer.append((char)i);
    	      }
    	      data = stringBuffer.toString();
    	  }
    	  catch(Exception e){
    	        e.printStackTrace();
    	  }
    	  finally{
    	      if(fileInputStream!=null){  
    	          fileInputStream.close();
    	      }
    	  }
    	  
    	//  JSONParser parser = new JSONParser();
    	 // org.json.simple.JSONArray jsonArray= (org.json.simple.JSONArray) parser.parse(data);
    	  
    	  char endChar = '}';
    	  int endCharCounter = 0;
    	  String finalString = "";
    	  boolean flowCompleted = false;
    	  boolean fistEntry = true;
    	  boolean expectedFlow = false;
    	  String jsonString = "[";
    	  
    	  for (int i = 0; i < data.length(); i++) {
    		  
              // Print current character
              //System.out.print(data.charAt(i) + " ");
              
              if(expectedFlow ||  (data.charAt(i) == '"' && data.charAt(i+1) == 'v' && data.charAt(i+2) == 'a' && data.charAt(i+3) == 'l' && data.charAt(i+4) == 'u'
            		  &&  data.charAt(i+5) == 'e' && data.charAt(i+6) == '"' && data.charAt(i+7) == ':' )) {
            	  
            	  expectedFlow = true;
            	  
            	  if(fistEntry)
            		  i  = i + 8;
            	  
            	  fistEntry = false;
            	  
            	  if(data.charAt(i) == '}') {
                	  endCharCounter ++;
                  }
                  
                  if(endCharCounter == 2) {
                	  finalString +=  '}';
                	  //endChatSeqCompleted = true;
                	  System.out.println(finalString);
                	  
                	 
                     

                	  
                	  
                	  jsonString+= finalString + "   ,";
                	  endCharCounter = 0;
                	  flowCompleted = true;
                	  finalString = "";
                	  fistEntry = true;
                	  expectedFlow = false;
                	  
                  }
                  
                  	if(!flowCompleted)
                	  finalString +=  data.charAt(i);
                  	
                  	flowCompleted = false;
              }
              
              
              
              
           
              
              
          }
    	  
    	  jsonString+=  "]";
    	  
    	  //System.out.println(jsonString);
    	  
    	  wr.write(jsonString);
    	//flushing the writer
          wr.flush();
           
          //closing the writer
          wr.close();
    	  
    	  
    	//  JSONObject obj=(JSONObject)jsonArray.parse(data); 
    	//  JSONArray arr=(JSONArray)obj.get("units"); 
    	//  
    	//  System.out.println("Contents of the JSON are: "+jsonArray.get(1));
    	  
    	  
    	//  org.json.simple.JSONArray  temp1 = (org.json.simple.JSONArray)jsonArray.get(1);
    	//  System.out.println("Contents of the JSON are: "+temp1.get(1));
    	  
    	//  org.json.simple.JSONObject temp = (org.json.simple.JSONObject)  jsonArray.get(1);
    	  
    	//  System.out.println("Contents of the JSON are: "+temp.get(2));
         //String value = (String) jsonObject.get("value");
       //  String last_name = (String) jsonObject.get("Last_Name");
       //  String date_of_birth = (String) jsonObject.get("Date_Of_Birth");
       //  String place_of_birth = (String) jsonObject.get("Place_Of_Birth");
      //   String country = (String) jsonObject.get("Country");
         //Forming URL
        // System.out.println("Contents of the JSON are: ");
         //System.out.println("value :"+value);
        // System.out.println("First name: "+first_name);
        // System.out.println("Last name: "+last_name);
       //  System.out.println("Date of birth: "+date_of_birth);
       //  System.out.println("Place of birth: "+place_of_birth);
        // System.out.println("Country: "+country);
        // System.out.println(" ");
      } catch (FileNotFoundException e) {
            e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}