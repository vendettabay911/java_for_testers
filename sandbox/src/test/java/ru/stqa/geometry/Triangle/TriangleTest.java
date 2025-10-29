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
}