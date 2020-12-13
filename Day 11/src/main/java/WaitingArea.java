import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WaitingArea {

    private List<List<Character>> area;
    private List<List<Character>> lastArea;
    private List<List<Character>> nextArea;

    public WaitingArea(List<List<Character>> area) {
        this.area = area;
        this.lastArea = initializeList();
        this.nextArea = initializeList();
    }

    /**
     * Creates a new 2D List initialized with .
     * @return A new List of Lists of characters
     */
    private List<List<Character>> initializeList() {
        List<List<Character>> newList = new ArrayList<>();
        for (int i = 0; i < area.size(); i++) {
            newList.add(new ArrayList<>(area.get(0).size()));
            for (int j = 0; j < area.get(0).size(); j++) {
                newList.get(i).add('.');
            }
        }
        return newList;
    }

    /**
     * Creates a deep copy of a given 2D List of Lists
     * @param list List to be copied
     * @return A deep copy of that list
     */
    private List<List<Character>> deepCopyList(List<List<Character>> list) {
        List<List<Character>> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(new ArrayList<>(list.get(0).size()));
            for (int j = 0; j < list.get(0).size(); j++) {
                newList.get(i).add(list.get(i).get(j));
            }
        }
        return newList;
    }

    /**
     * Gets the input from a file
     * @param name The file's name
     * @return The waiting area represented as a WaitingArea object
     */
    public static WaitingArea getFromFile(String name) {
        List<List<Character>> area = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                area.add(scanner.nextLine().chars().mapToObj(x -> (char) x).collect(Collectors.toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new WaitingArea(area);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Character> characters : area) {
            for (int j = 0; j < area.get(0).size(); j++) {
                builder.append(characters.get(j));
            }
            builder.append('\n');
        }

        return builder.toString();
    }

    /**
     * Goes to the next round
     */
    public void nextRound() {
        for (int i = 0; i < area.size(); i++) {
            for (int j = 0; j < area.get(0).size(); j++) {
                change(i, j);
            }
        }
        lastArea = deepCopyList(area);
        area = deepCopyList(nextArea);
    }

    /**
     * Automatically runs until the the area doesn't change
     */
    public void runUntilStateNotChanging() {
        while (stateHasChanged()) {
            nextRound();
        }
    }

    /**
     *
     * @return true if state has changed, otherwise false
     */
    public boolean stateHasChanged() {
        for (int i = 0; i < area.size(); i++) {
            for (int j = 0; j < area.get(0).size(); j++) {
                if (area.get(i).get(j) != lastArea.get(i).get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * At given coordinates changes the seat from empty to occupied if there are no adjacent occupied seats
     * and from occupied to empty if the number of adjacent occupied seats is greater or equal to 4
     * @param x The x coordinate
     * @param y The y coordinate
     */
    private void change(int x, int y) {
        char currentChar = area.get(x).get(y);

        if (currentChar == 'L' && numberAdjacentOccupied(x, y) == 0) {
            nextArea.get(x).set(y, '#');
        } else if (currentChar == '#' && numberAdjacentOccupied(x, y) >= 4) {
            nextArea.get(x).set(y, 'L');
        }
    }

    /**
     * Checks whether tile with given coordinates is occupied
     * @param x The x coordinate of the tile
     * @param y The y coordinate of the tile
     * @return true if tile is an occupied seat otherwise false
     */
    private boolean isOccupied(int x, int y) {
        return x < area.size() && x >= 0 && y < area.get(0).size() && y >= 0 && area.get(x).get(y) == '#';
    }

    /**
     * A member that returns the number of occupied seats directly adjacent to a given seat
     * @param x The x coordinate
     * @param y The y coordinate
     * @return An integer number of adjacent seats that are occupied
     */
    private int numberAdjacentOccupied(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(j == 0 && i == j) && isOccupied(x + i, y + j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * A member that gives the number of all occupied seats
     * @return An integer of the number of occupied seats
     */
    public int getNumberOccupiedTotal() {
        int sum = 0;
        for (List<Character> characters : area) {
            for (char character : characters) {
                if (character == '#') {
                    sum++;
                }
            }
        }
        return sum;
    }
}
