import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Map {

    private char[][] map;

    public Map(char[][] map) {
        this.map = map;
    }

    public static Map mapFromFile(String name) {
        char[][] map = new char[323][31];
        int count = 0;
        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                map[count] = line.toCharArray();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Map(map);
    }

    public char get(int right, int down) {
        int width = width();
        if (down > map.length) {
            return '.';
        }
        return map[down][right % width];
    }

    public int height() {
        return map.length;
    }

    public int width() {
        return map[0].length;
    }

    public int amountOfTrees(Toboggan toboggan) {
        int count = 0;
        for (int i = 0; i < height() - 1; i++) {
            toboggan.move();
            count += get(toboggan.getRight(), toboggan.getDown()) == '#' ? 1 : 0;
        }
        return count;
    }
}
