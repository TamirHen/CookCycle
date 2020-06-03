package com.cookCycle.junitTests;

import com.cookCycle.model.IngredientsInRecipes;
import com.cookCycle.model.Recipe;
import com.cookCycle.repository.RecipeRepository;
import com.cookCycle.service.RecipeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RecipeTests {

    @Mock
    private RecipeRepository recipeMockRepository;

    @InjectMocks
    private RecipeService recipeMockService;

    @Test
    public void getAllRecipesShouldReturnCorrectNumberOfRecipes() {
        final List<Recipe> recipes = new ArrayList<>();
        final List<IngredientsInRecipes> ingredientsInRecipe = new ArrayList<>();
        ingredientsInRecipe.add(new IngredientsInRecipes("spaghetti"));
        for (int i = 1; i <= 3; i++) {

            recipes.add(new Recipe(
                    "test author",
                    "spaghetti bolognese",
                    "Some instructions for spaghetti bolognese",
                    ingredientsInRecipe,
                    "serves 4",
                    "10 mins",
                    "10 mins",
                    "Some image url"
            ));
            /* Set id manually (because DB responsible for this). */
            recipes.get(i-1).setId(new Long(i));
        }
        Mockito.when(recipeMockRepository.findAll()).thenReturn(recipes);
        final List<Recipe> expected = recipeMockService.getAllRecipes();

        Assert.assertEquals(expected.size(), recipes.size());
    }

    @Test
    public void whenCallingGetRecipeByIdItCallsFindByIdOnce() throws Throwable {
        final Long id = new Long(1);
        final List<IngredientsInRecipes> ingredientsInRecipe = new ArrayList<>();
        ingredientsInRecipe.add(new IngredientsInRecipes("spaghetti"));
        final Recipe recipe = new Recipe(
                "test author",
                "spaghetti bolognese",
                "Some instructions for spaghetti bolognese",
                ingredientsInRecipe,
                "serves 4",
                "10 mins",
                "10 mins",
                "Some image url"
        );
        /* Set id manually (because DB responsible for this). */
        recipe.setId(id);
        Mockito.when(recipeMockRepository.findById(id)).thenReturn(Optional.of(recipe));
        final Recipe expected = recipeMockService.getRecipeById(id);
        Mockito.verify(recipeMockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenCallingGetRecipeByIdItReturnsRecipeObject() throws Throwable {
        final Long id = new Long(2);
        final List<IngredientsInRecipes> ingredientsInRecipe = new ArrayList<>();
        ingredientsInRecipe.add(new IngredientsInRecipes("spaghetti"));
        final Recipe recipe = new Recipe(
                "test author",
                "spaghetti bolognese",
                "Some instructions for spaghetti bolognese",
                ingredientsInRecipe,
                "serves 4",
                "10 mins",
                "10 mins",
                "Some image url"
        );
        /* Set id manually (because DB responsible for this). */
        recipe.setId(id);
        Mockito.when(recipeMockRepository.findById(id)).thenReturn(Optional.of(recipe));
        final Recipe expected = recipeMockService.getRecipeById(id);
        Assert.assertNotNull(expected);
        Assert.assertEquals(recipe, expected);
    }
}
