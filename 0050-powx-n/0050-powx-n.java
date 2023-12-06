class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1.0;
        if (x == -1 && n < 0) return 1.0;
        if (x == -1) return -1.0;
        if (n == 1) return x;
        if (n == -1) return 1.0/x;
        double answer = x;
        int extentByModule = n == Integer.MIN_VALUE ? Math.abs(n + 1) : Math.abs(n);
        int limit = extentByModule % 2 == 0 ? extentByModule/2 : extentByModule/2 + 1;
        while (limit > 1) {
            answer *= x;
            limit--;
        }
        answer = extentByModule % 2 == 0 ? answer * answer : answer * (answer/x);
        return n > 0 ? answer : (x < 0 ? -1.0/answer : 1.0/answer);
    }
}