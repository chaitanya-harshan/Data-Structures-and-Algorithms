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
        // System.out.println(Arrays.toString(union(arr1,arr2)));
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