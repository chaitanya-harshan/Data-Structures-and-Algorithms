package greedy.medium;

public class _06_candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candy = 1, prev_candy = 1;
        int desc_slope_len = 0;
        int local_maxima = -1;

        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy += ++prev_candy;
                desc_slope_len = 0;
                local_maxima = prev_candy;
            }
            else if (ratings[i] == ratings[i-1]) {
                candy += 1;
                prev_candy = 1;
                desc_slope_len = 0;
                local_maxima = 1;

            }
            else {
                desc_slope_len++;
                candy += desc_slope_len;

                if (desc_slope_len >= local_maxima) candy++;
                prev_candy = 1;

                // --- SAME THING AS ABOVE - but more complicated
                // if (desc_slope_len == 0) {
                //     candy++;
                //     local_maxima = prev_candy;
                //     if (prev_candy == 1) {
                //         candy++; // case local_maxima is itself '1'
                //         local_maxima = 2;
                //     }
                //     prev_candy = 1;
                //     desc_slope_len++;
                // }
                // else {
                //     desc_slope_len++;
                //     candy += desc_slope_len;
                //     if (desc_slope_len >= local_maxima) {
                //         candy++; // exceeded prev local maxima so increase that too 
                //     }
                //     // prev_candy = 1
                // }
                
            }
        }
        return candy;
    }
}

// [1, 6, 10, 8, 7, 3, 2]  lm 3, ds 4
//  1  3  6   7  9  13 18

// 1 ,2 ,4 ,5 ,2
// 1 3  6  10  {}

// [1,2,87,87,87,2,1]
//  1 3 6  7  8  10 13


/*
 * # [135. Candy](https://leetcode.com/problems/candy/description/)

There are <code>n</code> children standing in a line. Each child is assigned a rating value given in the integer array <code>ratings</code>.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.

**Example 1:** 

```
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
```

**Example 2:** 

```
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
```

**Constraints:** 

- <code>n == ratings.length</code>
- <code>1 <= n <= 2 * 10^4</code>
- <code>0 <= ratings[i] <= 2 * 10^4</code>
 */