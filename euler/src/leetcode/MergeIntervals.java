package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

		List<Interval> resultList = new ArrayList<>();
		resultList.add(intervals.get(0));
		for (int i = 0; i < intervals.size(); i++) {
			Interval prev = resultList.get(resultList.size() - 1);
			Interval current = intervals.get(i);
			if (prev.end < current.start) {
				resultList.add(current);
			} else {
				if (current.end > prev.end) {
					Interval mergedInterval = new Interval(prev.start, current.end);
					resultList.remove(prev);
					resultList.add(mergedInterval);
				}
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		MergeIntervals s = new MergeIntervals();
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 3));
		System.out.println(s.merge(intervals));
	}
}
