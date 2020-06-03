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
            ingredients.add(new Ingredient(
                    "butter"
            ));
            /* Set id manually (because DB responsible for this). */
            ingredients.get(i-1).setId(new Long(i));
        }
        Mockito.when(ingredientMockRepository.findAll()).thenReturn(ingredients);
        final List<Ingredient> expected = ingredientMockService.getAllIngredients();

        Assert.assertEquals(expected.size(), ingredients.size());
    }

    @Test
    public void whenCallingGetIngredientByIdItCallsFindByIdOnce() throws Throwable {
        final Long id = new Long(1);
        final Ingredient ingredient = new Ingredient(
                "butter"
        );
        /* Set id manually (because DB responsible for this). */
        ingredient.setId(id);
        Mockito.when(ingredientMockRepository.findById(id)).thenReturn(Optional.of(ingredient));
        final Ingredient expected = ingredientMockService.getIngredientById(id);
        Mockito.verify(ingredientMockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenCallingGetIngredientByIdItReturnsIngredientObject() throws Throwable {
        final Long id = new Long(2);
        final Ingredient ingredient = new Ingredient(
                "butter"
        );
        /* Set id manually (because DB responsible for this). */
        ingredient.setId(id);
        Mockito.when(ingredientMockRepository.findById(id)).thenReturn(Optional.of(ingredient));
        final Ingredient expected = ingredientMockService.getIngredientById(id);
        Assert.assertNotNull(expected);
        Assert.assertEquals(ingredient, expected);
    }
}
