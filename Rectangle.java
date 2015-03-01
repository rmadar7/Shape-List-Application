// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Rectangle extends TwoDimensionalShape {

	protected double x,y;// An instance variable for each required component of area/circumference
	
	public Rectangle(double side1, double side2, String s){
		super(s);
		setX(side1);
		setY(side2);
		setCirc(side1,side2);
		setArea(side1,side2);
	}
	public double getX(){
		return x;
	}
	public void setX(double side1){
		x = side1;
	}
	public double getY(){
		return y;
	}
	public void setY(double side2){
		y = side2;
	}
	
	public void setArea(double side1, double side2){
		area = side1*side2;
	}
	public void setCirc(double side1, double side2){
		circ = 2*(side1+side2);
	}

	
}
