
public final class Sphere extends ThreeDimensionalShape {
	
	protected double radius; // An instance variable for each required component of area/volume
	
	public Sphere(double r, String s) {
		super(s);
		setRadius(r);
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double r){
		radius = r;
		vol = (Math.pow(r, 3)*Math.PI*4)/3;
		area = 4 * Math.PI * r * r;
	}

}
