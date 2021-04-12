public class PatternAcorn extends Pattern {

    public boolean [][] cells = {
            {false, false, false, false, false, false, false, false, false},
            {false, false, true, false, false, false, false, false, false},
            {false, false, false, false, true, false, false, false, false},
            {false, true, true, false, false, true, true, true, false},
            {false, false, false, false, false, false, false, false, false}
    };

    public int getSizeX() {
        return 9;
    }

    public int getSizeY() {
        return 5;
    }

    public boolean getCell(int x, int y) {

        return false;
    }
}
