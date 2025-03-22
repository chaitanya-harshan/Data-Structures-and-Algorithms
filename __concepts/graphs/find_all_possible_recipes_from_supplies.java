package __concepts.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class find_all_possible_recipes_from_supplies {
    String[] recipes_g;
    HashMap<String, Boolean> dp = new HashMap<>();
    HashMap<String, Integer> recipes_map = new HashMap<>();
    HashSet<String> all_supplies = new HashSet<>();
    HashSet<String> visited = new HashSet<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        for (String s: supplies) all_supplies.add(s);
        for (int i=0; i<recipes.length; i++) recipes_map.put(recipes[i], i);
        recipes_g = recipes;

        List<String> res = new ArrayList<>();

        for (int i=0; i<recipes.length; i++) {
            if (dfs_isPossible(i, ingredients)) {
                res.add(recipes[i]);
            }
        }
        return res; 
    }

    public boolean dfs_isPossible(int i, List<List<String>> ingredients) {
        String recipe = recipes_g[i];
        if (visited.contains(recipe)) return false;
        visited.add(recipe);

        for (String s: ingredients.get(i)) {
            if (all_supplies.contains(s)) continue;
            else if (dp.containsKey(s) && dp.get(s)) continue;
            else if (recipes_map.containsKey(s) && dfs_isPossible(recipes_map.get(s), ingredients)) continue;
            else {
                visited.remove(recipe);
                return false;
            }
        }

        all_supplies.add(recipes_g[i]);
        dp.put(recipes_g[i], true);
        visited.remove(recipe);
        return true;
    }
}


// a           b               c              d
// 12b        4cd             67d            467    



/*
 * 2115. Find All Possible Recipes from Given Supplies
https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/

You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

 

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:

Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 

Constraints:

n == recipes.length == ingredients.length
1 <= n <= 100
1 <= ingredients[i].length, supplies.length <= 100
1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
All the values of recipes and supplies combined are unique.
Each ingredients[i] does not contain any duplicate values.
 */