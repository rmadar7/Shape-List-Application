// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project

public final class Circle extends TwoDimensionalShape {

	protected double radius; // An instance variable for each required component of area/circumference
	
	public Circle(double r, String s) { // Creates a circle reference attribute
		super(s);
		setRadius(r);
		
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double r){ // Will calculate radius as well as circumference and area
		radius = r;
		circ = 2* Math.PI * radius;
		area = Math.PI * radius * radius;
	}
	
}
