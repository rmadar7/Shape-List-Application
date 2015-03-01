// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Cube extends ThreeDimensionalShape {
	protected double side;// An instance variable for each required component of area/volume
	
	public Cube(double s, String st){
		super(st); // Sets the sides for the cube reference
		setSide(s);
	}
	
	public double getSide(){
		return side;
	}
	
	public void setSide(double s){
		side = s;
		vol = side * side * side;
		area = 6 * side * side;
		
	}

}
