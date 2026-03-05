public class Main {
    public static void main(String[] args) {
        RoutingSystem topNavigator = new RoutingSystem();

        Location nodeA = new City("Bucuresti", 5, 5, 1900000);
        Location nodeB = new City("Pitesti", 5, 110, 150000);
        Location nodeC = new GasStation("Petrom-Km80", 5, 80, 7.12);
        Location nodeD = new Airport("Otopeni", 20, 20, 2);
   
        topNavigator.registerSite(nodeA);
        topNavigator.registerSite(nodeB);
        topNavigator.registerSite(nodeC);
        topNavigator.registerSite(nodeD);

        try {
            topNavigator.establishPath(new Road(Road.Type.DN, 75.0, nodeA, nodeC));
            topNavigator.establishPath(new Road(Road.Type.DN, 35.0, nodeC, nodeB));
            topNavigator.establishPath(new Road(Road.Type.DC, 25.0, nodeA, nodeD));

            System.out.println("Validitate: " + topNavigator.isInstanceValid());
            System.out.println("Legatura Bucuresti -> Pitesti: " + topNavigator.canConnect(nodeA, nodeB));
            System.out.println("Legatura Pitesti -> Otopeni: " + topNavigator.canConnect(nodeB, nodeD));
            Location oras = new City("Vaslui", 5, 5, 100000);
             System.out.println(oras);
             Road autostrada = new Road(Road.Type.DN, 152.0, nodeA, nodeC);
             System.out.println(autostrada);
        } catch (IllegalArgumentException e) 
        {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
