package com.matrix;

import java.util.Arrays;

/*
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.

The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.

 

Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: 
Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
Team B was ranked second by 2 voters and ranked third by 3 voters.
Team C was ranked second by 3 voters and ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team, and team B is the third.
Example 2:

Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation:
X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position. 
Example 3:

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter, so their votes are used for the ranking.
 * 
 */

public class TwoDTestRank {
	 public static void main(String[] args) {
		 
		 String input[] = new String[2];
		 input[0] = "WXYZ";input[1] = "XYZW";
		 int len = input[0].length(); 
		 
		 int m[][] = new int[26][len+1];
		 
		 
		 System.out.println("len:"+len);
		 
		 for(int i=0;i<26;i++) {
			 m[i][len]=i;
		 }
		 
		 System.out.println("Original:");
		 printArray(m);
		 
		
		 for(String str : input) {
			 for(int i=0;i<len;i++) {
				 char ch = str.charAt(i);
				 m[ch-'A'][i]++; 
				 
			 }
		 }
		 
		 System.out.println("Before Sort:");
		 printArray(m);
		 
		 // remember a technique to sort via row
		 Arrays.sort(m, (a,b) -> {
			 
			 for(int k=0;k<len;k++) {
				 if(a[k]<b[k]) {
					 return 1;
				 } else if(a[k]>b[k]) {
					 return -1;
				 }
			 }
			 
			 return 0;
			 
		 });
		 
		 System.out.println("After Sort:");
		 printArray(m);
		 
		 StringBuilder sb = new StringBuilder();
		 
		 for(int i=0;i<len;i++) {
			 sb.append((char)('A'+ m[i][len]));
		 }
		 
		 
		 System.out.println("result:"+sb.toString());
		 
		 
	 }
	 
	 public static void printArray(int m[][]) {
		 for(int i=0;i<m.length;i++) {
			 for(int j=0;j<m[0].length;j++) {
				 System.out.print(" "+m[i][j]);
			 }
			 System.out.println();
		 }
	 }
}
