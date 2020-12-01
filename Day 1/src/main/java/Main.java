import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int sum = 2020;
        List<Integer> integers = getListFromInputFile("input");
        System.out.println("Answer of the first part:");
        System.out.println(getIntegerPairWithSumAndReturnTheirProduct(sum, integers));
        System.out.println("Answer of the second part:");
        System.out.println(getThreeIntegersWithSumAndReturnTheirProduct(sum, integers));
    }

    /**
     * Opens a file and returns a list of ints
     * @param file File name of the file containing the integers
     * @return A list of all integers in that file
     */
    private static List<Integer> getListFromInputFile(String file) {
        try {
            ArrayList<Integer> integers = new ArrayList<>();
            List<String> strings = Files.readAllLines(Paths.get(file));
            for (String string : strings) {
                integers.add(Integer.parseInt(string));
            }
            return integers;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Returns the product of two integers with a sum given as an argument
     * @param sum The integer those two integers should sum up to
     * @param integers A list of integers
     * @return The product of those two integers, if none is found returns -1
     */
    private static int getIntegerPairWithSumAndReturnTheirProduct(int sum, List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i; j < integers.size(); j++) {
                if (i != j && integers.get(i) + integers.get(j) == sum) {
                    return integers.get(i) * integers.get(j);
                }
            }
        }
        return -1;
    }

    /**
     * Returns the product of three integers with a sum given as an argument
     * @param sum The integer three integers should sum up to
     * @param integers A list of integers
     * @return The product of three integers, if none is found returns -1
     */
    private static int getThreeIntegersWithSumAndReturnTheirProduct(int sum, List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i; j < integers.size(); j++) {
                for (int k = j; k < integers.size(); k++) {
                    if (i != j && j != k && integers.get(i) + integers.get(j) + integers.get(k) == sum) {
                        return integers.get(i) * integers.get(j) * integers.get(k);
                    }
                }
            }
        }
        return -1;
    }
}
