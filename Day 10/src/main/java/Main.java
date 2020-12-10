public class Main {
    public static void main(String[] args) {
        Graph graph = Graph.getFromFile("input");

        // Solution to part 1
        System.out.printf("Product of amount of 1-differences and 3-differences: %d%n",
                graph.getAmountOneDifferenceAndThreeDifferenceProduct());

        // Solution to part 2
        System.out.printf("Number of all possible ways to arrange the adapter: %d%n", graph.traverse(0));
    }
}
