package leetcode;
import java.util.HashMap;
import java.util.Map;

public class BestAverageScore {

	private String[][] scores = {{"Bobby","87"},{"Sam","62"},{"Sarah", "75"}, {"Bobby", "98"}};
	
	private int computeHighestAverageScore() {
		Map<String, Integer> map = new HashMap<>();
		int maxAvg = Integer.MIN_VALUE;
		int newAvg = 0;
		for(int i = 0; i < scores.length; i++) {
			String name = scores[i][0];
			String score = scores[i][1];
			System.out.println(name+"'s score ="+score);
			if(map.containsKey(name)) {
				int runningAvg = map.get(name);
				newAvg = (runningAvg + Integer.parseInt(score))/2;
			}
			else {
				newAvg = Integer.parseInt(score);
			}
			map.put(name, newAvg);
			if(newAvg > maxAvg) {
				maxAvg = newAvg;
			}
		}
		return maxAvg;
	}
	
	public static void main(String[] args) {
		BestAverageScore bestAverageScore = new BestAverageScore();
		System.out.println(bestAverageScore.computeHighestAverageScore());
	}
	
}
