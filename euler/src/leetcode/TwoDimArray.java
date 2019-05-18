package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDimArray {
	
	public static List<List<Integer>> findMatrix(List<List<Integer>> a) {
		int[][] runningTotalMatrix = new int[a.size()][a.get(0).size()];
		for(int i = 0; i < a.size() ; i++) {
			for(int j = 0; j < a.get(i).size(); j++) {
				runningTotalMatrix[i][j] = a.get(i).get(j);
				if(j > 0) {
					runningTotalMatrix[i][j] = runningTotalMatrix[i][j] + runningTotalMatrix[i][j-1];
				}
				if(i > 0) {
					runningTotalMatrix[i][j] = runningTotalMatrix[i][j] + runningTotalMatrix[i-1][j];
				}
				if(i > 0 && j > 0) {
					runningTotalMatrix[i][j] = runningTotalMatrix[i][j] - runningTotalMatrix[i-1][j-1];
				}
			}
		}
		return convert2dArrayIntoList(runningTotalMatrix);
    }

	private static List<List<Integer>> convert2dArrayIntoList(int[][] matrix) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		for (int[] array : matrix) {
			List<Integer> innerList = new ArrayList<>(array.length);
			for(int num: array) {
				innerList.add(num);
			}
		    resultList.add(innerList);
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();

		matrix.add(Arrays.asList(1, 2, 3));
		matrix.add(Arrays.asList(4, 5, 6));
		matrix.add(Arrays.asList(7, 8, 9));
		System.out.println(matrix);
		System.out.println(findMatrix(matrix));
	}
	
}
