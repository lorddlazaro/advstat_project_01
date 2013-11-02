package model;

public class Pair {
	
	/* Data Variables */
	private double x;
	private double y;
	
	/** Constructors **/
	
	public Pair() {
		x = 0;
		y = 0;
	}
	
	public Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/** Getters and Setters **/
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
