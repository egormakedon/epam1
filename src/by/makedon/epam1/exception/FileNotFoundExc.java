package by.makedon.epam1.exception;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileNotFoundExc extends Exception {
    static Logger logger = LogManager.getLogger();

    public FileNotFoundExc(String fileName) {
        logger.log(Level.ERROR, fileName + " not found");
    }
}