import java.util.*;

public class RoutingSystem {
    private List<Location> sites = new ArrayList<>();
    private List<Road> paths = new ArrayList<>();

    public void registerSite(Location l) {
        if (!sites.contains(l)) sites.add(l);
    }

    public void establishPath(Road r) {
        if (!paths.contains(r)) paths.add(r);
    }

    public boolean isInstanceValid() {
        for (Road r : paths) {
            if (!sites.contains(r.getSrc()) || !sites.contains(r.getDest())) return false;
        }
        return true;
    }

    public boolean canConnect(Location start, Location end) {
        Set<Location> tracker = new HashSet<>();
        return performDfs(start, end, tracker);
    }

    private boolean performDfs(Location current, Location goal, Set<Location> tracker) {
        if (current.equals(goal)) return true;
        tracker.add(current);
        for (Road r : paths) {
            Location neighbor = null;
            if (r.getSrc().equals(current)) neighbor = r.getDest();
            else if (r.getDest().equals(current)) neighbor = r.getSrc();
            if (neighbor != null && !tracker.contains(neighbor)) {
                if (performDfs(neighbor, goal, tracker)) return true;
            }
        }
        return false;
    }
}