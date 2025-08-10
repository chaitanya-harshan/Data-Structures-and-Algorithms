/*
https://www.naukri.com/code360/problems/fractional-knapsack_975286

 * You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.

Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.

Note:
You are allowed to break the items.
Example:
If 'N = 4' and 'W = 10'. The weights and values of items are weights = [6, 1, 5, 3] and values = [3, 6, 1, 4]. 
Then the best way to fill the knapsack is to choose items with weight 6, 1 and  3. The total value of knapsack = 3 + 6 + 4 = 13.00
 */
package greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        if ((double)a.value/a.weight >= (double)b.value/b.weight) return -1;
        else return 1;
    }
}

public class _02_knapsack_weigths_max_value {
    
    public static double fractionalKnapsack(int w, Item arr[], int n) {
        // Arrays.sort(arr, new itemComparator());
        Arrays.sort(arr, (a, b) -> (double)a.value/a.weight >= (double)b.value/b.weight ? -1 : 1);
        double value = 0;
        for (Item item : arr) {
            if (item.weight <= w) {
                value += item.value;
                w -= item.weight;
            }
            else {
                value += ((double)item.value / item.weight) * w;
                break;
            }
        }
        return value;
    }
}
