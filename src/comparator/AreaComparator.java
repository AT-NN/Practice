package comparator;
import java.util.Comparator;

public class AreaComparator implements Comparator<Rectangle>{
		
  @Override
  public int compare(Rectangle rectangle1,Rectangle rectangle2){
	  double area1 = rectangle1.getArea();
	  double area2 = rectangle2.getArea();
	  int result=0;
	  if (area1<area2) result=-1;
	  if (area1>area2) result=1;
	  return result;
  }

}
