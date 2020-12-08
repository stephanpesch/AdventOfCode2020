import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String[]> instructions = readFile("input");
        int accumulator = 0;
        int lineNumber = 0;
        Set<Integer> linesRead = new HashSet<>();

        while (!linesRead.contains(lineNumber)) {
            String operation = instructions.get(lineNumber)[0];
            int argument = Integer.parseInt(instructions.get(lineNumber)[1]);
            linesRead.add(lineNumber);
            System.out.println("Line: " + lineNumber);

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
            }
        }
        System.out.println("Accumulator: " + accumulator);
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
