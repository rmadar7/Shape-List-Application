// Coded by: Ryan Madar
// Date: 11/21/2014
// Assignment #4
// Purpose: A program that will identify and create a collection of shapes at the user's will and be able to output information
// 	for all shapes used in the project


public final class Prism extends ThreeDimensionalShape {

	protected double height,baseArea,basePeri;// An instance variable for each required component of area/volume
	
	public Prism(double h,double a,double p, String st){
		super(st);
		setHeight(h);
		setBaseArea(a);
		setBasePeri(p);
		setArea(h,a,p);
		setVol(a,h);
	}
	public void setHeight(double h){
		height = h;
	}
	public double getHeight(){
		return height;
	}
	public void setBaseArea(double a){
		baseArea=a;
	}
	public double getBaseArea(){
		return baseArea;
	}
	public void setBasePeri(double s){
		basePeri = s;
	}
	public double getBasePeri(){
		return basePeri;
	}
	public void setArea(double h, double a, double p){
		area = ((2*a)+(p*h));
	}
	public void setVol(double a, double h){ 
		vol = a*h;
	}

	
}
