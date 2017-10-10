package by.makedon.epam1.parser;

import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongInputParamsExc;
import by.makedon.epam1.validation.InputValidation;

public class StringDataParser {
    public boolean isParseString(String stringData) {
        InputValidation inputValidation = new InputValidation();
        if (inputValidation.validation(stringData)) {
            try {
                return inputValidation.validation(takeData(stringData));
            } catch (WrongInputParamsExc wrongInputParamsExc) {
                wrongInputParamsExc.getMessage();
                return false;
            }
        } else {
            return false;
        }
    }

    public Dot[] takeData(String stringData) {
        String[] strings = stringData.split(" ");

        final int DOT_AMOUNT = 3;
        Dot[] dots = new Dot[DOT_AMOUNT];
        dots[0] = new Dot((Double.parseDouble(strings[0])), Double.parseDouble(strings[1]));
        dots[1] = new Dot((Double.parseDouble(strings[2])), Double.parseDouble(strings[3]));
        dots[2] = new Dot((Double.parseDouble(strings[4])), Double.parseDouble(strings[5]));

        return dots;
    }
}