package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Amazon online assessment for Alexa news team
 * @author sudharshan
 *
 */

public class SortLexicograph {
	
	public List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList){
		List<String> resultList = new ArrayList<>(numberOfBoxes);
		List<String> oldGenBoxList = new ArrayList<>();
		List<String> newGenBoxList = new ArrayList<>();
		if(boxList == null || boxList.size() == 0) {
			return resultList;
		}
		
		for(String box: boxList) {
			String[] boxVersionArray = box.split(" ");
			if(isNewGen(boxVersionArray)) {
				newGenBoxList.add(box);
			}
			else {
				oldGenBoxList.add(box);
			}
		}
		Collections.sort(oldGenBoxList, new OldGenBoxComparator());
		for(String box: oldGenBoxList) {
			resultList.add(box);
		}
		for(String box: newGenBoxList) {
			resultList.add(box);
		}
		return resultList;
	}
	
	class OldGenBoxComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String[] boxVersion1 = o1.split(" ");
			String[] boxVersion2 = o2.split(" ");
			if(boxVersion1[1].compareTo(boxVersion2[1]) == 0) {
	        	if(boxVersion1[2].compareTo(boxVersion2[2]) == 0) {
	        		return boxVersion1[0].compareTo(boxVersion2[0]);
	        	}
	        	else {
	        		return boxVersion1[2].compareTo(boxVersion2[2]);
	        	}
	        }
        	return boxVersion1[1].compareTo(boxVersion2[1]);
		}
	 }
	
	private boolean isNewGen(String[] boxVersionArray) {
		return boxVersionArray.length > 0 && isNumberOnly(boxVersionArray[1]);
	}
	
	private boolean isNumberOnly(String text) {
		boolean isDigit = false;
	    if (text.matches("[0-9]+") && text.length() > 0) {
	        isDigit = true;
	    }else {
	        isDigit = false;
	    }
	    return isDigit;
	}
	
	
	public static void main(String[] args) {
		int num = 6;
		List<String> boxList = new ArrayList<>(num);
		boxList.add("ykc 82 01");
		boxList.add("eo first qpx");
		boxList.add("09z cat hamster");
		boxList.add("06f 12 25 6");
		boxList.add("az0 first qpx");
		boxList.add("236 cat dog rabbit snake");
		SortLexicograph obj = new SortLexicograph();
		System.out.println(obj.orderedJunctionBoxes(num, boxList));
	}
	
}
