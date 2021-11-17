import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if(that.x - this.x == 0 && that.y - this.y == 0)
            return Double.NEGATIVE_INFINITY;
        else if(that.x - this.x == 0)
            return Double.POSITIVE_INFINITY;
        else if (that.y - this.y == 0)
            return +0.0;
        else return 1.0*(that.y - this.y)/(that.x - this.x);
    }

    public int compareTo(Point that) {
        if(this.x == that.x && this.y == that.y)
            return 0;
        else if(this.y < that.y || (this.y == that.y && this.x < that.x))
            return -1;
        else return 1;
    }

    public Comparator<Point> slopeOrder() {
        return new SlopeCmp();
    }

    private class SlopeCmp implements Comparator<Point> {


        @Override
        public int compare(Point o1, Point o2) {
            if(Point.this.slopeTo(o1) < Point.this.slopeTo(o2)) {
                return -1;
            } else if(Point.this.slopeTo(o1) > Point.this.slopeTo(o2)) {
                return 1;
            }
            return 0;
        }
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p = new Point(4, 4);
        Point p1 = new Point(5,5);
        System.out.println(p.slopeTo(p1));
    }

}
