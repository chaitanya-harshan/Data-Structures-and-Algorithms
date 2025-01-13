package strings.extras.easy;

import java.util.HashMap;
import java.util.Map;

public class min_len_of_str_after_ops__3_same_chars_reduce_to_1__ {
    
    // just counting the count and map them to 1 or 2
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int len = 0;
        for (int val : map.values()) {
            // len += (val % 2) == 0 ? 2 : 1;
            len += ((val & 1 ^ 1) << 1) | (val & 1); // using bitwise ops, FYI: didnt make any faster
            // u need to hashing array to make it faster
        }
        return len;
    }
}
// 9 -> 3 4 2 -> (n%2 == 1) 
// 1+2+2 = 5

// 1 2 3 4 5 6 7 8 9  -> initial counts of chars in the string
// 1 0 1 0 1 0 1 0 1  -> is count odd or even?
// 1 2 1 2 1 2 1 2 1  -> their final reduced count after getting cancelled

