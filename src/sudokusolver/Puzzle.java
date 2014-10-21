/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.util.ArrayList;

/**
 *
 * @author ozielcarneiro
 */
public class Puzzle {

    private Square[][] board;
    private ArrayList<Square> queue;

    public Puzzle() {
        board = new Square[9][9];
        queue = new ArrayList<Square>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(i, j);
                queue.add(board[i][j]);
            }
        }
    }

    public int getPos(int i, int j) {
        return getBoard()[i][j].getValue();
    }

    public void updatePos(int i, int j, int value) {
        if (value != 0) {
            getBoard()[i][j].setValue(value);
            for (int k = 0; k < getBoard().length; k++) {
                if (k != i) {
                    getBoard()[k][j].setPossiblePos(value - 1, false);
                }
                if (k != j) {
                    getBoard()[i][k].setPossiblePos(value - 1, false);
                }
            }
            switch (getBoard()[i][j].getQuadrant()) {
                case 1:
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 2:
                    for (int k = 0; k < 3; k++) {
                        for (int l = 3; l < 6; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 3:
                    for (int k = 0; k < 3; k++) {
                        for (int l = 6; l < 9; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 4:
                    for (int k = 3; k < 6; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 5:
                    for (int k = 3; k < 6; k++) {
                        for (int l = 3; l < 6; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 6:
                    for (int k = 3; k < 6; k++) {
                        for (int l = 6; l < 9; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 7:
                    for (int k = 6; k < 9; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 8:
                    for (int k = 6; k < 9; k++) {
                        for (int l = 3; l < 6; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
                case 9:
                    for (int k = 6; k < 9; k++) {
                        for (int l = 6; l < 9; l++) {
                            if (k != i && l != j) {
                                getBoard()[k][l].setPossiblePos(value - 1, false);
                            }
                        }
                    }
                    break;
            }
        }
    }

    public void removeZeros() {
        for (int i = 0; i < getQueue().size(); i++) {
            if (getQueue().get(i).getPossibleCount() == 0) {
                getQueue().remove(i);
            }
        }
    }

    public ArrayList<Square> sortQueue(ArrayList<Square> queue) {
        ArrayList<Square> left = new ArrayList<Square>();
        ArrayList<Square> right = new ArrayList<Square>();
        for (int i = 0; i < queue.size(); i++) {
            if (i < queue.size() / 2) {
                left.add(queue.get(i));
            } else {
                right.add(queue.get(i));
            }
        }
        if (left.size() > 1) {
            left = sortQueue(left);
        }
        if (right.size() > 1) {
            right = sortQueue(right);
        }
        queue = merge(left, right);
        return queue;
    }

    public ArrayList<Square> merge(ArrayList<Square> left, ArrayList<Square> right) {
        int i = 0, j = 0;
        ArrayList<Square> merged = new ArrayList<Square>();
        while (i < left.size() || j < right.size()) {
            if (i < left.size() && j < right.size()) {
                if (left.get(i).getPossibleCount() <= right.get(j).getPossibleCount()) {
                    merged.add(left.get(i));
                    i++;
                } else {
                    merged.add(right.get(j));
                    j++;
                }
            } else if (i < left.size()) {
                merged.add(left.get(i));
                i++;
            } else if (j < right.size()) {
                merged.add(right.get(j));
                j++;
            }
        }
        return merged;
    }

    public boolean isSolved() {
        boolean solved = true;
        //checks each row
        for (Square[] board1 : board) {
            boolean[] check = {false, false, false, false, false, false, false, false, false};
            for (Square board11 : board1) {
                if (board11.getValue() == 0) {
                    return false;
                } else if (check[board11.getValue()-1]) {
                    return false;
                } else {
                    check[board11.getValue()-1] = true;
                }
            }
            for (int i = 0; i < check.length; i++) {
                solved = solved && check[i];
            }
        }
        //checks each column
        for (int i = 0; i < board[1].length; i++) {
            boolean[] check = {false, false, false, false, false, false, false, false, false};
            for (Square[] board1 : board) {
                if (board1[i].getValue() == 0) {
                    return false;
                } else if (check[board1[i].getValue()-1]) {
                    return false;
                } else {
                    check[board1[i].getValue()-1] = true;
                }
            }
            for (int j = 0; j < check.length; j++) {
                solved = solved && check[j];
            }
        }
        //checks each quadrant
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] check = {false, false, false, false, false, false, false, false, false};
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[(i * 3) + k][(j * 3) + l].getValue() == 0) {
                            return false;
                        } else if (check[board[(i * 3) + k][(j * 3) + l].getValue()-1]) {
                            return false;
                        } else {
                            check[board[(i * 3) + k][(j * 3) + l].getValue()-1] = true;
                        }
                    }
                }
                for (int k = 0; k < check.length; k++) {
                    solved = solved && check[k];
                }
            }
        }
        return solved;
    }

    /**
     * @return the board
     */
    public Square[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Square[][] board) {
        this.board = board;
    }

    /**
     * @return the queue
     */
    public ArrayList<Square> getQueue() {
        return queue;
    }

    /**
     * @param queue the queue to set
     */
    public void setQueue(ArrayList<Square> queue) {
        this.queue = queue;
    }

    public void printBoard() {
        String out = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j % 3 == 0 && j != 0) {
                    out += "| ";
                }
                out += board[i][j].getValue() + " ";
            }
            if (i % 3 == 2 && i != 8) {
                out += "\n---------------------\n";
            } else {
                out += "\n";
            }
        }
        System.out.println(out);
    }
}
