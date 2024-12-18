package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {
	 public static void main(String[] args) throws Exception {

		       List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cac", "dog"));
		       
		       // looping over all elements using Iterable.forEach() method
		       alphabets.forEach(k -> System.out.println(k));
		       
		       // You can even replace lambda expression with method reference
		       // because we are passing the lambda parameter as it is to the
		       // method
		       alphabets.forEach(System.out::println);
		       
		       // you can even do something with lambda parameter e.g. adding a comma
		       alphabets.forEach(s -> System.out.print(s + ","));
		       
		       
		       // There is one more forEach() method on Stream class, which operates
		       // on stream and allows you to use various stream methods e.g. filter()
		       // map() etc
		       
		       alphabets.stream().forEach(System.out::println);
		       
		       // let's now only print elmements which startswith "a"
		       alphabets.stream()
		               .filter(s -> s.startsWith("a"))
		               .forEach(System.out::println);
		       
		       // let's filter out only which has length greater than 2
		       alphabets.stream()
		               .filter(s -> s.length() > 2)
		               .forEach(System.out::println);

		       
		       // now, let's print length of each string using map()
		       alphabets.stream()
		               .mapToInt(s -> s.length())
		               .forEach(System.out::println);
		       
		       // how about calculating sum of length of all string
		      int t =  alphabets.stream()
		               .mapToInt(s -> s.length())
		               .sum();
		      System.out.println("t:"+t);
		    }
}
