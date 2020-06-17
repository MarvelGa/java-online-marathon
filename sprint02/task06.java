//часу не хватило допрацювати

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Shape {
    public abstract String getName() ;
    public abstract double getArea();
}
class Circle extends Shape {
    private double radius;
    final double pi = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public double getArea() {
        return (pi * Math.pow(radius, 2));
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ']';
    }
}
class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public double getArea() {
        return  this.height * this.width;
    }

    @Override
    public String toString() {
        return "Rectangle[" +
                "height=" + height +
                ", width=" + width +
                ']';
    }
}

 class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> result =new ArrayList<>();

       for (Shape elem:shapes){
           result.add(elem);
       }
       return result;
    }
}

class ShapeComparator implements Comparable<Shape>{

    @Override
    public int compareTo(Shape o ) {
        return 0;
    }
}
