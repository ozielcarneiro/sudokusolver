/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;


/**
 *
 * @author ozielcarneiro
 */
public class Solver {

    public static boolean solve(Puzzle puzz) {
        int i = 0;
        while (!puzz.getQueue().isEmpty()) {
            puzz.setQueue(puzz.sortQueue(puzz.getQueue()));
            puzz.removeZeros();
            if (puzz.getQueue().isEmpty()) {
                break;
            }
            Square sq = puzz.getQueue().get(0);
            int x = sq.getRow();
            int y = sq.getColumn();

            if (sq.getPossibleCount() == 1) {
                int value = sq.getPossibleValue();
                if (value != 0) {
                    puzz.updatePos(x, y, value);
                    //To display solution log in terminal uncomment line below
                    //System.out.println(i+": Only value possible: ("+x+","+y+") = "+value);
                } else {
                    return false;
                }
            } else if (sq.getPossibleCount() > 1) {
                //Check for squares that can are the only possible location for a value
                boolean change = false;
                change = checkRows(puzz) || change;
                change = checkColumns(puzz) || change;
                change = checkQuadrant(puzz) || change;
                //Branching for multiple solutions
                if (!change) {
                    int[] branch = new int[sq.getPossibleCount()];
                    int k = 0;
                    for (int j = 0; j < sq.getPossible().length; j++) {
                        if (sq.getPossible()[j]) {
                            branch[k] = j + 1;
                            k++;
                        }
                    }
                    k = 0;
                    boolean solved = false;
                    while (k < branch.length) {
                        Puzzle copyPuzz = new Puzzle(puzz);
                        copyPuzz.updatePos(x, y, branch[k]);
                        //To display solution log in terminal uncomment line below
                        //System.out.println(i+": Branch: ("+x+","+y+") = "+branch[k]);
                        solved = solve(copyPuzz);
                        if (solved) {
                            for (int j = 0; j < copyPuzz.getBoard().length; j++) {
                                for (int l = 0; l < copyPuzz.getBoard()[j].length; l++) {
                                    if (puzz.getPos(j, l) == 0) {
                                        puzz.updatePos(j, l, copyPuzz.getPos(j, l));
                                    }
                                }
                            }
                            break;
                        }else{
                            //To display change log in terminal uncomment line below
                            //System.out.println("Fail Branch");
                            k++;
                        }
                    }
                    if(!solved){
                        return false;
                    }
                }else{
                    //To display solution log in terminal uncomment line below
                    //System.out.println(i+": Row, Column or Quadrant Change");
                }

            }
            if (i > 100) {
                break;
            }
            i++;
        }
        return puzz.isSolved();
    }

    public static boolean checkRows(Puzzle puzz) {
        boolean change = false;
        for (int i = 0; i < puzz.getBoard().length; i++) {
            for (int j = 0; j < 9; j++) {
                boolean oneSq = false;
                int idx = 0;
                for (int k = 0; k < puzz.getBoard()[i].length; k++) {
                    if (i == 5 && j == 7 && k == 0) {
                        boolean x = true;
                    }
                    if (puzz.getBoard()[i][k].getPossible()[j] && !oneSq) {
                        oneSq = true;
                        idx = k;
                    } else if (puzz.getBoard()[i][k].getPossible()[j] && oneSq) {
                        oneSq = false;
                        idx = 0;
                        break;
                    }
                }
                if (oneSq) {
                    puzz.updatePos(i, idx, j + 1);
                    //To display solution log in terminal uncomment line below
                    //System.out.println("Only square on row possible: ("+i+","+idx+") = "+(j+1));
                    change = true;
                }
            }
        }
        return change;
    }

    public static boolean checkColumns(Puzzle puzz) {
        boolean change = false;
        for (int i = 0; i < puzz.getBoard()[1].length; i++) {
            for (int j = 0; j < 9; j++) {
                boolean oneSq = false;
                int idx = 0;
                for (int k = 0; k < puzz.getBoard().length; k++) {
                    if (puzz.getBoard()[k][i].getPossible()[j] && !oneSq) {
                        oneSq = true;
                        idx = k;
                    } else if (puzz.getBoard()[k][i].getPossible()[j] && oneSq) {
                        oneSq = false;
                        idx = 0;
                        break;
                    }
                }
                if (oneSq) {
                    puzz.updatePos(idx, i, j + 1);
                    //To display solution log in terminal uncomment line below
                    //System.out.println("Only square on col possible: ("+idx+","+i+") = "+(j+1));
                    change = true;
                }
            }
        }
        return change;
    }

    public static boolean checkQuadrant(Puzzle puzz) {
        boolean change = false;
        for (int i = 0; i < 9; i++) {
            int qdx = i / 3;
            int qdy = i % 3;
            for (int j = 0; j < 9; j++) {
                boolean oneSq = false;
                int idx = 0;
                int idy = 0;
                for (int k = 0; k < 3; k++) {
                    boolean brkStatus = false;
                    for (int l = 0; l < 3; l++) {
                        if (puzz.getBoard()[qdx*3+k][qdy*3+l].getPossible()[j] && !oneSq) {
                            oneSq = true;
                            idx = qdx*3+k;
                            idy = qdy*3+l;
                        } else if (puzz.getBoard()[qdx*3+k][qdy*3+l].getPossible()[j] && oneSq) {
                            oneSq = false;
                            idx = 0;
                            idy = 0;
                            brkStatus = true;
                            break;
                        }
                    }
                    if(brkStatus){
                        break;
                    }
                }
                if (oneSq) {
                    puzz.updatePos(idx, idy, j + 1);
                    //To display solution log in terminal uncomment line below
                    //System.out.println("Only square on quad possible: ("+idx+","+idy+") = "+(j+1));
                    change = true;
                }
            }
        }
        return change;
    }
}
