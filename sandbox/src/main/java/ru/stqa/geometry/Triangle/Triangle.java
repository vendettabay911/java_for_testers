package ru.stqa.geometry.Triangle;

public class Triangle {
    int aSide;
    int bSide;
    int cSide;



    public Triangle(int aSide, int bSide, int cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        if (aSide < 0 || bSide < 0 || cSide < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (aSide>(bSide+cSide) || bSide>(aSide+cSide) || cSide>(aSide+bSide)) {
            throw new IllegalArgumentException("One of triangle sides is too big");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.aSide, this.aSide) == 0 && Double.compare(triangle.bSide, this.bSide) == 0 && Double.compare(triangle.cSide, this.cSide) == 0
                || Double.compare(triangle.aSide, this.bSide) == 0 && Double.compare(triangle.bSide, this.aSide) == 0 && Double.compare(triangle.cSide, this.cSide) == 0
                || Double.compare(triangle.aSide, this.cSide) == 0 && Double.compare(triangle.bSide, this.bSide) == 0 && Double.compare(triangle.cSide, this.aSide) == 0
                || Double.compare(triangle.aSide, this.cSide) == 0 && Double.compare(triangle.bSide, this.aSide) == 0 && Double.compare(triangle.cSide, this.bSide) == 0
                || Double.compare(triangle.aSide, this.bSide) == 0 && Double.compare(triangle.bSide, this.cSide) == 0 && Double.compare(triangle.cSide, this.aSide) == 0
                || Double.compare(triangle.aSide, this.aSide) == 0 && Double.compare(triangle.bSide, this.cSide) == 0 && Double.compare(triangle.cSide, this.bSide) == 0;
    }

    @Override
    public int hashCode() {
        return 1;
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