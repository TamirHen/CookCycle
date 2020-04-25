package com.cookCycle.junitTests;

import com.cookCycle.model.Ingredient;
import com.cookCycle.repository.IngredientRepository;
import com.cookCycle.service.IngredientService;
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
public class IngredientTests {

    @Mock
    private IngredientRepository ingredientMockRepository;

    @InjectMocks
    private IngredientService ingredientMockService;

    @Test
    public void getAllIngredientsShouldReturnCorrectNumberOfIngredients() {
        final List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            byte vFalse = 0;
            byte vTrue = 1;
            ingredients.add(new Ingredient(
                    200 + i,
                    "butter",
                    1,
                    "Some image url",
                    new Byte(vTrue),
                    new Byte(vTrue),
                    new Byte(vFalse),
                    new Byte(vFalse)
            ));
            ingredients.get(i-1).setId(i); // set id manually (because DB responsible for this).
        }
        Mockito.when(ingredientMockRepository.findAll()).thenReturn(ingredients);
        final List<Ingredient> expected = ingredientMockService.getAllIngredients();

        Assert.assertEquals(expected.size(), ingredients.size());
    }

    @Test
    public void testThatWhenCallingGetIngredientByIdItCallsFindByIdOnce() {
        final int id = 1;
        byte vFalse = 0;
        byte vTrue = 1;
        final Ingredient ingredient = new Ingredient(
                200,
                "butter",
                1,
                "Some image url",
                new Byte(vTrue),
                new Byte(vTrue),
                new Byte(vFalse),
                new Byte(vFalse)
        );
        ingredient.setId(id);
        Mockito.when(ingredientMockRepository.findById(id)).thenReturn(Optional.of(ingredient));
        final Ingredient expected = ingredientMockService.getIngredientById(id);
        Mockito.verify(ingredientMockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testThatWhenCallingGetIngredientByIdItReturnsIngredientObject() {
        final int id = 2;
        byte vFalse = 0;
        byte vTrue = 1;
        final Ingredient ingredient = new Ingredient(
                200,
                "butter",
                1,
                "Some image url",
                new Byte(vTrue),
                new Byte(vTrue),
                new Byte(vFalse),
                new Byte(vFalse)
        );
        ingredient.setId(id);
        Mockito.when(ingredientMockRepository.findById(id)).thenReturn(Optional.of(ingredient));
        final Ingredient expected = ingredientMockService.getIngredientById(id);
        Assert.assertNotNull(expected);
        Assert.assertEquals(ingredient, expected);
    }
}
