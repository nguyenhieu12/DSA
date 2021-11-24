import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;

public class Solver {
    private SearchNode currentNode;
    private SearchNode twinNode;
    private ArrayList<Board> solution;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if(initial == null)
            throw new IllegalArgumentException("Illegal");
        currentNode = new SearchNode(initial, null);
        twinNode = new SearchNode(initial.twin(), null);
        MinPQ<SearchNode> currentMinPQ = new MinPQ<SearchNode>();
        MinPQ<SearchNode> twinMinPQ = new MinPQ<SearchNode>();

        currentMinPQ.insert(currentNode);
        twinMinPQ.insert(twinNode);

        while(true) {
            currentNode = currentMinPQ.delMin();
            if(currentNode.getSearchNodeBoard().isGoal())
                break;
            putNeighBors(currentNode, currentMinPQ);

            twinNode = twinMinPQ.delMin();
            if(twinNode.getSearchNodeBoard().isGoal())
                break;
            putNeighBors(twinNode, twinMinPQ);
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return currentNode.getSearchNodeBoard().isGoal();
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if(currentNode.getSearchNodeBoard().isGoal())
            return currentNode.getMoves();
        else if(twinNode.getSearchNodeBoard().isGoal())
            return twinNode.getMoves();
        else return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if(currentNode.getSearchNodeBoard().isGoal()) {
            solution = new ArrayList<>();
            SearchNode curNode = currentNode;
            while(curNode != null) {
                solution.add(curNode.getSearchNodeBoard());
                curNode = curNode.pre;
            }
            return solution;
        }
        else if(twinNode.getSearchNodeBoard().isGoal()) {
            solution = new ArrayList<>();
            SearchNode curNode = twinNode;
            while(curNode != null) {
                solution.add(curNode.getSearchNodeBoard());
                curNode = curNode.pre;
            }
            return solution;
        }
        else return null;
    }

    private void putNeighBors(SearchNode searchNode, MinPQ<SearchNode> minPQ) {
        Iterable<Board> neighbors = searchNode.getSearchNodeBoard().neighbors();
            for(Board neighbor : neighbors) {
                if(searchNode.pre == null || !neighbor.equals(searchNode.pre.getSearchNodeBoard()))
                    minPQ.insert(new SearchNode(neighbor,searchNode));
            }
    }

    private class SearchNode implements Comparable<SearchNode> {
        private Board searhNodeBoard;
        private final int moves;
        private final int priority;
        private SearchNode pre;

        public SearchNode(Board board, SearchNode searchNode) {
            searhNodeBoard = board;
            pre = searchNode;
            if(searchNode == null)
                moves = 0;
            else moves = searchNode.moves + 1;
            priority = moves + searhNodeBoard.manhattan();
        }

        public Board getSearchNodeBoard() {
            return searhNodeBoard;
        }

        public int getMoves() {
            return moves;
        }

        @Override
        public int compareTo(SearchNode o) {
            return Integer.compare(this.priority, o.priority);
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        int[][] a = {{7,0,4}, {8,5,1}, {6,3,2}};
        Board board = new Board(a);
        Solver solver = new Solver(board);
        Iterable<Board> iterable = solver.solution();
        System.out.println(solver.moves());
        for(Board board1 : iterable)
            System.out.println(board1.toString());
    }

}
