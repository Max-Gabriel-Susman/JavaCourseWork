public class PatternBlock extends Pattern {

    public boolean [][] cells = {
            {false, false, false, false},
            {false, true, true, false},
            {false, true, true, false},
            {false, false, false, false}
    };

    public int getSizeX() {

        return 4;
    }

    public int getSizeY() {


        return 4;
    }

    public boolean getCell(int x, int y) {

        return false;
    }
}
