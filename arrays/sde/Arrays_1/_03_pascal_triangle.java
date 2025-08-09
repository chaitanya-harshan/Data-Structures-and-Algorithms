/*
 * 118. Pascal's Triangle
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Input: numRows = 1
Output: [[1]]


    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1


 */

package arrays.sde.Arrays_1;

import java.util.ArrayList;
import java.util.List;

/**
 * pascal_triangle
 */
public class _03_pascal_triangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate1(5));
    }

    //better way (adding 0's at the ends to make code easier)
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        result.add(new ArrayList<>(list));
        if (numRows == 1) return result;

        for (int i = 1; i < numRows; i++) {
            list.addFirst(0);
            list.addLast(0);
            for (int j = 0; j < list.size()-1; j++) {
                list.set(j, list.get(j) + list.get(j+1));
            }
            list.removeLast();// to remove the last zero
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        result.add(new ArrayList<>(list));
        if (numRows == 1) return result;

        list.add(1);
        result.add(new ArrayList<>(list));
        if (numRows == 2) return result;

        for (int i=2; i< numRows; i++) {
            int a = 1, b = 0; // buffers
            for (int j = 1; j<i; j++) {
                b = list.get(j);
                list.set(j, a+b);
                a = b;
            }
            list.add(1);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}