import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String[]> instructions = readFile("testinput");
        int accumulator = 0;
        int lineNumber = 0;
        Set<Integer> linesRead = new HashSet<>();

        while (!linesRead.contains(lineNumber) && lineNumber < instructions.size()) {
            String operation = instructions.get(lineNumber)[0];
            int argument = Integer.parseInt(instructions.get(lineNumber)[1]);
            // Adds the current line number to the set so execution can be cancelled
            linesRead.add(lineNumber);
            System.out.printf("Line %d: %s %d%n", lineNumber, operation, argument);

            switch (operation) {
                case "acc":
                    accumulator += argument;
                    lineNumber++;
                    break;
                case "jmp":
                    lineNumber += argument;
                    break;
                case "nop":
                    lineNumber++;
                    break;
            }
            System.out.println("Accumulator: " + accumulator);
        }
    }

    private static List<String[]> readFile(String name) {
        try {
            return Files.readAllLines(Paths.get(name)).stream()
                    .map(s -> s.split(" "))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
