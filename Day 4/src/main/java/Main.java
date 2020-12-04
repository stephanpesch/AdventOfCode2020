public class Main {
    public static void main(String[] args) {
        AirportQueue queue = AirportQueue.getFromFile("input");

        System.out.println(queue.countValid());
    }
}
