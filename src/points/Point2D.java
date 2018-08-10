package points; 

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setXY(float x,float y) {
        setX(x);
        setY(y);
    }

    public float[] getXY() {
        float coord[] = new float[2];
        coord[0]=getX();
        coord[1]=getY();
        return coord;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}

