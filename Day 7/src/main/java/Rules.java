import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Rules {

    private Map<Bag, List<Bag>> canContain;

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
                rules.addEdge(bag, new Bag(lineArray[i + 1], lineArray[i + 2]));
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
        canContain.putIfAbsent(bag, new ArrayList<>());
    }

    public void removeBag(Bag bag) {
        canContain.values().forEach(e -> e.remove(bag));
    }

    public void addEdge(Bag outBag, Bag inBag) {
        if (!canContain.containsKey(inBag)) {
            addBag(inBag);
        }

        canContain.get(inBag).add(outBag);
    }

    public List<Bag> getBag(Bag bag) {
        return canContain.get(bag);
    }

    public Set<Bag> getBagSet() {
        return canContain.keySet();
    }

    public Map<Bag, List<Bag>> getCanContain() {
        return canContain;
    }

    public Set<Bag> getContainingBags(Bag bag) {
        // Maybe done wrongly
        List<Bag> bags = canContain.get(bag);
        Set<Bag> bagSet = new HashSet<>(bags);
        for (Bag b : bags) {
            bagSet.addAll(getContainingBags(b));
        }
        return bagSet;
    }

    public int howManyCanContain(Bag bag) {
        return getContainingBags(bag).size();
    }
}
