package com.sort;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Consumer;

public class StockFeedConsumerService {
	public void process(List<Stock> stockList, Consumer<TopOccurrence> stockConsumer) {
		Set<Stock> uniqueStocks = new HashSet<>();
		uniqueStocks.addAll(stockList);
		System.out.println("uniqueStocks = " + uniqueStocks);
		TopOccurrence topOccurrence = new TopOccurrence(2);
		uniqueStocks.forEach(stock -> topOccurrence.add(stock));
		stockConsumer.accept(topOccurrence);
	}

	public static void main(String[] args) {
		PricingService pricingService = new PricingService();
		StockFeedConsumerService consumerService = new StockFeedConsumerService();
		consumerService.process(pricingService.getPriceFeed(), topOccurrence -> System.out.println(topOccurrence));
	}

	static class TopOccurrence {
		private final PriorityQueue<Stock> minHeap;
		private final int maxSize;

		public TopOccurrence(int maxSize) {
			this.maxSize = maxSize;
			this.minHeap = new PriorityQueue<>(Comparator.comparing(Stock::getPrice));
// This constructs a min heap (when order of elements is natural i.e. ascending order).
// We are using Natural order for integers (wc.count)
// In order to create a max-heap, we just need to provide reversed comparator i.e. that sorts in descending order,
//as shown below
// this.minHeap = new PriorityQueue<WordCount>(Comparator.comparingInt((WordCount wc) -> wc.count).
//reversed());
		}

		public void add(Stock data) {
			if (minHeap.size() < maxSize) { // size() is Big O(1)
				minHeap.offer(data); // Big O(log(k)) where k is the number of top occurrences required
			} else if (minHeap.peek().getPrice() < data.getPrice()) { // peek() is Big O(1)
				minHeap.poll(); // Big O(log(k))
				minHeap.offer(data); // Big O(log(k))
			}
		}

		@Override

		public String toString() {
			return "TopOccurrence{" + "minHeap=" + minHeap + ", maxSize=" + maxSize + '}';
		}
	}
}
