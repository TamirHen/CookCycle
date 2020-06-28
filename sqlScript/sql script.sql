
CREATE PROCEDURE `GET_NUM_OF_MISSING_INGREDIENTS`(IN str_in LONGTEXT)
BEGIN

	SET @query = CONCAT('
    create or replace view numOfWantedIngredientsInRecipeView as
	select recipeId, count(recipeId) as numOfWantedIngredientsInRecipe
	from IngredientsInRecipes
	where ', str_in, '
	group by recipeId;
	');
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
    
	create or replace view numOfIngredientsForEachRecipe as
	select recipeId, count(string) as numOfIngredients
	from IngredientsInRecipes
	group by recipeId;

	select recipeId, numOfIngredients - numOfWantedIngredientsInRecipe as numOfMissingIngredients
	from numofingredientsforeachrecipe
	join numofwantedingredientsinrecipeview using(recipeId)
	where numOfIngredients - numOfWantedIngredientsInRecipe <= 3
	order by numOfMissingIngredients
	limit 100;

    
END

