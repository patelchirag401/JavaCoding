package com.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.JSONParser;
public class ReadfromXLSandCreateJSON {
	
	 static char Quote = '"';

	  static String surroundByQuote(String str) {
		   return Quote + str + Quote;
	   }
	 
	 
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
    	  File path = new File("D:\\Docs\\Staging\\NotInSMS_1.json");
    	  FileWriter wr = new FileWriter(path, false);
    	  
    	  
    	  String INPUT_FILE_NAME = "NotInSMS.xlsx";
  		//String RESULT_FILE_NAME = "Results.xlsx";
  		String FILE_PATH = "D:\\Docs\\Staging\\";
  		final int ROW_COUNT = 1982;
  		
  		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(FILE_PATH + INPUT_FILE_NAME));
  		XSSFSheet myExcelSheet = myExcelBook.getSheet("NotInSMS");
  		
  		

  		
  		
  		
  		//String startHeader = "{\"header\":";
  		String startHeader = "{" + surroundByQuote("header") + ":{";
  		String startChar = "{";
  		String endChar = "}";
  		String header = "";
  		String payload = "";
  		
  		String finalString = "";
  		
  		
  		for(int i=1;i<=ROW_COUNT;i++) {
  			XSSFRow row_i = myExcelSheet.getRow(i);
  			
  			if(row_i != null) {
  				
  				
  				String CUSTOMER_ID = row_i.getCell(0).getRawValue();
  				//System.out.println("CUSTOMER_ID : " + CUSTOMER_ID);
  				
  				String TRANSACTION_ID = row_i.getCell(2).toString();
  				//System.out.println("TRANSACTION_ID : " + TRANSACTION_ID);
  				
  				String ENTITLEMENT_ID = row_i.getCell(3).toString();
  				//System.out.println("ENTITLEMENT_ID : " + ENTITLEMENT_ID);
  				
  				

  				
  				String USER_LOGIN = row_i.getCell(4).toString();
  				//System.out.println("USER_LOGIN : " + USER_LOGIN);
  				
  				String VENDOR_SKU = row_i.getCell(6).toString();
  				//System.out.println("VENDOR_SKU : " + VENDOR_SKU);
  			
  				Date DATE_CREATED = row_i.getCell(7).getDateCellValue();
  				
  				
  				LocalDate localDate = DATE_CREATED.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  				LocalTime localTime = DATE_CREATED.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
 				
  				//System.out.println("timestamp: " + localDate.toString()+"T"+localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond()+"-04:00");  
  			
                
                
  				TimeZone tz = TimeZone.getTimeZone("UTC");
  				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmmZ"); // Quoted "Z" to indicate UTC, no timezone offset
  				df.setTimeZone(tz);
  				String nowAsISO = df.format(DATE_CREATED);
  				
  				//System.out.println("creationDate: " + nowAsISO.substring(0, nowAsISO.length()-5)+"Z");  
  				
  				header = startHeader + surroundByQuote("transactionId") + ":" + surroundByQuote(TRANSACTION_ID) + "," +
  						surroundByQuote("sourceName") + ":" + surroundByQuote("EXTERNAL-PARTNER") +  "," + 
  						
  						surroundByQuote("timestamp") + ":" + surroundByQuote(localDate.toString()+"T"+localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond()+"-04:00") + 
  						
  						endChar + "," ;
  				
  				payload = surroundByQuote("action") + ":" + surroundByQuote("activation")  + "," +
  						 surroundByQuote("externalSubscriptionID") + ":" + surroundByQuote(ENTITLEMENT_ID)  + "," +
  						surroundByQuote("corpId") + ":" + surroundByQuote("13500")  + "," +
  						surroundByQuote("creationDate") + ":" + surroundByQuote(nowAsISO.substring(0, nowAsISO.length()-5)+"Z")  + "," +
  						surroundByQuote("email") + ":" + surroundByQuote(USER_LOGIN)  + "," +
  						surroundByQuote("firstName") + ":" + surroundByQuote("Subscriber")  + "," +
  						surroundByQuote("lastName") + ":" + surroundByQuote("TMOBILE")  + "," +
  						surroundByQuote("sku") + ":" + surroundByQuote(VENDOR_SKU)  + "," +
  						surroundByQuote("userName") + ":" + surroundByQuote(USER_LOGIN)  + 
  						endChar;
  				
  				
  				if(i==1) {
  					finalString += "[";
  				}
  				
  				//System.out.println(header +  payload);  
  				
  				
  				//finalString = header +  payload + ",";
  				
  				if(i==ROW_COUNT) {
  					finalString += header +  payload;
  					finalString +=  "]";
  					System.out.print("print final count"+i);
  				} else {
  					finalString += header +  payload + ",";
  				}
  			}
  		}
  		
  		
  		wr.write(finalString);
    	//flushing the writer
        wr.flush();
           
          //closing the writer
        wr.close();
        
        System.out.println("Done");  
  		
  		
  		///////////////////////////////////////////////////////////
    	  /*
    	  
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
          wr.close();*/
    	  
    	  
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