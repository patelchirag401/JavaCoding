package com.fibo;

//Java program to find length of a jump
//to reach end avoiding all obstacles
import java.util.*;

public class obstacle {
 static int avoidObstacles(int[] obs)
 {
     // Insert all array elements in a hash table
     // and find the maximum value in the array
     HashSet<Integer> hs = new HashSet<Integer>();
     int max = obs[0];
     for (int i=0; i<obs.length; i++)
     {
         hs.add(obs[i]);
         max = Math.max(max, obs[i]);
     }

     // checking for every possible length which
     // yield us solution
     for (int i = 1; i <= max; i++) {
         int j;
         for (j = i; j <= max; j = j + i) {

             // if there is obstacle, break the loop.
             if (hs.contains(j))
                 break;
         }

         // If above loop did not break
         if (j > max)
             return i;        
     }

     return max+1;
 }

 // Driver Code
 public static void main(String[] args)
 {
     int a[] = new int[] { 5, 3, 6, 7, 9 };
     int b = avoidObstacles(a);
     System.out.println(b);
 }
}