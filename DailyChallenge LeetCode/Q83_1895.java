class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        int maxSize = 1; 

        for (int size = 2; size <= Math.min(m, n); size++) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = row[i][j + size] - row[i][j];
                    boolean valid = true;

                    for (int r = i; r < i + size; r++) {
                        if (row[r][j + size] - row[r][j] != target) {
                            valid = false;
                            break;
                        }
                    }

                    for (int c = j; c < j + size && valid; c++) {
                        if (col[i + size][c] - col[i][c] != target) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        int d1 = 0, d2 = 0;
                        for (int k = 0; k < size; k++) {
                            d1 += grid[i + k][j + k];
                            d2 += grid[i + k][j + size - 1 - k];
                        }
                        if (d1 != target || d2 != target) valid = false;
                    }

                    if (valid) maxSize = size;
                }
            }
        }
        return maxSize;
    }
}
