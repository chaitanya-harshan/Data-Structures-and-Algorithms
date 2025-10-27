package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr = {3,6,1,8,9,3,5,6,0,2};
        merge_sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void merge_sort(int[] arr, int low, int high) {
        if (low == high) return;

        int mid = (low + high)/2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int left = low;
        int right = mid+1;
        // Soting the array by comparing elements from left & right part 
        while (left <= mid && right <= high) {
            if (arr[right] < arr[left] ){
                list.add(arr[right]);
                right++;       
            }
            else {
                list.add(arr[left]);
                left++;
            }
        }

        //  if elements on the left half are still left
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        //  if elements on the right half are still left
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i-low);
        }
    }
}
