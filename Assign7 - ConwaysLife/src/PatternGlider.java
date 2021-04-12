public class PatternGlider extends Pattern {

    public boolean [][] cells = {
            {false, false, false, false, false},
            {false, false, false, true, false},
            {false, true, false, true, false},
            {false, false, true, true, false},
            {false, false, false, false, false}
    };

    public int getSizeX() {
        return 5;
    }

    public int getSizeY() {
        return 5;
    }

    public boolean getCell(int x, int y) {

        return false;
    }
}
