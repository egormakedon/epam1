package by.makedon.epam1.parser;

import by.makedon.epam1.entity.Dot;

import java.util.ArrayList;
import java.util.List;

public class StringDataParser {
    public List<Dot[]> parse(List<String> dataList) {
        List<Dot[]> dotsList = new ArrayList<>();
        for (String dataLine : dataList) {
            String[] splitDataLine = splitString(dataLine);
            dotsList.add(takeData(splitDataLine));
        }
        return dotsList;
    }

    private Dot[] takeData(String[] splitDataLine) {
        Dot[] dots = new Dot[3];
        dots[0].set((Double.parseDouble(splitDataLine[0])), Double.parseDouble(splitDataLine[1]));
        dots[1].set((Double.parseDouble(splitDataLine[2])), Double.parseDouble(splitDataLine[3]));
        dots[2].set((Double.parseDouble(splitDataLine[4])), Double.parseDouble(splitDataLine[5]));
        return dots;
    }

    private String[] splitString(String string) {
        String[] splitString = string.split(" ");
        return splitString;
    }
}