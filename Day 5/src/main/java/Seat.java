public class Seat {

    private int row;
    private int column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Seat(String binarySpacePartitioning) {
        int[] coordinates = traverse(binarySpacePartitioning, 0, new int[] {0, 127, 0 ,7});
        this.row = coordinates[0];
        this.column = coordinates[2];
    }

    private int[] traverse(String binarySpacePartitioning, int index, int[] rowsAndColumns) {
        if (index == binarySpacePartitioning.length()) {
            return rowsAndColumns;
        }
        char currentChar = binarySpacePartitioning.charAt(index);
        switch (currentChar) {
            case 'F':
                rowsAndColumns[1] = rowsAndColumns[0] + ((rowsAndColumns[1] - rowsAndColumns[0]) / 2);
                break;
            case 'B':
                rowsAndColumns[0] = rowsAndColumns[1] - ((rowsAndColumns[1] - rowsAndColumns[0]) / 2);
                break;
            case 'L':
                rowsAndColumns[3] = rowsAndColumns[2] + ((rowsAndColumns[3] - rowsAndColumns[2]) / 2);
                break;
            case 'R':
                rowsAndColumns[2] = rowsAndColumns[3] + ((rowsAndColumns[2] - rowsAndColumns[3]) / 2);
                break;
        }
        return traverse(binarySpacePartitioning, index + 1, rowsAndColumns);
    }

    public int getID() {
        return row * 8 + column;
    }

    @Override
    public String toString() {
        return String.format("%d, %d: %d", row, column, getID());
    }
}
