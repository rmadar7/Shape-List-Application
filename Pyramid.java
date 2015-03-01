// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Pyramid extends ThreeDimensionalShape {

	protected double base,height;// An instance variable for each required component of area/volume
	public Pyramid(double b, double h, String s){
		super(s);
		setBase(b);
		setHeight(h);
		setVol(b,h);
		setArea(b,h);
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
	
	public void setVol(double b, double h){
		vol = (b * b * (h/3));
	}
	public void setArea(double b, double h){
		area = ( (b*b) + (2*b*Math.sqrt(((b*b)/4) + (h*h))) );
	}
	
}
