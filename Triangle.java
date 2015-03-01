// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Triangle extends TwoDimensionalShape {

	protected double side1, side2, base, height; // An instance variable for each required component of area/circumference
	
	public Triangle(double b, double h, double s1, double s2, String st){
		super(st);
		setSide1(s1);
		setSide2(s2);
		setBase(b);
		setHeight(h);
		setCirc(b,s1,s2);
		setArea(b,h);
	}
	
	public void setSide1(double s1){
		side1 = s1;
	}
	public double getSide1(){
		return side1;
	}
	public void setSide2(double s2){
		side2 = s2;
	}
	public double getSide2(){
		return side2;
	}
	public void setBase(double b){
		base = b;
	}
	public double getBase(){
		return base;
	}
	public void setHeight(double h){
		height = h;
	}
	public double getHeight(){
		return height;
	}
	
	public void setCirc(double b, double s1, double s2){
		circ = b+s1+s2;
	}
	public void setArea(double b, double h){
		area = .5*b*h;
	}


	
}
