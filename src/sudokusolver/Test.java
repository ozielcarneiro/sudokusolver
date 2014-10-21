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
        p.updatePos(0, 1, 5);
        p.updatePos(0, 5, 3);
        p.updatePos(0, 8, 6);
        p.updatePos(1, 1, 9);
        p.updatePos(1, 3, 5);
        p.updatePos(1, 6, 7);
        p.updatePos(1, 7, 8);
        p.updatePos(2, 2, 8);
        p.updatePos(2, 5, 9);
        p.updatePos(2, 6, 3);
        p.updatePos(3, 0, 4);
        p.updatePos(3, 3, 2);
        p.updatePos(3, 4, 6);
        p.updatePos(3, 6, 8);
        p.updatePos(4, 0, 1);
        p.updatePos(4, 1, 8);
        p.updatePos(4, 3, 9);
        p.updatePos(4, 4, 3);
        p.updatePos(4, 5, 4);
        p.updatePos(4, 7, 6);
        p.updatePos(4, 8, 7);
        p.updatePos(5, 2, 7);
        p.updatePos(5, 4, 8);
        p.updatePos(5, 5, 5);
        p.updatePos(5, 8, 4);
        p.updatePos(6, 2, 4);
        p.updatePos(6, 3, 3);
        p.updatePos(6, 6, 6);
        p.updatePos(7, 1, 1);
        p.updatePos(7, 2, 6);
        p.updatePos(7, 5, 8);
        p.updatePos(7, 7, 4);
        p.updatePos(8, 0, 8);
        p.updatePos(8, 3, 4);
        p.updatePos(8, 7, 2);
        p.printBoard();
        
        Solver s = new Solver();
        s.solve(p);
        p.printBoard();
    }
    
}
