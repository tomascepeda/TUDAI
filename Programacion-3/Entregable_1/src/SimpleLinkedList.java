import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Integer> {

	private Node head; 
	private Node tail;
	private int size;

	// O(1)
	public SimpleLinkedList() {
		head = null;
		tail = null;
		size = 0; 
	}
	
	// O(n) siendo n el tamaño del arreglo
	public SimpleLinkedList(int[] valores) {
		for (int i : valores) {
			this.insertLast(i);
		}
	}

	// O(1)
	public void insertFront(int data) {
		Node n = new Node(data);
		if (head != null) {
			n.setNext(this.head);
			this.head = n;
		} else 
			this.head = n;
		this.size++;
	}

	// O(1)
	public void insertLast(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}
		this.size++;
	}

	// O(1)
	public int extractFront() {
		int data = this.head.getData();
		this.head = head.getNext();
		this.size--;
		return data;
	}

	// O(n) siendo n el tamaño de la lista
	public int extractLast() {
		int data = this.tail.getData();
		Node pointer = head;
		int count = 1;
		while (count < this.size - 1) {
			pointer = pointer.getNext();
			count++;
		}
		this.tail = pointer;
		pointer.setNext(null);
		this.size--;
		return data;
	}

	// O(1)
	public boolean isEmpty() {
		return head == null;
	}

	// O(1)
	public int size() {
		return this.size;
	}

	// O(n) siendo n el index a buscar
	public Integer get(int index) {
		if (index > this.size || index < 0)
			return null;
		Iterator<Integer> it = this.iterator();
		int count = -1;
		int data = 0;
		while (it.hasNext() && count < index) {
			data = it.next();
			count++;
		}	
		return data;
	}

	// O(n) siendo n la posicion del elemento a buscar
	public Integer indexOf(int data) {
		Iterator<Integer> it = this.iterator();
		int count = 0;
		while(it.hasNext() && it.next() != data)
			count++;
		if(count == this.size && this.tail.getData() != data)
			return null;
		else
			return count;
	}
	
	// O(n) siendo n el tamaño de la lista
	public String print() {
		if(this.isEmpty())
			return "[]";
		Iterator<Integer> it = this.iterator();
		String content = "[" + it.next();
		while (it.hasNext())
			content += ", " + it.next();
		return content + "]";
	}

	// O(1)
	@Override
	public Iterator<Integer> iterator() {
		return new MyIterator(head);
	}

}
