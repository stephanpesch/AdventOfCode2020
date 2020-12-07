public class Main {
    public static void main(String[] args) {
        Rules rules = Rules.getFromFile("input");

        Bag shinyGold = new Bag("shiny", "gold");
        System.out.println(rules.amountBagsInBag(shinyGold) - 1);
    }
}
