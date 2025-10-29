package ru.stqa.geometry.Triangle;

public class Triangle {
    int aSide;
    int bSide;
    int cSide;

    public Triangle(int aSide, int bSide, int cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    public static void main(String[] args) {
    }

    public int perimeter() {
        return this.aSide+this.bSide+this.cSide;
    }

    public int area() {
        int p = (aSide + bSide + cSide) / 2;
        return (int) Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
    }
}