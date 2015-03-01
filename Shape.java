// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public abstract class Shape {
	protected double area; // We initialize area here because every shape has either area or surface area
	protected String shapeType; // I kept asking myself if I should create a shapeType string, I went back and forth as to whether or not
								//   I needed it, I decided to keep it because it was a simple addition to the code and I could just call 
								//   getShapeType() to get a string of what the shape is. It was easy for when I call displayInformation()
	protected String information;
	public Shape(String s){
		setShapeType(s); // Every shape hsa a type
	}
	
	public String getShapeType(){
		return shapeType;
	}
	public void setShapeType(String s){
		shapeType = s;
	}
	
	public double getArea(){
		return area;
	}
	
	public abstract String getInformation(); // The information in this method only changes in twoDimensional and threeDimensional
	
}
