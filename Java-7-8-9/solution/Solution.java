package com.solution;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    
       double size = arr.size();
       List<Integer> posetive = new ArrayList<Integer>();
       List<Integer> negative = new ArrayList<Integer>();
       List<Integer> zero = new ArrayList<Integer>();


        
        for(Integer I:arr) {
            if(I > 0) {
                posetive.add(I);
            } else if (I<0) {
                negative.add(I);

            } else if (I==0) {
                zero.add(I);

            }
        }
        
        Double f1 =  Double.valueOf(posetive.size()/size);
        Double f2 =  Double.valueOf(negative.size()/size);
        Double f3 =  Double.valueOf(zero.size()/size);
        
        double test  = posetive.size()/size;
        System.out.println(test);

        
        System.out.println(String.format("%.6f", f1.floatValue()));
        System.out.println(String.format("%.6f", f2.floatValue()));
        System.out.println(String.format("%.6f", f3.floatValue()));
  

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim()); 
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
    	
    	List<Integer> arr = new ArrayList<Integer>();
    	arr.add(1);arr.add(1);arr.add(0);arr.add(-1);arr.add(-1);
    	

        Result.plusMinus(arr);

       // bufferedReader.close();
    }
}
