class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] >= target && matrix[i][0] <= target) {
                if (matrix[i][0] == target) return true;
                if (matrix[i][matrix[i].length - 1] == target) return true;
                int leftBoundary = 0;
                int rightBoundary = matrix[i].length - 1;
                while (leftBoundary <= rightBoundary) {
                    int mid = (leftBoundary + rightBoundary) / 2;
                    if (matrix[i][mid] == target) return true;
                    if (target > matrix[i][mid]) {
                        leftBoundary = mid + 1;
                    } else {
                        rightBoundary = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}