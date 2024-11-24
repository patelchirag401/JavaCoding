package com.javasmallcomponent;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test1 {
	

	// variable to check if part1 has returned
	// volatile used to prevent threads from
	// storing local copies of variable
	volatile boolean part1done = false;
	
	public static void main(String a[]) {
		System.out.println("test");
		/*int totalRows = 30000;
		int pageSize = 10000;
		for (int start = 1, counter = 1; start <= totalRows; start+=pageSize, counter++) {
			int end = start + pageSize > totalRows ? totalRows : start + pageSize - 1;
			
			System.out.println(" start: "+start+" counter: "+counter+" end: "+end);
		}
		
		*/
		
		Double ab = Double.POSITIVE_INFINITY;
		
		
		char[] chars = new char[] {'\u0097'};
		String str = new String(chars);
		System.out.println("test:--"+str);
		
		System.out.println(Arrays.toString(str.getBytes())); 
		
		
		System.out.println("devide test:"+ 1.0/0.0); 
		System.out.println("devide test:"+ 0.0/0.0); 
		System.out.println("devide test:"+ -1.0/0.0); 
		
		String s1 ="";
		s1.intern();
		
		LocalDate ld1;
		LocalTime lt1;
		LocalDateTime ldt;
		
		List<String> list = List.of();
		StringBuffer sb1 = new StringBuffer(); // methods length, capacity and appends are synchronized  
		StringBuilder sb2 = new StringBuilder(); // they are not 
		SimpleDateFormat sd = new SimpleDateFormat();
		ThreadLocal<SimpleDateFormat> tl =  new ThreadLocal<SimpleDateFormat>();
		// joda time library
		
		
		//
		//LocalDate date =  LocalDate.now();
		//DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("ddmmyyyy");
		//String formatedddate = dtf.format(date);
		
		//Date aDate = new Date(2015,12,25,20,40);
		
		SimpleDateFormat sd1; // this is not a thread safe so have to be used with thread local variable....recommend to use joda library..
		
		// after java 8 user datetimeformatter api
		
		// old date api was not threadsafe, immutable and wrong sequence
		
		java.sql.Date sqldate;
		java.util.Date utildate = new Date(); utildate.setSeconds(34);
		
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		date.format(dtf);
		
		
		java.util.Date a11; // this is not immutable.. so use java 8 LocalDate...
		java.sql.Date be11;
		
		Calendar cl = Calendar.getInstance();
		Date datecl = cl.getTime(); // convert calendar to date and date to calendar
		
		
		
		Date date11 = new Date();
		date11.clone();
		
		WeakReference<String> wr = new WeakReference<String>("");
		//PhantomReference<String> pr = new PhantomReference<String>("" );
		SoftReference sr = new SoftReference("");
		
		
		 ReferenceQueue<String> rq  = new ReferenceQueue<>();
		 
		 ArrayList<String> alstring;
		 ArrayList generic;
		 
		 HashMap hm;
		 ArrayList al =  new ArrayList<String>();
		 al.add("a");al.add("b");al.add("c");
		 
		 Integer[] array = new Integer[] {1,2,3,4,5,6,7,8,9,10}; 

		 int length = array.length;  
		 int listsize = al.size(); 
		

System.out.println("array.length:"+ length); 
System.out.println("al.size():"+ listsize);


CopyOnWriteArrayList<String> conwet = new CopyOnWriteArrayList<String>(); // atlernative of synchronized array list for the better performance

BlockingQueue<String> BQ;

ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>(); // remember it's iterating over the copy of map ..so it's fail safe...other thread can not see it if during the 
                                                                                 // iteration one thread has modified it

Collections.unmodifiableList(al); // to get immutable version of arraylist

Collections.reverseOrder(); // to sort the collection in reverse order

HashMap newmap = new HashMap<String, String>();

newmap.size();


CyclicBarrier cb;
CountDownLatch clatch;

System.out.println("expiry date:"+Integer.valueOf("1689059112"));

		
	}

}
