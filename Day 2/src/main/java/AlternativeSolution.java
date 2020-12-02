import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlternativeSolution {
    public static void main(String[] args) {
        List<String[]> lines;
        try {
            lines = Files.lines(Paths.get("input"))
                    .map(line -> line.split("-|\\s|(:\\s)"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            lines = new ArrayList<>();
        }

        System.out.println("Solution 1: ");
        System.out.println(lines.stream()
                .filter(line ->
                        (line[3].length() - line[3].replace(line[2], "").length()) >= Integer.parseInt(line[0]) &&
                                (line[3].length() - line[3].replace(line[2], "").length()) <= Integer.parseInt(line[1]))
                .count());

        System.out.println("Solution 2:");
        System.out.println(lines.stream()
                .filter(line -> ((line[3].charAt(Integer.parseInt(line[0]) - 1) == line[2].charAt(0))
                        ^ (line[3].charAt(Integer.parseInt(line[1]) - 1) == line[2].charAt(0))))
                .count());
    }
}
