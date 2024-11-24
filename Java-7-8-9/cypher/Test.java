package com.cypher;

public class Test {
	
	public static void main(String a[]) {
		
		String[] strArray1 = new String[] {"OAC","cep","Dtc"};
		String inputSource = "OAC";
		
		
		for(String str: strArray1) {
			
			if(str.equalsIgnoreCase("oac")) {
				//System.out.println(str);
			} 
			
		}
		
		String cipherKey = "6ce94ad8641ab09ae9c621aa33bbe2e0"; 
        String message = "402f0e8181a2f8b9bdf696157149473f"; 
//String password = CryptoUtil.decryptMessage(message, cipherKey);
		
		System.out.println("test:"+"");
		
			
		String str = "41111111111111aa@xm.com";
		str = str.replaceAll("[^\\d]", "");
		//System.out.println(str);
		
		String str1 = "41111111111111";
		//System.out.println(CCUtils.isValidCC(str1));
		
	}

}
