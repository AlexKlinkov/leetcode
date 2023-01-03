class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] havingDigits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] havingSymbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int count = 0;
        while (count < havingDigits.length) {
            if (num >= havingDigits[count]) {
                for (int i = 0; i < num / havingDigits[count]; i++) {
                    result.append(havingSymbols[count]);
                }
                num = num - havingDigits[count] * (num / havingDigits[count]);
            }
            count++;
        }
        return result.toString();
    }
}