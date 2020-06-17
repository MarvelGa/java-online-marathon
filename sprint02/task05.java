import java.util.ArrayList;
import java.util.List;

public class Rectang {
    private double height;
    private double width;

    public Rectang(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }
}

class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return this.side * 4;
    }
}

class MyUtils {
    public double sumPerimeter(List<?> firures) {
        double result = 0.0;
        for (Object elem : firures) {
            if (elem != null) {
                if (elem.getClass() == Rectang.class) {
                    result += ((Rectang) elem).getPerimeter();
                }
                if (elem.getClass() == Square.class) {
                    result += ((Square) elem).getPerimeter();
                }
            }
        }
        return result;
    }
}
