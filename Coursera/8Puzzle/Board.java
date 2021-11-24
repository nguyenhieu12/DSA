import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int[][] puzzles;
    private final int dimension;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if(tiles == null)
            throw new IllegalArgumentException("Illegal");
        dimension = tiles.length;
        puzzles = new int[dimension][dimension];
        for(int i = 0;i < dimension;i++)
            for(int j = 0;j < dimension;j++)
                puzzles[i][j] = tiles[i][j];
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder(dimension + "\n");
        for(int i = 0;i < dimension;i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", puzzles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return dimension;
    }

    /**
     * 00 01 02     1 2 3     puzzle[0][1] = 1 = 0 * 3 + 0 + 1
     * 10 11 12 ->  4 5 6 ->  puzzle[1][2] = 5 = 1 * 3 + 0 + 2
     * 20 21 22     7 8 0     puzzle[2][1] = 8 = 2 * 3 + 1 + 1
     */
    private int getValue(int i, int j) {
        return i * dimension + j + 1;
    }

    // number of tiles out of place
    public int hamming() {
        int hamming = 0;
        for(int i = 0;i < dimension;i++)
            for(int j = 0;j < dimension;j++)
                if(puzzles[i][j] != 0 && puzzles[i][j] != getValue(i, j))
                    hamming++;

        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int mahattan = 0;
        for(int i = 0;i < dimension;i++)
            for(int j = 0;j < dimension;j++)
                if(puzzles[i][j] != 0 && puzzles[i][j] != getValue(i, j)) {
                    mahattan += (Math.abs((puzzles[i][j] - 1) / dimension - i)
                            + Math.abs((puzzles[i][j] - 1) % dimension - j));
                }

        return mahattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if(y == null)
            return false;
        if(y == this)
            return true;
        if(y.getClass().isInstance(this)) {
            Board cur = (Board) y;
            return Arrays.deepEquals(cur.puzzles, this.puzzles);
//            for(int i = 0;i < dimension;i++)
//                for(int j = 0;j < dimension;j++)
//                    if(cur.puzzles[i][j] != puzzles[i][j])
//                        return false;
//
//            return true;
        }

        return false;
    }

    private void swap(int row1, int col1, int row2, int col2) {
        int value = puzzles[row1][col1];
        puzzles[row1][col1] = puzzles[row2][col2];
        puzzles[row2][col2] = value;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();
        for(int i = 0;i < dimension;i++) {
            for(int j = 0;j < dimension;j++) {
                if(puzzles[i][j] == 0) {
                    // up
                    if(i > 0) {
                        Board neighUP = new Board(puzzles);
                        neighUP.swap(i, j, i - 1, j);
                        neighbors.add(neighUP);
                    }
                    // down
                    if(i < dimension - 1) {
                        Board neighDOWN = new Board(puzzles);
                        neighDOWN.swap(i, j, i + 1, j);
                        neighbors.add(neighDOWN);
                    }
                    // left
                    if(j > 0) {
                        Board neighLEFT = new Board(puzzles);
                        neighLEFT.swap(i, j, i, j - 1);
                        neighbors.add(neighLEFT);
                    }
                    // right
                    if(j < dimension - 1) {
                        Board neighRIGHT = new Board(puzzles);
                        neighRIGHT.swap(i, j, i, j + 1);
                        neighbors.add(neighRIGHT);
                    }
                }
            }
        }
        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        Board newPuzzles = new Board(puzzles);
        int row = 0, col = 0;
        if(puzzles[row][col] == 0) {
            row++;
        }
        for(int i = 0;i < dimension;i++) {
            for(int j = 0;j < dimension;j++) {
                if(puzzles[i][j] != 0 && puzzles[i][j] != puzzles[row][col]) {
                    newPuzzles.swap(i, j, row, col);
                    return newPuzzles;
                }
            }
        }

        return newPuzzles;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
//        int[][] a = {{0,1,3},{4,2,5},{7,8,6}};
//        Board board = new Board(a);
//        Iterable<Board> iterable = board.neighbors();
//        for(Board board1 : iterable) {
//            System.out.println(board1.toString());
//        }
    }

}
