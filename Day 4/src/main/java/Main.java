public class Main {
    public static void main(String[] args) {
        AirportQueue queue = AirportQueue.getFromFile("input");
        System.out.printf("Valid: %d", queue.countValid());
    }
}
