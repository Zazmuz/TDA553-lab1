package src;


public class Vector2D {

    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("Vector2D(%s, %s)", x, y);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public void add(Vector2D other) {
        x += other.x;
        y += other.y;
    }

    public void sub(Vector2D other) {
        x -= other.x;
        y -= other.y;
    }

    public void mul(int val) {
        x *= val;
        y *= val;
    }

    public void mul(double val) {
        x *= val;
        y *= val;
    }

    public double distanceTo(Vector2D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

}
