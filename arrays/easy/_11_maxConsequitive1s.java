package arrays.easy;

public class _11_maxConsequitive1s {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) return nums[0];

        int maxCount = 0;
        if (nums[0] == 1) maxCount = 1;
        
        for (int i=1; i<nums.length; i++) {
            if (maxCount == 0 && nums[i] ==  1) maxCount = 1;

            int count = 0;
            while ( i<nums.length && nums[i] == 1 && nums[i-1] == nums[i]) {
                count++;
                i++;
                if (count+1 > maxCount) maxCount = count + 1;
            }
        }
        return maxCount;
    }


    // better way----------------------------------------------------------***************************

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) count++;
            else count = 0;

            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
