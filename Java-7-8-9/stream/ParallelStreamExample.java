package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential Stream - Perform operations sequentially
        numbers.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);

        System.out.println("----");
        
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "16");

        
        System.out.println("Parallel threads:----"+Runtime.getRuntime().availableProcessors());
       // System.out.println("Parallel threads:----"+Runtime.getRuntime().());


        // Parallel Stream - Perform operations in parallel
        numbers.parallelStream()	
                .map(n -> n * 2)
                .forEach(System.out::println);
        
        
        MyFunctionalInterface myFunc = () -> {
            // Implementation of the single abstract method
        };
        
        MyFunctionalInterface myfunc2 = () -> {
        	
        };
        
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = numbers1.stream().reduce((a, b) -> a + b);
        
        System.out.println("----"+sum.toString());


    }
    
    
    @FunctionalInterface
    public interface MyFunctionalInterface {
        void myAbstractMethod();
    }

}
