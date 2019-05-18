package gbikes;

public class Bike {
	String id;
	int xCoord;
	int yCoord;
	
	public Bike(String id, int xCoord, int yCoord) {
		this.id = id;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	@Override
	public String toString() {
		return "Bike [id=" + id + ", xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
