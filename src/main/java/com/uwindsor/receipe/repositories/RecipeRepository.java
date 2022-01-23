package com.uwindsor.receipe.repositories;

import com.uwindsor.receipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
