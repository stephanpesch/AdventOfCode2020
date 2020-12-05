import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Plane {

    private int rows;
    private int columns;
    private Map<Integer, Seat> seats;

    public Plane(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new HashMap<>();
    }

    public void readSeatsFromFile(String name) {
        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                Seat seat = new Seat(scanner.nextLine());
                seats.put(seat.getID(), seat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllSeatIDs() {
        seats.values().forEach(System.out::println);
    }

    public int getHighestSeatID() {
        return seats.keySet().stream().mapToInt(x -> x).max().orElse(-1);
    }

    public int getLowestSeatID() {
        return seats.keySet().stream().mapToInt(x -> x).min().orElse(-1);
    }

    public int findSeatID() {
        for (int i = getLowestSeatID(); i < getHighestSeatID(); i++) {
            if (seats.get(i) == null && seats.get(i - 1) != null && seats.get(i + 1) != null) {
                return i;
            }
        }
        return -1;
    }
}
