package com.tree1;

public class MinimumFallingPathSum {
	
	  public static int minFallingPathSum(int[][] matrix) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;

	        // Initialize a dp array to store minimum falling path sum
	        int[][] dp = new int[rows][cols];

	        // Copy the first row of the matrix to the dp array
	        for (int i = 0; i < cols; i++) {
	            dp[0][i] = matrix[0][i];
	        }

	        // Start from the second row and calculate the minimum falling path sum
	        for (int i = 1; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                // Calculate the minimum falling path sum for each element in the current row
	                dp[i][j] = matrix[i][j] +
	                		Math.min(dp[i - 1][j], 
	                				Math.min(dp[i - 1][Math.max(0, j - 1)], dp[i - 1][Math.min(cols - 1, j + 1)]));
	            }
	        }

	        // Find the minimum falling path sum in the last row
	        int minSum = Integer.MAX_VALUE;
	        for (int i = 0; i < cols; i++) {
	            minSum = Math.min(minSum, dp[rows - 1][i]);
	        }

	        return minSum;
	    }

	    public static void main(String[] args) {
	        int[][] matrix = {
	            {2, 1, 3},
	            {6, 5, 4},
	            {7, 8, 9}
	        };

	        int result = minFallingPathSum(matrix);
	        System.out.println("Minimum Falling Path Sum: " + result);
	    }

}
