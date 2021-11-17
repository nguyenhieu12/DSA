import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points) {
        if(points == null)
            throw new IllegalArgumentException("Illegal");
        for(int i = 0;i < points.length;i++) {
            for(int j = 0;j < points.length;j++) {
                if(points[i] == null || points[j] == null)
                    throw new IllegalArgumentException("Illegal");
            }
        }

        Point[] curPoints = new Point[points.length];
        for(int i = 0;i < points.length;i++)
            curPoints[i] = points[i];

        Arrays.sort(curPoints);
        for(int i = 0;i < curPoints.length;i++) {
            for(int j = 0;j < curPoints.length;j++) {
                if(i != j && points[i].compareTo(points[j]) == 0)
                    throw new IllegalArgumentException("Illegal");
            }
        }

        lineSegments = new LineSegment[1];
        ArrayList<Point> arr = new ArrayList<Point>();
        ArrayList<LineSegment> lines = new ArrayList<LineSegment>();

        for(int i = 0;i < curPoints.length;i++) {
            Arrays.sort(curPoints, curPoints[i].slopeOrder());
            int j = 0;
            double curSlope = curPoints[i].slopeTo(curPoints[j]);
            for(;j < curPoints.length;j++) {
                if(curPoints[i].slopeTo(curPoints[j]) == curSlope) {
                    arr.add(curPoints[j]);
                }
            }
            if(arr.size() >= 3 && curPoints[i].compareTo(arr.get(arr.size()-1)) < 0) {
                lines.add(new LineSegment(curPoints[i], arr.get(arr.size() - 1)));
            }
            arr.clear();
        }
        lineSegments = lines.toArray(new LineSegment[0]);
    }

//    private void resize(int capacity) {
//        LineSegment[] tmp = new LineSegment[capacity];
//        for(int i = 0;i < countLines;i++)
//            tmp[i] = lineSegments[i];
//        lineSegments = tmp;
//    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return lineSegments;
    }

    public static void main(String[] args) {

    }
}
