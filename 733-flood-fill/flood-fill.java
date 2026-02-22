class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // checks that a new pixel has already required color
        if (image[sr][sc] == color)
            return image;

        depthFirstSearch(image, sr, sc, image[sr][sc], color);

        return image;
    }

    private static void depthFirstSearch(int[][] image, int r, int c, int originalColor, int newColor) {
        if (!isArrayWithinBoundaries(image, r, c) || image[r][c] != originalColor)
            return;

        image[r][c] = newColor;

        // checks 4 directions
        depthFirstSearch(image, r, c - 1, originalColor, newColor); // left
        depthFirstSearch(image, r, c + 1, originalColor, newColor); // right
        depthFirstSearch(image, r - 1, c, originalColor, newColor); // up
        depthFirstSearch(image, r + 1, c, originalColor, newColor); // down
    }

    private static boolean isArrayWithinBoundaries(int[][] image, int r, int c) {
        return r >= 0 && r < image.length &&
                c >= 0 && c < image[0].length;
    }
}