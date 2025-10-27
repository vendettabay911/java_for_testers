package ru.stqa.geometry.Triangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleTest {

    @Test
    void canCalculatePerimeter() {
        var result = Triangle.perimeter(5);
        Assertions.assertEquals(20.0, result);
    }

    @Test
    void canCalculateArea() {
        var result = Triangle.area(5.0,5.0, 5.0);
        Assertions.assertEquals(20, result);
    }
}