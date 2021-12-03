package Week12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {
    private Queue<Integer> queue = new LinkedList<>();
    private int[][] graph;
    private int[] distance;
    private boolean[] marked;
    private int n, m;

    public BreadthFirstSearchShortestReach(int n, int m) {
        this.n = n;
        this.m = m;
        graph = new int[n][n];
        distance = new int[n];
        marked = new boolean[n];
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            BreadthFirstSearchShortestReach bfs = new BreadthFirstSearchShortestReach(n, m);

            for (int j = 0; j < m; j++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                bfs.graph[u][v] = 1;
                bfs.graph[v][u] = 1;
            }

            int s = scanner.nextInt() - 1;

            shortest_reach(bfs, s);
        }
    }

    private static void shortest_reach(BreadthFirstSearchShortestReach bfs, int s) {
        bfs.marked[s] = true;

        bfs.queue.add(s);

        while (!bfs.queue.isEmpty()){
            int v = bfs.queue.remove();
            for (int i = 0; i < bfs.n; i++) {
                if (bfs.graph[v][i] == 1 && !bfs.marked[i]){
                    bfs.marked[i] = true;
                    bfs.queue.add(i);
                    bfs.distance[i] = bfs.distance[v] + 6;
                }
            }
        }

        for (int i = 0; i < bfs.n; i++) {
            if (i == s)
                continue;
            if (bfs.marked[i])
                System.out.print(bfs.distance[i] + " ");
            else
                System.out.print("-1 ");
        }
        System.out.println();
        int[] a;
    }

}

// Cre: https://www.thepoorcoder.com