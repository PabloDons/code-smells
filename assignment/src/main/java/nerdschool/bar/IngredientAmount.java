package nerdschool.bar;

public class IngredientAmount {
    private final Ingredient ingredient;
    private final double amount;

    public IngredientAmount(Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public IngredientAmount(Ingredient ingredient) {
        this(ingredient, 1);
    }

    public int getPrice() {
        return (int) (ingredient.price*amount);
    }

    public double getAmount() {
        return amount;
    }
}
