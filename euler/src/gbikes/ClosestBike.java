package gbikes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 Consider a grid. Assume each cell contains a bike, a person, or is empty.

 Part 1: 
 Calculate the distance between a bike and a person. Each person can walk only on the edges of cells (no diagonal).
 The distance is the number of cells they need to walk through. 
 x = person
 y = bike

[ y , 0 , 0 ]
[ 0,  0 , 0]
[ 0,  0 , x]

0,0 -> 0,2 = 2
0,0 -> 1,1 = 1 + 1 = 2
0,0 -> 2,2 = 2 + 2 = 4
2,2 -> 0,0 = 2 + 2 = 4

 *
 *
 *
 Part 2: 
 Assume there are a number of bikes and persons on the grid. The number of bikes is greater than or equal to the number of people.
 Each person will try to get the bike that is closest to them. They choose a bike if it is not taken by others by the time they get there.
 Everybody knows where other people and bikes are standing, so they will not try to get a bike if another person will get it before them.
 They all walk at the same speed - one cell per second. 
 Assume there will be no ties: no two people are in the same distance to a bike and no two bikes are in the same distance to a person. 
 I am standing in one of the cells. Suggest a bike for me. 
 The input is a grid and my position. The output is the location of the bike that I should take. 

bikes ->[2,1],[4,4],[0,0],[0,5]
persons -> [3,0],[4,3],[0,2] 
	c - - A - 
	- - a - - 
	C - - - - 
	- - - - B 
	- - - - b 
	d - - - - 

 * @author sudharshan
 *
 */
public class ClosestBike {
	
	// method for part 1
	private int calculateDistance(Person person, Bike bike) {
		//System.out.println("calculating distance from person:"+person+"w.r.t. bike:"+bike);
		int xDiff = Math.abs(person.xCoord - bike.xCoord);
		int yDiff = Math.abs(person.yCoord - bike.yCoord);
		//System.out.println("distance: "+(xDiff + yDiff));
		return (xDiff + yDiff);
	}
	
	// method for part 2
	private Bike findClosestBike(List<Person> personList, List<Bike> bikeList, Person inputPerson) {
		PriorityQueue<RelativeDistance> minHeap = new PriorityQueue<>((o1, o2) -> (o1.distance - o2.distance));
		for(Person person: personList) {
			for(Bike bike: bikeList) {
				int distance = calculateDistance(person, bike);
				minHeap.add(new RelativeDistance(person, bike, distance));
			}
		}
		Set<Bike> bikeAssigned = new HashSet<>();
		Map<Person, Bike> map = new HashMap<>(personList.size());
		while(!minHeap.isEmpty() && map.size() <= personList.size()) {
			RelativeDistance relativeDistance = minHeap.remove();
			if(!map.containsKey(relativeDistance.person) && !bikeAssigned.contains(relativeDistance.bike)) {
				map.put(relativeDistance.person, relativeDistance.bike);
				bikeAssigned.add(relativeDistance.bike);
			}
		}
		return map.get(inputPerson);
	}
	
	public static void main(String[] args) {
		// bikes -> [0,0],[2,1],[4,4],[0,5]
		// persons -> [3,0],[4,3],[0,2] 
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("A",3,0));
		personList.add(new Person("B",4,3));
		personList.add(new Person("C",0,2));
		
		List<Bike> bikeList = new ArrayList<>();
		bikeList.add(new Bike("a",2,1));
		bikeList.add(new Bike("b",4,4));
		bikeList.add(new Bike("c",0,0));
		bikeList.add(new Bike("d",0,5));
		
		ClosestBike obj = new ClosestBike();
		System.out.println(obj.calculateDistance(personList.get(0), bikeList.get(3)));
		for(Person person: personList) {
			System.out.println("person: "+person+"assigned to "+obj.findClosestBike(personList, bikeList, person));
		}
	}
}
