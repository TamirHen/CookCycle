package com.cookCycle.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@MappedSuperclass
@SqlResultSetMapping(name = "AvailableRecipe", classes = @ConstructorResult(targetClass = AvailableRecipe.class, columns = {
        @ColumnResult(name = "recipeId", type = Long.class),
        @ColumnResult(name = "numOfMissingIngredients", type = int.class)
}))
public class AvailableRecipe {
    private Long recipeId;
    private int numOfMissingIngredients;

    private Recipe recipe;

    public AvailableRecipe(Long recipeId, int numOfMissingIngredients) {
        this.recipeId = recipeId;
        this.numOfMissingIngredients = numOfMissingIngredients;
    }

}
