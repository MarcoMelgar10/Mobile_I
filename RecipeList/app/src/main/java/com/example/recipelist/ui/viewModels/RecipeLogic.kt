package com.example.recipelist.ui.viewModels

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.recipelist.ui.objects.Recipe

class RecipeLogic: ViewModel() {

    private var recipes: MutableList<Recipe> = mutableListOf(
        Recipe(
            "Chicken and Rice",
            "Prep the Chicken: Pat the chicken dry and season it heavily with your spices, salt, and pepper. You can also mix the seasonings with a little olive oil to create a paste/rub." +
                   "Prep the Rice: In the baking dish, stir together the rinsed rice, diced onion (often sautéed first in other recipes for flavor), and the liquid (usually hot broth helps the rice cook evenly). Season the rice mixture with salt and pepper.\n" +
                   "Assemble: Arrange the seasoned chicken pieces on top of the rice mixture. Make sure the liquid is covering the rice",
            listOf("Tomato",
            "Chicken",
            "Rice")
        ),
        Recipe(
            "Salad",
            "\" Prepare the Dressing:\n" +
                    "In a small bowl, whisk together the vinegar/lemon juice, Dijon mustard, minced garlic (if using), salt, and pepper.\n" +
                    "Slowly drizzle in the olive oil while continuously whisking until the mixture is well combined and slightly thickened (emulsified).\n" +
                    "Taste and adjust the seasoning—add more salt, pepper, or a bit of sweetener if desired.\n" +
                    "2. Prepare the Salad:\n" +
                    "Important: Wash your greens and make sure they are completely dry (use a salad spinner or pat them dry with a clean kitchen towel). Wet greens will cause the dressing to slide right off.\n" +
                    "In a very large bowl, combine the dried greens, chopped vegetables, and any optional toppings.\n" +
                    "3. Dress and Serve:\n" +
                    "Just before serving, drizzle the vinaigrette over the salad.\n" +
                    "Toss gently but thoroughly until all the leaves are lightly coated. It's better to start with less dressing and add more as needed to avoid a soggy salad.\n" +
                    "Serve immediately!\"",
            listOf("Tomato",
                "Union",
                "Carrot",
                )
        ),
        Recipe("Eggs with rice",
            "\"Cook the Egg: Heat the oil in a skillet or wok over medium-high heat. Pour in the beaten egg and scramble until just cooked. Remove the egg from the pan and set it aside.\n" +
                    "Fry the Rice: Add a little more oil if needed. Add the cold rice and break up any clumps with your spatula. Stir-fry for 2-3 minutes until heated through. (If using vegetables, add them now and cook until tender).\n" +
                    "Combine & Season: Add the cooked scrambled egg back into the pan. Pour the soy sauce around the edges of the pan (this gives it a nice flavor). Stir everything together for about 1 minute.\n" +
                    "Finish: Stir in the chopped green onions (if using) and serve immediately.\n" +
                    "2. Tamago Kake Gohan (TKG) (Raw Egg)\n" +
                    "This is a simple Japanese dish with a unique creamy texture. Note: This recipe uses a raw egg. Use very fresh, high-quality, or pasteurized eggs for safety.\n" +
                    "Ingredients (for 1 serving):\n" +
                    "1 cup piping hot, freshly cooked rice\n" +
                    "1 fresh, raw egg (or pasteurized egg)\n" +
                    "1/2 tsp soy sauce (or more, to taste)\n" +
                    "Optional: Pinch of salt, a dash of sesame oil, or furikake (rice seasoning)\n" +
                    "Instructions:\n" +
                    "Assemble: Scoop the hot rice into a serving bowl.\n" +
                    "Add Egg & Seasoning: Crack the egg directly over the rice. Drizzle with soy sauce and any other desired seasonings.\n" +
                    "Mix: Vigorously whip the egg and rice together with chopsticks or a fork. The heat from the rice will warm and slightly thicken the egg.\n" +
                    "Serve: Continue mixing until the rice turns pale yellow and creamy. Eat right away!\"",
            listOf("Rice",
                "Eggs",
                "Sugar",)),
        Recipe("Steak",
            "\"Preparation (Key to a Great Crust)\n" +
                    "Choose your cut: Boneless Ribeye or New York Strip are excellent for searing. Look for good marbling (streaks of fat).\n" +
                    "Bring to Room Temp: Take the steak out of the refrigerator 30 minutes to 1 hour before cooking. This helps it cook more evenly.\n" +
                    "Pat Dry: Pat the entire steak very dry with paper towels. Moisture is the enemy of a good sear!\n" +
                    "Season Generously: Liberally season all sides with kosher salt and black pepper right before you cook it. Don't be shy—you need a lot.\n" +
                    "2. Cooking (Hot and Fast)\n" +
                    "Heat the Pan: Use a heavy-bottomed pan, preferably cast iron. Place it over high heat and let it get smoking hot—about 5-10 minutes.\n" +
                    "Add Oil: Add a high-smoke-point oil (like canola, vegetable, or avocado oil) to the hot pan just until it shimmers (a light coat).\n" +
                    "Sear: Carefully place the steak in the pan. It should sizzle aggressively.\n" +
                    "Cook for 2-4 minutes on the first side without moving it to form a deep brown crust.\n" +
                    "Flip and sear the second side for another 2-4 minutes.\"\n",
            listOf("Lettuce",
                "Oil",
                "Meat")),
        Recipe("Macaroni and Cheese",
            "Sauté: Cook the diced chicken, then remove it from the pot.\n" +
                    "Cook Veggies: Sauté the onions, carrots, and celery in the same pot until softened.\n" +
                    "Simmer: Add the broth and your creamy element (like canned soup or milk/cream), seasonings, and bring to a boil.\n" +
                    "Add Noodles: Stir in the uncooked noodles and the cooked chicken. Reduce heat, cover, and simmer, stirring occasionally, until the noodles are tender and the sauce has thickened (usually about 10-20 minutes, depending on the noodle type).\n" +
                    "Finish: Stir in any final touches like frozen peas or a little shredded cheese if desired.\"",
            listOf("Noodles",
                "Tomato")),
    )
    private var recipeContemporany: Recipe? = null
    private val ingredients: MutableList<String> = mutableListOf(
        "Tomato",
        "Union",
        "Carrot",
        "Rice",
        "Eggs",
        "Sugar",
        "Lettuce",
        "Oil",
        "Meat",
        "Noodles",
        "Fish",
        "Pork"

    )
    private var results = List<Recipe>(100, { Recipe("", "", listOf(""))})

    fun dataIngredients(): List<String> {
        return ingredients
    }
    fun dataRecipes(): List<Recipe> {
        return recipes
    }
    fun dataRecipeContemporany(): Recipe? {
        return recipeContemporany
    }

    fun addIngredient(ingredient: String) {
        ingredients.add(ingredient)
    }

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun findRecipeByIngredient(ingredients: List<String>): List<Recipe> {
        println("Buscando recetas con ingredientes: $ingredients")
         results = recipes.filter { recipe -> recipe.ingredients.containsAll(ingredients) }
        println("Recetas encontradas: ${results.size}")
        return results
    }
    fun dataRecipesFilter(): List<Recipe> {
       return results
    }

    fun contemporanyRecipe(recipe: Recipe){
        recipeContemporany = recipe
    }


    @Composable
    fun SimpleMessageDialog(showDialog: Boolean, navController: NavController, onDismiss: () -> Unit) {
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { onDismiss() },
                title = { Text("Notice") },
                text = { Text("Recipe Saved!") },
                confirmButton = {
                    TextButton(onClick = {
                        onDismiss()
                        navController.navigate("MAINSCREEN")
                    }) {
                        Text("OK")
                    }
                }
            )
        }
    }




}