import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The data can be represented as a directed graph
 */
public class Graph {

    private final Map<Long, Set<Long>> graph = new HashMap<>();
    private final Map<Long, Long> cache = new HashMap<>();

    /**
     * Gets a file by file name and returns a graph representation of the content
     *
     * @param name File name
     * @return A graph representing the file
     */
    public static Graph getFromFile(String name) {
        Set<Long> numbers;
        Graph graph = new Graph();
        try {
            numbers = Files.lines(Paths.get(name)).map(Long::parseLong).collect(Collectors.toCollection(HashSet::new));
            numbers.add(0L);
            // numbers need to be in a SortedSet for this
            numbers.add(Collections.max(numbers) + 3);
            for (long i : numbers) {
                graph.addNode(i);
                for (int j = 1; j <= 3; j++) {
                    long newValue = i + j;
                    if (numbers.contains(newValue)) {
                        graph.addEdge(i, newValue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }


    /**
     * Gets the product of amounts of 1-difference and 3-differences
     *
     * @return The product of the amounts of the differences
     */
    public long getAmountOneDifferenceAndThreeDifferenceProduct() {
        long oneCount = 0;
        long threeCount = 0;
        for (Map.Entry<Long, Set<Long>> entry : graph.entrySet()) {
            long key = entry.getKey();
            Set<Long> values = entry.getValue();
            if (values.contains(key + 1)) {
                oneCount++;
            } else if (!values.contains(key + 2) && values.contains(key + 3)) {
                threeCount++;
            }
        }
        return oneCount * threeCount;
    }

    /**
     * Method to add a node to the graph a
     *
     * @param i Node
     */
    public void addNode(long i) {
        graph.put(i, new HashSet<>());
    }

    /**
     * Adds an edge to an existing node
     *
     * @param from From node
     * @param to   To node
     */
    public void addEdge(long from, long to) {
        graph.get(from).add(to);
    }

    /**
     * Get the set of all nodes in this graph
     *
     * @return A Set of all nodes
     */
    public Set<Long> getNodeSet() {
        return graph.keySet();
    }

    /**
     * @param node Node to start from
     * @return The number of all possible ways to get to the last node
     */
    public long traverse(long node) {
        // The next set of nodes to be traversed
        Set<Long> nextNodes = graph.get(node);
        long sum = 0;
        // If the node is not connected to another node, return 1
        if (nextNodes.isEmpty()) {
            return 1;
        }
        // If the node is already known get the sum cached
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        // Traverse each node connected to this node
        for (long i : nextNodes) {
            sum += traverse(i);
        }
        // Put the node into the map so the solution doesn't have to be brute forced
        cache.put(node, sum);
        return sum;
    }

    /**
     * String representation of this graph
     *
     * @return A string representation
     */
    @Override
    public String toString() {
        return graph.toString();
    }
}
