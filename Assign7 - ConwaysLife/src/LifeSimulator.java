//import System;

public class LifeSimulator {

    int sizeX;

    int sizeY;

    boolean [][] cells;

    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        cells = new boolean[getSizeY()][getSizeX()];

        for(int i = 0; i < sizeY; i ++) {

            for(int j = 0; j < sizeX; j++) {
                cells[i][j] = false;
            }
        }
    }

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }

    public boolean getCell(int x, int y) {
        return cells[y][x];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {

        for(int j = 0; j < pattern.getSizeY() ; j ++) {

            for(int i = 0; i < pattern.getSizeX(); i ++) {

                cells[i + startX][j + startY] = pattern.getCell(i,j);
            }
        }
    }

    public void update() {

        boolean [][] nextGenCells = new boolean[getSizeY()][getSizeX()];
        // birth death logic for the game
        for(int i = 0; i < cells.length; i ++) {
            for(int j = 0; j < cells[i].length; j ++) {
                boolean [] neighbors = new boolean[8];

                if(i == 0) {
                    if(j == 0) {
                        neighbors[4] = cells[i][j + 1];
                        neighbors[6] = cells[i + 1][j];
                        neighbors[7] = cells[i + 1][j + 1];
                    }
                    else if(j == cells[i].length - 1) {
                        neighbors[3] = cells[i][j - 1];
                        neighbors[5] = cells[i + 1][j - 1];
                        neighbors[6] = cells[i + 1][j];
                    }
                    else {
                        neighbors[3] = cells[i][j - 1];
                        neighbors[4] = cells[i][j + 1];
                        neighbors[5] = cells[i + 1][j - 1];
                        neighbors[6] = cells[i + 1][j];
                        neighbors[7] = cells[i + 1][j + 1];
                    }
                }
                else if(i == cells.length - 1) {
                    if(j == 0) {
                        neighbors[1] = cells[i - 1][j];
                        neighbors[2] = cells[i - 1][j + 1];
                        neighbors[4] = cells[i][j + 1];
                    }
                    else if(j == cells[i].length - 1) {
                        neighbors[0] = cells[i - 1][j - 1];
                        neighbors[1] = cells[i - 1][j];
                        neighbors[3] = cells[i][j - 1];
                    }
                    else {
                        neighbors[0] = cells[i - 1][j - 1];
                        neighbors[1] = cells[i - 1][j];
                        neighbors[2] = cells[i - 1][j + 1];
                        neighbors[3] = cells[i][j - 1];
                        neighbors[4] = cells[i][j + 1];
                    }
                }
                else if(j == 0) {
                    neighbors[1] = cells[i - 1][j];
                    neighbors[2] = cells[i - 1][j + 1];
                    neighbors[4] = cells[i][j + 1];
                    neighbors[6] = cells[i + 1][j];
                    neighbors[7] = cells[i + 1][j + 1];
                }
                else if(j == cells[i].length - 1) {
                    neighbors[0] = cells[i - 1][j - 1];
                    neighbors[1] = cells[i - 1][j];
                    neighbors[3] = cells[i][j - 1];
                    neighbors[5] = cells[i + 1][j - 1];
                    neighbors[6] = cells[i + 1][j];
                }
                else {
                    neighbors[0] = cells[i - 1][j - 1];
                    neighbors[1] = cells[i - 1][j];
                    neighbors[2] = cells[i - 1][j + 1];
                    neighbors[3] = cells[i][j - 1];
                    neighbors[4] = cells[i][j + 1];
                    neighbors[5] = cells[i + 1][j - 1];
                    neighbors[6] = cells[i + 1][j];
                    neighbors[7] = cells[i + 1][j + 1];
                }

                int liveNeighboors = 0;

                // iterate over neighbors array and tally current living neighboors
                for(int k = 0; k < neighbors.length; k ++) {
                    if(neighbors[k] == true) {
                        liveNeighboors ++;
                    }
                }

                if(liveNeighboors >= 2 && nextGenCells[i][j] == true) {
                    nextGenCells[i][j] = true;
                }
                else if(liveNeighboors > 2) {
                    nextGenCells[i][j] = true;
                }
                else {
                    nextGenCells[i][j] = false;
                }
            }
        }

        cells = nextGenCells;
    }
}