package com.fibo;

public class IPAddresstest {
	
	public static void main(String a[]) {
		System.out.println(solution("172.16.254.1"));
	}
	
	static boolean solution(String inputString) {
	    
	    String str[] = inputString.split(".");
	    if(str.length!=4){
	        return false;
	    }
	    
	    boolean result =  false;
	    for(String s:str) {
	        int num = Integer.valueOf(s);
	        if((num>=0 && num<=255) ) {
	            result =  true;
	        }
	        
	    }
	    return result;
	}

}
