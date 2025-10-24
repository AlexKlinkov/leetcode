class Solution {
    public int[][] merge(int[][] intervals) {
        // first of all, to sort given inner intervals in ascending way by first inner elem
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>(); // create a new array for merging overlapping intervals
        result.add(intervals[0]); // adding the first sorted elem in the new future result array
        int count = 1;
        while (count < intervals.length) {
            int[] prev = result.getLast();
            int[] next = intervals[count];
            // the next interval completely enters into previous one or the next interval overlaps with the previous one
            if (prev[0] <= next[0] && prev[1] >= next[0]) {
                result.set(result.size() - 1, new int[]{prev[0], Math.max(prev[1], next[1])});
            } else {
                result.add(next);
            }
            count++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}