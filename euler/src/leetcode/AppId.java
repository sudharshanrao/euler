package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * Amazon online assessment for Alexa news team
 * @author sudharshan
 *
 */
public class AppId {
	
	List<List<Integer>> optimalUtilization(
            int deviceCapacity, 
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
	{
		final Comparator<PairDiff> diffComparator = (PairDiff o1, PairDiff o2) -> Integer.compare(o1.getDiff(), o2.getDiff());
		List<List<Integer>> resultList = new ArrayList<>();
		List<App> backAppList = new ArrayList<>(backgroundAppList.size());
		List<App> foreAppList = new ArrayList<>(foregroundAppList.size());

		for(List<Integer> list: foregroundAppList) {
			App app = new App(list.get(0), list.get(1));
			foreAppList.add(app);
		}
		for(List<Integer> list: backgroundAppList) {
			App app = new App(list.get(0), list.get(1));
			backAppList.add(app);
		}
		boolean exactPairFound = false;
		
		PriorityQueue<PairDiff> minHeap = new PriorityQueue<>(diffComparator);
		
		for(App foreApp: foreAppList) {
			for(App backApp: backAppList) {
				int diff = deviceCapacity - (foreApp.getMemory() + backApp.getMemory());
				if(diff == 0) {
					addOptimalPair(resultList, foreApp.getId(), backApp.getId());
					exactPairFound = true;
				}
				else if(diff < 0) {
					System.out.println("exceeds capacity");
				}
				else {
					minHeap.add(new PairDiff(foreApp.getId(), backApp.getId(), diff));
				}
			}
		}
		if(exactPairFound) {
			return resultList;
		}
		if(minHeap.isEmpty()) {
			return resultList;
		}
		PairDiff optimalPair = minHeap.remove();
		addOptimalPair(resultList, optimalPair.getForeAppId(), optimalPair.getBackAppId());
		return resultList;
	}

	List<List<Integer>> optimalUtilizationWithSorting(
            int deviceCapacity, 
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
	{
		final Comparator<PairDiff> diffComparator = (PairDiff o1, PairDiff o2) -> Integer.compare(o1.getDiff(), o2.getDiff());
		final Comparator<App> memoryComparator = (App o1, App o2) -> Integer.compare(o1.getMemory(), o2.getMemory());
		List<List<Integer>> resultList = new ArrayList<>();
		List<App> backAppList = new ArrayList<>(backgroundAppList.size());
		List<App> foreAppList = new ArrayList<>(foregroundAppList.size());

		for(List<Integer> list: foregroundAppList) {
			App app = new App(list.get(0), list.get(1));
			foreAppList.add(app);
		}
		Collections.sort(foreAppList, memoryComparator);
		for(List<Integer> list: backgroundAppList) {
			App app = new App(list.get(0), list.get(1));
			backAppList.add(app);
		}
		Collections.sort(backAppList, memoryComparator);
		
		boolean exactPairFound = false;
		PriorityQueue<PairDiff> minHeap = new PriorityQueue<>(diffComparator);
		int i = 0;
		int j = backAppList.size() - 1;
		while(i < foreAppList.size() && j >= 0) {
			App foreApp = foreAppList.get(i);
			App backApp = backAppList.get(j);
			int diff = deviceCapacity - (foreApp.getMemory() + backApp.getMemory());
			if(diff == 0) {
				addOptimalPair(resultList, foreApp.getId(), backApp.getId());
				exactPairFound = true;
				i++;
				j--;
			}
			else if(diff < 0) {
				System.out.println("exceeds capacity");
				j--;
			}
			else {
				minHeap.add(new PairDiff(foreApp.getId(), backApp.getId(), diff));
				i++;
			}
		}
		if(exactPairFound) {
			return resultList;
		}
		if(minHeap.isEmpty()) {
			return resultList;
		}
		PairDiff optimalPair = minHeap.remove();
		addOptimalPair(resultList, optimalPair.getForeAppId(), optimalPair.getBackAppId());
		return resultList;
	}
	
	List<List<Integer>> optimalUtilizationWithMap(
            int deviceCapacity, 
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
	{
		final Comparator<PairDiff> diffComparator = (PairDiff o1, PairDiff o2) -> Integer.compare(o1.getDiff(), o2.getDiff());
		List<List<Integer>> resultList = new ArrayList<>();
		List<App> backAppList = new ArrayList<>(backgroundAppList.size());
		List<App> foreAppList = new ArrayList<>(foregroundAppList.size());

		for(List<Integer> list: foregroundAppList) {
			App app = new App(list.get(0), list.get(1));
			foreAppList.add(app);
		}
		for(List<Integer> list: backgroundAppList) {
			App app = new App(list.get(0), list.get(1));
			backAppList.add(app);
		}
		boolean exactPairFound = false;
		Map<Integer, App> map = new HashMap<>(foreAppList.size());
		for(App app: foreAppList) {
			map.put(deviceCapacity - app.getMemory(), app);
		}
		for(App backApp: backAppList) {
			if(map.containsKey(backApp.getMemory())) {
				App foreApp = map.get(backApp.getMemory());
				addOptimalPair(resultList, foreApp.getId(), backApp.getId());
				exactPairFound = true;
			}
		}
		if(exactPairFound) {
			return resultList;
		}
		PriorityQueue<PairDiff> minHeap = new PriorityQueue<>(diffComparator);
		for(App backApp: backAppList) {
			for(App foreApp: map.values()) {
				int diff = deviceCapacity - (foreApp.getMemory() + backApp.getMemory());
				if(diff < 0) {
					System.out.println("exceeds capacity");
				}
				else {
					minHeap.add(new PairDiff(foreApp.getId(), backApp.getId(), diff));
				}
			}
		}
		if(minHeap.isEmpty()) {
			return resultList;
		}
		PairDiff optimalPair = minHeap.remove();
		addOptimalPair(resultList, optimalPair.getForeAppId(), optimalPair.getBackAppId());
		return resultList;
	}
	
	private void addOptimalPair(List<List<Integer>> resultList, int foreAppId, int backAppId){
		List<Integer> subList = new ArrayList<>(2);
		subList.add(foreAppId);
		subList.add(backAppId);
		resultList.add(subList);
	}
	
	class PairDiff{
		public PairDiff(int foreAppId, int backAppId, int diff) {
			super();
			this.foreAppId = foreAppId;
			this.backAppId = backAppId;
			this.diff = diff;
		}
		int foreAppId;
		int backAppId;
		int diff;
		public int getForeAppId() {
			return foreAppId;
		}
		public void setForeAppId(int foreAppId) {
			this.foreAppId = foreAppId;
		}
		public int getBackAppId() {
			return backAppId;
		}
		public void setBackAppId(int backAppId) {
			this.backAppId = backAppId;
		}
		public int getDiff() {
			return diff;
		}
		public void setDiff(int diff) {
			this.diff = diff;
		}
		@Override
		public String toString() {
			return "PairDiff [foreAppId=" + foreAppId + ", backAppId=" + backAppId + ", diff=" + diff + "]";
		}
	}
	class App{
		int id;
		public App(int id, int memory) {
			super();
			this.id = id;
			this.memory = memory;
		}
		int memory;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getMemory() {
			return memory;
		}
		public void setMemory(int memory) {
			this.memory = memory;
		}
		@Override
		public String toString() {
			return "App [id=" + id + ", memory=" + memory + "]";
		}
	}
	public static void main(String[] args) {
		List<List<Integer>> foregroundAppList = new ArrayList<List<Integer>>();
		foregroundAppList.add(Arrays.asList(1,2));
		foregroundAppList.add(Arrays.asList(2,3));
		foregroundAppList.add(Arrays.asList(3,4));

		List<List<Integer>> backgroundAppList = new ArrayList<List<Integer>>();
		backgroundAppList.add(Arrays.asList(1,3));
		backgroundAppList.add(Arrays.asList(2,2));
		
		AppId obj = new AppId();
		System.out.println("result = "+obj.optimalUtilizationWithSorting(
	            7, 
	            foregroundAppList,
	            backgroundAppList));
	}
}
