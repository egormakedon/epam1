package by.makedon.epam1.validation;

import by.makedon.epam1.exception.FileNotFoundExc;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class ValidInParam {
    static Logger logger = LogManager.getLogger();

    public boolean isFileExist(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            logger.log(Level.INFO, fileName + " found successfully");
            return true;
        } else {
            return false;
        }
    }

    public boolean readFile(String fileName) throws Exception {
        Scanner in;
        if (isFileExist(fileName)) {
            in = new Scanner(new File(fileName));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] parseLine = parseLine(line);

                if (!checkParamOnCorrect(parseLine)) {
                    logger.log(Level.ERROR, "wrong params in line: " + line);
                }
            }
            logger.log(Level.INFO, fileName + " read successfully");
            return true;
        } else {
            throw new FileNotFoundExc(fileName);
        }
    }

    public String[] parseLine(String line) {
        String[] parseLine = line.split(" ");
        return parseLine;
    }

    public boolean checkParamOnCorrect(String[] parseLine) {
        if (parseLine.length != 6) {
            logger.log(Level.ERROR, "line should has 6 params");
            return false;
        }

        try {
            double x1 = Double.parseDouble(parseLine[0]);
            double y1 = Double.parseDouble(parseLine[1]);
            double x2 = Double.parseDouble(parseLine[2]);
            double y2 = Double.parseDouble(parseLine[3]);
            double x3 = Double.parseDouble(parseLine[4]);
            double y3 = Double.parseDouble(parseLine[5]);

            if (!(x1 >= 0d && y1 >= 0d && x2 >= 0d && y2 >= 0d && x3 >= 0d && y3 >= 0d)) return false;

            logger.log(Level.INFO, "all params are correct");
            return true;
        } catch (NumberFormatException e) {
            StringBuilder line = new StringBuilder();
            for (String s : parseLine){
                line.append(s + " ");
            }

            logger.log(Level.ERROR, "params are not correct in line: " + line);
            return false;
        }
    }
}