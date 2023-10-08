class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // Determine the sign of the result
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        // Convert dividend and divisor to positive values
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        // Initialize the result
        long result = 0;
        // Perform the division
        while (ldividend >= ldivisor) {
            long temp = ldivisor;
            long multiple = 1;
            // Keep doubling the divisor and the multiple until it becomes greater than the dividend
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            // Subtract the multiple of divisor from dividend
            ldividend -= temp;
            result += multiple;
        }
        // Apply the sign to the result
        result *= sign;
        // Check for overflow and return the result within the 32-bit integer range
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)result;
        }
    }
}