import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> input = getFromFile("input");
        List<Integer> busIDs = new ArrayList<>();

        int timeStamp = Integer.parseInt(input.get(0));
        String[] busIDStrings = input.get(1).split(",");

        for (String s : busIDStrings) {
            if (!"x".equals(s)) {
                busIDs.add(Integer.parseInt(s));
            }
        }

        boolean found = false;

        for (int i = timeStamp; !found; i++) {
            int id = integerDivisibleByAnyInList(i, busIDs);
            if (id != -1) {
                System.out.printf("ID: %d, minutes to wait: %d, result: %d", id, i - timeStamp, id * (i - timeStamp));
                found = true;
            }
        }
    }

    private static List<String> getFromFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename));
    }

    private static int integerDivisibleByAnyInList(int number, List<Integer> numbers) {
        for (int n : numbers) {
            if (number % n == 0) {
                return n;
            }
        }
        return -1;
    }
}
