package by.makedon.epam1.validation;

import by.makedon.epam1.action.DotAction;
import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongInputParamsExc;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    private static Logger logger = LogManager.getLogger(InputValidation.class);
    private final int DOT_AMOUNT = 3;

    public boolean isDotsComposeTriangle(Dot dot1, Dot dot2, Dot dot3) {
        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistanceBeetwenDots(dot1, dot2);
        double side2 = dotAction.calculateDistanceBeetwenDots(dot2, dot3);
        double side3 = dotAction.calculateDistanceBeetwenDots(dot1, dot3);

        return ((side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1));
    }

    public boolean isDotsComposeTriangle(Dot[] dots) {
        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistanceBeetwenDots(dots[0], dots[1]);
        double side2 = dotAction.calculateDistanceBeetwenDots(dots[1], dots[2]);
        double side3 = dotAction.calculateDistanceBeetwenDots(dots[0], dots[2]);

        return ((side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1));
    }

    public boolean validation(Dot dot1, Dot dot2, Dot dot3) throws WrongInputParamsExc {
        if (isDotsComposeTriangle(dot1, dot2, dot3)) {
            return true;
        } else {
            logger.log(Level.ERROR, dot1.toString() + " " + dot2.toString() + " " + dot3.toString() +" don't compose triangle");
            throw new WrongInputParamsExc(dot1.toString() + " " + dot2.toString() + " " + dot3.toString() +" don't compose triangle");
        }
    }

    public boolean validation(Dot[] dots) throws WrongInputParamsExc {
        if (dots.length > DOT_AMOUNT) {
            logger.log(Level.ERROR, "mush params: " + dots.length);
            throw new WrongInputParamsExc("mush params " + dots.length);
        } else if (dots.length < DOT_AMOUNT) {
            logger.log(Level.ERROR, "less params " + dots.length);
            throw new WrongInputParamsExc("less params " + dots.length);
        } else {
            if(isDotsComposeTriangle(dots)) {
                return true;
            } else {
                logger.log(Level.ERROR, dots[0].toString() + " " + dots[1].toString() + " " + dots[2].toString() +" don't compose triangle");
                throw new WrongInputParamsExc(dots[0].toString() + " " + dots[1].toString() + " " + dots[2].toString() +" don't compose triangle");
            }
        }
    }

    public boolean validation(int index) throws WrongInputParamsExc {
        if (index > DOT_AMOUNT - 1) {
            return false;
        } else if (index < 0) {
            return false;
        }
        return true;
    }

    public boolean validation(String stringData) {
        final String REGEX = "([0-9]{1,}\\.[0-9]{1,}\\s" +
                "[0-9]{1,}\\.[0-9]{1,}\\s" +
                "[0-9]{1,}\\.[0-9]{1,}\\s" +
                "[0-9]{1,}\\.[0-9]{1,}\\s" +
                "[0-9]{1,}\\.[0-9]{1,}\\s" +
                "[0-9]{1,}\\.[0-9]{1,})";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(stringData);
        return matcher.matches();
    }
}