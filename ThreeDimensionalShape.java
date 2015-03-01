

// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public abstract class ThreeDimensionalShape extends Shape {

	protected double vol; // Every three dimensional shape has a volume
	
	public ThreeDimensionalShape(String s) {
		super(s);
	}

	public double getVol(){
		return vol;
	}
	@Override
	public String getInformation() { // Here we give meaning to the abstract method.
		return information = String.format("Shape: %s\nArea: %.2f\nVolume : %.2f", getShapeType(), getArea(), getVol());

	}
	
}
