package by.makedon.epam1.triangle;

import by.makedon.epam1.dot.Dot;

public class TriangleAction {
    public double getArea(Triangle triangle) {
        double sideA = getSideA(triangle.getDotA());
        double sideB = getSideB(triangle.getDotB());
        double sideC = getSideC(triangle.getDotC());
        double perimeter = getPerimeter(triangle);

        double area = Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC));
        return area;
    }

    public double getPerimeter(Triangle triangle) {
        double sideA = getSideA(triangle.getDotA());
        double sideB = getSideB(triangle.getDotB());
        double sideC = getSideC(triangle.getDotC());

        return sideA + sideB + sideC;
    }

    public boolean isTriangleRectangle(Triangle triangle) {
        double sideA = getSideA(triangle.getDotA());
        double sideB = getSideB(triangle.getDotB());
        double sideC = getSideC(triangle.getDotC());

        return (isPythTheoTrue(sideA, sideB, sideC) || isPythTheoTrue(sideA, sideC, sideB) ||
                isPythTheoTrue(sideB, sideC, sideA));
    }

    private boolean isPythTheoTrue(double catheter1, double cathete2, double hypotenuse) {
        double sqrCath1 = Math.pow(catheter1, 2d);
        double sqrCath2 = Math.pow(cathete2, 2d);
        double sqrHypot = Math.pow(hypotenuse, 2d);

        return ((sqrCath1 + sqrCath2) == sqrHypot);
    }

    private double getSideA(Dot dotA) {
        double x1 = dotA.getX();
        double y1 = dotA.getY();

        return Math.hypot(x1, y1);
    }

    private double getSideB(Dot dotB) {
        double x2 = dotB.getX();
        double y2 = dotB.getY();

        return Math.hypot(x2, y2);
    }

    private double getSideC(Dot dotC) {
        double x3 = dotC.getX();
        double y3 = dotC.getY();

        return Math.hypot(x3, y3);
    }
}
