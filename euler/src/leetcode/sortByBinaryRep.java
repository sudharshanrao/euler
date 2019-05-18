package leetcode;
import java.util.Comparator;

public class sortByBinaryRep implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		//System.out.println("num1="+num1+"::num2="+num2);
		String binaryRep1 = Integer.toBinaryString(num1);
		String binaryRep2 = Integer.toBinaryString(num2);
		//System.out.println("binaryRep1="+binaryRep1+"::binaryRep2="+binaryRep2);
		int bits1 = countBits(binaryRep1);
		int bits2 = countBits(binaryRep2);
		//System.out.println("bits1="+bits1+"::bits2="+bits2);
		if(bits1 == bits2) {
			return num1 - num2;
		}
		else {
			return bits1 - bits2;
		}
	}

	private int countBits(String a){
		int count = 0;
		for(char c: a.toCharArray()) {
			if(c == '1') {
				count++;
			}
		}
		return count;
	}
	
}
