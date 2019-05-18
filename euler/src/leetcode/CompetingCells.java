package leetcode;
import java.util.ArrayList;
import java.util.List;
public class CompetingCells
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] newCells = new int[states.length];
        for (int k = 0; k < days; k++) {
            for (int i = 0; i < states.length; i++) {
                int nextCell;
                int prevCell;
                int activenumber;
                if (i == 0) {
                    // edge cases
                    nextCell = states[1];
                    prevCell = 0;
                } else if (i == states.length - 1) {
                    // edge case
                    prevCell = states[states.length - 2];
                    nextCell = 0;
                } else {
                    nextCell = states[i + 1];
                    prevCell = states[i - 1];
                }
                if (nextCell == prevCell) {
                    // set it to inactive
                    activenumber = 0;
                } else {
                    //set it to active
                    activenumber = 1;
                }
                newCells[i] = activenumber;
            }
            for (int j = 0; j < 8; j++) {
                states[j] = newCells[j];
            }
        }
        List<Integer> resultList = new ArrayList<>(newCells.length);
        for(int num: newCells) {
        	resultList.add(num);
        }
        return resultList;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,1,1,0,1,1,1,1};
    	int k = 2;
    	
    	CompetingCells obj = new CompetingCells();
    	List<Integer> list = obj.cellCompete(arr, k);
    	System.out.println(list);
    	
    	//expected
    	//{0,0,0,0,0,1,1,0}
    }
}