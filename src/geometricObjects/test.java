package geometricObjects;

public class test {
    public static void main(String[] args) {
        Circle circle = new Circle (5);
        ResizableCircle resizableCircle = new ResizableCircle (5);

        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(resizableCircle.getPerimeter());
        System.out.println(resizableCircle.getArea());
        resizableCircle.resize(100);
        System.out.println(resizableCircle.getPerimeter());
        System.out.println(resizableCircle.getArea());
        resizableCircle.resize(-50);
        System.out.println(resizableCircle.getPerimeter());
        System.out.println(resizableCircle.getArea());
    }
}
