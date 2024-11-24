package com.test1;

import java.util.Calendar;

public class Vovels {
	
	public static void main(String a[]) {
		
		String strvowels="AI the next step to digitalization";	
	
		long count = strvowels.chars().mapToObj(c->(char)c).filter(c->"aeiouAEIOU".indexOf(c)!=-1).count();
		
		System.out.print("count:"+count);		
		
		int cal  = Calendar.JANUARY;
		
	}

}
