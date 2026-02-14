class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        // prepares the stack and the map
        for (Integer currentNum : nums2) {
            // while stack isn't empty AND a current number is greater than the top of stack
            while (!stack.isEmpty() && currentNum > stack.peek()) {
                map.put(stack.pop(), currentNum);
            }
            stack.push(currentNum); // it will wait for a next greater element
        }

        // puts '-1' for elements, which don't have the next greater anyone
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // collects the final result
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}