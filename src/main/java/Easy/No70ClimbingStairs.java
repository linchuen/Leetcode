package Easy;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class No70ClimbingStairs {
    //f(n) = f(n-1) + f(n-2) f(1)==1,f(2)==2
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int nMinus2 = 1;
        int nMinus1 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = temp + nMinus1;
        }
        return nMinus1 + nMinus2;
    }

    public static void main(String[] args) {
        assert climbStairs(5) == 8;
    }
}
