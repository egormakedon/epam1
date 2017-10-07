package by.makedon.epam1.triangle;

import by.makedon.epam1.dot.Dot;

public class Triangle {
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

    public void setDotA(Dot dotA) {
        this.dotA = dotA;
    }

    public void setDotB(Dot dotB) {
        this.dotB = dotB;
    }

    public void setDotC(Dot dotC) {
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
}
