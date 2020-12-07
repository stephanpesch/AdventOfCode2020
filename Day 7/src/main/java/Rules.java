import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Rules {

    private Map<Bag, Map<Bag, Integer>> canContain;

    public Rules() {
        canContain = new HashMap<>();
    }

    public static Rules getFromFile(String name) {
        Rules rules = new Rules();
        try (Scanner scanner = new Scanner(Paths.get(name))) {
            while (scanner.hasNext()) {
                readLineIntoRules(rules, scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rules;
    }

    private static void readLineIntoRules(Rules rules, String line) {
        int startIndex = 4;
        int indexAdd = 4;
        String[] lineArray = line.replace(",", "")
                .replace(".", "")
                .split(",?\\s");
        Bag bag = new Bag(lineArray[0], lineArray[1]);
        rules.addBag(bag);
        for (int i = startIndex; i < lineArray.length; i += indexAdd) {
            if (!"no".equals(lineArray[i])) {
                rules.addEdge(bag, new Bag(lineArray[i + 1], lineArray[i + 2]), Integer.parseInt(lineArray[i]));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Rules)) {
            return false;
        }

        Rules rules = (Rules) obj;

        return canContain.equals(rules.canContain);
    }

    public void addBag(Bag bag) {
        canContain.putIfAbsent(bag, new HashMap<>());
    }

    public void addEdge(Bag outBag, Bag inBag, int amount) {
        if (!canContain.containsKey(inBag)) {
            addBag(inBag);
        }
        canContain.get(outBag).put(inBag, amount);
    }

    public Map<Bag, Integer> getBag(Bag bag) {
        return canContain.get(bag);
    }

    public Set<Bag> getBagSet() {
        return canContain.keySet();
    }

    public Map<Bag, Map<Bag, Integer>> getCanContain() {
        return canContain;
    }

    public Set<Bag> getContainingBags(Bag bag) {
        // Maybe done wrongly
        Map<Bag, Integer> bags = canContain.get(bag);
        Set<Bag> bagSet = new HashSet<>(bags.keySet());
        for (Bag b : bags.keySet()) {
            bagSet.addAll(getContainingBags(b));
        }
        return bagSet;
    }

    public int amountColorsInBag(Bag bag) {
        return getContainingBags(bag).size();
    }

    public int amountBagsInBag(Bag bag) {
        Map<Bag, Integer> bagIntegerMap = canContain.get(bag);
        int sum = 1;
        if (!bagIntegerMap.isEmpty()) {
            for (Bag b : bagIntegerMap.keySet()) {
                sum += (bagIntegerMap.get(b) * amountBagsInBag(b));
            }
        }
        return sum; // Off by one
    }
}
