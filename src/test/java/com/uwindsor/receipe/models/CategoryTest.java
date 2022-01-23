package com.uwindsor.receipe.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category category = new Category();

    @Before("")
    public void setUp(){
        category = new Category();

    }

    @Test
    void getId() {

        Long expected = 1L;
        category.setId(expected);
        assertEquals(expected, category.getId());
    }

    @Test
    void getDescription() {
        category.setDescription("hello");
        assertEquals("hello", category.getDescription());
    }

    @Test
    void getRecipes() {

    }
}