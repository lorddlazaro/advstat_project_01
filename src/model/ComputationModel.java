package model;

import java.util.ArrayList;

public class ComputationModel {
	
	public ComputationModel() {}
	
	public static double mean(ArrayList<Pair> pairs) {
		double mean = 0.0;
		int n = 0;
		
		for (Pair pair : pairs) {
			mean += pair.getX();
			n += pair.getY();
		}
		
		mean = mean / n;
		
		return mean;
	}
	
	public static double variance(ArrayList<Pair> pairs) {
		ArrayList<Pair> squaredPairs = new ArrayList<>(pairs);
		double variance = 0;
		double mean = mean(pairs);
		
		for (Pair pair : squaredPairs) {
			pair.setX(square(pair.getX()));
		}
		
		variance = mean(squaredPairs) - square(mean);
		
		return variance;
	}
	
	private static double square(double x) {
		return x * x;
	}
	
}
