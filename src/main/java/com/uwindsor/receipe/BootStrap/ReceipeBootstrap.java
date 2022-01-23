package com.uwindsor.receipe.BootStrap;

import com.uwindsor.receipe.models.*;
import com.uwindsor.receipe.repositories.CategoryRepository;
import com.uwindsor.receipe.repositories.RecipeRepository;
import com.uwindsor.receipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ReceipeBootstrap  implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public ReceipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        recipeRepository.saveAll(getRecipe());

    }

    private List<Recipe> getRecipe(){

        List<Recipe> recipes = new ArrayList<>();


        Optional<UnitOfMeasure> tableSpoonOptional = unitOfMeasureRepository.findByDescription("tablespoon");
        if(!tableSpoonOptional.isPresent()){
            throw new RuntimeException("expected table soon not found");
        }

        Optional <UnitOfMeasure> spoonfulOptional = unitOfMeasureRepository.findByDescription("spoonful");
        if(!spoonfulOptional.isPresent()){
            throw new RuntimeException("expected spoonful not found");
        }
        Optional <UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByDescription("cup");
        if(!cupOptional.isPresent()){
            throw new RuntimeException("expected cupOptional not found");
        }

        Optional <UnitOfMeasure> pinchOptional = unitOfMeasureRepository.findByDescription("pinch");
        if(!pinchOptional.isPresent()){
            throw new RuntimeException("expected pinch not found");
        }


        Optional <UnitOfMeasure> teaspoonfulOptional = unitOfMeasureRepository.findByDescription("teaspoonful");
        if(!teaspoonfulOptional.isPresent()){
            throw new RuntimeException("expected teaspoonful not found");
        }

        UnitOfMeasure tablepoonUOM = tableSpoonOptional.get();
        UnitOfMeasure teaspoonUOM = teaspoonfulOptional.get();
        UnitOfMeasure cupUOM = cupOptional.get();
        UnitOfMeasure pinchUOM = pinchOptional.get();
        UnitOfMeasure spoonfulUOM = spoonfulOptional.get();

        Optional<Category> americacategoryOptional = categoryRepository.findByDescription("America");
        Optional<Category> germangoryOptional = categoryRepository.findByDescription("German");

        Optional<Category> chinaOptional = categoryRepository.findByDescription("China");

        Optional<Category> frenchOptional = categoryRepository.findByDescription("French");


        Category chinaCategory = chinaOptional.get();
        Category germanCategory = germangoryOptional.get();
        Category americaCategory = americacategoryOptional.get();
        Category frenchCategory = frenchOptional.get();


        Recipe oneRecipe = new Recipe();
        oneRecipe.setDescription("this is one");
        oneRecipe.setPreTime(10);
        oneRecipe.setCookTime(20);
        oneRecipe.setDifficulty(Difficulty.HARD);
        oneRecipe.setDirections("this is direction one");


        Notes oneNote = new Notes();
        oneNote.setRecipeNotes("this is note one");

        oneRecipe.setNotes(oneNote);



        oneRecipe.getIngredients().add(new Ingredient("ingredient 2", new BigDecimal(23), teaspoonUOM, oneRecipe));
        oneRecipe.getIngredients().add(new Ingredient("ingredient 3", new BigDecimal(33), cupUOM, oneRecipe));
        oneRecipe.getIngredients().add(new Ingredient("ingredient 4", new BigDecimal(53), spoonfulUOM, oneRecipe));

    oneRecipe.getCategory().add(chinaCategory);
    oneRecipe.getCategory().add(americaCategory);
        oneRecipe.getCategory().add(frenchCategory);

    recipes.add(oneRecipe);


    return recipes;







    }
}
