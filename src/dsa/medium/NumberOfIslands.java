package dsa.medium;

import java.util.LinkedList;
import java.util.Queue;

/*Input: grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        Output: 1
*/
public class NumberOfIslands {
    private boolean[][] visitedGrid;

    public int numIslands(char[][] grid) {
        visitedGrid = new boolean[grid.length][grid[0].length];
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (!visitedGrid[i][j] && grid[i][j] == '1') {
                    islandCount++;
                    markConnectedLandsAsVisited(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private void markConnectedLandsAsVisited(char[][] grid, int rowValue, int colValue) {
        int rowBoundary = visitedGrid.length;
        int colBoundary = visitedGrid[0].length;

        if (rowValue < 0 || colValue < 0 || rowValue >= rowBoundary || colValue >= colBoundary
                || visitedGrid[rowValue][colValue] || grid[rowValue][colValue] == '0')
            return;

        visitedGrid[rowValue][colValue] = true;

        markConnectedLandsAsVisited(grid, rowValue - 1, colValue);
        markConnectedLandsAsVisited(grid, rowValue + 1, colValue);
        markConnectedLandsAsVisited(grid, rowValue, colValue - 1);
        markConnectedLandsAsVisited(grid, rowValue, colValue + 1);
    }

    private void markConnectedLandsAsVisitedOld(char[][] grid, int rowValue, int columnValue) {
        int rowBoundary = visitedGrid.length;
        int colBoundary = visitedGrid[0].length;

        Queue<int[]> toVisitInSameIsland = new LinkedList<>();
        toVisitInSameIsland.add(new int[]{rowValue, columnValue});
        visitedGrid[rowValue][columnValue] = true;

        while (!toVisitInSameIsland.isEmpty()) {
            int[] currentCell = toVisitInSameIsland.poll();
            int currentRowIdx = currentCell[0];
            int currentColIdx = currentCell[1];

            visitedGrid[currentRowIdx][currentColIdx] = true;

            if (currentRowIdx + 1 < rowBoundary && grid[currentRowIdx + 1][currentColIdx] == '1' && !visitedGrid[currentRowIdx + 1][currentColIdx]) {
                toVisitInSameIsland.add(new int[]{currentRowIdx + 1, currentColIdx});
            }
            if (currentRowIdx - 1 >= 0 && grid[currentRowIdx - 1][currentColIdx] == '1' && !visitedGrid[currentRowIdx - 1][currentColIdx]) {
                toVisitInSameIsland.add(new int[]{currentRowIdx - 1, currentColIdx});
            }
            if (currentColIdx + 1 < colBoundary && grid[currentRowIdx][currentColIdx + 1] == '1' && !visitedGrid[currentRowIdx][currentColIdx + 1]) {
                toVisitInSameIsland.add(new int[]{currentRowIdx, currentColIdx + 1});
            }
            if (currentColIdx - 1 >= 0 && grid[currentRowIdx][currentColIdx - 1] == '1' && !visitedGrid[currentRowIdx][currentColIdx - 1]) {
                toVisitInSameIsland.add(new int[]{currentRowIdx, currentColIdx - 1});
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
