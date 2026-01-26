class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointerLeft = 0;
        int pointerRight = numbers.length - 1;
        int sum;
        while (pointerLeft < pointerRight) {
            sum = numbers[pointerLeft] + numbers[pointerRight];
            if (sum > target) {
                pointerRight--;
            } else if (sum < target) {
                pointerLeft++;
            } else {
                return new int[]{pointerLeft + 1, pointerRight + 1};
            }
        }
        return null;
    }
}