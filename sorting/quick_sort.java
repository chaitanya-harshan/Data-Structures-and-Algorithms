    package sorting;

import java.util.Arrays;

public class quick_sort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,7,9,1,3};
        quick_sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int[] arr, int low, int high) {
        // for single ele arr: recursion call would be q(0,0-1) as p would be 0
        // so low would be -1 and high would be 0. 
        // for this case we need to use low >= high and not just low == high
        if (low >= high) return;
        int pivot = partition(arr, low, high);
        quick_sort(arr, low, pivot-1);
        quick_sort(arr, pivot+1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int l = low;
        for (int r = low; r < high; r++) {
            if (arr[r] <= pivot) {
                swap(l, r, arr);
                l++;
            }
        }
        swap(l, high, arr);
        return l;
        // return l-1 == -1 ? 0 : l-1;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
