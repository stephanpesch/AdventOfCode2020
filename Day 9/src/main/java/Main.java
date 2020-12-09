import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Long> numbers = getFromFile("input");
        int intervalLength = 25; // Set to 5 to test

        long number = getFirstNumber(numbers, intervalLength);
        long min = getListOfNumbersAddingUpTo(numbers, number).stream().mapToLong(x -> x).min().orElse(0);
        long max = getListOfNumbersAddingUpTo(numbers, number).stream().mapToLong(x -> x).max().orElse(0);
        System.out.println(max + min);
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

    private static long getFirstNumber(List<Long> numbers, int intervalLength) {
        loop: for (int i = intervalLength; i < numbers.size(); i++) {
            Set<Long> subSet = new HashSet<>(numbers.subList(i - intervalLength, i));
            long number = numbers.get(i);
            for (long l : subSet) {
                long difference = number - l;
                if (difference != l && subSet.contains(difference)) {
                    continue loop;
                }
            }
            return number;
        }
        return -1;
    }

    private static List<Long> getListOfNumbersAddingUpTo(List<Long> numbers, long number) {
        for (int interval = 2; interval < numbers.size(); interval++) {
            List<Long> subList = searchForSubListOfSizeWithSumOfOrNull(numbers, number, interval);
            if (subList != null) {
                return subList;
            }
        }
        return new ArrayList<>();
    }

    private static List<Long> searchForSubListOfSizeWithSumOfOrNull(List<Long> numbers, long number, int interval) {
        for (int index = 0; index < numbers.size() - interval; index++) {
            List<Long> subList = numbers.subList(index, index + interval);
            if (subList.stream().mapToLong(x -> x).sum() == number) {
                return subList;
            }
        }
        return null;
    }
}
