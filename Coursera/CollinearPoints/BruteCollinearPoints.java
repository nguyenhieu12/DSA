import java.util.Arrays;

public class BruteCollinearPoints {
    //private Point[] points;
    private LineSegment[] lineSegments;
    private int countLines;

    public BruteCollinearPoints(Point[] points) {
        if(points == null)
            throw new IllegalArgumentException("Illegal");
        for(int i = 0;i < points.length;i++) {
            for(int j = 0;j < points.length;j++) {
                if(points[i] == null || points[j] == null
                        || (i != j && points[i].compareTo(points[j]) == 0))
                    throw new IllegalArgumentException("Illegal");
            }
        }

        Point[] curPoints = new Point[points.length];
        for(int i = 0;i < points.length;i++)
            curPoints[i] = points[i];

        lineSegments = new LineSegment[1];
        countLines = 0;

        Arrays.sort(curPoints);
        for(int m = 0;m < curPoints.length - 3;m++) {
            for (int n = m + 1; n < curPoints.length - 2; n++) {
                for (int p = n + 1; p < curPoints.length - 1; p++) {
                    for (int q = p + 1; q < curPoints.length; q++) {
                        if (curPoints[m].slopeTo(curPoints[n]) == curPoints[n].slopeTo(curPoints[p])
                                && curPoints[n].slopeTo(curPoints[p]) == curPoints[p].slopeTo(curPoints[q])) {
                            if (countLines == lineSegments.length)
                                resize(2 * lineSegments.length);
                            lineSegments[countLines++] = new LineSegment(curPoints[m], curPoints[q]);
                        }
                    }
                }
            }
        }
    }

    private void resize(int capacity) {
        LineSegment[] tmp = new LineSegment[capacity];
        for(int i = 0;i < countLines;i++)
            tmp[i] = lineSegments[i];
        lineSegments = tmp;
    }

    public int numberOfSegments() {
        return countLines;
    }

    public LineSegment[] segments() {
        LineSegment[] result = new LineSegment[countLines];
        for(int i = 0;i < countLines;i++)
            result[i] = lineSegments[i];
        return result;
    }

    public static void main(String[] args) {

    }

}
