package gbikes;

public class RelativeDistance {
	Person person;
	Bike bike;
	int distance;
	
	public RelativeDistance(Person person, Bike bike, int distance) {
		this.person = person;
		this.bike = bike;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RelativeDistance [person=" + person + ", bike=" + bike + ", distance=" + distance + "]";
	}
}
