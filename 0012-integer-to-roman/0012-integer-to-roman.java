class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] havingDigits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] havingSymbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int count = 0;
        int leftOverFromDivide;
        while (count < havingDigits.length) {
            leftOverFromDivide = num / havingDigits[count];
            if (leftOverFromDivide != 0 && num >= havingDigits[count]) {
                leftOverFromDivide = num - havingDigits[count] * leftOverFromDivide;
                for (int i = 0; i < num / havingDigits[count]; i++) {
                    result.append(havingSymbols[count]);
                }
                num = leftOverFromDivide;
            }
            count++;
        }
        return result.toString();
    }
}