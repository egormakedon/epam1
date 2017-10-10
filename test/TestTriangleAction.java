import by.makedon.epam1.action.TriangleAction;
import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.entity.Triangle;
import by.makedon.epam1.exception.WrongInputParamsExc;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTriangleAction {
    private TriangleAction triangleAction;
    @BeforeTest
    public void set() {
        triangleAction = new TriangleAction();
    }

    @AfterTest
    public void destr() {
        triangleAction = null;
    }

    @Test
    public void calculateAreaTest() throws WrongInputParamsExc {
        Triangle triangle = new Triangle(new Dot(0,0), new Dot(0,10), new Dot(20,0));
        double area = triangleAction.calculateArea(triangle);
        double excepted = 100;
        Assert.assertEquals(area, excepted);
    }

    @Test
    public void calculateAreaNotEqTest() throws WrongInputParamsExc {
        Triangle triangle = new Triangle(new Dot(-100,20), new Dot(1000,10), new Dot(20,0));
        double area = triangleAction.calculateArea(triangle);
        double excepted = 100;
        Assert.assertNotEquals(area, excepted);
    }

    @Test (expectedExceptions = WrongInputParamsExc.class)
    public void calculateAreaWrongTriangleTest() throws WrongInputParamsExc {
        Triangle triangle = new Triangle(new Dot(1,1), new Dot(2,2), new Dot(3,3));
    }

    @Test
    public void calculatePerimeterTest() throws WrongInputParamsExc {
        Triangle triangle = new Triangle(new Dot(10, 10), new Dot(1, 5), new Dot(1,0));
        double perimeter = triangleAction.calculatePerimeter(triangle);
        double excepted = 28.74925418806071;
        Assert.assertEquals(excepted, perimeter);
    }

    @Test
    public void calculatePerimeterNotEqTest() throws WrongInputParamsExc {
        Triangle triangle = new Triangle(new Dot(10, 10), new Dot(1, 5), new Dot(1,0));
        double perimeter = triangleAction.calculatePerimeter(triangle);
        double excepted = 250;
        Assert.assertNotEquals(excepted, perimeter);
    }

    @Test (expectedExceptions = WrongInputParamsExc.class)
    public void calculatePerimeterWrongTriangleTest() throws WrongInputParamsExc {
        Triangle triangle = new Triangle(new Dot(1,1), new Dot(2,2), new Dot(3,3));
    }
}
