// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Cone extends ThreeDimensionalShape {
	
	protected double radius,height;// An instance variable for each required component of area/volume
	
	public Cone(double r, double h, String s){ // Sets a radius and height for the object reference then calculates area and volume
		super(s);
		setRadius(r);
		setHeight(h);
		setArea(r,h);
		setVol(r,h);
	}
	
	public void setRadius(double r){
		radius = r;
	}
	public double getRadius(){
		return radius;
	}
	public void setHeight(double h){
		height = h;
	}
	public double getHeight(){
		return height;
	}
	public void setArea(double r, double h){
		double temp = ((r*r)+(h*h));
		area = ((Math.PI * r * r) + (Math.PI * r * Math.sqrt(temp))); // I used temp to simplify the equation
	}
	public void setVol(double r, double h){
		vol = (Math.pow(r, 2) * Math.PI * h)/3;
	}
	
}
