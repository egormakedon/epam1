package by.makedon.epam1.action;

import by.makedon.epam1.entity.Dot;
import by.makedon.epam1.entity.Triangle;
import by.makedon.epam1.exception.WrongInputParamsExc;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAction {
    private static Logger logger = LogManager.getLogger(TriangleAction.class);
    public double calculateArea(Triangle triangle) throws WrongInputParamsExc {
        int index = 0;
        Dot dot1 = triangle.getDot(index);

        index = 1;
        Dot dot2 = triangle.getDot(index);

        index = 2;
        Dot dot3 = triangle.getDot(index);

        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistance(dot1, dot2);
        double side2 = dotAction.calculateDistance(dot2, dot3);
        double side3 = dotAction.calculateDistance(dot1, dot3);
        double halfP = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(halfP * (halfP - side1) * (halfP - side2) * (halfP - side3));

        logger.log(Level.INFO, "triangle " + triangle.toString() + " has area " + area);
        return area;
    }
    public double calculatePerimeter(Triangle triangle) throws WrongInputParamsExc {
        int index = 0;
        Dot dot1 = triangle.getDot(index);

        index = 1;
        Dot dot2 = triangle.getDot(index);

        index = 2;
        Dot dot3 = triangle.getDot(index);

        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistance(dot1, dot2);
        double side2 = dotAction.calculateDistance(dot2, dot3);
        double side3 = dotAction.calculateDistance(dot1, dot3);
        double perimeter = side1 + side2 + side3;

        logger.log(Level.INFO, "triangle " + triangle.toString() + " has perimeter " + perimeter);
        return perimeter;
    }
}