public class SubrectangleQueries {

    public static void main(String[] args) throws Exception {

        int[][] nums = new int[][] {
                { 0, 1, 2, 3 },
                { 0, 1, 2, 3 }
        };

        SubrectangleQueries obj = new SubrectangleQueries(nums);
        obj.updateSubrectangle(0, 0, 1, 1, 9);
        obj.getValue(0, 1);
    }

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= (row2 <= rectangle.length ? row2 : rectangle.length); i++) {
            for (int j = col1; j <= (col2 <= rectangle[0].length ? col2 : rectangle[0].length); j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}