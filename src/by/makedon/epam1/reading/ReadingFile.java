package by.makedon.epam1.reading;

import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.DataNotFoundExc;
import by.makedon.epam1.exception.FileNotFoundExc;
import by.makedon.epam1.parser.StringDataParser;
import by.makedon.epam1.validation.InputValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadingFile {
    private static Logger logger = LogManager.getLogger(ReadingFile.class);

    public boolean isFileExist(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            logger.log(Level.INFO,fileName + " found");
            return true;
        } else {
            return false;
        }
    }

    public List<Dot[]> readData(String fileName) throws FileNotFoundExc, DataNotFoundExc {
        if (isFileExist(fileName)) {
            Scanner in = null;
            try {
                in = new Scanner(new File(fileName));
                List<Dot[]> dataList = new ArrayList<>();
                StringDataParser parser = new StringDataParser();

                while (in.hasNextLine()) {
                    String stringData = in.nextLine();
                    if (parser.isParseString(stringData)) {
                        dataList.add(parser.takeData(stringData));
                    } else {
                        logger.log(Level.INFO, stringData + " has wrong parameters");
                    }
                }

                if (dataList.size() != 0) {
                    return dataList;
                } else {
                    logger.log(Level.ERROR, fileName + " hasn't none correct line of parameters");
                    throw new DataNotFoundExc(fileName + " hasn't none correct line of parameters");
                }

            } catch (FileNotFoundException e) {
                logger.log(Level.WARN, "unknown error");
                throw new FileNotFoundExc("unknown error");
            } finally {
                if (in != null) in.close();
            }

        } else {
            logger.log(Level.ERROR,fileName + " didn't find");
            throw new FileNotFoundExc(fileName + " didn't find");
        }
    }
}