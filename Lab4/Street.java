package org.example;

public class Street implements Comparable<Street> {
    private String label;
    private int size;
    private Intersection point1, point2;

    public Street(String label, int size, Intersection point1, Intersection point2) {
        this.label = label;
        this.size = size;
        this.point1 = point1;
        this.point2 = point2;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Street other) {
        return Integer.compare(this.size, other.size);
    }

    @Override
    public String toString() {
        return label + " (" + size + "m)";
    }
}