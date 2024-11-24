package com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
* Created by Munish on 4/19/2015.
*/
public class PricingService {
	Random rand = new Random(System.currentTimeMillis());

	/**
	 * Generates & Returns a Random Feed of Stock Information with variant Price
	 * information.
	 * 
	 * @return
	 */
	public List<Stock> getPriceFeed() {
		int[] instrTics = { 100, 1001, 1002, 1003 };
		String[] names = { "Reliance", "TCS", "Airtel", "BSNL" };
		Random randomStraem = new Random(System.currentTimeMillis());
		double[] prices = randomStraem.doubles(100.0, 200.0).limit(50).toArray();
		List<Stock> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			final int randInt = randInt(0, instrTics.length - 1);
			results.add(StockBuilder.aStock().withInstrTic(instrTics[randInt])
					.withPrice(prices[randInt(0, prices.length - 1)]).withName(names[randInt]).build());
		}
		return results;
	}

	public int randInt(int min, int max) {
		return rand.nextInt((max - min) + 1) + min;
	}
}

 class Stock {
	private String name;
	private int instrTic;
	private double price;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Stock stock = (Stock) o;
		return instrTic == stock.instrTic;
	}

	@Override
	public int hashCode() {
		return instrTic;
	}
//getters and setters not shown

	public String toString() {
		return "Stock{" + "price=" + price + ", instrTic=" + instrTic + ", name='" + name + '\'' + '}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInstrTic() {
		return instrTic;
	}

	public void setInstrTic(int instrTic) {
		this.instrTic = instrTic;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}