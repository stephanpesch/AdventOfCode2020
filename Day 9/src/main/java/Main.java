import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Long> numbers = getFromFile("input");
        int intervalLength = 25; // Set to 5 to test

        loop: for (int i = intervalLength; i < numbers.size(); i++) {
            List<Long> subList = numbers.subList(i - intervalLength, i);
            long number = numbers.get(i);
            for (long l : subList) {
                long difference = number - l;
                if (difference != l && subList.contains(difference)) {
                    continue loop;
                }
            }
            System.out.printf("First number: %d", number);
            break;
        }
    }

    private static List<Long> getFromFile(String name) {
        List<Long> list = new ArrayList<>();
        try {
            list.addAll(Files.lines(Paths.get(name)).map(Long::parseLong).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
