package com.cookCycle.junitTests;

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

import java.sql.Time;
import java.sql.Timestamp;
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
        for (int i = 1; i <= 3; i++) {
            byte vFalse = 0;
            byte vTrue = 1;
            recipes.add(new Recipe(
                    100 + i,
                    "source for test",
                    "Spaghetti Bolognese",
                    "Some instructions for spaghetti bolognese",
                    4,
                    10,
                    10,
                    1,
                    "Some image url",
                    "Italian",
                    new Byte(vFalse),
                    new Byte(vFalse),
                    new Byte(vFalse),
                    new Byte(vTrue)
            ));
            recipes.get(i-1).setId(i); // set id manually (because DB responsible for this).
        }
        Mockito.when(recipeMockRepository.findAll()).thenReturn(recipes);
        final List<Recipe> expected = recipeMockService.getAllRecipes();

        Assert.assertEquals(expected.size(), recipes.size());
    }

    @Test
    public void testThatWhenCallingGetRecipeByIdItCallsFindByIdOnce() {
        final int id = 1;
        byte vFalse = 0;
        byte vTrue = 1;
        final Recipe recipe = new Recipe(
                100,
                "source for test",
                "Spaghetti Bolognese",
                "Some instructions for spaghetti bolognese",
                4,
                10,
                10,
                1,
                "Some image url",
                "Italian",
                new Byte(vFalse),
                new Byte(vFalse),
                new Byte(vFalse),
                new Byte(vTrue)
        );
        recipe.setId(id);
        Mockito.when(recipeMockRepository.findById(id)).thenReturn(Optional.of(recipe));
        final Recipe expected = recipeMockService.getRecipeById(id);
        Mockito.verify(recipeMockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testThatWhenCallingGetRecipeByIdItReturnsRecipeObject() {
        final int id = 2;
        byte vFalse = 0;
        byte vTrue = 1;
        final Recipe recipe = new Recipe(
                100,
                "source for test",
                "Spaghetti Bolognese",
                "Some instructions for spaghetti bolognese",
                4,
                10,
                10,
                1,
                "Some image url",
                "Italian",
                new Byte(vFalse),
                new Byte(vFalse),
                new Byte(vFalse),
                new Byte(vTrue)
        );
        recipe.setId(id);
        Mockito.when(recipeMockRepository.findById(id)).thenReturn(Optional.of(recipe));
        final Recipe expected = recipeMockService.getRecipeById(id);
        Assert.assertNotNull(expected);
        Assert.assertEquals(recipe, expected);
    }
}
