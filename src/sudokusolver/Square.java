/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

/**
 *
 * @author ozielcarneiro
 */
public class Square {
    
    private int value;
    private int column;
    private int row;
    private int quadrant;
    private boolean[] possible;
    private int possibleCount;
    
    public Square(int row, int column){
        this.column = column;
        this.row = row;
        value = 0;
        possible = new boolean[9];
        for (int i = 0; i < possible.length; i++) {
            possible[i] = true;
        }
        if(this.row<3&&this.column<3) {
            quadrant = 1;
        }
        else if(this.row<3&&this.column<6) {
            quadrant = 2;
        }
        else if(this.row<3) {
            quadrant = 3;
        }
        else if(this.row<6&&this.column<3) {
            quadrant = 4;
        }
        else if(this.row<6&&this.column<6) {
            quadrant = 5;
        }
        else if(this.row<6) {
            quadrant = 6;
        }
        else if(this.column<3) {
            quadrant = 7;
        }
        else if(this.column<6) {
            quadrant = 8;
        }
        else {
            quadrant = 9;
        }
        possibleCount = 9;
    }
    
    public Square(Square sq){
        this.value = sq.value;
        this.column = sq.column;
        this.row = sq.row;
        this.quadrant = sq.quadrant;
        this.possibleCount = sq.possibleCount;
        this.possible = sq.possible.clone();
    }
    
    public int getPossibleValue(){
        int possibleValue = 0;
        for (int i = 0; i < possible.length; i++) {
            if(possible[i]&&possibleValue==0){
                possibleValue = i+1;
            }else if(possible[i]&&possibleValue!=0){
                possibleValue = 0;
            }
        }
        return possibleValue;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        if(value>0&&value<=9){
            this.value = value;
            for (int i = 0; i < getPossible().length; i++) {
                getPossible()[i] = false;
            }
            possibleCount = 0;
        }else{
            this.value = 0;
        }
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the quadrant
     */
    public int getQuadrant() {
        return quadrant;
    }

    /**
     * @param quadrant the quadrant to set
     */
    public void setQuadrant(int quadrant) {
        this.quadrant = quadrant;
    }

    /**
     * @return the possible
     */
    public boolean[] getPossible() {
        return possible;
    }

    /**
     * @param possible the possible to set
     */
    public void setPossible(boolean[] possible) {
        this.possible = possible;
    }

    public void setPossiblePos(int pos, boolean status){
        if(possible[pos] != status){
            possible[pos] = status;
            if(status==false){
                possibleCount--;
            }else{
                possibleCount++;
            }
        }
    }

    /**
     * @return the possibleCount
     */
    public int getPossibleCount() {
        return possibleCount;
    }

    /**
     * @param possibleCount the possibleCount to set
     */
    public void setPossibleCount(int possibleCount) {
        this.possibleCount = possibleCount;
    }
    
    
}
