package points; 

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Point2D point2D_1 = new Point2D ();
        Point3D point3D_1 = new Point3D ();
        Point2D point2D_2 = new Point2D (1,2);
        Point3D point3D_2 = new Point3D (11,12,13);

        System.out.println(point2D_1);
        System.out.println(point3D_1);
        System.out.println(point2D_2);
        System.out.println(point3D_2);
        point2D_2.setXY(1.1f,2.1f);
        System.out.println(point2D_2 + "  ==  " + Arrays.toString(point2D_2.getXY()));
        point3D_2.setXYZ(11.1f,12.1f, 13.1f);
        System.out.println(point3D_2 + "  ==  " + Arrays.toString(point3D_2.getXYZ()));
    }
}
