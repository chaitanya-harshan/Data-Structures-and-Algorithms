package dp.1D;

public class _02_frog_jump_with_2_jumps {

    // GFG - question is not so clear
    public int minimumEnergy(int arr[],int n){
        //code here
        int nxt = 0, nxtNxt = 0;
        int cur = 0;
        for (int i=n-2; i>=0; i--) {
            int twoJump = Integer.MAX_VALUE;
            
            int oneJump = Math.abs(arr[i]-arr[i+1]) + nxt;
            if (i+2 < n) twoJump = Math.abs(arr[i]-arr[i+2]) + nxtNxt;
            
            cur = Math.min(oneJump, twoJump);
            nxtNxt = nxt;
            nxt = cur;
        }
        return cur;
    }

    // Coding Ninjas    https://www.naukri.com/code360/problems/frog-jump_3621012?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
    public static int frogJump(int n, int heights[]) {
        int nxt = Math.abs(heights[n-1]-heights[n-2]);
        int nNxt = 0;
        int energy = 0;
    
        for (int i=n-3; i>=0; i--) {
            int one = Math.abs(heights[i+1] - heights[i]) + nxt;
            int two = Math.abs(heights[i+2] - heights[i]) + nNxt;
            energy = Math.min(one, two);
            
            nNxt = nxt;
            nxt =  energy;
        }
        return energy;
    }
    /*
     * There is a frog on the '1st' step of an 'N' stairs long staircase. 
     * The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.
     * If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). 
     * If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. 
     * Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
      For Example
      If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 
      1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair 
      (|10-20| = 10 energy lost). So, the total energy lost is 20.
     */
}



//   ************ GEEKS FOR GEEKS *************************

/*https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump

 * Geek Jump
 Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

Input: n = 4, height = {10 20 30 10}
Output: 20
Explanation:
Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost). Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost). So, total energy lost is 20 which is the minimum.
 */