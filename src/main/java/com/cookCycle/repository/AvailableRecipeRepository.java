package com.cookCycle.repository;

import com.cookCycle.model.AvailableRecipe;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AvailableRecipeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<AvailableRecipe> getAvailableRecipes(String strIngredients) {
        List<Object[]> list = new ArrayList<>();
        List<AvailableRecipe> availableRecipes = new ArrayList<>();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GET_NUM_OF_MISSING_INGREDIENTS");
        query.registerStoredProcedureParameter("param", String.class, ParameterMode.IN);
        query.setParameter("param", strIngredients);
        try {
            // Execute query
            query.execute();
            list = query.getResultList();
            for (Object[] obj : list) {

                Long recipe_id = Long.parseLong(String.valueOf(obj[0]));
                int numOfMissingIngredients = Integer.parseInt(String.valueOf(obj[1]));
                availableRecipes.add(new AvailableRecipe(recipe_id, (int)numOfMissingIngredients));
            }
        } finally {
            try {
                query.unwrap(ProcedureOutputs.class).release();
            } catch (Exception e) {
            }
        }
        return availableRecipes;
    }

}