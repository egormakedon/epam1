import by.makedon.epam1.validator.ParserValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestParserValidator {
    private ParserValidator parser;

    @BeforeTest
    public void set() {
        parser = new ParserValidator();
    }

    @AfterTest
    public void destr() {
        parser = null;
    }

    @Test
    public void validationStringTest() {
        String stringData = "1.1 2.2 3.3 4.5 6.6 6.6";
        Assert.assertTrue(parser.validation(stringData));
    }

    @Test
    public void validationStringWrongTest1() {
        String stringData = "1ss.1 2.2 3.3 4.5 6.6 6.6";
        Assert.assertFalse(parser.validation(stringData));
    }

    @Test
    public void validationStringWrongTest2() {
        String stringData = "1ss.1 2.2 3.3 4.5 6.6 6.6 2e23e qweqasdasda";
        Assert.assertFalse(parser.validation(stringData));
    }

    @Test
    public void validationStringWrongTest3() {
        String stringData = "epam training";
        Assert.assertFalse(parser.validation(stringData));
    }

    @Test
    public void validationStringTest4() {
        String stringData = "-1.1 2.2 3.3 4.5 6.6 6.6";
        Assert.assertTrue(parser.validation(stringData));
    }

    @Test
    public void validationStringWrongTest5() {
        String stringData = "1 2 3 4 5 6";
        Assert.assertFalse(parser.validation(stringData));
    }
}
