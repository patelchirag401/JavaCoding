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
public class CompareErrorcode {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//
		readFromExcel("D:\\Docs\\backup\\UWI Error reports\\Sep23\\AUG01TOAUG31.xlsx","D:\\Docs\\backup\\UWI Error reports\\Sep23\\Sep01TOSep30.xlsx");
		//writeIntoExcel("Results.xlsx");
	}

	public static void readFromExcel(String jul, String aug) throws IOException {
		XSSFWorkbook augExcelbook = new XSSFWorkbook(new FileInputStream(jul));
		XSSFSheet augExcelSheet = augExcelbook.getSheet("Table1");
		
		XSSFWorkbook sepExcelbook = new XSSFWorkbook(new FileInputStream(aug));
		XSSFSheet sepExcelSheet = sepExcelbook.getSheet("Table1");
		
		
		/*XSSFRow row = myExcelSheet.getRow(2);
		String Header0 = row.getCell(0).getStringCellValue();
		//System.out.println("Header0 : " + Header0);

		String Header1 = row.getCell(1).getStringCellValue();
		//System.out.println("Header1 : " + Header1);

		String Header2 = row.getCell(2).getStringCellValue();
		//System.out.println("Header2 : " + Header2);

		String Header3 = row.getCell(3).getStringCellValue();
		//System.out.println("Header3 : " + Header3);
		*/
		HashMap<String,String> julmap = new HashMap<>();
		HashMap<String,String> augmap = new HashMap<>();
		HashMap<String,String> result = new HashMap<>();
		HashMap<String,String> diff = new HashMap<>();
		
		String val = "";
		
		for(int i=1;i<10898;i++) {
			XSSFRow row_i = augExcelSheet.getRow(i);
			String key = row_i.getCell(5)!=null ? row_i.getCell(5).getStringCellValue():"";
			//System.out.println("cell : " + cell1);
			
			try {
			 val = row_i.getCell(10)!=null ?row_i.getCell(10).getStringCellValue():"";
			}catch(Exception e) {
				
			}
			//System.out.println("cell : " + cell1);
			julmap.put(key.trim(),val.trim());		
			
		}
		
		for(int i=1;i<9245;i++) {
			XSSFRow row_i = sepExcelSheet.getRow(i);
			String key = row_i.getCell(5)!=null ? row_i.getCell(5).getStringCellValue():"";
			//System.out.println("cell : " + cell1);
			try {
			 val = row_i.getCell(10)!=null ?row_i.getCell(10).getStringCellValue():"";
			}catch(Exception e) {
				
			}
			//System.out.println("cell : " + cell1);
			augmap.put(key.trim(),val.trim());		
			
		}
		
		try {
            for (Map.Entry<String, String> set : augmap.entrySet()) {
            	if(!julmap.containsKey(set.getKey())) {
            		 result.put(set.getKey(),set.getValue());
            	}
            }
            
            
            for (Map.Entry<String, String> set : augmap.entrySet()) {
            	
            	String augkey = set.getKey();
            	String augvalue = set.getValue();
            	
            	String julkey = julmap.get(augkey);
            	String jukvalue = julmap.get(augvalue);
            	
            	if (!augkey.equals(julkey)) {
            		diff.put(augkey, augvalue);
            	}
            	
            	
            	if(!julmap.containsKey(set.getKey())) {
            		 result.put(set.getKey(),set.getValue());
            	}
            }
            
            
            //for (Map.Entry<String, Double> set : result.entrySet()) {
            	//System.out.println(set.getKey());
            	//System.out.println(set.getValue());
            	//System.out.println(set.getKey()+ ": " + set.getValue());
            //}
            
            
            writeIntoExcel("compare01.xlsx",result);
            writeIntoExcel("diff.xlsx",result);
            
            System.out.println("writes done : ");
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
		

		sepExcelbook.close();
		augExcelbook.close();
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
    		Cell apr_count = 	
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
	        FileOutputStream fileOut = new FileOutputStream("D:\\\\Docs\\\\backup\\\\UWI Error reports\\\\Sep23\\"+file);
	        book.write(fileOut);
	        fileOut.close();
	        
		//book.write(new FileOutputStream(file));
		//book.close();
	}
}
