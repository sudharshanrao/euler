package leetcode;


import java.util.List;



public class RobotGrid
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
    	int m = 0;
    	int n = 0;
    	for(List<Integer> rowList: lot) {
    		for(Integer num: rowList) {
    			if(num == 9 ) {
    				break;
    			}
    			n++;
    		}
    		m++;
    	}
    	// to store min cells required to be 
        // covered to reach a particular cell 
        int dp[][] = new int[numRows][numColumns]; 
        
        // initially no cells can be reached 
        for (int i = 0; i < numRows; i++) 
            for (int j = 0; j < numColumns; j++) 
                dp[i][j] = Integer.MAX_VALUE; 
        
        // base case 
        dp[0][0] = 1; 
        
        for (int i = 0; i < lot.size(); i++) {
        	List<Integer> columnList = lot.get(i);
            for (int j = 0; j < columnList.size(); j++) { 
        
                // dp[i][j] != INT_MAX denotes that cell 
                // (i, j) can be reached from cell (0, 0) 
                // and the other half of the condition 
                // finds the cell on the right that can 
                // be reached from (i, j) 
                if (dp[i][j] != Integer.MAX_VALUE &&  
                   (j + columnList.get(j)) < numColumns && (dp[i][j] + 1) 
                   < dp[i][j + columnList.get(j)]
                		   && columnList.get(j) != 0) 
                    dp[i][j + columnList.get(j)] = dp[i][j] + 1; 
        
                if (dp[i][j] != Integer.MAX_VALUE &&  
                   (i + columnList.get(j)) < numRows && (dp[i][j] + 1) 
                   < dp[i + columnList.get(j)][j] && columnList.get(j) != 0) 
                    dp[i + columnList.get(j)][j] = dp[i][j] + 1; 
            } 
        } 
                
        if (dp[m - 1][n - 1] != Integer.MAX_VALUE) 
            return dp[m - 1][n - 1]; 
        
        return -1; 
    }
}