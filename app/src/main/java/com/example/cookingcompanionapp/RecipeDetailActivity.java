package com.example.cookingcompanionapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        ImageView recipeImage = findViewById(R.id.recipe_image);
        TextView recipeTitle = findViewById(R.id.recipe_title);
        TextView recipeIngredients = findViewById(R.id.recipe_ingredients);
        TextView recipeInstructions = findViewById(R.id.recipe_instructions);

        Recipe recipe = getIntent().getParcelableExtra("recipe");
        if (recipe != null) {
            recipeTitle.setText(recipe.getTitle());
            recipeImage.setImageResource(recipe.getImageResourceId());
            recipeIngredients.setText(recipe.getIngredients());
            recipeInstructions.setText(recipe.getInstructions());
        }
    }
}
