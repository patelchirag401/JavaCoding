package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCC {
	
	public static void main(String a[]) {
		
		String name = "J. Michael";
		//String name = "Michael";
		//String name = "J.Michael";
		System.out.println(isMatch(name));
		
		
		name = "MILE HOUSE 15000000";
		//name = "!@#@#@$%$%^^%^&&&*&&(*(*()((*)()__+";
		name = "BBBBBBBBBBBBBBBBBBBBBBBBBBMILE HOUSE 150";
		name = " MILE HOUSE";
		//name = "150";
		
		System.out.println(isCityMatch(name));
	  	
	}
	
	
	public static boolean isMatch(String name) {
		Pattern regexPattern = Pattern.compile("^[a-zA-Z]+((((\\-)|(\\s)|(\\')|(\\.))[a-zA-Z]+)*?(,(\\s*)?(((j|J)|(s|S))(r|R)(\\.)?|II|III|IV))?)?$");
		//Matcher matcher = Pattern.compile("\\d+").matcher(str);
		
		
		return  regexPattern.matcher(name).matches();
		//return true;
	}
	
	public static boolean isCityMatch(String name) {
		
		String a = "[A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']{1,30}?$    |     ^(?:\\D*\\d){0,5}\\D*$";
		 a = "[A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']{1,30}?$    |     ^([A-Za-zÃ-Ã¿ÅÅ\\\\s\\\\-\\\\.\\\\']{1,30}:\\D*\\d){0,5}\\D*$";
		 a="^([A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']*([0-9][A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']*){0,5}).{1,30}$";
		 a="^(?![0-9]*$)[A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']{1,30}$";
		 a="^(?!.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d)[A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']{1,30}$";
		 a="^(*\\d.*\\d.*\\d.*\\d.*\\d.*\\d)[A-Za-zÃ-Ã¿ÅÅ\\s\\-\\.\\']{1,30}$";
		 a="^(?=[A-Z]{1,30}$)(?=(?:[^0-9]*[0-9]){0,5}[^0-9]*)$";
		 		
		//String b = "^(?:\\D*\\d){0,5}\\D*$";
		
		Pattern regexPattern = Pattern.compile(a);
		//Matcher matcher = Pattern.compile("\\d+").matcher(str);
		
		
		return  regexPattern.matcher(name).matches();
		//return true;
	}
	
	
	

}
