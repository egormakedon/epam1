import by.makedon.epam1.exception.FileNotFoundExc;
import by.makedon.epam1.validation.ValidInParam;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestInParam {
    private ValidInParam validInParam;

    @BeforeTest
    public void setValidInParam() {
        validInParam = new ValidInParam();
    }

    @AfterTest
    public void destrValidInParam() {
        validInParam = null;
    }

    @Test
    public void fileExistTest() {
        boolean result = validInParam.isFileExist("in/in.txt");
        Assert.assertTrue(result);
    }

    @Test
    public void fileNotExistTest() {
        boolean result = validInParam.isFileExist("fileNotExist");
        Assert.assertFalse(result);
    }

    @Test
    public void parseLineTest() {
        String[] result = validInParam.parseLine("1 2 3");
        String[] expected = {"1", "2", "3"};
        Assert.assertEquals(result, expected);
    }

    @Test
    public void checkParamsOnCorrectTest() {
        String[] line = {"1", "2.0", "2", "4", "5", "5.0"};
        boolean result = validInParam.checkParamOnCorrect(line);
        Assert.assertTrue(result);
    }

    @Test
    public void checkParamsOnNotCorrectTest() {
        String[] line = {"1z", "2.0", "-1", "4", "5", "5.0"};
        boolean result = validInParam.checkParamOnCorrect(line);
        Assert.assertFalse(result);
    }

    @Test
    public void readExistFileTest() throws Exception {
        String fileName = "in/in.txt";
        boolean result = validInParam.readFile(fileName);
        Assert.assertTrue(result);
    }

    @Test (expectedExceptions = FileNotFoundExc.class)
    public void readNotExistFileTest() throws Exception {
        String fileName = "in/notExistFile.txt";
        boolean result = validInParam.readFile(fileName);
    }
}
