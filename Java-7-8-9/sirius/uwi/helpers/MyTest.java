package com.sirius.uwi.helpers;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTest {
	
	public static void main(String a[]) {
		
		
		String password = CryptoUtil.decryptMessage("17147aa1fa0674c0380e36b30d0e48b8", "21fe04b793286e050dc6412fa69b7e9f");
		
		System.out.println("test:"+password);
		
		String encrtpt = CryptoUtil.encryptMessage("s1Rixmkey", "21fe04b793286e050dc6412fa69b7e9f");
		
		System.out.println("test:"+encrtpt);	
		
		
		/*String cipherKey = "6ce94ad8641ab09ae9c621aa33bbe2e0"; 
        String message = "402f0e8181a2f8b9bdf696157149473f";
        
        String password = CryptoUtil.decryptMessage(message, cipherKey);
		
		System.out.println("test:"+password);
		*/
		
		//String encrtpt = CryptoUtil.encryptMessage("s1Rixmkey", "21fe04b793286e050dc6412fa69b7e9f");
		
		//System.out.println("test:"+encrtpt);
	}

}
