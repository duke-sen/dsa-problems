package designpatterns;

import java.util.Arrays;

public class PushAndFall {
    public char[][] pushAndFall(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        char[][] result = new char[rows][cols];

        // Copy the input board to the result board
        for (int i = 0; i < rows; i++) {
            System.arraycopy(board[i], 0, result[i], 0, cols);
        }

        // Iterate through each cell of the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {  // If the cell contains a box
                    // Push the box to the right
                    int k = j + 1;
                    while (k < cols && board[i][k] != '*' && board[i][k] != '#') {
                        k++;
                    }
                    k--;  // Adjust the position to the last valid cell
                    result[i][k] = '#';  // Update the result board

                    // Push the box down
                    int l = i + 1;
                    while (l < rows && board[l][j] != '*' && board[l][j] != '#') {
                        l++;
                    }
                    l--;  // Adjust the position to the last valid cell
                    result[l][j] = '#';  // Update the result board
                }
            }
        }

        return result;
    }

    // Helper method to print a 2D char array
    private void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        PushAndFall solution = new PushAndFall();
        char[][] board = {
                {'.', '#', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'#', '.', '#', '#', '.'},
                {'#', '.', '.', '.', '#'}
        };
        char[][] result = solution.pushAndFall(board);
        solution.printBoard(result);
    }
}