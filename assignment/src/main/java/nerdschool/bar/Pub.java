package nerdschool.bar;

import java.util.HashMap;

import static nerdschool.bar.Ingredient.*;

public class Pub {
    HashMap<String, Beverage> menu = new HashMap<>();

    public static final String BEER_HANSA = "hansa";
    public static final String CIDER_GRANS = "grans";
    public static final String CIDER_STRONGBOW = "strongbow";
    public static final String DRINK_GT = "gt";
    public static final String DRINK_BACARDI = "bacardi_special";
    private int MAX_ALLOWED_DRINKS;

    public Pub() {
        menu.put(DRINK_GT, new MixedDrink(GIN, TONIC_WATER, GREEN_STUFF));
        menu.put(DRINK_BACARDI, new MixedDrink(
                new IngredientAmount(GIN, 0.5),
                new IngredientAmount(RUM),
                new IngredientAmount(GRENADINE),
                new IngredientAmount(LIME_JUICE)
        ));
        menu.put(BEER_HANSA, new SimpleBeverage( 74));
        menu.put(CIDER_GRANS, new SimpleBeverage(103));
        menu.put(CIDER_STRONGBOW, new SimpleBeverage(110));
//        addItemToMenu("strongbow", 110);
    }

    public int computeCost(String drink, boolean student, int amount) {
        int price;
        if (!menu.containsKey(drink)) {
            throw new RuntimeException("No such drink exists");
        }
        Beverage beverage = menu.get(drink);

        MAX_ALLOWED_DRINKS = 2;
        if (amount > MAX_ALLOWED_DRINKS && (beverage.hasUpperLimit())) {
            throw new RuntimeException("Too many drinks, max "+MAX_ALLOWED_DRINKS+".");
        }
        price = beverage.getPrice();
        if (student && (beverage.hasStudentDiscount())) {
            price = price - price/10;
        }
        return price*amount;
    }

    //one unit of rum
    private int rumPrice() {
        return 65;
    }

    //one unit of grenadine
    private int grenadinePrice() {
        return 10;
    }

    //one unit of lime juice
    private int limeJuicePrice() {
        return 10;
    }
    
    //one unit of green stuff
    private int greenStuffPrice() {
        return 10;
    }

    //one unit of tonic water
    private int tonicWaterPrice() {
        return 20;
    }

    //one unit of gin
    private int ginPrice() {
        return 85;
    }
}
