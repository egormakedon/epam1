package by.makedon.epam1.entity;

import by.makedon.epam1.action.DotAction;
import by.makedon.epam1.exception.WrongInputParamsExc;
import by.makedon.epam1.validation.InputValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Triangle {
    private Dot[] dots;
    private final int DOT_AMOUNT = 3;
    static Logger logger = LogManager.getLogger(Triangle.class);

    public Triangle(Dot dot1, Dot dot2, Dot dot3) throws WrongInputParamsExc {
        InputValidation inputValidation = new InputValidation();
        if(inputValidation.validation(dot1, dot2, dot3)) {
            dots = new Dot[DOT_AMOUNT];
            dots[0] = dot1;
            dots[1] = dot2;
            dots[2] = dot3;
            logger.log(Level.INFO, this.toString() + " create successfully");
        }
    }
    public Triangle(Dot[] dots) throws WrongInputParamsExc {
        InputValidation inputValidation = new InputValidation();
        if(inputValidation.validation(dots)) {
            this.dots = new Dot[DOT_AMOUNT];
            this.dots[0] = dots[0];
            this.dots[1] = dots[1];
            this.dots[2] = dots[2];
            logger.log(Level.INFO, this.toString() + " create successfully");
        }
    }

    public void set(Dot dot1, Dot dot2, Dot dot3) throws WrongInputParamsExc {
        InputValidation inputValidation = new InputValidation();
        if(inputValidation.validation(dot1, dot2, dot3)) {
            dots[0] = dot1;
            dots[1] = dot2;
            dots[2] = dot3;
            logger.log(Level.INFO, this.toString() + " create successfully");
        }
    }
    public void set(Dot[] dots) throws WrongInputParamsExc {
        InputValidation inputValidation = new InputValidation();
        if(inputValidation.validation(dots)) {
                this.dots[0] = dots[0];
                this.dots[1] = dots[1];
                this.dots[2] = dots[2];
                logger.log(Level.INFO, this.toString() + " create successfully");
        }
    }

    public Dot getDot(int index) throws WrongInputParamsExc {
        InputValidation inputValidation = new InputValidation();
        if (inputValidation.validation(index)) {
            return dots[index];
        } else {
            logger.log(Level.ERROR, "overstepping, index: " + index);
            throw new WrongInputParamsExc("overstepping, index: " + index);
        }
    }

    public boolean isRect() {
        DotAction dotAction = new DotAction();

        return (dotAction.isRectangle(dots[1], dots[0], dots[2]) ||
                dotAction.isRectangle(dots[0], dots[1], dots[2]) ||
                dotAction.isRectangle(dots[1], dots[2], dots[0]));
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

        if (DOT_AMOUNT != triangle.DOT_AMOUNT) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dots, triangle.dots);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dots);
        result = 31 * result + DOT_AMOUNT;
        return result;
    }
}