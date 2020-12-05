public class Main {
    public static void main(String[] args) {
        Plane plane = new Plane(128, 8);
        plane.readSeatsFromFile("input");
        System.out.println(plane.getHighestSeatID());
    }
}
