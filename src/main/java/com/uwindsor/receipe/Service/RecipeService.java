package com.uwindsor.receipe.Service;

import com.uwindsor.receipe.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface RecipeService {

    Set<Recipe> getRecipe();
}
