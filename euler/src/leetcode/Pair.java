package leetcode;

public class Pair {
	private int val1;
	private int val2;
	public Pair(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val1;
		result = prime * result + val2;
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
		Pair other = (Pair) obj;
		if (val1 != other.val1)
			return false;
		if (val2 != other.val2)
			return false;
		return true;
	}
}
