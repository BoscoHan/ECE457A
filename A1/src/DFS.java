import java.util.List;

public class DFS {
    public int DFSSearch(int[][] grid, int startI, int startJ, int endI, int endJ, List<int[]> pathList) {
        return dfs(grid, startI, startJ, endI, endJ, pathList);
    }

    private int dfs(int[][] grid, int i, int j, int destI, int destJ, List<int[]> pathList) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0)
            return 0;

        if (i == destI && j == destJ) {
            return 1;
        }

        pathList.add(new int[] {i, j});
        grid[i][j] = -1; //mark as visited:

        return 1 + dfs(grid, i+1, j, destI, destJ, pathList) +
        dfs(grid, i-1, j, destI, destJ, pathList) +
        dfs(grid, i, j+1, destI, destJ, pathList) +
        dfs(grid, i, j-1, destI, destJ, pathList);
    }
}
