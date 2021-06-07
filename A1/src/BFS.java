import java.util.*;

public class BFS {
    public int[][] directions= {{0,1},{0,-1},{1,0},{-1,0}};
    public int BFSsearch (int[][] grid, int startI, int startJ, int endI, int endJ, List<int[]> pathList) {
        int nodesExplored = 0;

        Set<String> visitedSet = new HashSet();
        // queue that holds next x and y pairs:
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {startI, startJ});

        while (!queue.isEmpty()) {
            int[] currCoord = queue.poll();
            int i = currCoord[0], j = currCoord[1];
            String currCords = i+"~"+j;

            if (visitedSet.contains(currCords))
                continue;

            //reached end:
            if (i == endI && j == endJ) {
                System.out.println("found target after exploring "+nodesExplored+ " nodes");
            }

            //check out of bounds or if it's wall
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0)
                continue;

            visitedSet.add(currCords);
            nodesExplored++;
            pathList.add(new int[] {i, j});

            for(int k = 0; k < directions.length; k++) {
                int r = i + directions[k][0], c = j + directions[k][1];
                queue.offer(new int[]{r, c});
            }
        }
        return nodesExplored;
    }
}
