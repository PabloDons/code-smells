package nerdschool.bar;

import java.util.Arrays;
import java.util.List;

public class MixedDrink implements Beverage {
    List<IngredientAmount> ingredients;
    String name;

    public MixedDrink(IngredientAmount... ingredientAmounts) {
        this.ingredients = Arrays.asList(ingredientAmounts);
    }

    public MixedDrink(Ingredient... ingredients) {
        IngredientAmount[] tmp = new IngredientAmount[ingredients.length];

        for (int i = 0; i < ingredients.length; i++) {
            Ingredient ingredient = ingredients[i];

            tmp[i] = new IngredientAmount(ingredient);
        }

        this.ingredients = Arrays.asList(tmp);
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (IngredientAmount ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        return price;
    }

    @Override
    public boolean hasUpperLimit() {
        return true;
    }

    @Override
    public boolean hasStudentDiscount() {
        return false;
    }
}
