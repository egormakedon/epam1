import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongInputParamsExc;
import by.makedon.epam1.validation.InputValidation;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestInputValidation {
    private InputValidation inputValidation;

    @BeforeTest
    public void set() {
        inputValidation = new InputValidation();
    }

    @AfterTest
    public void destr() {
        inputValidation = null;
    }

    @Test
    public void isDotsComposeTriangleTest_1() {
        Assert.assertTrue(inputValidation.isDotsComposeTriangle(new Dot(0,0), new Dot(1.10,200), new Dot(-123,213.232)));
    }

    @Test
    public void isDotsNotComposeTriangleTest_1() {
        Assert.assertFalse(inputValidation.isDotsComposeTriangle(new Dot(0,0), new Dot(1,1), new Dot(-1,-1)));
    }

    @Test
    public void isDotsComposeTriangleTest_2() {
        Dot[] dots = new Dot[3];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(2,2);
        dots[2] = new Dot(22,100);
        Assert.assertTrue(inputValidation.isDotsComposeTriangle(dots));
    }

    @Test
    public void isDotsNotComposeTriangleTest_2() {
        Dot[] dots = new Dot[3];
        dots[0] = new Dot(1,1);
        dots[1] = new Dot(2,2);
        dots[2] = new Dot(3,3);
        Assert.assertFalse(inputValidation.isDotsComposeTriangle(dots));
    }

    @Test (expectedExceptions = WrongInputParamsExc.class)
    public void validationWrongTest1() throws WrongInputParamsExc {
        Dot[] dots = new Dot[4];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(1,2);
        dots[2] = new Dot(1,2);
        dots[3] = new Dot(1,2);
        inputValidation.validation(dots);
    }

    @Test (expectedExceptions = WrongInputParamsExc.class)
    public void validationWrongTest2() throws WrongInputParamsExc {
        Dot[] dots = new Dot[2];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(1,2);
        inputValidation.validation(dots);
    }

    @Test
    public void validationIndexTest() throws WrongInputParamsExc {
        int index = 2;
        Assert.assertTrue(inputValidation.validation(index));
    }

    @Test
    public void validationIndexWrongTest1() throws WrongInputParamsExc {
        int index = 100;
        Assert.assertFalse(inputValidation.validation(index));
    }

    @Test
    public void validationIndexWrongTest2() throws WrongInputParamsExc {
        int index = -100;
        Assert.assertFalse(inputValidation.validation(index));
    }

    @Test
    public void validationStringTest() {
        String stringData = "1.1 2.2 3.3 4.5 6.6 6.6";
        Assert.assertTrue(inputValidation.validation(stringData));
    }

    @Test
    public void validationStringWrongTest1() {
        String stringData = "1ss.1 2.2 3.3 4.5 6.6 6.6";
        Assert.assertFalse(inputValidation.validation(stringData));
    }

    @Test
    public void validationStringWrongTest2() {
        String stringData = "1ss.1 2.2 3.3 4.5 6.6 6.6 2e23e qweqasdasda";
        Assert.assertFalse(inputValidation.validation(stringData));
    }

    @Test
    public void validationStringWrongTest3() {
        String stringData = "epam training";
        Assert.assertFalse(inputValidation.validation(stringData));
    }

    @Test
    public void validationStringWrongTest4() {
        String stringData = "-1.1 2.2 3.3 4.5 6.6 6.6";
        Assert.assertFalse(inputValidation.validation(stringData));
    }

    @Test
    public void validationStringWrongTest5() {
        String stringData = "1 2 3 4 5 6";
        Assert.assertFalse(inputValidation.validation(stringData));
    }
}
