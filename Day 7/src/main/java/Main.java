public class Main {
    public static void main(String[] args) {
        Rules rules = Rules.getFromFile("input");

        Bag shinyGold = new Bag("shiny", "gold");
        System.out.println(rules.howManyCanContain(shinyGold));
    }

    private static void test() {
        Rules rules = new Rules();

        Bag lightRed = new Bag("light", "red");
        Bag darkOrange = new Bag("dark", "orange");
        Bag brightWhite = new Bag("bright", "white");
        Bag mutedYellow = new Bag("muted", "yellow");
        Bag shinyGold = new Bag("shiny", "gold");
        Bag darkOlive = new Bag("dark", "olive");
        Bag vibrantPlum = new Bag("vibrant", "plum");
        Bag fadedBlue = new Bag("faded", "blue");
        Bag dottedBlack = new Bag("dotted", "black");

        rules.addBag(lightRed);
        rules.addEdge(lightRed, brightWhite);
        rules.addEdge(lightRed, mutedYellow);

        rules.addBag(darkOrange);
        rules.addEdge(darkOrange, brightWhite);
        rules.addEdge(darkOrange, mutedYellow);

        rules.addBag(brightWhite);
        rules.addEdge(brightWhite, shinyGold);

        rules.addBag(mutedYellow);
        rules.addEdge(mutedYellow, shinyGold);
        rules.addEdge(mutedYellow, fadedBlue);

        rules.addBag(shinyGold);
        rules.addEdge(shinyGold, darkOlive);
        rules.addEdge(shinyGold, vibrantPlum);

        rules.addBag(darkOlive);
        rules.addEdge(darkOlive, fadedBlue);
        rules.addEdge(darkOlive, dottedBlack);

        rules.addBag(vibrantPlum);
        rules.addEdge(vibrantPlum, fadedBlue);
        rules.addEdge(vibrantPlum, dottedBlack);

        rules.addBag(fadedBlue);

        rules.addBag(dottedBlack);

        System.out.println(rules.getCanContain());
    }
}
