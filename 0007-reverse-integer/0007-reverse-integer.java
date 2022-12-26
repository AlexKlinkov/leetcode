import java.util.Objects;
import java.math.BigInteger;
class Solution {
    public int reverse(int x) {
        if (validate(BigInteger.valueOf(x))) {
            StringBuilder reverseResult = new StringBuilder(String.valueOf(x)).reverse();
            StringBuilder reverseResultForNegativeDigit = new StringBuilder();
            if (Objects.equals(reverseResult.substring(reverseResult.length() - 1, reverseResult.length()), "-")) {
                reverseResultForNegativeDigit.append("-");
                reverseResultForNegativeDigit.append(reverseResult.substring(0, reverseResult.length() - 1));
                if (validate(new BigInteger(reverseResultForNegativeDigit.toString()))) {
                    return Integer.parseInt(reverseResultForNegativeDigit.toString());
                }
            } else {
                if (validate(new BigInteger(reverseResult.toString()))) {
                    return Integer.parseInt(reverseResult.toString());
                }
            }
        }
        return 0;
    }
    public static boolean validate (BigInteger x) {
        if (x.compareTo(BigInteger.valueOf((long) -Math.pow(2, 31))) >= 0 &&
                x.compareTo(BigInteger.valueOf((long) Math.pow(2, 31) - 1)) <= 0) {
            return true;
        }
        return false;
    }
}