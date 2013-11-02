package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class GenerationModel {
	
	/* Distribution Types */
	public static final int UNIFORM = 1;
	public static final int SKEWED_NEGATIVELY = 2;
	public static final int SKEWED_POSITIVELY = 3;
	public static final int BIMODAL = 4;
	public static final int NORMAL = 5;
	public static final int RANDOM = 6;
	
	/* Generate Population */
	public static ArrayList<Pair> generatePopulation(int lowerBound, int upperBound, int populationSize, int distributionType) {
		ArrayList<Pair> listPopulation = null;
		TreeMap<Integer, Integer> treePopulation = null;
		
		if (populationSize > 0 && upperBound - lowerBound + 1 > 0) {
			switch (distributionType) {
				case UNIFORM:			treePopulation = generateUniformPopulation(lowerBound, upperBound, populationSize);
										break;
				case SKEWED_NEGATIVELY:	treePopulation = generateSkewedNegativelyPopulation(lowerBound, upperBound, populationSize);
										break;
				case SKEWED_POSITIVELY:	treePopulation = generateSkewedPositivelyPopulation(lowerBound, upperBound, populationSize);
										break;
				case BIMODAL:			treePopulation = generateBimodalPopulation(lowerBound, upperBound, populationSize);
										break;
				case NORMAL:			treePopulation = generateNormalPopulation(lowerBound, upperBound, populationSize);
										break;
				case RANDOM:			treePopulation = generateRandomPopulation(lowerBound, upperBound, populationSize);
										break;
			}
		}
		
		if (treePopulation != null) {
			listPopulation = new ArrayList<>();
			
			for (Map.Entry<Integer, Integer> entry : treePopulation.entrySet()) {
				Pair pair = new Pair(entry.getKey(), entry.getValue());
				listPopulation.add(pair);
			}
		}
		
		return listPopulation;
	}
	
	/* Generate Population: UNIFORM */
	private static TreeMap<Integer, Integer> generateUniformPopulation(int lowerBound, int upperBound, int populationSize) {
		TreeMap<Integer, Integer> population = new TreeMap<>();
		
		int boundarySize = upperBound - lowerBound + 1;
		int addQuotient = populationSize / boundarySize;
		int addRemainder = populationSize % boundarySize;
		int skipQuotient = boundarySize / populationSize;
		
		Random random = new Random();
		
		if (skipQuotient <= 0) {
			skipQuotient = 1;
		}
		
		for (int i = lowerBound; i <= upperBound; i += skipQuotient) {
			if (addRemainder > 0) {
				population.put(i, addQuotient + 1);
				addRemainder--;
				i += (addRemainder > 0 ? random.nextInt(1) : 0);
			}
			else if (addQuotient > 0) {
				population.put(i, addQuotient);
			}
		}
		
		return population;
	}
	
	/* Generate Population: SKEWED_NEGATIVELY */
	private static TreeMap<Integer, Integer> generateSkewedNegativelyPopulation(int lowerBound, int upperBound, int populationSize) {
		TreeMap<Integer, Integer> population = new TreeMap<>();
		
		int boundsThird = (upperBound - lowerBound) / 3;
		int i = lowerBound + boundsThird;
		int j = 0;
		boolean hitZero = false;
		
		while (populationSize > 0) {
			int currentY = 1;
			if (hitZero || i > upperBound) {
				i = lowerBound + boundsThird - j;
				if (i > lowerBound) {
					j++;
				}
				hitZero = false;
			}
			
			try {
				currentY += population.get(i);
			}
			catch (Exception ex) {
				if (i >= boundsThird + lowerBound) {
					hitZero = true;
				}
			}
			
			population.put(i, currentY);
			
			populationSize--;
			i++;
		}
		
		return population;
	}
	
	/* Generate Population: SKEWED_POSITIVELY */
	private static TreeMap<Integer, Integer> generateSkewedPositivelyPopulation(int lowerBound, int upperBound, int populationSize) {
		TreeMap<Integer, Integer> population = new TreeMap<>();

		int boundsThird = (upperBound - lowerBound) / 3;
		int i = upperBound - boundsThird;
		int j = 0;
		boolean hitZero = false;
		
		while (populationSize > 0) {
			int currentY = 1;
			
			if (hitZero || i > upperBound) {
				i = upperBound - boundsThird + j;
				if (i < upperBound) {
					j++;
				}
				hitZero = false;
			}
			
			try {
				currentY += population.get(i);
			}
			catch (Exception ex) {
				if (i <= upperBound - boundsThird) {
					hitZero = true;
				}
			}
			
			population.put(i, currentY);
			
			populationSize--;
			i--;
		}
		
		return population;
	}
	
	/* Generate Population: BIMODAL */
	private static TreeMap<Integer, Integer> generateBimodalPopulation(int lowerBound, int upperBound, int populationSize) {
		TreeMap<Integer, Integer> population = new TreeMap<>();
		
		int boundsFourth = (upperBound - lowerBound) / 4;
		int i = lowerBound + boundsFourth;
		int j = 0;
		int k = 0;
		boolean onUpper = false;
		boolean hitZero = false;
		
		while (populationSize > 0) {
			int currentY = 1;
			
			try {
				currentY += population.get(i);
			}
			catch (Exception ex) {
				if (onUpper) {
					if (i <= upperBound - boundsFourth) {
						hitZero = true;
					}
				}
			}
			
			population.put(i, currentY);
			
			populationSize--;
			
			onUpper = !onUpper;
			
			if (onUpper) {
				i = upperBound - boundsFourth + j - k;
			}
			else {
				if (hitZero) {
					if (i + k < upperBound) {
						j++;
					}
					k = 0;
					hitZero = false;
				}
				else {
					k++;
					if (lowerBound + boundsFourth - j + k > upperBound) {
						k = 0;
					}
				}
				
				i = lowerBound + boundsFourth - j + k;
			}
		}
		
		return population;
	}
	
	/* Generate Population: NORMAL */
	private static TreeMap<Integer, Integer> generateNormalPopulation(int lowerBound, int upperBound, int populationSize) {
		TreeMap<Integer, Integer> population = new TreeMap<>();
		
		int boundsHalf = (upperBound + lowerBound) / 2;
		int i = boundsHalf;
		int j = 0;
		boolean hitZero = false;
		
		while (populationSize > 0) {
			int currentY = 1;
			
			if (hitZero || i > upperBound) {
				i = boundsHalf - j;
				if (i > lowerBound) {
					j++;
				}
				hitZero = false;
			}
			
			try {
				currentY += population.get(i);
			}
			catch (Exception ex) {
				if (i >= boundsHalf) {
					hitZero = true;
				}
			}
			
			population.put(i, currentY);
			
			populationSize--;
			i++;
		}
		
		return population;
	}
	
	/* Generate Population: RANDOM */
	private static TreeMap<Integer, Integer> generateRandomPopulation(int lowerBound, int upperBound, int populationSize) {
		TreeMap<Integer, Integer> population = new TreeMap<>();
		Random random = new Random();
		int boundarySize = upperBound - lowerBound + 1;
		
		while (populationSize > 0) {
			int randomX = lowerBound;
			int randomY = random.nextInt(populationSize + 1);
			int currentY = 0;
			
			if (boundarySize > 0) {
				randomX += random.nextInt(boundarySize);
			}
			
			try {
				currentY = population.get(randomX);
			}
			catch (Exception ex) {}
			
			if (randomY > 0) {
				population.put(randomX, randomY + currentY);
			}
			
			populationSize -= randomY;
		}
		
		return population;
	}
	
}
