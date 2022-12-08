class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int length = (int)(Math.log10(x) + 1);
        if (length == 1) {
            return true;
        }
        StringBuilder startDivide = new StringBuilder("1" + "0".repeat(length - 1));
        int[] arr = new int[startDivide.length()];
        for (int i = 0; i < arr.length; i++) {
            int length2;
            if (x == 0) {
                length2 = 1;
            } else {
                length2 = (int)(Math.log10(x) + 1);
            }
            int digit = Integer.parseInt (startDivide.substring(0, arr.length - i));
            arr[i] = x / digit;
            x = x - Integer.parseInt("1" + "0".repeat(length2 - 1)) * arr[i];
        }
        int countStart = 0;
        int countFinish = arr.length - 1;
        while (true) {
            if (arr[countStart] != arr[countFinish - countStart] && countStart != countFinish) {
                return false;
            }
            if (countStart == countFinish) {
                break;
            }
            countStart += 1;
        }
        return true;
    }
}