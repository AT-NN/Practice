package comparator;

public class Rectangle extends Shape implements Comparable<Rectangle>{
	protected double width;
	protected double length;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}
	
	public Rectangle(double width, double length, String color, boolean filled) {
		super(color,filled);
		setWidth(width); 
		setLength(length);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	@Override
	public double getArea(){
		return width*length;
	}
	
	@Override
	public double getPerimeter(){
		return 2*(width+length);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", length=" + length + ", color=" + color + ", filled=" + filled + ", perimeter=" + getPerimeter() + ", area=" + getArea() + "]" + "\n";
	}

	@Override
	public int compareTo(Rectangle rectangle) {
		double perimeter1 = getPerimeter();
		double perimeter2 = rectangle.getPerimeter();
		int result=0;
		if (perimeter1<perimeter2) result=-1;
		if (perimeter1>perimeter2) result=1;
		return result;
	}
}
