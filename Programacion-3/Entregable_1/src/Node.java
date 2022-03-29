
public class Node {

	private int data;
	private Node next;

	// O(1)
	public Node() {
		this.data = -1;
		this.next = null;
	}

	// O(1)
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	// O(1)
	public int getData() {
		return this.data;
	}

	// O(1)
	public void setData(int data) {
		this.data = data;
	}

	// O(1)
	public Node getNext() {
		return next;
	}

	// O(1)
	public void setNext(Node next) {
		this.next = next;
	}
	
}
