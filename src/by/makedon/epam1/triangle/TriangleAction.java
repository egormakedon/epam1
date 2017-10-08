package by.makedon.epam1.triangle;

import by.makedon.epam1.dot.Dot;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAction {
    static Logger logger = LogManager.getLogger();

    public double getArea(Triangle triangle) {
        Dot dotA = triangle.getDotA();
        Dot dotB = triangle.getDotB();
        Dot dotC = triangle.getDotC();

        double sideAB = getSide(dotA, dotB);
        double sideBC = getSide(dotB, dotC);
        double sideAC = getSide(dotA, dotC);
        double perimeter = getPerimeter(triangle);

        double area = Math.sqrt(perimeter * (perimeter - sideAB) * (perimeter - sideBC) * (perimeter - sideAC));
        logger.log(Level.INFO, "triangle " + triangle.toString() + " has area " + area);
        return area;
    }

    public double getPerimeter(Triangle triangle) {
        Dot dotA = triangle.getDotA();
        Dot dotB = triangle.getDotB();
        Dot dotC = triangle.getDotC();

        double sideAB = getSide(dotA, dotB);
        double sideBC = getSide(dotB, dotC);
        double sideAC = getSide(dotA, dotC);

        double perimeter = sideAB + sideBC + sideAC;
        logger.log(Level.INFO, "triangle " + triangle.toString() + " has perimeter " + perimeter);
        return perimeter;
    }

    public boolean isTriangleRectangle(Triangle triangle) {
        Dot dotA = triangle.getDotA();
        Dot dotB = triangle.getDotB();
        Dot dotC = triangle.getDotC();

        boolean result = (orthoVectors(dotA, dotB, dotC) ||
                orthoVectors(dotB, dotC, dotA) ||
                orthoVectors(dotB, dotA, dotC));

        if (result) logger.log(Level.INFO, "triangle " + triangle.toString() + " is Rectangle");
        else logger.log(Level.INFO, "triangle " + triangle.toString() + " isn't Rectangle");

        return result;
    }

    public boolean isDotsComposeTriangle(Dot dotA, Dot dotB, Dot dotC) {
        double sideAB = getSide(dotA, dotB);
        double sideBC = getSide(dotB, dotC);
        double sideAC = getSide(dotA, dotC);

        boolean result = ((sideAB + sideBC > sideAC) && (sideAB + sideAC > sideBC) && (sideBC + sideAC > sideAB));
        if (result) logger.log(Level.INFO, dotA.toString() + " " + dotB.toString() + " " + dotC.toString() +" compose triangle");
        else logger.log(Level.INFO, dotA.toString() + " " + dotB.toString() + " " + dotC.toString() +" don't compose triangle");
        return result;
    }

    private boolean orthoVectors(Dot dot1, Dot dot2, Dot dot3) {
        double vx1 = dot2.getX() - dot1.getX();
        double vy1 = dot2.getY() - dot1.getY();

        double vx2 = dot3.getX() - dot2.getX();
        double vy2 = dot3.getY() - dot2.getY();

        return  (vx1*vx2 + vy1*vy2 == 0);
    }

    private double getSide(Dot dot1, Dot dot2) {
        double x1 = dot1.getX();
        double y1 = dot1.getY();
        double x2 = dot2.getX();
        double y2 = dot2.getY();

        return Math.hypot(x1 - x2, y1 - y2);
    }
}