package com.xlsreader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WriteFile {
	
	public static void main(String a[]) {
		String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><a><b></b><c>Salomé Salomé</c></a>";  

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder;  

		
		try {  
		  //  builder = factory.newDocumentBuilder();  
		   // Document document = builder.parse(new InputSource(new StringReader(xmlString)));  
		    
		  //  BufferedWriter bufw = new BufferedWriter( new FileWriter( "D:\\Docs\\backup\\UWI Error reports\\JAN23\\testfile.txt", true ) );
		    
		  //  BufferedWriter out = new BufferedWriter (new OutputStreamWriter(new FileOutputStream("D:\\Docs\\backup\\UWI Error reports\\JAN23\\testfile.txt")));
			File    fileOut = new File( "D:\\Docs\\backup\\UWI Error reports\\JAN23\\testfile.xml" );
			//BufferedWriter bufw = new BufferedWriter( new FileWriter(new FileOutputStream("D:\\Docs\\backup\\UWI Error reports\\JAN23\\testfile.txt"), "true" ));
			 // BufferedWriter bufw = new BufferedWriter( new FileWriter( fileOut, true ) );
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Docs\\backup\\UWI Error reports\\JAN23\\testfile.xml"), StandardCharsets.UTF_8) );
		    
		   // bufw.write(xmlString);
		  //  bufw.close();
		    System.out.println("done");
		    
			  bufw.write(xmlString);
			  bufw.close();
		    
		} catch (Exception e) {  
		    e.printStackTrace();  
		} 
	}

}
