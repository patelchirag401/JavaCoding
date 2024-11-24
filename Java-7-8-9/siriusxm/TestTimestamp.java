package com.siriusxm;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class TestTimestamp {
	
	
	
	public static void main(String a[]) {
		Timestamp ts = Timestamp();
		System.out.println("test:"+dateStringToTimestamp("2024-07-15T13:59:59.915Z"));
	}
	
	
	public static Timestamp dateStringToTimestamp(String val) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Timestamp timestamp = null;
		if (val!=null) {
			try {
				LocalDate parsedDate;
				parsedDate = LocalDate.parse(val, dateFormat);
				timestamp = Timestamp.valueOf(parsedDate.atStartOfDay());
			}catch (DateTimeParseException e){
				e.printStackTrace();
			}
		}
		return timestamp;
	}

}

