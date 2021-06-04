import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public int[][] directions= {{0,1},{0,-1},{1,0},{-1,0}};
    public int BFSsearch (int[][] grid, int startI, int startJ, int endI, int endJ, List<int[]> pathList) {
        int cost = 0;

        // queue that holds next x and y pairs:
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {startI, startJ});

        while (!queue.isEmpty()) {
            int[] currCoord = queue.poll();
            int i = currCoord[0], j = currCoord[1];

            //check out of bounds
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0)
                continue;

            //reached end, quit:
            if (i == endI && j == endJ)
                return cost+1;

            grid[i][j] = -1; //mark as visited
            cost++;
            pathList.add(new int[] {i, j});

            for(int k = 0; k < directions.length; k++) {
                int r = i + directions[k][0], c = j + directions[k][1];
                queue.offer(new int[]{r, c});
            }
        }
        return cost;
    }
}
