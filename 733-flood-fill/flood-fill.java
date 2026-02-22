class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // checks that a new pixel has already required color
        if (image[sr][sc] == color)
            return image;

        int originalColor = image[sr][sc];
        depthFirstSearch(image,  sr, sc, originalColor, color);

        return image;
    }

    private static void depthFirstSearch(int[][] image, int r, int c, int originalColor, int newColor) {
        if (!isArrayWithinBoundaries(image, r, c) || image[r][c] != originalColor)
            return;

        image[r][c] = newColor;

        // checks 4 directions
        depthFirstSearch(image, r + 1, c, originalColor, newColor); // up
        depthFirstSearch(image, r - 1, c, originalColor, newColor); // down
        depthFirstSearch(image, r, c + 1, originalColor, newColor); // right
        depthFirstSearch(image, r, c - 1, originalColor, newColor); // left

    }

    private static boolean isArrayWithinBoundaries(int[][] image, int r, int c) {
        return r >= 0 && r < image.length && c >= 0 && c < image[0].length;
    }

// BFS approach
/*
public static int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
    if (image[sr][sc] == color) return image;

    int originalColor = image[sr][sc];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{sr, sc});

    while (!queue.isEmpty()) {
        int[] pixel = queue.poll();
        int r = pixel[0], c = pixel[1];

        if (image[r][c] != originalColor) continue;

        image[r][c] = color;

        // Add neighbors
        if (r > 0) queue.offer(new int[]{r-1, c});
        if (r < image.length-1) queue.offer(new int[]{r+1, c});
        if (c > 0) queue.offer(new int[]{r, c-1});
        if (c < image[0].length-1) queue.offer(new int[]{r, c+1});
    }
    return image;
}*/
}