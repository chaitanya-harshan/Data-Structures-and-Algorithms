package recursion.lec2_subsequences;

/*
 * ****************************************** IMPORTANT ******************************************
 * GFG 
 * not working properly
 * code feels correct
 */
public class _04_num_of_subsets_of_string {
    public static void main(String[] args) {
        System.out.println(getSubsequences("bekoilx",  0));
        System.out.println(getSubsequences("gboubwd",  0));
        System.out.println(getSubsequences("gfg",  0));
        System.out.println(getSubsequences("ggg",  0));
    }

    // total number of subsets if there are no duplicates is 2^n
    // so if there are duplicates then it will be less than that
    public static int getSubsequences(String str, int k) {
        if (k == str.length()) {
            return 1;
        }

        int left = getSubsequences(str, k+1);

        while (k+1 < str.length() && str.charAt(k) == str.charAt(k+1)) k++; // to understand this read subsets with duplicates
        int right = getSubsequences(str, k+1);

        return left + right;
    }
}

/*
 * Given a pair of strings of equal lengths, Geek wants to find the better string. The better string is the string having more number of distinct subsequences.
If both the strings have equal count of distinct subsequence then return str1.

str1 = "gfg", str2 = "ggg"
Output: "gfg"
Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct 
 */