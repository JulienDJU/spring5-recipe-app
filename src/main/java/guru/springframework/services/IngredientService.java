package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

/**
 * Created by jt on 6/27/17.
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId, Long ingredientId);
}