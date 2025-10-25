package arrays.easy;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * union
 */
public class _09_union_of_arrays {

    public static void main(String[] args) {
        // int[] arr1 = {1,2,3,4,5};
        // int[] arr2 = {2,2,3,6,4,5};
        int[] arr1 = {-8,-3,-3,-2,0,1,2,2,6};
        int[] arr2 = {-9,-9,0};
        // result = [-9, -8, -3, -2, 0, 1, 2, 6]
        System.out.println(union(arr1,arr2));

    }

    public static ArrayList<Integer> union(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> union = new ArrayList<>();
        int l = 0, r = 0;
        
        while (l < a.length && r < b.length) {
            if (a[l] <= b[r]) {
                if (union.size() == 0 || union.get(union.size()-1) != a[l]) {
                    union.add(a[l]);
                }
                l++;
            }
            else {
                if (union.size() == 0 || union.get(union.size()-1) != b[r]) {
                    union.add(b[r]);
                }
                r++;
            }
        }
        
        while (l < a.length) {
            if (union.getLast() != a[l]) union.add(a[l]);
            l++;
        }
        while (r < b.length) {
            if (union.getLast() != b[r]) union.add(b[r]);
            r++;
        }
        
        return union;
    }



    
        
    static int[] union1(int[] arr1, int[] arr2) {
        HashSet<Integer> freq = new HashSet<>();
        // ArrayList<Integer> union = new ArrayList<>();
        // 😂😂 dumbass hashset doesn't store stuff in order, guess you're a noob back then

        for (int i = 0; i < arr1.length; i++) {
            if (!freq.contains(arr1[i])) {
                freq.add(arr1[i]);
            }
        }
        for (int j = 0; j < arr2.length; j++) {
            if (!freq.contains(arr2[j])) {
                freq.add(arr2[j]);
            }
        }

        int[] unionArr = new int[freq.size()];
        int i = 0;
        for ( int key: freq) { // freq.keySet() for HashMap
            unionArr[i] = key;
            i++;
        }
        return unionArr;
    }
}

/*
 * Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. 
 * The elements in the union must be in ascending order.

The union of two arrays is an array where all values are distinct and are present in either the 
first array, the second array, or both.


Examples:
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
Output: [1, 2, 3, 4, 5, 7]
Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
Output: [1, 3, 4, 5, 6, 7, 8, 9]
Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2
 */