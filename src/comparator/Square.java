package comparator;

public class Square extends Rectangle{

	public Square() {
		super();
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public double getSide(){
		return getLength();
	}
	
	public void setSide(double side){
		super.setWidth(side);
		super.setLength(side);
	}

	public void setWidth(double side) {
		setSide(side);
	}

	public void setLength(double side) {
		setSide(side);
	}

}
