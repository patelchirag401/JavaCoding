package com.xlsreader;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
 * Compare error message and error count with previous month data
 */
public class ExcelDateReader {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		

		

		readFromExcel();
	}

	public static void readFromExcel() throws IOException {
		
		
		
		

		String INPUT_FILE_NAME = "Jul01TOJul31.xlsx";
		String RESULT_FILE_NAME = "Results.xlsx";
		String FILE_PATH = "D:\\Docs\\backup\\UWI Error reports\\July23\\";
		final int ROW_COUNT = 217;
		
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(FILE_PATH + INPUT_FILE_NAME));
		XSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet5");
		XSSFRow row = myExcelSheet.getRow(0);
		String Header0 = row.getCell(0).getStringCellValue();
		//System.out.println("Header0 : " + Header0);

		String Header1 = row.getCell(1).getStringCellValue();
		//System.out.println("Header1 : " + Header1);

		String Header2 = row.getCell(2).getStringCellValue();
		//System.out.println("Header2 : " + Header2);

		String Header3 = row.getCell(3).getStringCellValue();
		//System.out.println("Header3 : " + Header3);
		
		HashMap<String,Double> current = new HashMap<>();
		HashMap<String,Double> prev = new HashMap<>();
		HashMap<String,Double> result = new HashMap<>();
		
		for(int i=1;i<=ROW_COUNT;i++) {
			XSSFRow row_i = myExcelSheet.getRow(i);
			
			if(row_i != null) {
				
				String current_error = row_i.getCell(0)!=null ? row_i.getCell(0).getStringCellValue():"";
				//System.out.println("cell : " + cell1);
				
				double current_count = row_i.getCell(1)!=null ?row_i.getCell(1).getNumericCellValue():0;
				//System.out.println("cell : " + cell1);
				current.put(current_error,current_count);
				
				String prev_error = row_i.getCell(2)!=null?row_i.getCell(2).getStringCellValue():"";
				//System.out.println("cell : " + cell1);
				
				double prev_count = row_i.getCell(3)!=null ?row_i.getCell(3).getNumericCellValue(): 0;
				//System.out.println("cell : " + cell1);
				prev.put(prev_error,prev_count);
			}
		}
		
		try {
            for (Map.Entry<String, Double> set : current.entrySet()) {

            	double prev_count = 0;
            	if(prev.containsKey(set.getKey())) {
            		prev_count = prev.get(set.getKey());
            	}
                
            	double current_count = current.get(set.getKey());
                
            	double diff = current_count - prev_count;
            	// 0 = same
            	// > 0 , increase in error count
                // < 0 , decrease in error count 
                result.put(set.getKey(),diff);
            }
            
            
            for (Map.Entry<String, Double> set : result.entrySet()) {
            	//System.out.println(set.getKey());
            	//System.out.println(set.getValue());
            	//System.out.println(set.getKey()+ ": " + set.getValue());
            }
            
            
            writeIntoExcel(FILE_PATH + RESULT_FILE_NAME,result,prev,current);
            
            System.out.println("writes done : Check generated file in given directory.");
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }		

		myExcelBook.close();
	}

	@SuppressWarnings("deprecation")
	public static void writeIntoExcel(String file, HashMap<String, Double> result, HashMap<String, Double> prev,
			HashMap<String, Double> current) throws FileNotFoundException, IOException {
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Result");
		
		// error name
		Row row = sheet.createRow(0);
		Cell error_name = row.createCell(0);
		error_name.setCellValue("error name");

		// diff
		Cell error_count = row.createCell(1);
		error_count.setCellValue("diff");

		// prev count
		Cell prev_count = row.createCell(2);
		// Double aprcount = apr.get(set.getKey())!=null?apr.get(set.getKey()):0.0;
		prev_count.setCellValue("prev count");

		// current count
		Cell current_count = row.createCell(3);
		current_count.setCellValue("current count");
					
					
		int k = 1;
		for (Map.Entry<String, Double> set : result.entrySet()) {
			// error name
			 row = sheet.createRow(k);
			 error_name = row.createCell(0);
			error_name.setCellValue(set.getKey());

			// diff
			 error_count = row.createCell(1);
			error_count.setCellValue(set.getValue());

			// prev count
			 prev_count = row.createCell(2);
			// Double aprcount = apr.get(set.getKey())!=null?apr.get(set.getKey()):0.0;
			prev_count.setCellValue(prev.get(set.getKey()) != null ? prev.get(set.getKey()) : 0.0);

			// current count
			 current_count = row.createCell(3);
			current_count.setCellValue(current.get(set.getKey()));

			k++;
		}

		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(file);
		book.write(fileOut);
		fileOut.close();

	}
}
