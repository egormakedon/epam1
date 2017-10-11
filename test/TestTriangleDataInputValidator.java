import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongDataException;
import by.makedon.epam1.validator.TriangleDataInputValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTriangleDataInputValidator {
    private TriangleDataInputValidator triangleDataInputValidator;

    @BeforeTest
    public void set() {
        triangleDataInputValidator = new TriangleDataInputValidator();
    }

    @AfterTest
    public void destr() {
        triangleDataInputValidator = null;
    }

    @Test
    public void isDotsComposeTriangleTest_1() throws WrongDataException {
        Assert.assertTrue(triangleDataInputValidator.dotsValidation(new Dot(0,0), new Dot(1.10,200), new Dot(-123,213.232)));
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void isDotsNotComposeTriangleTest_1() throws WrongDataException {
        triangleDataInputValidator.dotsValidation(new Dot(0,0), new Dot(1,1), new Dot(-1,-1));
    }

    @Test
    public void isDotsComposeTriangleTest_2() throws WrongDataException {
        Dot[] dots = new Dot[3];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(2,2);
        dots[2] = new Dot(22,100);
        Assert.assertTrue(triangleDataInputValidator.dotsValidation(dots));
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void isDotsNotComposeTriangleTest_2() throws WrongDataException {
        Dot[] dots = new Dot[3];
        dots[0] = new Dot(1,1);
        dots[1] = new Dot(2,2);
        dots[2] = new Dot(3,3);
        triangleDataInputValidator.dotsValidation(dots);
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationWrongTest1() throws WrongDataException {
        Dot[] dots = new Dot[4];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(1,2);
        dots[2] = new Dot(1,2);
        dots[3] = new Dot(1,2);
        triangleDataInputValidator.dotsValidation(dots);
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationWrongTest2() throws WrongDataException {
        Dot[] dots = new Dot[2];
        dots[0] = new Dot(1,2);
        dots[1] = new Dot(1,2);
        triangleDataInputValidator.dotsValidation(dots);
    }

    @Test
    public void validationIndexTest() throws WrongDataException {
        int index = 2;
        Assert.assertTrue(triangleDataInputValidator.indexValidation(index));
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationIndexWrongTest1() throws WrongDataException {
        int index = 100;
        triangleDataInputValidator.indexValidation(index);
    }

    @Test (expectedExceptions = WrongDataException.class)
    public void validationIndexWrongTest2() throws WrongDataException {
        int index = -100;
        triangleDataInputValidator.indexValidation(index);
    }
}
