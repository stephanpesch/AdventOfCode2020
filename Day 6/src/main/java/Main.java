public class Main {
    public static void main(String[] args) {
        Plane plane = Plane.getFromFile("input");
        System.out.printf("Sum of counts: %d", plane.getSumOfCounts());
    }
}
