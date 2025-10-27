package ru.stqa.geometry.Triangle;

public class Triangle {
    public static void main(String[] args) {
        printTrianglePerimeter(5.0);
        printTriangleArea(5.0, 5.0, 5.0);
    }

    public static void printTrianglePerimeter(double a) {
        System.out.println("Периметр треугольника со сторонами " + " "+ a +" " + "равен " + perimeter(a));
    }

    public static double perimeter(double a) {
        return a * 3;
    }

    public static void printTriangleArea(double a, double b, double c) {
        System.out.println("Площадь треугольника со сторонами " + " "+ a +" " + "равен " + area(a, b, c));
    }


    public static double area(double a, double b, double c) {
        double p = (a*3)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}