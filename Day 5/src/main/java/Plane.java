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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int max = getHighestSeatID();
        int min = getLowestSeatID();
        int maxLength = Integer.toString(max).length(); // There surely is a more efficient way
        for (int i = min; i <= max; i++) {
            String IDNumber = String.format("%d%s", i, " ".repeat(maxLength - Integer.toString(i).length()));
            if (seats.containsKey(i)) {
                builder.append((char) 27).append("[48;5;0m ").append(IDNumber).append((char) 27).append("[0m");
            } else {
                builder.append((char) 27).append("[48;5;1m ").append(IDNumber).append((char) 27).append("[0m");
            }
            if ((i + 1) % columns == 0) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }



    public void readSeatsFromFile(String name) {
        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                Seat seat = new Seat(scanner.nextLine(), rows, columns);
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
            if (seats.get(i) == null) {
                return i;
            }
        }
        return -1;
    }
}
