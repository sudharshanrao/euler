package leetcode;
import java.util.Arrays;

public class LocalMinima {
	
	public static void main(String[] args) {
		int[] numArr = {9, 1, 3, 2, 7, -3};
		//System.out.println(find(numArr));
		System.out.println(findWithBinarySearch(numArr));
	}

	private static int find(int[] numArr) {
		if(numArr == null || numArr.length == 0) {
			return -1;
		}
		for(int i = 0; i < numArr.length - 1; i++) {
			if(numArr[i] < numArr[i + 1]) {
				return numArr[i];
			}
		}
		return numArr[numArr.length - 1];
	}
	
	private static int findWithBinarySearch(int[] numArr) {
		if(numArr == null || numArr.length == 0) {
			return -1;
		}
		int low = 0; 
		int high = numArr.length - 1;
		
		while(low < high) {
			int mid = low + (high - low) / 2;
			if( mid == 0 || (numArr[mid] < numArr[mid + 1]) && (numArr[mid] < numArr[mid - 1 ])) {
				return numArr[mid];
			}
			else if ( numArr[mid] >= numArr[mid - 1] ) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return numArr[low];
	}
	
}
