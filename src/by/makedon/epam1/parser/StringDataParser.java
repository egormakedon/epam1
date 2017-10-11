package by.makedon.epam1.parser;

import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.exception.WrongDataException;
import by.makedon.epam1.validator.ParserValidator;
import by.makedon.epam1.validator.TriangleDataInputValidator;

public class StringDataParser {
    public boolean isParseString(String stringData, String delimiter) throws WrongDataException {
        ParserValidator parserValidator = new ParserValidator();
        if (parserValidator.validation(stringData)) {
            TriangleDataInputValidator triangleDataInputValidator = new TriangleDataInputValidator();
            return triangleDataInputValidator.dotsValidation(takeDots(stringData, delimiter));
        } else {
            throw new WrongDataException(stringData + " hasn't read: wrong parameters");
        }
    }

    public Dot[] takeDots(String stringData, String delimiter) throws WrongDataException {
        final int DOT_AMOUNT = 3;
        String[] strings = stringData.split(delimiter);
        if (strings.length == 6) {
            Dot[] dots = new Dot[DOT_AMOUNT];
            dots[0] = new Dot((Double.parseDouble(strings[0])), Double.parseDouble(strings[1]));
            dots[1] = new Dot((Double.parseDouble(strings[2])), Double.parseDouble(strings[3]));
            dots[2] = new Dot((Double.parseDouble(strings[4])), Double.parseDouble(strings[5]));
            return dots;
        } else {
            throw new WrongDataException("length of " + strings.toString() + " not equal " + DOT_AMOUNT);
        }
    }
}