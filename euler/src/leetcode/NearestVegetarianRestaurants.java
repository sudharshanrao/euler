package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NearestVegetarianRestaurants
{
	/**
	 * @param totalRestaurants - this is the total number of restaurants in the db.
	 * @param allLocations - List of Coordinates (inner list contains coordinates e.g. (2,1) ) of all the restaurants. 
	 * @param numRestaurants - this is the number of nearest vegetarian restaurants to be returned.
	 * @return - list of coordinates of restaurants to be returned.
	 */
    List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants, 
                                         List<List<Integer>> allLocations, 
                                         int numRestaurants)
	{
	    Set<CoordinatesWithDistance> set = new TreeSet<>(Comparator.comparingDouble(CoordinatesWithDistance::getDistance));
        for(int i = 0; i< allLocations.size(); i++){
            List<Integer> locationCoord = allLocations.get(i);
            Double distance = computeDistance(locationCoord.get(0), locationCoord.get(1));
            set.add(new CoordinatesWithDistance(locationCoord, distance));
        }
        
        List<List<Integer>> nearestVegList = new ArrayList<>(numRestaurants);
        int cnt = 0;
        
        for(CoordinatesWithDistance obj: set){
            nearestVegList.add(obj.getCoordinates());
            cnt++;
            if(cnt == numRestaurants){
                break;
            }
        }
        return nearestVegList;
    }
    
    private class CoordinatesWithDistance{
    	List<Integer> coordinates;
    	private double distance;
    	
    	CoordinatesWithDistance(List<Integer> coordinates, double distance){
    		this.coordinates = coordinates;
    		this.distance = distance;
    	}

		public double getDistance() {
			return distance;
		}
		
		public List<Integer> getCoordinates(){
			return this.coordinates;
		}
    }
    
    /**
     * given coordinates x and y, Formula for distance computed = sqrt(x^2 + y^2)
     * @param x
     * @param y
     * @return
     */
    private Double computeDistance(Integer x, Integer y){
        return Math.sqrt(Math.pow(x, 2)
                                    + Math.pow(y, 2));
    }
    
    
    public static void main(String[] args) {
    	List<List<Integer>>  allLocationsList = new ArrayList<>();
    	List<Integer> list1 = new ArrayList<>();
    	list1.add(0);
    	list1.add(-1);
    	
    	List<Integer> list2 = new ArrayList<>();
    	list2.add(1);
    	list2.add(2);
    	
    	List<Integer> list3 = new ArrayList<>();
    	list3.add(10);
    	list3.add(1);
    	
    	List<Integer> list4 = new ArrayList<>();
    	list4.add(4);
    	list4.add(2);
    	
    	List<Integer> list5 = new ArrayList<>();
    	list5.add(2);
    	list5.add(-2);

    	allLocationsList.add(list1);
    	allLocationsList.add(list2);
    	allLocationsList.add(list3);
    	allLocationsList.add(list4);
    	allLocationsList.add(list5);
    	
    	NearestVegetarianRestaurants n = new NearestVegetarianRestaurants();
    	System.out.println(n.nearestVegetarianRestaurant(4, allLocationsList, 3));
    }
}