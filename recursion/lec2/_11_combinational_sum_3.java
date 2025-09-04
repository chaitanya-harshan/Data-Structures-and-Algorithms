package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _11_combinational_sum_3 {
    List<List<Integer>> result = new ArrayList<>();
    int k;
    int target;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.target = n;
        int i = 1;
        backtrack(new ArrayList<>(), i, 0);
        return result;        
    }

    void backtrack(List<Integer> list, int i, int sum) {
        if (sum == target && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (i > 9) return;
        
        if (sum+i <= target && list.size() < k) {
            list.add(i);
            backtrack(list, i+1, sum+i);
            list.removeLast();

            backtrack(list, i+1, sum); 
            // nums 1 to 9 so if this sum+'i' is > target then no need to proceed further
        }
    }
}

/*
 * URL: https://leetcode.com/problems/combination-sum-iii/description/

216. Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 
Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

 
Constraints:

	2 <= k <= 9
	1 <= n <= 60
 */