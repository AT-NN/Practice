package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverClass {

	public static void main(String[] args) {
		List<Rectangle> rectangles = new ArrayList<>();
		rectangles.add(new Rectangle(1,2));
		rectangles.add(new Rectangle(2,2));
		rectangles.add(new Rectangle(1,3));
		rectangles.add(new Rectangle(1,4));
		rectangles.add(new Rectangle(2,3));
		rectangles.add(new Rectangle(2,4));
		rectangles.add(new Rectangle(2,5));
		rectangles.add(new Rectangle(3,3));
		rectangles.add(new Rectangle(20,10));
		rectangles.add(new Rectangle(15,15));
		rectangles.add(new Rectangle(1,1));
		
		Collections.sort(rectangles, new AreaComparator());
		System.out.printf("List sorted by area:%n%s%n", rectangles);
		
		Collections.sort(rectangles);
		System.out.printf("List sorted by perimeter:%n%s%n", rectangles);
	}

}
