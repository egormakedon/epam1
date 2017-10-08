import by.makedon.epam1.dot.Dot;
import by.makedon.epam1.triangle.Triangle;
import by.makedon.epam1.triangle.TriangleAction;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCalcParam {
    private Triangle triangle;
    private TriangleAction triangleAction;
    private Dot dotA;
    private Dot dotB;
    private Dot dotC;

    @BeforeTest
    public void set() {
        triangle = new Triangle();
        triangleAction = new TriangleAction();
        dotA = new Dot();
        dotB = new Dot();
        dotC = new Dot();
    }

    @AfterTest
    public void destr() {
        triangle = null;
        triangleAction = null;
        dotA = null;
        dotB = null;
        dotC = null;
    }

    @Test
    public void getPerimeterTest() {
        dotA.set(2, 3);
        dotB.set(3, 3);
        dotC.set(5, 5);
        triangle.setTrianlge(dotA, dotB, dotC);
        double expected = 1 + Math.sqrt(8) + Math.sqrt(13);
        double perimeter = triangleAction.getPerimeter(triangle);
        Assert.assertEquals(expected, perimeter);
    }

    @Test
    public void getPerimeterWrongTest() {
        dotA.set(4, 4);
        dotB.set(3, 3);
        dotC.set(5, 5);
        triangle.setTrianlge(dotA, dotB, dotC);
        double expected = 1 + Math.sqrt(8) + Math.sqrt(13);
        double perimeter = triangleAction.getPerimeter(triangle);
        Assert.assertNotEquals(expected, perimeter);
    }

    @Test
    public void getAreaTest() {
        dotA.set(2, 3);
        dotB.set(3, 3);
        dotC.set(5, 5);
        triangle.setTrianlge(dotA, dotB, dotC);
        double perimeter = triangleAction.getPerimeter(triangle);
        double expected = Math.sqrt(perimeter * (1 + Math.sqrt(8)) * (Math.sqrt(8) + Math.sqrt(13)) * (1 + Math.sqrt(13)));
        double area = triangleAction.getArea(triangle);
        Assert.assertEquals(expected, area);
    }

    @Test
    public void getAreaWrongTest() {
        dotA.set(3, 3);
        dotB.set(4, 4);
        dotC.set(10, 10);
        triangle.setTrianlge(dotA, dotB, dotC);
        double perimeter = triangleAction.getPerimeter(triangle);
        double expected = Math.sqrt(perimeter * (1 + Math.sqrt(8)) * (Math.sqrt(8) + Math.sqrt(13)) * (1 + Math.sqrt(13)));
        double area = triangleAction.getArea(triangle);
        Assert.assertNotEquals(expected, area);
    }

    @Test
    public void triangleIsRectangleTest() {
        dotA.set(0, 0);
        dotB.set(0, 5);
        dotC.set(5, 0);
        triangle.setTrianlge(dotA, dotB, dotC);
        Assert.assertTrue(triangleAction.isTriangleRectangle(triangle));
    }

    @Test
    public void triangleNotRectTest() {
        dotA.set(1, 1);
        dotB.set(2, 2);
        dotC.set(3, 1.5);
        triangle.setTrianlge(dotA, dotB, dotC);
        Assert.assertFalse(triangleAction.isTriangleRectangle(triangle));
    }

    @Test
    public void dotsComposeTriangleTest() {
        dotA.set(1, 1);
        dotB.set(2, 2);
        dotC.set(3, 1.5);
        Assert.assertTrue(triangleAction.isDotsComposeTriangle(dotA, dotB, dotC));
    }

    @Test
    public void dotsDontComposeTriangleTest() {
        dotA.set(1, 1);
        dotB.set(2, 2);
        dotC.set(3, 3);
        Assert.assertFalse(triangleAction.isDotsComposeTriangle(dotA, dotB, dotC));
    }
}
