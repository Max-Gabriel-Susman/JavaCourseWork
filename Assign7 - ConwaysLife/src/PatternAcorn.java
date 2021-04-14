public class PatternAcorn extends Pattern {

    public boolean [][] oldCells = {
            {false, false, false, false, false, false, false, false, false},
            {false, false, true, false, false, false, false, false, false},
            {false, false, false, false, true, false, false, false, false},
            {false, true, true, false, false, true, true, true, false},
            {false, false, false, false, false, false, false, false, false}
    };

    public boolean [][] cells = {
            {false, false, false, false, false},
            {false, false, false, true, false},
            {false, true, false, true, false},
            {false, false, false, false, false},
            {false, false, true, false, false},
            {false, false, false, true, false},
            {false, false, false, true, false},
            {false, false, false, true, false},
            {false, false, false, false, false},
    };

    public int getSizeX() {
        return 9;
    }

    public int getSizeY() {
        return 5;
    }

    public boolean getCell(int x, int y) {
        return cells[x][y];
    }
}
