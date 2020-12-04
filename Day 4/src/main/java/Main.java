public class Main {
    public static void main(String[] args) {
        AirportQueue queue = AirportQueue.getFromFile("input");
        queue.printAll();
        System.out.println(queue.countValid());
    }
}
