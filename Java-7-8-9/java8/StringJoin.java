package java8;

import java.util.Arrays;

public class StringJoin {
	 public static void main(String args[]){
		 
		 String[] typesOfCards = {"Credit card", "Debit card", "Master Card"};
		 String cards = String.join(",", typesOfCards );
		 System.out.println("cards: " + cards);
		 
		 String banks = String.join("|", "Citibank", "Bank of America", "Chase");
		 System.out.println("banks: " + banks);

		 
		 // Joining arbitrary number of String
		    String combined = String.join(" and ", "LinkedIn", "Microsoft");
		    System.out.println("string joined by and : " + combined);

		    // joining elements from a list of String
		    String joined = String
		        .join("|", Arrays.asList("Java", "Android", "Oracle"));
		    System.out.println("String joined by pipe from list : " + joined);

		    // joining String elements of an array
		    String[] biggies = { "Apple", "Google", "Amazon" };
		    String fromArray = String.join(",", biggies);
		    System.out.println("String joined by comma from array: " + fromArray);


	 }
}
