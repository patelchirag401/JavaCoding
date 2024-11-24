package com.xlsreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * * This program read date values from XLSX file in Java using Apache POI. *
 * * @author WINDOWS 8 *
 */
public class CompareStackTypemap {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//
		readFromExcel("D:\\Docs\\backup\\UWI Error reports\\Sep\\SEP01TOSEP31.xlsx");
		//writeIntoExcel("Results.xlsx");
	}

	public static void readFromExcel(String sep) throws IOException {
		XSSFWorkbook sepExcelbook = new XSSFWorkbook(new FileInputStream(sep));
		XSSFSheet table1ExcelSheet = sepExcelbook.getSheet("Table1");
		
		XSSFSheet stacktypeExcelSheet = sepExcelbook.getSheet("StackTypeMap");
		
		
		HashMap<String,String> result = new HashMap<>();
		HashMap<String,String> diff = new HashMap<>();
		
		HashMap<String,String> table1map = new HashMap<>();
		HashMap<String,String> stacktypemap = new HashMap<>();
		
		
		String val = "";
		
		// table1
		for(int i=1;i<10869;i++) {
			try {

			XSSFRow row_i = table1ExcelSheet.getRow(i);
			String key = row_i.getCell(5)!=null ? row_i.getCell(5).getStringCellValue():"";
			//System.out.println("cell : " + cell1);
			
			 val = row_i.getCell(9)!=null ?row_i.getCell(9).getRawValue():"";
			 
			 table1map.put(key.trim(),val.trim());		
			 
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			//System.out.println("cell : " + cell1);
			
			
		}
		
		// stacktype
				for(int i=1;i<3498;i++) {
					
					try {
						
					XSSFRow row_i = stacktypeExcelSheet.getRow(i);
					String key = row_i.getCell(0)!=null ? row_i.getCell(0).getStringCellValue():"";
					//System.out.println("cell : " + cell1);
					
					
					 val = row_i.getCell(1)!=null ?row_i.getCell(1).getRawValue():"";
					 
						stacktypemap.put(key.trim(),val.trim());		
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					//System.out.println("cell : " + cell1);
				
					
				}
		
	
		
		try {
           /* for (Map.Entry<String, String> set : stacktypemap.entrySet()) {
            	if(!table1map.containsKey(set.getKey())) {
            		 result.put(set.getKey(),set.getValue());
            	}
            }*/
            
            
            for (Map.Entry<String, String> set : stacktypemap.entrySet()) {
            	
            	String stmkey = set.getKey();
            	String stmvalue = set.getValue();
            	
            	//String t1mkey = table1map.get(stmkey);
            	String t1mvalue = table1map.get(stmkey);
            	
            	if (stmvalue!=null && t1mvalue!=null && !stmvalue.trim().equals(t1mvalue.strip())) {
            		diff.put(stmkey, stmvalue);
            	}
            	
            	
            	//if(!julmap.containsKey(set.getKey())) {
            		// result.put(set.getKey(),set.getValue());
            	//}
            }
                       
           
           // writeIntoExcel("results.xlsx",result);
            writeIntoExcel("diff.xlsx",diff);
            
            System.out.println("writes done : ");
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
		

		sepExcelbook.close();
	}

	@SuppressWarnings("deprecation")
	public static void writeIntoExcel(String file,HashMap<String,String> result) throws FileNotFoundException, IOException {
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Result");
		//Row row = sheet.createRow(0);
		int k=0;
		 for (Map.Entry<String, String> set : result.entrySet()) {
         	//System.out.println(set.getKey());
         	//System.out.println(set.getValue());
         	//System.out.println(set.getKey()+ ": " + set.getValue());
			 
			 // error name
			Row row = sheet.createRow(k);
         	Cell error_name = row.createCell(0);
    		error_name.setCellValue(set.getKey());
    		
    		//diff
    		Cell error_count = row.createCell(1);
    		error_count.setCellValue(set.getValue());
    		
    		/*// apr count
    		Cell apr_count = row.createCell(2);
    		//Double aprcount  = apr.get(set.getKey())!=null?apr.get(set.getKey()):0.0;
    		apr_count.setCellValue(apr.get(set.getKey())!=null?apr.get(set.getKey()):0.0);
    		
    		// may count
    		Cell may_count = row.createCell(3);
    		may_count.setCellValue(may.get(set.getKey()));
    		*/
    		
    		k++;
         }
		
		
		//Cell error_name = row.createCell(0);
		//error_name.setCellValue("Gokul");
		
		//Cell error_count = row.createCell(1);
		//error_count.setCellValue(new Date(115, 10, 10));
		//DataFormat format = book.createDataFormat();
		//CellStyle dateStyle = book.createCellStyle();
		//dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
		//birthdate.setCellStyle(dateStyle);
		//birthdate.setCellValue(new Date(115, 10, 10));
		 sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		// Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("D:\\Docs\\backup\\UWI Error reports\\Sep\\inner\\"+file);
	        book.write(fileOut);
	        fileOut.close();
	        
		//book.write(new FileOutputStream(file));
		//book.close();
	}
}
