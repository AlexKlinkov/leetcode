class Solution {
    public int[][] merge(int[][] intervals) {
        // first of all, to sort given inner intervals in ascending way by first inner elem
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // create a new array for merging overlapping intervals
        List<int[]> result = new ArrayList<>();
        // create a new list by putted intervals for comparing elements
        List<int[]> initialIntervals = new ArrayList<>(Arrays.stream(intervals).toList());
        result.add(intervals[0]); // adding the first sorted elem in the new future result array
        int count = 1;
        while (count < initialIntervals.size()) {
            int[] prev = result.get(result.size() - 1);
            int[] next = initialIntervals.get(count);
            // the next interval completely enters into previous one
            if (prev[0] <= next[0] && prev[1] >= next[1]) {
                count++;
                continue;
                // the next interval overlaps with the previous one
            } else if (prev[0] <= next[0] &&  prev[1] >= next[0]) {
                result.add(result.size() - 1, new int[]{prev[0], next[1]});
                result.removeLast();
            } else {
                result.add(initialIntervals.get(count));
            }
            count++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}