package com.test;

//Java code to demonstrate the
//working of compareTo()
public class CompareToStringClass {
 public static void main(String args[])
 {

     // Initializing Strings
     String str1 = "geeksforgeeks";
     String str2 = new String("geeksforgeeks");
     String str3 = new String("astha");

     // Checking if geeksforgeeks string
     // equates to geeksforgeeks object
     System.out.print(
         "Difference of geeksforgeeks(obj) and geeksforgeeks(str) : ");
     System.out.println(str1.compareTo(str2));

     // Checking if geeksforgeeks string
     // equates to astha object
     System.out.print(
         "Difference of astha(obj) and geeksforgeeks(str) : ");
     System.out.println(str1.compareTo(str3));
 }
}