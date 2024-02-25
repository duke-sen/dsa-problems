package dsa;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFillHelper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void floodFillHelper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        // System.out.println("Index being visited is : " + "[" + sr + "][" + sc + "]");
        if (sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1)
            return;
        if (image[sr][sc] != oldColor || image[sr][sc] == newColor)
            return;
        image[sr][sc] = newColor;
        floodFillHelper(image, sr - 1, sc, newColor, oldColor);
        floodFillHelper(image, sr + 1, sc, newColor, oldColor);
        floodFillHelper(image, sr, sc - 1, newColor, oldColor);
        floodFillHelper(image, sr, sc + 1, newColor, oldColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = new FloodFill().floodFill(image, 1,1, 2);
        System.out.println("Done");
    }
}
