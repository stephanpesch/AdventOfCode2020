public class Main {
    public static void main(String[] args) {
        WaitingArea waitingArea = WaitingArea.getFromFile("input");

        waitingArea.runUntilStateNotChanging();
        System.out.println(waitingArea.getNumberOccupiedTotal());
    }
}
