package by.makedon.epam1.entity;

import java.util.Arrays;

public class Triangle {
    private Dot[] dots;

    public Triangle(Dot dot1, Dot dot2, Dot dot3) {
        dots = new Dot[3];
        dots[0] = dot1;
        dots[1] = dot2;
        dots[2] = dot3;
    }
    public Triangle(Dot[] dots) {
        this.dots = new Dot[3];
        this.dots[0] = dots[0];
        this.dots[1] = dots[1];
        this.dots[2] = dots[2];
    }
    public void set(Dot dot1, Dot dot2, Dot dot3) {
        dots[0] = dot1;
        dots[1] = dot2;
        dots[2] = dot3;
    }
    public void set(Dot[] dots) {
        this.dots[0] = dots[0];
        this.dots[1] = dots[1];
        this.dots[2] = dots[2];
    }

    public Dot getDot(int index) {
        return dots[index];
    }

    @Override
    public String toString() {
        return dots[0].toString() + " " + dots[1].toString() + " " + dots[2].toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dots, triangle.dots);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dots);
    }
}