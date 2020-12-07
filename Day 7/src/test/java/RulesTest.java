import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RulesTest {

    Rules rules = new Rules();
    Bag lightRed;
    Bag darkOrange;
    Bag brightWhite;
    Bag mutedYellow;
    Bag shinyGold;
    Bag darkOlive;
    Bag vibrantPlum;
    Bag fadedBlue;
    Bag dottedBlack;

    @Before
    public void initialize() {
        lightRed = new Bag("light", "red");
        darkOrange = new Bag("dark", "orange");
        brightWhite = new Bag("bright", "white");
        mutedYellow = new Bag("muted", "yellow");
        shinyGold = new Bag("shiny", "gold");
        darkOlive = new Bag("dark", "olive");
        vibrantPlum = new Bag("vibrant", "plum");
        fadedBlue = new Bag("faded", "blue");
        dottedBlack = new Bag("dotted", "black");

        rules.addBag(lightRed);
        rules.addEdge(lightRed, brightWhite,1);
        rules.addEdge(lightRed, mutedYellow, 2);

        rules.addBag(darkOrange);
        rules.addEdge(darkOrange, brightWhite, 3);
        rules.addEdge(darkOrange, mutedYellow, 4);

        rules.addBag(brightWhite);
        rules.addEdge(brightWhite, shinyGold, 1);

        rules.addBag(mutedYellow);
        rules.addEdge(mutedYellow, shinyGold, 2);
        rules.addEdge(mutedYellow, fadedBlue, 9);

        rules.addBag(shinyGold);
        rules.addEdge(shinyGold, darkOlive, 1);
        rules.addEdge(shinyGold, vibrantPlum, 2);

        rules.addBag(darkOlive);
        rules.addEdge(darkOlive, fadedBlue, 3);
        rules.addEdge(darkOlive, dottedBlack, 4);

        rules.addBag(vibrantPlum);
        rules.addEdge(vibrantPlum, fadedBlue, 5);
        rules.addEdge(vibrantPlum, dottedBlack, 6);

        rules.addBag(fadedBlue);

        rules.addBag(dottedBlack);
    }

    @Test
    public void rulesFromFileEqualInitializedRules() {
        Map<Bag, Integer> bagIntegerMap = rules.getBag(new Bag("shiny", "gold"));
        Map<Bag, Integer> referenceMap = new HashMap<>();
        referenceMap.put(darkOlive, 1);
        referenceMap.put(vibrantPlum, 2);
        assertEquals(referenceMap, bagIntegerMap);
    }
}
