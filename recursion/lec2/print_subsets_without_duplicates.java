package recursion.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class print_subsets_without_duplicates {
    public static void main(String[] args) {
        // int[] nums = {1,2,3};
        // int[] nums = {1,2,2,3};
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> list = new ArrayList<>();
        list = subsets(nums);
        for (List<Integer> inner : list) {
            System.out.println(inner);
        }
        System.out.println("size "+list.size());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(list, arr, 0, nums);
        return list;
    }

    //  [1,2,2,3]
    //                      1    (starting with 1 to explain the point)
    //           1,2                 1 <----(here)
    //    1,2,2       (1,2)   (1,2)       1

    // here we need to make sure anoter 2 is not added as 2 is already added on the left side
    // as this side is for not adding so regardles of in which index it is we shouldnt
    // thats why we need sorted array to skip the duplicates
    // we basically stop the creating of the duplicate branch by k++
    static void backtrack(List<List<Integer>> list, List<Integer> arr, int k, int[] nums) {
        if (k == nums.length) {
            list.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[k]);
        backtrack(list, arr, k+1, nums);
        arr.removeLast();

        while (k+1 < nums.length && nums[k] == nums[k+1]) k++;
        backtrack(list, arr, k+1, nums);
    }




    // i'm not sure how this is working since .contains cheks by reference and not direct eqality
    // Found the asnwer for above:
    // If the list object reference in the 2D list is the same, but its elements have changed, contains 
    // will return true only if the elements are exactly equal at the time of comparison; otherwise, it returns false.
    // ------------ But the list object is same for all the recursive methods ---------------
    // so the obj reference is the same so now it checks for the elements

    static void backtrack1(List<List<Integer>> list, List<Integer> arr, int k, int[] nums) {
        if (k == nums.length) {
            if (!list.contains(arr)) list.add(new ArrayList<>(arr));
            return;
        }

        backtrack(list, arr, k+1, nums);
        arr.add(nums[k]);
        backtrack(list, arr, k+1, nums);
        arr.removeLast();
    }
}
