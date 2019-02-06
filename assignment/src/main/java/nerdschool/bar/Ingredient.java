package nerdschool.bar;

public enum Ingredient {
    GIN(85), TONIC_WATER(20), GREEN_STUFF(10), LIME_JUICE(10), GRENADINE(10), RUM(65);

    public final int price;

    Ingredient(int price) {

        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
