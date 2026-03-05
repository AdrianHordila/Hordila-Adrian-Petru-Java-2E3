import java.util.Objects;

public abstract sealed class Location permits City, Airport, GasStation {
    protected String id;
    protected double xCoord;
    protected double yCoord;

    public Location(String id, double xCoord, double yCoord) {
        this.id = id;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public String getId() { return id; }
    public double getX() { return xCoord; }
    public double getY() { return yCoord; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location that)) return false;
        return Double.compare(that.xCoord, xCoord) == 0 && 
               Double.compare(that.yCoord, yCoord) == 0 && 
               id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xCoord, yCoord);
    }

    @Override
    public String toString() {
        return id + " (" + xCoord + "," + yCoord + ")";
    }
}

final class City extends Location {
    private int citizens;
    public City(String id, double x, double y, int citizens)  {
        super(id, x, y);
        this.citizens = citizens;
    }
}

final class Airport extends Location {
    private int gates;
    public Airport(String id, double x, double y, int gates) {
        super(id, x, y);
        this.gates = gates;
    }
}

final class GasStation extends Location {
    private double literPrice;
    public GasStation(String id, double x, double y, double literPrice) {
        super(id, x, y);
        this.literPrice = literPrice;
    }
}