package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	class SortByStartTime implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}
	
	public boolean canAttendMeetings (Interval[] intervals) {
		Arrays.sort(intervals, new SortByStartTime());
		for(int i = 0; i < intervals.length - 1; i++) {
			if(intervals[i].end >= intervals[i+1].start) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		MeetingRooms obj = new MeetingRooms();
		Interval[] intervals = { new Interval(0, 30), new Interval(5, 10), new Interval(15,20) }; 
		if(obj.canAttendMeetings(intervals)) {
			System.out.println("test1 passed");
		}
		else {
			System.out.println("test1 failed");
		}
		
		Interval[] intervals1 = { new Interval(7,10), new Interval(2,4) }; 
		if(obj.canAttendMeetings(intervals1)) {
			System.out.println("test2 passed");
		}
		else {
			System.out.println("test2 failed");
		}
		
	}
}
