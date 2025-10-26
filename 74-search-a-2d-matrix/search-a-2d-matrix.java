class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] necessaryInnerArray = getInnerLineAsArray(matrix, target);
        if (necessaryInnerArray != null) {
            if (necessaryInnerArray[0] == target) return true;
            if (necessaryInnerArray[necessaryInnerArray.length - 1] == target) return true;
            byte leftBoundary = 0;
            byte rightBoundary = (byte) (necessaryInnerArray.length - 1);
            while (leftBoundary <= rightBoundary) {
                byte mid = (byte) ((leftBoundary + rightBoundary) / 2);
                if (necessaryInnerArray[mid] == target) return true;
                if (target > necessaryInnerArray[mid]) {
                    leftBoundary = (byte) (mid + 1);
                } else {
                    rightBoundary = (byte) (mid - 1);
                }
            }
            return false;
        }
        return false;
    }

    private int[] getInnerLineAsArray(int[][] matrix, int target) {
        byte leftBoundary = 0;
        byte rightBoundary = (byte) (matrix.length - 1);
        while (leftBoundary <= rightBoundary) {
            byte mid = (byte) ((leftBoundary + rightBoundary) / 2);
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return matrix[mid];
            } else if (matrix[mid][0] < target) {
                leftBoundary = (byte) (mid + 1);
            } else {
                rightBoundary = (byte) (mid - 1);
            }
        }
        return null;
    }
}