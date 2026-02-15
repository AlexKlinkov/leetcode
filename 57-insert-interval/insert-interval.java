class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Gets united combined sorted array by the first element using asc approach
        int[][] combinedArray = getCombinedTwoArraysWhichSortedByTheFirstElemInASCWay(intervals, newInterval);

        List<int[]> merged = new ArrayList<>(); // creates a list for the answer
        merged.add(combinedArray[0]); // adds the first element for checking

        for (int i = 1; i < combinedArray.length; i++) {

            if (isOverlapIntervals(merged.getLast(), combinedArray[i])) {
                merged.set(merged.size() - 1, getMergedOverlappedIntervals(merged.getLast(), combinedArray[i]));
            } else {
                merged.add(combinedArray[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    private static int[][] getCombinedTwoArraysWhichSortedByTheFirstElemInASCWay(int[][] firstArr, int[] secondArr) {
        List<int[]> sortedListByFirstElement = new ArrayList<>(Arrays.asList(firstArr));
        sortedListByFirstElement.add(secondArr);

        return sortedListByFirstElement.stream()
                .sorted(Comparator.comparingInt(a -> a[0]))
                .toArray(int[][]::new);
    }

    private static boolean isOverlapIntervals(int[] interval1, int[] interval2) {
        return interval2[0] >= interval1[0] && interval2[0] <= interval1[1];
    }

    private static int[] getMergedOverlappedIntervals(int[] interval1, int[] interval2) {
        int[] mergedIntervals = new int[2];

        mergedIntervals[0] = Math.min(interval1[0], interval2[0]);
        mergedIntervals[1] = Math.max(interval1[1], interval2[1]);

        return mergedIntervals;
    }
}