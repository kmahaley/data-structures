package edu.basic.preparation.design;

import java.util.Arrays;
import java.util.List;

/**
 * Polygon class has 5 functions
 * 1) perimeter of the polygon
 * 2) distance between points
 * 3) area of the polygon using triangle method
 * 4) inclination of the 3 points
 * 5) is polygon convex or concave
 * convex = line joining between to vertices of the polygon intersects sides of the polygon
 */
public class Polygon {

    public static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public static double perimeter(List<Point> pointList) {
        double perimeter = 0.0d;

        if (!isPolygonExists(pointList)) return perimeter;
        Point prev = pointList.get(0);

        for (int i = 1; i < pointList.size(); i++) {
            Point curr = pointList.get(i);
            perimeter = perimeter + distance(prev, curr);
            prev = curr;
        }

        return perimeter + distance(pointList.get(0), prev);
    }

    public static double areaOfPolygon(List<Point> pointList) {
        double area = 0.0d;
        if (!isPolygonExists(pointList)) return area;

        Point start = pointList.get(0);
        Point second = pointList.get(1);

        for (int i = 2; i < pointList.size(); i++) {
            Point third = pointList.get(i);
            area = area + getAreaOfTriangle(start, second, third);
            second = third;
        }

        return area;
    }

    public static boolean isConcave(List<Point> pointList) {

        // TODO: implement this
        return false;
    }

    public static double inclination(Point p1, Point p2, Point p3) {

        double first = (p2.y - p1.y) / (p2.x - p1.x);
        double second = (p3.y - p2.y) / (p3.x - p2.x);

        return second - first;
    }

    private static boolean isPolygonExists(List<Point> pointList) {
        return pointList.size() >= 3;
    }

    /**
     * s = (a+b+c)/2
     * area = math.sqrt(s * (s-side1) * (s-side1) * (s-side1))
     *
     */
    private static double getAreaOfTriangle(Point p1, Point p2, Point p3) {

        double perimeter = perimeter(Arrays.asList(p1,p2,p3));
        double s = perimeter/2;

        double a = distance(p1,p2);
        double b = distance(p2,p3);
        double c = distance(p3,p1);

        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

}



