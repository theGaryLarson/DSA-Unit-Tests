import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    
    @Test
    void slopeTo() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        Point d = new Point(-1, -1);
        Point e = new Point(1, -1);
        Point f = new Point(3, 6);
        Point g = new Point(3, -6);
        Point h = new Point(3, 1);
        Point i = new Point(3, -1);
        
        assertEquals(Double.NEGATIVE_INFINITY, a.slopeTo(a)); // equal points
        assertEquals(0,a.slopeTo(b)); // horizontal
        assertEquals(Double.POSITIVE_INFINITY, a.slopeTo(c)); // vertical
        assertEquals(1, a.slopeTo(d));
        assertEquals(-1, a.slopeTo(e));
        assertEquals(2, a.slopeTo(f));
        assertEquals(-2, a.slopeTo(g));
        assertEquals(0.333333, a.slopeTo(h), .00001);
        assertEquals(-0.333333, a.slopeTo(i), .00001);
    }
    
    @Test
    void compareTo() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(0, 1);
        
        assertTrue(p1.compareTo(p2) < 0);
        assertEquals(0, p1.compareTo(p3));
        assertTrue(p1.compareTo(p4) > 0);
    }
    
    @Test
    public void testSlopeOrder() {
        ArrayList<Point> points = new ArrayList<>();
        Point origin = new Point(0, 0);
        points.add(origin);
        Comparator<Point> comparator = origin.slopeOrder();
        
        Point p1 = new Point(2, 4);  //  m = 4/2 -> 2/1 relative to origin
        points.add(p1);
        Point p2 = new Point(1, 3);  // m = 3/1 relative to origin
        points.add(p2);
        Point p3 = new Point(1, 2);  // m = 2/1 relative to origin
        points.add(p3);
        assertEquals(-1,comparator.compare(p1, p2));
        assertEquals(1,comparator.compare(p2, p1));
        assertEquals(0,comparator.compare(p3, p1));
        // question: What is the slope that is going to print out?
        System.out.println(origin.slopeTo(origin));  // HINT: degenerate line (between point and itself)
        assertEquals(0,comparator.compare(origin, origin));
        
        // Assert that the slope to a point with the same coordinates as the reference point is negative infinity
        // meaning that no matter the slope created with another point the slope with itself is always going to be less
        // slope of origin relative to origin is negative infinity
        // slope of p5 relative to origin is positive 0
        // Question: In the example above which slope comes first in slope order? negative infinity or positive 0?
        Point p5 = new Point(-1, 0);
        assertEquals(-1, comparator.compare(origin, p5));
        points.add(p5);
        
        
        // Assert that the slope between two points with the same y-coordinate is positive zero
        // slope of p10 relative origin is positive zero
        // slope of p22 relative to origin is 1
        Point p10 = new Point(1, 0); // 0/1 is positive zero
        Point p22 = new Point(2, 2); // 2/2 is one
        assertEquals(1, comparator.compare(p22, p10));
        points.add(p10);
        points.add(p22);
        
        // Assert that the slope between two points with the same x-coordinate is positive infinity
        Point p12 = new Point(1, 2); // m = 2/1
        Point p13= new Point(1, 3);  // m = 3/1
        assertEquals(-1, comparator.compare(p12, p13));
        assertThrows(NullPointerException.class, () -> origin.slopeOrder().compare(null, p13));
        assertThrows(NullPointerException.class, () -> origin.slopeOrder().compare(p13, null));
    
    
        Point p123 = new Point(0, 0);
        points.add(p123);
        Point newRelativePoint = new Point(2, 2);
        points.add(newRelativePoint);
        
        
        points.sort(origin.slopeOrder());
        System.out.println("Relative to origin (0, 0)");
        System.out.println(points);
        points.sort(newRelativePoint.slopeOrder());
        System.out.println("Relative to new relative point (2, 2)");
        System.out.println(points);
        
        // note:
    }
}
