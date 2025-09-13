package dp.strings;

public class _02_print_Longest_Common_Subsequence {

    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];

        for (int i=n-1; i>=0; i--) {

            for (int j=m-1; j>=0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while (i<n && j<m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++; j++;
            }
            else if (dp[i+1][j] >= dp[i][j+1]) i++;
            else j++;
        }

        return sb.toString();
    }



    // ********** T-L-E ***********
    // public static List<String> all_longest_common_subsequences(String s, String t) {
    //     int n = s.length(), m = t.length();
    //     int[][] dp = new int[n+1][m+1];
        
    //     for (int i=1; i<=n; i++) {
    //         for (int j=1; j<=m; j++) {
    //             if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
    //             else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
    //         }
    //     }
        
    //     int maxLen = dp[n][m];
    //     // System.out.println(maxLen);
    //     Set<String> res = new HashSet<>();
    //     generateStrings(s,t, n, m, "", res, dp, maxLen);
    //     List<String> list = new ArrayList<>(res);
    //     Collections.sort(list);
    //     return list;
    // }
    
    // public static void generateStrings(String s, String t, int i, int j, String str, Set<String> res, int[][] dp, int len) {
    //     // System.out.print(str.length() +" ");
    //     if (str.length() == len) {
    //         res.add(str);
    //         return;
    //     }
    //     if (i == 0 || j == 0) {
    //         return;
    //     }
        
    //     if (s.charAt(i-1) == t.charAt(j-1)) {
    //         generateStrings(s,t,i-1,j-1, s.charAt(i-1)+str, res, dp, len);
    //     }
    //     else {
    //         int left = dp[i][j-1];
    //         int right = dp[i-1][j];
            
    //         if (left > right) generateStrings(s,t,i,j-1, str,res, dp, len);
    //         if (right > left) generateStrings(s,t,i-1,j, str,res, dp, len);
    //         else {
    //             generateStrings(s,t,i,j-1, str,res, dp, len);
    //             generateStrings(s,t,i-1,j, str,res, dp, len);
    //         }
    //     }
    // }
}

/*
 *  Print Longest Common Subsequence
https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383

You are given two strings ‘s1’ and ‘s2’.



Return the longest common subsequence of these strings.



If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.



Note:
Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of ‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters from ‘s1’.


Example:
Input: ‘s1’  = “abcab”, ‘s2’ = “cbab”

Output: “bab”

Explanation:
“bab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5 6
ababa
cbbcad


Expected Answer:
"bba"


Output on console:
1


Explanation of sample output 1:
“bba” is only possible longest subsequence present in both s1 = “ababa” and s2 = “cbbcad”. '1' is printed if the returned string is equal to "bba". 


Sample Input 2:
3 3
xyz
abc


Expected Answer:
""


Output on console:
1


Explanation of sample output 2:
There’s no subsequence of ‘s1’ that is also present in ‘s2’. Thus an empty string is returned and '1' is printed.


Expected Time Complexity:
Try to solve this in O(n*m). Where ‘n’ is the length of ‘s1’ and ‘m’ is the length of ‘s2’. 


Constraints:
1 <= n, m <= 10^3

Time Limit: 1 sec

 */