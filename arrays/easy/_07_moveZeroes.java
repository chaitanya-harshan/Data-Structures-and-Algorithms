package _extras.arrays.easy;

class _07_moveZeroes {
    public void _07_moveZeroes(int[] nums) {
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while(i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}