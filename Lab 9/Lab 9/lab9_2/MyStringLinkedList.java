package lab9_2;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = new Node(null, null, ' ');
	}

	public void addFirst(char item) {
		Node n = new Node(header.next, header, item);
		if (header.next != null) {
			header.next.previous = n;
		}
		header.next = n;

	}

	public String printNodes() {
		String remaining = ""; 
		Node next = header.next;
		if (next == null)
			return null;
		else {
			while (next != null) {
				remaining = remaining +" "+ next.value;
				next = next.next;
			}
			
		}
		return remaining;
	}



	public void insert(char data, int pos) {
		int size = size();

		if (pos >= size) {
			throw new IndexOutOfBoundsException("the position " + pos + " does not exist");
		}

		Node temp = header;

		for (int i = 0; i <= pos; i++) {
			temp = temp.next;
		}

		Node newNode = new Node(temp, temp.previous, data);
		temp.previous.next = newNode;
		temp.previous = newNode;

	}
	
	public char pop() {
		Node temp = header.next;
	
		if (temp!= null) {
		header.next = temp.next;
		temp.previous = header;
		}
		else {
			return 0;
		}
			
		return temp.value;

	}
	public char peek() {
		Node temp = header.next;
	
		if (temp== null) 
		return 0;
			
		return temp.value;
		
	}

	boolean remove(char data) {
		Node temp = header.next;

		while (temp.value != 0) {
			if (temp.value == data) {
				temp.previous.next = temp.next;
				if (temp.next != null) {
					temp.next.previous = null;
				}

				temp = null;
				break;
			}
			temp = temp.next;
		}
		return true;

	}

	public int size() {
		Node next = header.next;
		int count = 0;
		while (next != null) {
			next = next.next;
			count++;

		}

		return count;
	}

	class Node {
		char value;
		Node next;
		Node previous;

		Node(Node next, Node previous, char value) {
			this.next = next;
			this.previous = previous;
			this.value = value;
		}

		@Override
		public String toString() {
			if (value == 0)
				return "";
			StringBuilder sb = new StringBuilder(value + " ");
			sb = toString(sb, next);
			return sb.toString();
		}

		private StringBuilder toString(StringBuilder sb, Node n) {
			if (n == null)
				return sb;
			sb.append(n.value + " ");
			return toString(sb, n.next);
		}

	}
	
	public int removeOnPos(int pos) {
		Node temp= header;
		int count=0;
		while(temp.next!=null) {
			if(count<=pos) {
				count++;
			}
			else {
				temp.previous.next=temp.next;
				temp.next=temp.previous;
				temp=null;
				break;
			}
			temp=temp.next;
		}
		
		return count;
	}
}
