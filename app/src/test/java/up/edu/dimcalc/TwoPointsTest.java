package up.edu.dimcalc;

import android.graphics.Point;

import up.edu.dimcalc.TwoPoints;

import up.edu.dimcalc.DimCalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoPointsTest {

    /**
     * when created, getPoint() should show both points at the origin
     */
    @Test
    public void getPoint () throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y, 0);
    }

    /**
     * verify that arbitrary values are properly stored via setPoint()
     */
    @Test
    public void setPoint () throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 5);
        assertEquals(p1.y, -3);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);
    }


    @Test
    public void randomValue () {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(-1);
        testPoints.randomValue(10000);

        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assert (p1.x >= -10 && p1.x <= 10 && p1.y >= -10 && p1.y <= 10);
        assert (p2.x < -10 || p2.x > 10 || p2.y < -10 || p2.y > 10);
    }

    @Test
    public void setOrigin () {

        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(2);
        testPoints.setOrigin(-1);

        testPoints.setOrigin(0);
        testPoints.setOrigin(1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assert (p1.x != 0 || p1.y != 0);

        assert (p2.x != 0 || p2.y != 0);


        testPoints.setOrigin(-100);
        testPoints.setOrigin(10000);

    }

    @Test
    public void copy () {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 5);
        testPoints.randomValue(1);
        testPoints.copy(0, 1);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(p1.x, 5);
        assertEquals(p1.y, 5);
        assertEquals(p2.x, 5);
        assertEquals(p2.y, 5);

        testPoints.copy(0, 0);

    }

    @Test
    public void distance () {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 5);
        testPoints.setPoint(1, 5, 5);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(testPoints.distance(), 0.0, 0.001);

        testPoints.setPoint(0, 0, 0);
        testPoints.setPoint(1, 0, 1);

        assertEquals(testPoints.distance(), 1, 0.001);
    }

    @Test
    public void slope () {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, 5);
        testPoints.setPoint(1, 5, 5);

        assertEquals(testPoints.slope(), 0.0, 0.001);

    }
}