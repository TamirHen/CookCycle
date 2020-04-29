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
        ingredientsInRecipe.add(new IngredientsInRecipes(new Long(1), "milk", new Double(1), "cup", "example"));
        for (int i = 1; i <= 3; i++) {

            recipes.add(new Recipe(
                    new Long(100 + i),
                    "source for test",
                    "Spaghetti Bolognese",
                    "Some instructions for spaghetti bolognese",
                    ingredientsInRecipe,
                    4,
                    10,
                    10,
                    new Long(1),
                    "Some image url",
                    "Italian",
                    false,
                    false,
                    false,
                    true
            ));
            recipes.get(i-1).setId(new Long(i)); // set id manually (because DB responsible for this).
        }
        Mockito.when(recipeMockRepository.findAll()).thenReturn(recipes);
        final List<Recipe> expected = recipeMockService.getAllRecipes();

        Assert.assertEquals(expected.size(), recipes.size());
    }

    @Test
    public void testThatWhenCallingGetRecipeByIdItCallsFindByIdOnce() throws Throwable {
        final Long id = new Long(1);
        final List<IngredientsInRecipes> ingredientsInRecipe = new ArrayList<>();
        ingredientsInRecipe.add(new IngredientsInRecipes(new Long(1), "milk", new Double(1), "cup", "example"));
        final Recipe recipe = new Recipe(
                new Long(100),
                "source for test",
                "Spaghetti Bolognese",
                "Some instructions for spaghetti bolognese",
                ingredientsInRecipe,
                4,
                10,
                10,
                new Long(1),
                "Some image url",
                "Italian",
                false,
                false,
                false,
                true
        );
        recipe.setId(id);
        Mockito.when(recipeMockRepository.findById(id)).thenReturn(Optional.of(recipe));
        final Recipe expected = recipeMockService.getRecipeById(id);
        Mockito.verify(recipeMockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testThatWhenCallingGetRecipeByIdItReturnsRecipeObject() throws Throwable {
        final Long id = new Long(2);
        final List<IngredientsInRecipes> ingredientsInRecipe = new ArrayList<>();
        ingredientsInRecipe.add(new IngredientsInRecipes(new Long(1), "milk", new Double(1), "cup", "example"));
        final Recipe recipe = new Recipe(
                new Long(100),
                "source for test",
                "Spaghetti Bolognese",
                "Some instructions for spaghetti bolognese",
                ingredientsInRecipe,
                4,
                10,
                10,
                new Long(1),
                "Some image url",
                "Italian",
                false,
                false,
                false,
                true
        );
        recipe.setId(id);
        Mockito.when(recipeMockRepository.findById(id)).thenReturn(Optional.of(recipe));
        final Recipe expected = recipeMockService.getRecipeById(id);
        Assert.assertNotNull(expected);
        Assert.assertEquals(recipe, expected);
    }
}
