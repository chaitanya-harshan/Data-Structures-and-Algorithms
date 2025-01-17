/*
 * You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.

'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
Subset [2, 3] has sum equal to 'K'.
So our answer is True.

https://www.naukri.com/code360/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&count=25&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=PROBLEM&page=1
wont work without dp
using recursion the time limit is exceeded
 */
package recursion.lec2;

public class _06_subsets_sum_exists {
    public static void main(String[] args) {
        int[] nums = {5,2,3,10,6,8};
        System.out.println(isSubsetPresent(nums.length, 10, nums));

    }

    public static boolean isSubsetPresent(int n, int k, int[] nums) {
        // Write your code here
        return backtrack(nums, 0, 0, k, n); // k is sum not index
    }

    static boolean backtrack(int[] nums, int k, int s, int sum, int n) {
        if (k == n) {
            if (s == sum) return true;
            else return false;
        }

        s += nums[k];
        if (backtrack(nums, k+1, s, sum, n)) return true;
        s -= nums[k];

        if (backtrack(nums, k+1, s, sum, n)) return true;

        return false;
    }
}
