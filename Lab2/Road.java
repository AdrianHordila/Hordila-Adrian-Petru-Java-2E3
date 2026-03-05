import java.util.Objects;

public class Road {
    public enum Type { DN, DJ, DC }

    private Type category;
    private double len;
    private Location src;
    private Location dest;

    public Road(Type category, double len, Location src, Location dest) {
        double airDist = Math.sqrt(Math.pow(src.getX() - dest.getX(), 2) + 
                                   Math.pow(src.getY() - dest.getY(), 2));
        if (len < airDist) throw new IllegalArgumentException("Drum prea scurt.");
        
        this.category = category;
        this.len = len;
        this.src = src;
        this.dest = dest;
    }

    public Location getSrc() { return src; }
    public Location getDest() { return dest; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return (src.equals(road.src) && dest.equals(road.dest)) || 
               (src.equals(road.dest) && dest.equals(road.src));
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest) + Objects.hash(dest, src);
    }

    @Override
    public String toString() {
        return category + " [" + src.getId() + " - " + dest.getId() + "]";
    }
    
}