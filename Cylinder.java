// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Cylinder extends ThreeDimensionalShape {

	protected double radius,height;// An instance variable for each required component of area/volume
	
	public Cylinder(double r, double h, String s){ // Sets radius/height for the cylinder and allows for us to set area and vol
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
		area = ((2*Math.PI*r)*(r+h));
	}
	public void setVol(double r, double h){
		vol = (Math.PI * h * r * r);
	}

}
