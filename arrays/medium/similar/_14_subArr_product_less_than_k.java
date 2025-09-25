package arrays.medium.similar;

public class _14_subArr_product_less_than_k {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int cnt = 0;
        int l = 0;

        for (int r=0; r<nums.length; r++) {
            product *= nums[r];
            while (l <= r &&product >= k) product /= nums[l++];
            cnt += r-l+1;
        }
        return cnt; 
    }
}
