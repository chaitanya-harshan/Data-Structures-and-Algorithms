package stacks_queues.monotonic_stacks;

public class _04_greater_elements_right_cnt {
    public static int[] count_NGE(int arr[], int indices[]) {
        int[] res = new int[indices.length];
        
        // Loop through each query
        for (int i = 0; i < indices.length; i++) {
            int queryIndex = indices[i];
            int valueToCompare = arr[queryIndex];
            int count = 0;
            
            // Linearly scan all elements to the right
            for (int j = queryIndex + 1; j < arr.length; j++) {
                if (arr[j] > valueToCompare) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<indices.length; i++) map.put(indices[i], i);
        
        // int n = arr.length;
        // int[] res = new int[indices.length];
        // TreeMap<Integer, Integer> tree = new TreeMap<>();
        
        // for (int i=n-1; i>=0; i--) {
        //     int num = arr[i];
            
        //     if (map.containsKey(i)) {
        //         // res[map.get(i)] = tree.tailMap(num, false).size() // if no duplicates
        //         int cnt = 0;
        //         for (int fq: tree.tailMap(num, false).values()) cnt += fq;
        //         res[map.get(i)] = cnt;
        //     }
            
        //     tree.put(num, tree.getOrDefault(num,0)+1);
        // }
        // return res;
    }
}

/*\
https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1

 * Number of greater elements to the right
Difficulty: MediumAccuracy: 56.74%Submissions: 46K+Points: 4Average Time: 10m
Given an array of arr[] and Q queries of indices. For each query indices[i], determine the count of elements in arr that are strictly greater than arr[indices[i]] to its right (after the position indices[i]).

Examples :

Input: arr[] = [3, 4, 2, 7, 5, 8, 10, 6], queries = 2, indices[] = [0, 5]
Output:  [6, 1]
Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6. The next greater elements to the right of 8(index 5) is only 10.
Input: arr[] = [1, 2, 3, 4, 1], queries = 2, indices[] = [0, 3]
Output:  [3, 0]
Explanation: The count of numbers to the right of index 0 which are greater than arr[0] is 3 i.e. (2, 3, 4). Similarly, the count of numbers to the right of index 3 which are greater than arr[3] is 0, since there are no greater elements than 4 to the right of the array.
Constraints:
1 ≤ N ≤ 104
1 ≤ arr[i] ≤ 105
1 ≤ queries ≤ 100
0 ≤ indices[i] ≤ N - 1
 */