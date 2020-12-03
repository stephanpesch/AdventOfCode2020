public class Main {
    public static void main(String[] args) {
        Map map = Map.mapFromFile("input");

        Toboggan[] toboggans = new Toboggan[] {
                new Toboggan(1, 1),
                new Toboggan(3, 1), // Tree from first part
                new Toboggan(5,1),
                new Toboggan(7,1),
                new Toboggan(1, 2)};

        long treesMultiplied = 1;

        for (int i = 0; i < toboggans.length; i++) {
            int trees = map.amountOfTrees(toboggans[i]);
            System.out.printf("Toboggan %d: %d%n", i, trees);
            treesMultiplied *= trees;
        }

        System.out.println("All trees multiplied together: " + treesMultiplied);
    }
}
