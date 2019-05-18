package leetcode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private final Map<Integer, Integer> map;
    private int currentCapacity = 0;
    private final int maxCapacity;
    private final LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.list = new LinkedList<>();
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        this.list.removeFirstOccurrence(key);
        int value = map.get(key);
        addCacheElementToFront(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (this.currentCapacity + 1 > this.maxCapacity && !map.containsKey(key)) {
            final Integer removedKey = this.list.removeLast();
            this.map.remove(removedKey);
            addCacheElementToFront(key, value);
            return;
        }
        addCacheElementToFront(key, value);
    }

	private void addCacheElementToFront(int key, int value) {
		if(map.containsKey(key)) {
			list.removeFirstOccurrence(key);
		}
		else {
			this.currentCapacity++;
		}
        this.list.addFirst(key);
        this.map.put(key, value);
    }
    
    public static void main(String[] args) {
    	test1();
    }

	private static void test1() {
		LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));       // returns 4
	}
	
	private static void test2() {
		LRUCache cache = new LRUCache(2);
		System.out.println(cache.get(2));       // returns -1
    	cache.put(2, 6);
    	System.out.println(cache.get(1));       // returns -1
    	cache.put(1, 5);
    	cache.put(1, 2);
    	System.out.println(cache.get(1));       // returns 2
    	System.out.println(cache.get(2));       // returns 6
	}
	
	private static void test3() {
		LRUCache cache = new LRUCache(2);
    	cache.put(2, 1);
    	cache.put(1, 1);
    	cache.put(2, 3);
    	cache.put(4, 1);
    	System.out.println(cache.get(1));       // returns -1
    	System.out.println(cache.get(2));       // returns 3
	}
	
}
