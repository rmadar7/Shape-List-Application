

// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public abstract class TwoDimensionalShape extends Shape {
	protected double circ; // Every two dimensional shape has circumference

	public TwoDimensionalShape(String s) {
		super(s);
	}

	
	public double getCirc(){
		return circ;
	}
	@Override
	public String getInformation() { // We give meaning to the abstract method
		return information = String.format("Shape: %s\nArea: %.2f\nCircumference : %.2f", getShapeType(), getArea(), getCirc());
	}
}
