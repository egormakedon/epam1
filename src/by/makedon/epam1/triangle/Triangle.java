package by.makedon.epam1.triangle;

import by.makedon.epam1.dot.Dot;

public class Triangle extends Object {
    private Dot dotA;
    private Dot dotB;
    private Dot dotC;

    public Triangle() {

    }

    public Triangle(Dot dotA, Dot dotB, Dot dotC) {
        this.dotA = dotA;
        this.dotB = dotB;
        this.dotC = dotC;
    }

    public void setTrianlge(Dot dotA, Dot dotB, Dot dotC) {
        this.dotA = dotA;
        this.dotB = dotB;
        this.dotC = dotC;
    }

    public Dot getDotA() {
        return dotA;
    }

    public Dot getDotB() {
        return dotB;
    }

    public Dot getDotC() {
        return dotC;
    }

    @Override
    public String toString() {
        return dotA.toString() + ", " + dotB.toString() + ", " + dotC.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle triangle = (Triangle) obj;
        if (!dotA.equals(triangle.getDotA()))
            return false;
        if (!dotB.equals(triangle.getDotB()))
            return false;
        if (!dotC.equals(triangle.getDotC()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return dotA.hashCode() + dotB.hashCode() + dotC.hashCode();
    }
}