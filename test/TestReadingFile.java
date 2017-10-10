import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.DataNotFoundExc;
import by.makedon.epam1.exception.FileNotFoundExc;
import by.makedon.epam1.reading.ReadingFile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestReadingFile {
    private ReadingFile rF;

    @BeforeTest
    public void set() {
        rF = new ReadingFile();
    }

    @AfterTest
    public void destr() {
        rF = null;
    }

    @Test
    public void fileExistTest() {
        String fileName = "in/in.txt";
        Assert.assertTrue(rF.isFileExist(fileName));
    }

    @Test
    public void fileNotExistTest() {
        String fileName = "thisFileNotExist.txt";
        Assert.assertFalse(rF.isFileExist(fileName));
    }

    @Test
    public void readFileTest() throws DataNotFoundExc, FileNotFoundExc {
        String fileName = "in/in.txt";
        List<Dot[]> result = rF.readData(fileName);
        List<Dot[]> expectedList = new ArrayList<>();

        expectedList.add(new Dot[3]);
        expectedList.get(0)[0] = new Dot(0, 0);
        expectedList.get(0)[1] = new Dot(0, 2);
        expectedList.get(0)[2] = new Dot(3, 0);

        expectedList.add(new Dot[3]);
        expectedList.get(1)[0] = new Dot(1, 0);
        expectedList.get(1)[1] = new Dot(1, 4);
        expectedList.get(1)[2] = new Dot(10, 0);

        expectedList.add(new Dot[3]);
        expectedList.get(2)[0] = new Dot(1, 1);
        expectedList.get(2)[1] = new Dot(2, 2);
        expectedList.get(2)[2] = new Dot(5, 1.5);

        expectedList.add(new Dot[3]);
        expectedList.get(3)[0] = new Dot(2, 3);
        expectedList.get(3)[1] = new Dot(3, 2);
        expectedList.get(3)[2] = new Dot(4, 5);

//        for (Dot[] dots : result) {
//            for (Dot dot : dots) {
//                System.out.println(dot.toString() + " ");
//            }
//            System.out.println("\n");
//        }
        Assert.assertEquals(result, expectedList);
    }

}
