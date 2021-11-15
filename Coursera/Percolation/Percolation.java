import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int row_col;
    private boolean[][] sites;
    private int countSitesOpen;
    private boolean isPercolation;
    private final WeightedQuickUnionUF topUF;
    private final WeightedQuickUnionUF botUF;

    public Percolation(int n) {
        if(n <= 0)
            throw new IllegalArgumentException();
        sites = new boolean[n][n];
        countSitesOpen = 0;
        isPercolation = false;
        row_col = n;
        topUF = new WeightedQuickUnionUF(n * n + 1);
        botUF = new WeightedQuickUnionUF(n * n + 1);
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                sites[i][j] = false;
    }

    private void outBounds(int i, int j) {
        if(i < 1 || i > row_col || j < 1 || j > row_col)
            throw new IllegalArgumentException("Illegal");
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        outBounds(row, col);
        if(sites[row - 1][col - 1])
            return;
        sites[row-1][col-1] = true;
        countSitesOpen++;

        if(row_col == 1) {
            topUF.union(0, 1);
            botUF.union(0, 1);
            isPercolation = true;
            return;
        }
        if(row == 1)
            topUF.union(row_col * row_col, col - 1);
        if(row == row_col)
            botUF.union(row_col * row_col, (row_col - 1) * row_col + col - 1);
        if(row > 1 && sites[row-2][col-1]) {
            topUF.union((row - 2) * row_col + col - 1, (row - 1) * row_col + col - 1);
            botUF.union((row - 2) * row_col + col - 1, (row - 1) * row_col + col - 1);
        }
        if(row < row_col && sites[row][col-1]) {
            topUF.union(row * row_col + col - 1, (row - 1) * row_col + col - 1);
            botUF.union(row * row_col + col - 1, (row - 1) * row_col + col - 1);
        }
        if(col > 1 && sites[row-1][col-2]) {
            topUF.union((row - 1) * row_col + col - 2, (row - 1) * row_col + col - 1);
            botUF.union((row - 1) * row_col + col - 2, (row - 1) * row_col + col - 1);
        }
        if(col < row_col && sites[row-1][col]) {
            topUF.union((row - 1) * row_col + col, (row - 1) * row_col + col - 1);
            botUF.union((row - 1) * row_col + col, (row - 1) * row_col + col - 1);
        }

        isPercolate(row, col);
    }

    private void isPercolate(int row, int col) {
        if(!isPercolation && countSitesOpen >= row_col && topUF.connected(row_col * row_col, (row - 1) *
                row_col + col - 1) && botUF.connected(row_col * row_col, (row - 1) * row_col + col - 1)) {
            isPercolation = true;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        outBounds(row, col);
        return sites[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        outBounds(row, col);
        if(isOpen(row, col) && topUF.connected(row_col * row_col, (row - 1) * row_col + col - 1))
            return true;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return countSitesOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return isPercolation;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        p.open(2, 1);
        p.open(3, 3);
        System.out.println(p.percolates());
        p.open(3, 1);
        System.out.println(p.percolates());
    }
    /**
     * 11 12 13
     * 21 22 23
     * 31 32 33
     */

}
