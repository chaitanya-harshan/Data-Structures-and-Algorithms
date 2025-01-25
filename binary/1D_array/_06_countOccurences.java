package binary._1D_array;

public class _06_countOccurences {
    public static void main(String[] args) {
        int count = count(new int[]{1,1,1,2,2,3,3}, 7, 3);
        System.out.println(count);
    }
    public static int count(int nums[], int n, int target) {
        //Your code goes here
        int fp = firstIndex(nums, target);
        // int lp = lastIndex(nums, target);
        if (fp == -1) return 0;
        else return lastIndex(nums, target) - fp + 1;
    }

    static int firstIndex(int[] nums, int target) {
        int n = nums.length;
        int first = -1;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                high = mid-1;
                first = mid;
            }
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return first;
    }

    static int lastIndex(int[] nums, int target) {
        int n = nums.length;
        int last = -1;
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                low = mid+1;
                last = mid;
            }
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return last;
    }
}