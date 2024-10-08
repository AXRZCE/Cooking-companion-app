package com.example.cookingcompanionapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class RecipesFragment extends Fragment
        {

private List<Recipe> recipeList;
private RecyclerView recyclerView;
private RecipeAdapter adapter;

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
    Log.d("RecipesFragment", "onCreateView called");

    View view = inflater.inflate(R.layout.fragment_recipe, container, false);

    recyclerView = view.findViewById(R.id.recipe_list);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    initializeRecipes();

    Log.d("RecipesFragment", "Recipe list size: " + recipeList.size());

    adapter = new RecipeAdapter(recipeList, recipe -> {
        Log.d("RecipesFragment", "Recipe item clicked: " + recipe.getTitle());
        Intent intent = new Intent(getContext(), RecipeDetailActivity.class);
        intent.putExtra("recipe", recipe);
        startActivity(intent);
    });
    recyclerView.setAdapter(adapter);

    return view;
}

private void initializeRecipes() {
    recipeList = new ArrayList<>();
    recipeList.add(new Recipe("Spaghetti with Tomato Sauce", R.drawable.spaghetti,
                "Ingredients:\n" +
                        "- 1 pound spaghetti\n" +
                        "- 1 (28 ounce) can crushed tomatoes\n" +
                        "- 1/4 cup chopped onion\n" +
                        "- 2 cloves garlic, minced\n" +
                        "- 1 tablespoon olive oil\n" +
                        "- 1 teaspoon dried oregano\n" +
                        "- 1/2 teaspoon dried basil\n" +
                        "- Salt and pepper to taste\n" +
                        "- Grated Parmesan cheese (optional)\n",
                "Instructions:\n" +
                        "1. Cook spaghetti according to package directions.\n" +
                        "2. While spaghetti is cooking, heat olive oil in a saucepan over medium heat. Add onion and garlic and cook until softened, about 5 minutes.\n" +
                        "3. Stir in crushed tomatoes, oregano, basil, salt, and pepper. Bring to a simmer and cook for 15 minutes, stirring occasionally.\n" +
                        "4. Drain spaghetti and add to the sauce. Toss to coat.\n" +
                        "5. Serve with grated Parmesan cheese, if desired.\n"));

        recipeList.add(new Recipe("Classic Cheese Pizza", R.drawable.pizza,
                "Ingredients:\n" +
                        "- 1 (14 ounce) can pizza dough\n" +
                        "- 1 (14 ounce) can pizza sauce\n" +
                        "- 2 cups shredded mozzarella cheese\n" +
                        "- 1/4 cup grated Parmesan cheese (optional)\n" +
                        "- Your favorite pizza toppings (optional)\n",
                "Instructions:\n" +
                        "1. Preheat oven to 450 degrees F (230 degrees C).\n" +
                        "2. Roll out pizza dough on a lightly floured surface.\n" +
                        "3. Spread pizza sauce over the dough.\n" +
                        "4. Sprinkle with mozzarella cheese and Parmesan cheese (if using).\n" +
                        "5. Add your favorite toppings, if desired.\n" +
                        "6. Bake for 10-15 minutes, or until cheese is melted and bubbly.\n"));

        recipeList.add(new Recipe("Fresh Garden Salad", R.drawable.salad,
                "Ingredients:\n" +
                        "- 4 cups mixed salad greens\n" +
                        "- 1 cup cherry tomatoes, halved\n" +
                        "- 1/2 cup cucumber, sliced\n" +
                        "- 1/4 cup red onion, thinly sliced\n" +
                        "- Your favorite salad dressing\n",
                "Instructions:\n" +
                        "1. Combine salad greens, cherry tomatoes, cucumber, and red onion in a large bowl.\n" +
                        "2. Toss with your favorite salad dressing.\n" +
                        "3. Serve immediately.\n"));

        recipeList.add(new Recipe("Beef Tacos with all the Toppings", R.drawable.tacos,
                "Ingredients:\n" +
                        "- 1 pound ground beef\n" +
                        "- 1 tablespoon taco seasoning\n" +
                        "- 1/4 cup water\n" +
                        "- 8 taco shells\n" +
                        "- Your favorite taco toppings (lettuce, cheese, tomatoes, sour cream, etc.)\n",
                "Instructions:\n" +
                        "1. Brown ground beef in a skillet over medium heat. Drain off any excess grease.\n" +
                        "2. Stir in taco seasoning and water. Simmer for 5 minutes, stirring occasionally.\n" +
                        "3. Fill taco shells with ground beef mixture and your favorite toppings.\n"));

        recipeList.add(new Recipe("Fluffy Pancakes", R.drawable.pancakes,
                "Ingredients:\n" +
                        "- 1 cup all-purpose flour\n" +
                        "- 2 teaspoons baking powder\n" +
                        "- 1 teaspoon salt\n" +
                        "- 1 tablespoon white sugar\n" +
                        "- 1 1/4 cups milk\n" +
                        "- 1 egg\n" +
                        "- 3 tablespoons butter, melted\n",

                "Instructions:\n" +
                        "1. In a large bowl, sift together the flour, baking powder, salt, and sugar.\n" +
                        "2. Make a well in the center and pour in the milk, egg, and melted butter; mix until smooth.\n" +
                        "3. Heat a lightly oiled griddle or frying pan over medium high heat.\n" +
                        "4. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake.\n" +
                        "5. Brown on both sides and serve hot.\n"));
    }
}