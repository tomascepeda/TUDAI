import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
	
	private Node n;

	// O(1)
	public MyIterator(Node n) {
		this.n = n;
	}

	// O(1)
	@Override
	public boolean hasNext() {
		return n != null;
	}

	// O(1)
	@Override
	public Integer next() {
		Integer data = n.getData();
		n = n.getNext();
		return data;
	}
	
}