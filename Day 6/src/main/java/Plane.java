import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Plane {

    List<Group> groups = new ArrayList<>();

    public void addGroup(Group group) {
        groups.add(group);
    }

    public int getSumOfCounts() {
        return groups.stream().mapToInt(Group::getNumberOfAnswers).sum();
    }

    public static Plane getFromFile(String file) {
        Plane plane = new Plane();
        Group group = new Group();
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    plane.addGroup(group);
                    group = new Group();
                    continue;
                }
                group.retainAnswers(line.chars().mapToObj(x -> (char) x).collect(Collectors.toSet()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plane;
    }

    private static List<Character> charArrayToList(char[] array) {
        List<Character> charList = new ArrayList<>();
        for (char c : array) {
            charList.add(c);
        }
        return charList;
    }
}
