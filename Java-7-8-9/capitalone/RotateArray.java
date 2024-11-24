package com.capitalone;

public class RotateArray {
	
	public static void main(String a[]) {

		int arr[] = new int[] {1,2,3,4,5,6,7};
		rotate(arr,3);
	}

	
	public static void rotate(int[] nums, int k) {

		int temp[] = new int[10] ; // remember do not initialize with  { }
		for(int i=0;i<k;i++) {
			temp[i] = nums[nums.length + i - k];
			System.out.print(temp[i]);
		}
		
		System.out.print("");;
		
		int temp1[] = new int[10];
		for(int j=0;j<nums.length-k;j++) {
			temp1[j] = nums[j];
			//System.out.print(temp1[j]);
		}
		
		//System.arraycopy(temp, 0, temp1, 0, nums.length);
		
		for(int i=0;i<temp.length;i++) {
			System.out.print(temp[i]);
		}
		
		
		// merge two array;
		/*int index=0;
		for(int t=0;t<temp1.length;    t++) {
			index = temp1.length;
			temp[index] = temp1[t];
			index ++;
		}*/
		
	}
}
