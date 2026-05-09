public class Main {
    public static void main(String[] args) {
        GameMap map = new GameMap(10);

        Bunny bunny = new Bunny(0, 0, map);
        Robot r1 = new Robot("Robot1", 5, 5, map);
        Robot r2 = new Robot("Robot2", 2, 8, map);
        Robot r3 = new Robot("Robot3", 8, 2, map);

        bunny.start();
        r1.start();
        r2.start();
        r3.start();

        while (map.isRunning()) {
            map.display();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        
        map.display();
        System.out.println("Game Over");
    }
}