package com.capitalone;

import java.util.HashMap;
import java.util.Map;

public class DensityOfHouse {
	public static void main(String a[]) {
		int[] test1 = new int[] {1,4,5,7,8,9};
		
		
		test1 = densityOfHouse(test1);
		for (int i = 0; i < test1.length; i++) {
			
			System.out.print(test1[i]);
		}
	}
	
	
	static int[]  densityOfHouse(int[] input) {
		
		Map<String,Integer> hashmap = new HashMap<String,Integer>();
		
		
		
		int[] result = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			if (hashmap.isEmpty()) {
				hashmap.put("" + input[i], 1);
				result[0] = 1;
			} else {

				int temp = input[i];			
			
					if(mapKeysContain(hashmap,"" + (temp))!=null ) {
						String tempKey = mapKeysContain(hashmap,"" + (temp));
						tempKey = tempKey.concat("" + temp);
						int tempLegth = tempKey.length();
						hashmap.put(tempKey, tempLegth);
						result[i]=tempLegth;
						//break;
					}  else  {
						hashmap.put("" + input[i], 1);
						result[i] = 1;
						//break;
					}				
			}
		}
		
		return result;
	}
	
	static String mapKeysContain(Map<String,Integer> hashmap, String key ) {
		
		int plusone = Integer.parseInt(key);
		plusone++;
		
		int minusone = Integer.parseInt(key);
		minusone--;
		
		for (Map.Entry<String, Integer> set : hashmap.entrySet()) {
			
			if(set.getKey().contains(""+plusone) || set.getKey().contains(""+minusone)) {
				return set.getKey();
			}
			
		}
		return null;
		
	}
}
