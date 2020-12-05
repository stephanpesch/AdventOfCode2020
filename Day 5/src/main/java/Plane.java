import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Plane {

    private int rows;
    private int columns;
    private List<Seat> seats;

    public Plane(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();
    }

    public void readSeatsFromFile(String name) {
        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                seats.add(new Seat(scanner.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllSeatIDs() {
        seats.forEach(System.out::println);
    }

    public int getHighestSeatID() {
        return seats.stream().mapToInt(Seat::hashCode).max().orElse(-1);
    }
}
