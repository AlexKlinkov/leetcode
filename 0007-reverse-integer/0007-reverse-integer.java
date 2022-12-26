import java.util.Objects;
import java.math.BigInteger;
class Solution {
    public int reverse(int x) {
        if (validate(BigInteger.valueOf(x))) {
            StringBuilder result = new StringBuilder(String.valueOf(x)).reverse();
            String returnResult;
            if (String.valueOf(result.substring(result.length() - 1, result.length())).equals("-")) {
                result.insert(0, result.substring(result.length() - 1));
                returnResult = String.valueOf(result.substring(0, result.length() - 1));
            } else {
                returnResult = String.valueOf(result.substring(0, result.length()));
            }
            if (validate(new BigInteger(returnResult))) {
                return Integer.parseInt(returnResult);
            }
        }
        return 0;
    }

    public static boolean validate(BigInteger x) {
        return x.compareTo(BigInteger.valueOf((long) -Math.pow(2, 31))) >= 0 &&
                x.compareTo(BigInteger.valueOf((long) Math.pow(2, 31) - 1)) <= 0;
    }
}