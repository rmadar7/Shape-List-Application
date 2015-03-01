// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project

public final class Paralellogram extends TwoDimensionalShape {

	protected double side1, base, height;// An instance variable for each required component of area/circumference
	
	public Paralellogram(double s1, double b, double h, String st){ // Sets attributes for the shape reference
		super(st);
		setSide1(s1);
		setSide2(b);
		setHeight(h);
		setArea(b,h);
		setCirc(b,s1);
	}
	
	public void setSide1(double s1){
		side1 = s1;
	}
	public double getSide1(){
		return side1;
	}
	public void setSide2(double s2){
		base = s2;
	}
	public double getSide2(){
		return base;
	}
	public void setHeight(double h){
		height = h;
	}
	public double getHeight(){
		return height;
	}
	public void setArea(double b, double h){
		area = b*h;
	}
	public void setCirc(double b, double s1){
		circ = 2*(b+s1);
	}

}
