import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] grid = resetGrid();
        BFS bfs = new BFS();

//start at S, end on E1
        List<int[]> E1pathList = new ArrayList();
        int costE1 = bfs.BFSsearch(grid, 13, 2, 5, 23, E1pathList);
        System.out.println("\n finished BFS to E1, cost of: " + costE1);
        E1pathList.forEach(array -> System.out.print(Arrays.toString(array)));

    //start at S, end on E2
        int[][] grid2 = resetGrid();
        List<int[]> E2pathList = new ArrayList();
        int costE2 = bfs.BFSsearch(grid2, 13, 2, 3, 2, E2pathList);
        System.out.println("\n finished BFS to E2, cost of: " + costE2);
        E2pathList.forEach(array -> System.out.print(Arrays.toString(array)));

    //start at 0,0, end on 24,24
        int[][] grid3 = resetGrid();
        List<int[]> E3pathList = new ArrayList();
        int costE3 = bfs.BFSsearch(grid3, 0, 0, 24, 24, E3pathList);
        System.out.println("\n finished BFS to (24,24), cost of: " + costE3);
        E3pathList.forEach(array -> System.out.print(Arrays.toString(array)));


        DFS dfs = new DFS();
        int[][] gridDFS1 = resetGrid();
        List<int[]> E1pathListDFS = new ArrayList();
        int costDFSE1 = dfs.DFSSearch(gridDFS1, 13, 2, 5, 23, E1pathListDFS);
        System.out.println("\n finished DFS to E1, cost of: " + costDFSE1);
        E1pathListDFS.forEach(array -> System.out.print(Arrays.toString(array)));

        int[][] gridDFS2 = resetGrid();
        List<int[]> E2pathListDFS = new ArrayList();
        int costDFSE2 = dfs.DFSSearch(gridDFS2, 13, 2, 3, 2, E2pathListDFS);
        System.out.println("\n finished DFS to E2, cost of: " + costDFSE2);
        E2pathListDFS.forEach(array -> System.out.print(Arrays.toString(array)));

        int[][] gridDFS3 = resetGrid();
        List<int[]> E3pathListDFS = new ArrayList();
        int costDFSE3 = dfs.DFSSearch(gridDFS3, 0, 0, 24, 24, E3pathListDFS);
        System.out.println("\n finished DFS to (24,24), cost of: " + costDFSE3);
        E3pathListDFS.forEach(array -> System.out.print(Arrays.toString(array)));

        AStar aStar = new AStar();
        int[][] gridAStar1 = resetGrid();
        List<int[]> E1pathListAStar = new ArrayList();
        int costAStar1 = aStar.AStar(gridAStar1, 13, 2, 5, 23, E1pathListAStar);
        System.out.println("\n finished AStar to E1, cost of: " + costAStar1);
        E1pathListAStar.forEach(array -> System.out.print(Arrays.toString(array)));

        int[][] gridAStar2 = resetGrid();
        List<int[]> E2pathListAStar = new ArrayList();
        int costAStar2 = aStar.AStar(gridAStar2, 13, 2, 3, 2, E2pathListAStar);
        System.out.println("\n finished AStar to E2, cost of: " + costAStar2);
        E2pathListAStar.forEach(array -> System.out.print(Arrays.toString(array)));

        int[][] gridAStar3 = resetGrid();
        List<int[]> E3pathListAStar = new ArrayList();
        int costAStar3 = aStar.AStar(gridAStar3, 0, 0, 24, 24, E3pathListAStar);
        System.out.println("\n finished AStar to (24,24), cost of: " + costAStar3);
        E3pathListAStar.forEach(array -> System.out.print(Arrays.toString(array)));
    }

    private static int[][] resetGrid() {
        int[][] grid = new int[25][25];
        ArrayList<int[]> blackSpots = new ArrayList<int[]>(
        Arrays.asList(
                new int[] {0, 4}, new int[] {0, 5}, new int[] {1, 4}, new int[] {1, 5}, new int[] {2, 4}, new int[] {2, 5}, new int[] {2, 6}, new int[] {2, 7}, new int[] {2, 8}, new int[] {3, 7},
                new int[] {3, 8}, new int[] {4, 7}, new int[] {4, 8}, new int[] {6, 3}, new int[] {6, 4}, new int[] {6, 5}, new int[] {6, 6}, new int[] {6, 7}, new int[] {7, 3}, new int[] {7, 4},
                new int[] {7, 5}, new int[] {7, 6}, new int[] {7, 7}, new int[] {10, 2}, new int[] {10, 3}, new int[] {10, 4}, new int[] {10, 5}, new int[] {10, 6}, new int[] {10, 7}, new int[] {11, 2},
                new int[] {11, 3}, new int[] {11, 4}, new int[] {11, 5}, new int[] {11, 6}, new int[] {11, 7}, new int[] {12, 2}, new int[] {12, 3}, new int[] {12, 4}, new int[] {12, 5}, new int[] {12, 6},
                new int[] {12, 7}, new int[] {18, 1}, new int[] {18, 2}, new int[] {18, 3}, new int[] {18, 4}, new int[] {18, 5}, new int[] {18, 6}, new int[] {18, 7}, new int[] {18, 8}, new int[] {18, 9},
                new int[] {18, 10}, new int[] {18, 11}, new int[] {18, 12}, new int[] {18, 13}, new int[] {19, 1}, new int[] {19, 2}, new int[] {19, 3}, new int[] {19, 4}, new int[] {19, 5}, new int[] {19, 6},
                new int[] {20, 5}, new int[] {20, 6}, new int[] {21, 5}, new int[] {21, 6}, new int[] {22, 6}, new int[] {23, 6}, new int[] {4, 11}, new int[] {21, 8}, new int[] {21, 9}, new int[] {21, 10}, new int[] {21, 11},
                new int[] {21, 12}, new int[] {21, 13}, new int[] {22, 13}, new int[] {22, 14}, new int[] {23, 13}, new int[] {23, 14}, new int[] {23, 15}, new int[] {24, 12}, new int[] {24, 13}, new int[] {24, 14}, new int[] {24, 15},
                new int[] {24, 16}, new int[] {15, 10}, new int[] {15, 11}, new int[] {15, 12}, new int[] {15, 13}, new int[] {15, 14}, new int[] {16, 10}, new int[] {16, 11}, new int[] {16, 12}, new int[] {16, 13},
                new int[] {16, 14}, new int[] {8, 14}, new int[] {9, 14}, new int[] {10, 12}, new int[] {10, 13}, new int[] {10, 14}, new int[] {10, 15}, new int[] {10, 16}, new int[] {11, 14}, new int[] {12, 14}, new int[] {0, 17},
                new int[] {1, 17}, new int[] {2, 17}, new int[] {3, 17}, new int[] {4, 17}, new int[] {5, 17}, new int[] {6, 17}, new int[] {8, 17}, new int[] {8, 18}, new int[] {9, 18}, new int[] {10, 18}, new int[] {8, 19},
                new int[] {9, 19}, new int[] {10, 19}, new int[] {3, 20}, new int[] {4, 20}, new int[] {5, 20}, new int[] {8, 20}, new int[] {9, 20}, new int[] {10, 20}, new int[] {3, 21}, new int[] {4, 21}, new int[] {5, 21}, new int[] {8, 21},
                new int[] {0, 22}, new int[] {1, 22}, new int[] {2, 22}, new int[] {3, 22}, new int[] {4, 22}, new int[] {8, 22}, new int[] {0, 23}, new int[] {1, 23}, new int[] {2, 23}, new int[] {3, 23}, new int[] {4, 23},
                new int[] {5, 23}, new int[] {6, 23}, new int[] {7, 23}, new int[] {8, 23}, new int[] {9, 23}, new int[] {4, 24}, new int[] {5, 24}, new int[] {17, 24}, new int[] {18, 24}, new int[] {14, 22}, new int[] {15, 22}, new int[] {16, 22},
                new int[] {17, 22}, new int[] {18, 22}, new int[] {19, 22}, new int[] {20, 22}, new int[] {14, 21}, new int[] {15, 21}, new int[] {16, 21}, new int[] {17, 21}, new int[] {18, 21}, new int[] {19, 21}, new int[] {20, 21},
                new int[] {14, 20}, new int[] {15, 20}, new int[] {16, 20}, new int[] {17, 20}, new int[] {18, 20}, new int[] {19, 20}, new int[] {20, 20}, new int[] {14, 18}, new int[] {15, 18}, new int[] {16, 18}, new int[] {17, 18},
                new int[] {18, 18}, new int[] {19, 18}, new int[] {20, 18}
        ));
        for (int[] entry : blackSpots)
            grid[entry[0]][entry[1]] = 1;
        return grid;
    }
}




