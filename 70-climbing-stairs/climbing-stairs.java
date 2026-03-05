class Solution {
    // the bottom-up approach
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int oneStep = 2;
        int twoStep = 1;
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = current;
        }

        return current;
    }
}