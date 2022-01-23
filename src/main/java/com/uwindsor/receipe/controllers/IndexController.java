package com.uwindsor.receipe.controllers;

import com.uwindsor.receipe.Service.RecipeService;
import com.uwindsor.receipe.models.Category;
import com.uwindsor.receipe.models.UnitOfMeasure;
import com.uwindsor.receipe.repositories.CategoryRepository;
import com.uwindsor.receipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private  final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String index(Model model){
        model.addAttribute("recipes", recipeService.getRecipe());
       return "index";
    }
}
