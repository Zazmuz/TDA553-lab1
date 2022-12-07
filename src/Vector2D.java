package src;


public class Vector2D {

    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("Vector2D(%s, %s)", this.x, this.y);
    }

    public double magnitude() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public void add(Vector2D other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void sub(Vector2D other) {
        this.x -= other.x;
        this.y -= other.y;
    }

    public void mul(int val) {
        this.x *= val;
        this.y *= val;
    }

    public void mul(double val) {
        this.x *= val;
        this.y *= val;
    }

    public double distanceTo(Vector2D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

}
