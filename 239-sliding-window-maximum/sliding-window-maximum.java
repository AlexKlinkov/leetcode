class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1]; // 1. set an array for writing result
        Deque<Integer> deque = new ArrayDeque<>(); // 2. set a deque for storing indices

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst(); // 3. remove indices outside window (leftmost index)

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // 4. remove smaller elements (rightmost index)
            }

            deque.offerLast(i); // 5. replenish deque by new indicates
            if (i >= k - 1 && deque.peekFirst() != null)
                result[i - k + 1] = nums[deque.peekFirst()]; // 6. add to result when window is formed
        }

        return result;
    }
}