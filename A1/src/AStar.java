import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {
    public int[][] directions= {{1,0},{-1,0},{0,1},{0,-1}};

    public int AStar (int[][] grid, int startX, int startY, int endI, int endJ, List<int[]> pathList) {
        int cost = 0;
        Comparator<Node> customComparator = new Comparator<Node>() {
            @Override
            public int compare(Node s1, Node s2) {
                //our heuristic comparing 2 nodes decides their order in the fringe: (x-endX)^2 + (y-endY)^2
                double h_s1 = Math.pow(Math.abs(s1.I - endI), 2) + Math.pow(Math.abs(s1.J - endJ), 2);
                double h_s2 = Math.pow(Math.abs(s2.I - endI), 2) + Math.pow(Math.abs(s2.J - endJ), 2);
                return (int)(h_s1 - h_s2);
            }
        };

        PriorityQueue<Node> pq = new PriorityQueue(customComparator);
        pq.offer(new Node(startX, startY));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int i = currNode.I, j = currNode.J;

            //check out of bounds, and skip if cell is blocked/visited:
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
                pq.offer(new Node(r, c));
            }
        }
        return cost;
    }
}

class Node {
    int I, J;
    Node (int i, int j) {
        this.I = i;
        this.J = j;
    }
}
