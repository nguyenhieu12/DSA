package Week12;

import java.util.Scanner;

public class ConnectedCellsInAGrid {
    private static int[][] vertex;
    private static boolean[][] visited;
    private static int m, n;


    public static int dfs(int row, int col) {
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col])
            return 0;
        else if(vertex[row][col] == 0 && !visited[row][col]) {
            visited[row][col] = true;
            return 0;
        }

        int count = 1;
        visited[row][col] = true;

        for(int i = row - 1;i <= row + 1;i++) {
            for(int j = col - 1;j <= col + 1;j++) {
                count += dfs(i, j);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        vertex = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                vertex[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }

        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (vertex[i][j] == 0 || visited[i][j])
                    continue;
                max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);

    }
}