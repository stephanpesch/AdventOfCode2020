public class Main {

    public static void main(String[] args) {
        Ferry ferry = new Ferry();

        ferry.moveByInstructionsFromFile("input");
        System.out.println(ferry.manhattanDistanceFromStartingPosition());
    }
}
