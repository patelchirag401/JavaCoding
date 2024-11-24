package com.capitalone;

public class MatrixAITest {
	
	public static void main(String a[]) {
		
		//int[][] matrix = [[]]; 
		
		int[][] matrix3 = { { 3, 2, 1, 7 },
				   { 9, 11, 5, 4 },
				   { 6, 0, 13, 17 },
				   { 7, 21, 14, 15 },
				   { 7, 21, 14, 15 }};
		
		int m = matrix3[0].length;
		int n = matrix3.length;
		int start=0;
		int end = m*n-1;  //total 20 so it's 0 to 19
		int mid = (start + end)/2;
		int midx = mid/n;
		int midy = mid%n;
		//int q = 
		/*System.out.println("m:"+m);
		System.out.println("n:"+n);
		System.out.println("end:"+end);
		System.out.println("mid:"+mid);
		System.out.println("midx:"+midx);
		System.out.println("midy:"+midy);
		*/
		
		int[][] cherryPicking = { { 0, 1, -1 },
				   				{ 1, 0, -1},
				   				{ 1, 1, 1 },
				    };
		
		int[][] cherryPicking1 = { { 1, 1, -1 },
   				                   { 1, -1, 1},
   				                   { -1, 1, 1 },
                                 };
		
		int[][] cherryPicking2 = { { 1, 2, 3 },
                   				   { 4, 5, 6 },                   
              					 };
		
		
		int[][] cherryPicking3 = { { 1, 2, 3 },
				                   { 4, 5, 6 },         
				                   { 7, 8, 9 },         
				                   { 10, 11, 12},         
				 };
		
		int sum=0;
		
		for(int i=0;i<cherryPicking.length;i++) {
			for(int j=0;j<cherryPicking[i].length;j++) {
				//System.out.print(": "+i+" "+j);
				if(cherryPicking[i][j]==-1) {
					break;
				} else {
					sum+=cherryPicking[i][j];
				}
			}
		//	System.out.println("");
		}

	///	System.out.println("sum:"+sum);
		
		
		int pathsum=0;
		
//		for(int i=0;i<cherryPicking2.length;i++) {
//			for(int j=0;j<cherryPicking2[i].length;j++) {
//			}
//			System.out.println("");
//		}

		System.out.println("cherryPicking3:m:"+cherryPicking3.length);
		System.out.println("cherryPicking3:n:"+cherryPicking3[0].length);
		 m=cherryPicking3.length; //4
		 n=cherryPicking3[0].length;//3
		 
		 traverse(cherryPicking3,0,0);
		 
		 
	}

	public static void traverse(int[][] cherryPicking3, int i, int j){
		
		int m=cherryPicking3.length; //4
		int n=cherryPicking3[0].length;//3
		
		if(i==m-1 && j==n-1) {
			System.out.print(" "+cherryPicking3[i][j] + ", ");
			return;
		}
		
		if(j<m-1 ) {
			traverse(cherryPicking3,i,j+1);
		}
		else if(i<n-1) {
			traverse(cherryPicking3,i+1,0);
		}
	}
	
}
