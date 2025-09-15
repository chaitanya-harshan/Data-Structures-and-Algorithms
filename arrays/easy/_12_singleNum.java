package arrays.easy;

public class _12_singleNum {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2,5,5};
        singleNum(arr);
    }

    static int singleNum(int[] nums) {
        int xor = 0;
        for (int i=0; i<nums.length; i++) {
            xor = xor ^ nums[i];
            // String s1 = Integer.toBinaryString(nums[i]);
            // String s2 = Integer.toBinaryString(xor);
            // System.out.println(i+" - "+nums[i]+" "+xor+" "+s1+" "+s2);
        }
        return xor;
    }
}
