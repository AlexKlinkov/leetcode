class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0 || s.isBlank()) {
            return 0;
        }
        String[] parts = s.trim().split("\\s+");
        String first = parts[0];
        boolean negative = false;
        int start = 0;
        if (first.charAt(0) == '-') {
            negative = true;
            start = 1;
        } else if (first.charAt(0) == '+') {
            start = 1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < first.length(); i++) {
            char c = first.charAt(i);
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                break;
            }
        }
        String str = result.toString();
        if (str.length() == 0) {
            return 0;
        }
        double d = Double.parseDouble(str);
        if (negative) {
            d = -d;
        }
        if (d < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (d > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) d;
        }
    }
}