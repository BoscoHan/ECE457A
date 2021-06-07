import java.util.HashSet;
import java.util.List;

public class DFS {
    public int DFSSearch(int[][] grid, int startI, int startJ, int endI, int endJ, List<int[]> pathList) {
        return dfs(grid, startI, startJ, endI, endJ, pathList, new HashSet(), 0);
    }

    private int dfs(int[][] grid, int i, int j, int destI, int destJ, List<int[]> pathList, HashSet<String> visitedSet, int explored) {
        if (visitedSet.contains(i+ "~" +j))
            return 0;

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0)
            return 0;

        if (i == destI && j == destJ) {
            System.out.println("found target after exploring " + explored + " nodes");
            return 1;
        }

        pathList.add(new int[] {i, j});
        visitedSet.add(i+"~"+j);

        explored = 1 + dfs(grid, i+1, j, destI, destJ, pathList, visitedSet,explored+1) +
        dfs(grid, i-1, j, destI, destJ, pathList, visitedSet, explored+1) +
        dfs(grid, i, j+1, destI, destJ, pathList, visitedSet, explored+1) +
        dfs(grid, i, j-1, destI, destJ, pathList, visitedSet, explored+1);
        return explored;
    }
}
