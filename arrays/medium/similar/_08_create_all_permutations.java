package arrays.medium.similar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _08_create_all_permutations {
    // You’ve got 4 chairs ([_, _, _, _]) and 4 people ([1,2,3,4]).
    // At each step, you pick who sits in the current chair.
    // Once someone sits, you recurse to seat the rest in the remaining chairs.
    // you swap as a way to remove the element form the remaining elements to choose.(kinda)

    // 1---                   2---                3---  4---
    // 12--  13--  14--       21--  23--  24--
    // 123-  124-             213-  214-
    // 1234  1243             2134  2143
    List<List<Integer>> permutations = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        permute(0);
        return permutations;
    }

    void permute(int i) {
        if (i == nums.length) {
            permutations.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int j=i; j<nums.length; j++) {
            swap(i,j);
            permute(i+1);
            swap(i,j);
        }
    }

    void swap(int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//--------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------

    public List<List<Integer>> permute1(int[] nums) {
        this.nums = nums;
        HashSet<Integer> elements = new HashSet<>();
        for (int i: nums) elements.add(i);
        
        permute1(elements, new ArrayList<>());
        return permutations;
    }
    void permute1(HashSet<Integer> set, List<Integer> list) {
        if (set.isEmpty()) {
            permutations.add(new ArrayList<>(list));
            return;
        }

        HashSet<Integer> elements = new HashSet<>(set);
        for (int i: elements) {
            list.add(i);
            set.remove(i);
            permute1(set, list);
            set.add(i);
            list.removeLast();
        }
    }
}
