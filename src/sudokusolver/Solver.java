/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ozielcarneiro
 */
public class Solver {
    
    public boolean solve(Puzzle puzz){
        int i = 0;
        while(!puzz.getQueue().isEmpty()){
            puzz.setQueue(puzz.sortQueue(puzz.getQueue()));
            puzz.removeZeros();
            if(puzz.getQueue().isEmpty()){
                break;
            }
            int x = puzz.getQueue().get(0).getRow();
            int y = puzz.getQueue().get(0).getColumn();
            int value = puzz.getQueue().get(0).getPossibleValue();
            if(value!=0){
                puzz.updatePos(x, y, value);
            }else if(puzz.getQueue().get(0).getPossibleCount()>1){
                //
                JOptionPane.showMessageDialog(null, "The current solver is not equiped to solve this puzzle, or"
                        + " information inserted is incomplete or inaccurate.");
                return false;
            }
            if(i>100){
                break;
            }
            i++;
        }
        return puzz.isSolved();
    }
    
}
