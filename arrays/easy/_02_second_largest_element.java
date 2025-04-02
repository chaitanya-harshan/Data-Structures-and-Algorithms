/**
 * second_largest_element
 * https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
 */
public class _02_second_largest_element {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getSecondLargest(arr));
    }

    public static int getSecondLargest(int[] arr) {
        // Code Here
        int sl = 0;
        int l = arr[0];
        for (int i: arr) {
            if (i > l) {
                sl = l;
                l = i;
            }
            else if (i < l && i > sl) sl = i;
        }
        
        if (sl == 0) return -1;
        return sl;
    }
}