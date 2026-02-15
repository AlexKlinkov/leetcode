class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {


        int[][] combinedArray = combineTwoArrays(intervals, newInterval);


        List<int[]> merged = new ArrayList<>();
        merged.add(combinedArray[0]);

        for (int[] interval : combinedArray) {
            if (isOverlapIntervals(merged.getLast(), interval)) {
                int[] mergedInterval = getMergedOverlappedIntervals(merged.getLast(), interval);

                if (!merged.contains(mergedInterval))
                    merged.set(merged.size() - 1, mergedInterval);

            } else {
                if (!merged.contains(interval))
                    merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private static int[][] combineTwoArrays(int[][] firstArr, int[] secondArr) {
        int[][] combinedArray = new int[firstArr.length + 1][2];

        for (int i = 0; i < firstArr.length; i++) {
            combinedArray[i] = firstArr[i];
        }
        combinedArray[combinedArray.length - 1] = secondArr;

        return Arrays.stream(combinedArray).sorted(Comparator.comparingInt(a -> a[0])).toArray(int[][]::new);
    }

    private static boolean isOverlapIntervals(int[] interval1, int[] interval2) {
        return interval2[0] >= interval1[0] && interval2[0] <= interval1[1];
    }

    private static int[] getMergedOverlappedIntervals(int[] interval1, int[] interval2) {
        int[] mergedIntervals = new int[2];
        mergedIntervals[0] = Math.min(interval1[0],  interval2[0]);
        mergedIntervals[1] = Math.max(interval1[1],   interval2[1]);
        return mergedIntervals;
    }
}