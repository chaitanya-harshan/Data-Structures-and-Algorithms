
package binary.math;

import java.util.ArrayList;

/**
 * _09_allocate_books
 */
public class _09_allocate_books {
    
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if (n < m) return -1;

        int max = 0, sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = (low + high)/2;
            if (countStudents(arr,mid) <= m) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    
    static int countStudents(ArrayList<Integer> books, int capacity) {
        // *** DON'T CHANGE *** you've already tried and realized you can't
        int count = 1; // counts the last (partial) student
        int pages = books.get(0);
        
        // books[0] won't be > capacity b/c low = max(books)
        for (int i=1; i<books.size(); i++) {
            if (pages + books.get(i) > capacity) {
                count++;
                pages = books.get(i);
            }
            else pages += books.get(i);
        }
        return count;
    }

    //                            |
    //                            V
    // student:    high ---> m-1..m..m..m+1 ---> low
    // capacity:   low ----> cn..cn+1..cn+2... --->  High
    // we need lower capacity
}
    /*
    https://www.naukri.com/code360/problems/allocate-books_1090540
    
    Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
    There are ‘m’ number of students, and the task is to allocate all the books to the students.
    
    Allocate books in such a way that:
    1. Each student gets at least one book.
    2. Each book should be allocated to only one student.
    3. Book allocation should be in a contiguous manner.
    
    You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
    
    If the allocation of books is not possible, return -1.
    
    Input: ‘n’ = 4 ‘m’ = 2 
    ‘arr’ = [12, 34, 67, 90]
    
    Output: 113

    Sample Input 2:
5 4
25 46 28 49 24
Sample Output 2:
71
Explanation of sample input 2:
All possible ways to allocate the ‘5’ books to '4' students are:

25 | 46 | 28 | 49 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '28', and '73'. So the maximum is '73'.

25 | 46 | 28 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '77', and '24'. So the maximum is '77'.

25 | 46 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '74', '49', and '24'. So the maximum is '74'.

25 46 | 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '71', '28', '49', and '24'. So the maximum is '71'.

We are getting the minimum in the last case.

Hence answer is ‘71’.
Expected time complexity:
The expected time complexity is O(n * log(s)), where ‘n’ is the number of integers in the array ‘arr’ and ‘s’ is the sum of all the elements of ‘arr’.

    
    Constraints:
    2 <= 'n' <= 10 ^ 3
    1 <= 'm' <= 10 ^ 3
    1 <= 'arr[i]' <= 10 ^ 9
    The sum of all arr[i] does not exceed 10 ^ 9.
    
    Where ‘n’ denotes the number of books and ‘m’ denotes the number of students. ‘arr[i]’ denotes an element at position ‘i’ in the sequence.
     */