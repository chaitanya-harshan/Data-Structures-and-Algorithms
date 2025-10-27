package stacks_queues.monotonic_stacks;

public class _07_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        
        for (int ast: asteroids) {
            if (ast > 0) st.push(ast);
            else {
                boolean ast_survived = true;

                while (!st.isEmpty()) {
                    int top = st.peek();
                    
                    if (top < 0) break;

                    if      (top < -ast) st.pop();
                    else if (top == -ast) {
                        st.pop();
                        ast_survived = false;
                        break;
                    }
                    else if (top > -ast) {
                        ast_survived = false;
                        break;
                    }
                }

                if (ast_survived) st.push(ast);
            }
        }

        int[] res = new int[st.size()];
        for (int i=st.size()-1; i>=0; i--) {
            res[i] = st.pop();
        }
        return res;
    }

    // public int[] asteroidCollision(int[] asteroids) {
    //     Deque<Integer> st = new ArrayDeque<>();
        
    //     for (int i=0; i<asteroids.length; i++) {
    //         if (asteroids[i] < 0) {
    //             int cur = -1;
    //             while (!st.isEmpty()) {
    //                 cur = st.peek();
    //                 if (cur < 0) break;

    //                 if (cur <= -asteroids[i]) st.pop();
    //                 if (cur >= -asteroids[i]) break;
    //             }
    //             if (cur < -asteroids[i]) st.push(asteroids[i]);
    //         }
    //         else st.push(asteroids[i]);
    //     }

    //     int[] res = new int[st.size()];
    //     int i = st.size()-1;
    //     while (!st.isEmpty()) res[i--] = st.pop();
    //     return res;
    // }
}

// s B  s s  B s
//   B  - -  B

/*
 * URL: https://leetcode.com/problems/asteroid-collision/description/

735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 
Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:
Input: asteroids = [3,5,-6,2,-1,4]​​​​​​​
Output: [-6,2,4]
Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side, the asteroid 2 makes the asteroid -1 explode and then continues going right, without reaching asteroid 4.

 
Constraints:

	2 <= asteroids.length <= 104
	-1000 <= asteroids[i] <= 1000
	asteroids[i] != 0
 */