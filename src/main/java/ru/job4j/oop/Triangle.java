package ru.job4j.oop;

import static java.lang.Math.*;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double sum(double a, double b, double c) {
        return a + b + c;
    }

    public double semiPerimeter(double a, double b, double c) {
        return sum(a, b, c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return (sum(ab, ac) > bc) && (sum(ab, bc) > ac) && (sum(ac, bc) > ab);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}