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
public class CompareStackTypemapfromCurrentandPrevMonth {
	
	
	final static String OUTPUT_FILE =  "D:\\Docs\\backup\\UWI Error reports\\Aug23\\diff.xlsx";
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//
		readFromExcel();
		//writeIntoExcel("Results.xlsx");
	}

	public static void readFromExcel() throws IOException {
		
		final int CURRENT_COUNT = 10898;
		final int PREV_COUNT = 10917;
		String CURR_PATH = "D:\\Docs\\backup\\UWI Error reports\\Aug23\\Aug01TOAug31.xlsx";
		String PREV_PATH = "D:\\Docs\\backup\\UWI Error reports\\Aug23\\Jul01TOJul31.xlsx";


		
		XSSFWorkbook table1Excelbook = new XSSFWorkbook(new FileInputStream(CURR_PATH));
		XSSFSheet table1ExcelSheet = table1Excelbook.getSheet("Table1");
		
		XSSFWorkbook table2Excelbook = new XSSFWorkbook(new FileInputStream(PREV_PATH));
		XSSFSheet table2ExcelSheet = table2Excelbook.getSheet("Table1");
		

		HashMap<String,String> result = new HashMap<>();
		HashMap<String,String> diff = new HashMap<>();
		
		HashMap<String,String> table1map = new HashMap<>();
		HashMap<String,String> table2map = new HashMap<>();

		
		
		String val = "";
		
		// current
		for(int i=1;i<CURRENT_COUNT;i++) {
			try {

			XSSFRow row_i = table1ExcelSheet.getRow(i);
			String key = row_i.getCell(5)!=null ? row_i.getCell(5).getStringCellValue():"";
			//System.out.println("cell : " + cell1);
			
			 val = row_i.getCell(9)!=null ?row_i.getCell(9).getRawValue():"";
			 
			 table1map.put(key.trim(),val.trim());		
			 
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
		
		// prev
				for(int i=1;i<PREV_COUNT;i++) {
					try {

					XSSFRow row_i = table2ExcelSheet.getRow(i);
					String key = row_i.getCell(5)!=null ? row_i.getCell(5).getStringCellValue():"";
					//System.out.println("cell : " + cell1);
					
					 val = row_i.getCell(9)!=null ?row_i.getCell(9).getRawValue():"";
					 
					 table2map.put(key.trim(),val.trim());		
					 
					}catch(Exception e) {
						e.printStackTrace();
						
					}
				}

	
		
		try {
            for (Map.Entry<String, String> set : table1map.entrySet()) {
            	
            	String stmkey = set.getKey();
            	String stmvalue = set.getValue();
            	
            	String t1mvalue = table2map.get(stmkey);
            	
            	if (stmvalue!=null && t1mvalue!=null && !stmvalue.trim().equals(t1mvalue.strip())) {
            		diff.put(stmkey, stmvalue);
            	}
            }
                       
           
           // writeIntoExcel("results.xlsx",result);
            writeIntoExcel(diff);
            
            System.out.println("writes done : ");
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
		

		table1Excelbook.close();
	}

	@SuppressWarnings("deprecation")
	public static void writeIntoExcel(HashMap<String,String> result) throws FileNotFoundException, IOException {
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
	        FileOutputStream fileOut = new FileOutputStream(OUTPUT_FILE);
	        book.write(fileOut);
	        fileOut.close();
	        
		//book.write(new FileOutputStream(file));
		//book.close();
	}
}
