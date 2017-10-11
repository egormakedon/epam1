package by.makedon.epam1.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserValidator {
    public boolean validation(String stringData) {
        final String REGEX = "(-*)\\d{1,}.\\d{1,}\\s" +
                             "(-*)\\d{1,}.\\d{1,}\\s" +
                             "(-*)\\d{1,}.\\d{1,}\\s" +
                             "(-*)\\d{1,}.\\d{1,}\\s" +
                             "(-*)\\d{1,}.\\d{1,}\\s" +
                             "(-*)\\d{1,}.\\d{1,}";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(stringData);
        return matcher.matches();
    }
}