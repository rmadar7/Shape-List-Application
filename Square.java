// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Square extends TwoDimensionalShape {

	protected double side; // An instance variable for each required component of area/circumference
	
	public Square(double s, String st){
		super(st);
		setSide(s);
	}
	
	public double getSide(){
		return side;
	}
	
	public void setSide(double s){
		side = s;
		circ = side * 4;
		area = side * side;
		
	}

}
