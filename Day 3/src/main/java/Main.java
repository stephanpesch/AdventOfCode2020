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

        for (Toboggan toboggan : toboggans) {
            int trees = map.amountOfTrees(toboggan);
            System.out.println(trees);
            treesMultiplied *= trees;
        }

        System.out.println(treesMultiplied);
    }
}
