/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

/**
 *
 * @author ozielcarneiro
 */
public class Test {
    
    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        //EASY PUZZLE
//        p.updatePos(0, 1, 5);
//        p.updatePos(0, 5, 3);
//        p.updatePos(0, 8, 6);
//        p.updatePos(1, 1, 9);
//        p.updatePos(1, 3, 5);
//        p.updatePos(1, 6, 7);
//        p.updatePos(1, 7, 8);
//        p.updatePos(2, 2, 8);
//        p.updatePos(2, 5, 9);
//        p.updatePos(2, 6, 3);
//        p.updatePos(3, 0, 4);
//        p.updatePos(3, 3, 2);
//        p.updatePos(3, 4, 6);
//        p.updatePos(3, 6, 8);
//        p.updatePos(4, 0, 1);
//        p.updatePos(4, 1, 8);
//        p.updatePos(4, 3, 9);
//        p.updatePos(4, 4, 3);
//        p.updatePos(4, 5, 4);
//        p.updatePos(4, 7, 6);
//        p.updatePos(4, 8, 7);
//        p.updatePos(5, 2, 7);
//        p.updatePos(5, 4, 8);
//        p.updatePos(5, 5, 5);
//        p.updatePos(5, 8, 4);
//        p.updatePos(6, 2, 4);
//        p.updatePos(6, 3, 3);
//        p.updatePos(6, 6, 6);
//        p.updatePos(7, 1, 1);
//        p.updatePos(7, 2, 6);
//        p.updatePos(7, 5, 8);
//        p.updatePos(7, 7, 4);
//        p.updatePos(8, 0, 8);
//        p.updatePos(8, 3, 4);
//        p.updatePos(8, 7, 2);
        
        //VERY HARD PUZZLE
        p.updatePos(0, 0, 5);
        p.updatePos(0, 3, 8);
        p.updatePos(0, 4, 6);
        p.updatePos(0, 6, 2);
        p.updatePos(1, 3, 9);
        p.updatePos(1, 6, 5);
        p.updatePos(1, 7, 4);
        p.updatePos(2, 1, 4);
        p.updatePos(2, 3, 1);
        p.updatePos(3, 0, 9);
        p.updatePos(3, 3, 4);
        p.updatePos(3, 6, 8);
        p.updatePos(5, 2, 5);
        p.updatePos(5, 5, 9);
        p.updatePos(5, 8, 2);
        p.updatePos(6, 5, 1);
        p.updatePos(6, 7, 7);
        p.updatePos(7, 1, 8);
        p.updatePos(7, 2, 7);
        p.updatePos(7, 5, 3);
        p.updatePos(8, 2, 6);
        p.updatePos(8, 4, 8);
        p.updatePos(8, 5, 7);
        p.updatePos(8, 8, 9);
        p.printBoard();
        //System.out.println(p.isSolved());
        //Puzzle cp = new Puzzle(p);
        long start = System.currentTimeMillis();
        Solver.solve(p);
        long end = System.currentTimeMillis();
        p.printBoard();
        System.out.println(p.isSolved()+" in "+(end-start)+" ms");
    }
    
}
