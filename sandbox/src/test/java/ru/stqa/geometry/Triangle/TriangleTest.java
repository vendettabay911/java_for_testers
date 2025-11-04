package ru.stqa.geometry.Triangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTest {

    @Test
    void canCalculatePerimeter() {
        var b = new Triangle(7, 8, 9);
        int result = b.perimeter();
        Assertions.assertEquals(20.0, result);
    }

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(16, new Triangle(7, 8,9).area());
    }

    @Test
    void triangleTest() {
        var t1 = new Triangle(3, 4, 5);
        var t2 = new Triangle(5, 4, 3);
        Assertions.assertTrue(t1.equals(t2));
    }
}