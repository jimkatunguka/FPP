package lab8_2;
public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null,null, null);
	}
	public Node add(String item) {
        Node n = new Node(header.next, header, item);
        if (header.next != null) {
            header.next.previous = n;
        }
        header.next = n;
        return n;
    }
	public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node next = header.next;
        while (next != null) {
            sb.append(next.value + ", ");
            next = next.next;
        }
        String ret = sb.toString();
        ret = ret.substring(0, ret.length() - 2);
        return (ret + "]");
    }
	public void addFirst(String item){
		Node n = new Node(header.next,header,item);
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;
		
	}
	void printNodes() {
		Node next = header.next;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	 ////next refers to node after header
    int size(){//---
      Node next = header.next;
      int count = 0;
      while(next!=null){
        count++;
        next = next.next;
      }
      return count;
    }
   // returns the index of the String s, if found; -1 otherwise
   public int find(String s) {
       if (s == null) return -1;
       Node currentNode = header;
       int i = -1;
       while (currentNode.next != null) {
           ++i;
           currentNode = currentNode.next;
           if (s.equals(currentNode.value)) return i;
       }
       return -1;
   }
// returns true if string is found; false otherwise
   public boolean search(String s) {
       if(find(s) == -1) return false;
       return true;
   }
   private Node getNode(int pos) {
       if (pos >= size()) throw new IndexOutOfBoundsException();
       Node next = header;
       for (int i = 0; i <= pos; ++i) {
           next = next.next;
       }
       //next is the node we are seeking
       return next;
   }
   public boolean remove(int index) {
       Node toBeRemoved = getNode(index);
       if (toBeRemoved == null) return false;
       Node previous = toBeRemoved.previous;
       Node next = toBeRemoved.next;
       previous.next = toBeRemoved.next;
       if (next != null) {
           next.previous = toBeRemoved.previous;
       }
       toBeRemoved = null;
       return true;
   }
    //attempts to remove first node that contains data
    boolean remove(String data) {
        int pos = find(data);
        if (pos == -1)
        	return false;
        return remove(pos);

    }
	 //implements insert
    void insert(String data, int pos){
      if(pos >= size()){
        throw new IndexOutOfBoundsException("pos = "+ pos + " but size =" + size() );
      }
      Node next = header;
      Node previous = null;
      for(int i=0; i<=pos; i++){
        if(i==pos){
          previous = next;
        }
        next = next.next;
      }
      Node insertNode = new Node(next, previous,data);
      if(next!=null){
        next.previous = insertNode;
      }
      previous.next = insertNode;

    }
  //find the Node having min value nested inside theNode
    public Node minNode(Node theNode) {
        if (theNode == null || theNode.next == null) return theNode;
        String minVal = theNode.value;
        Node minNode = theNode;
        Node currentNode = theNode;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.value.compareTo(minVal) < 0) {
                minVal = currentNode.value;
                minNode = currentNode;
            }
        }
        return minNode;
    }
    private void swap(Node s, Node t) {
        String temp = s.value;
        s.value = t.value;
        t.value = temp;
    }
    
    //sorts the nodes according to their contents
	public void sort() {
        int size = size();
        if (size <= 1) return;
        Node curr = header;
        while (curr.next != null) {
            curr = curr.next;
            Node min = minNode(curr);
            //place the min val in curr
            swap(min, curr);

        }

    }	
	
	class Node {
		String value;
		Node next;
		Node previous;
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}
		@Override
		public String toString() {
		    if(value == null) return "";
			StringBuilder sb = new StringBuilder(value + " ");
			sb = toString(sb, next);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.value + " ");
			return toString(sb, n.next);
		}
		
		
	}
	public static void main(String[] args) {
		String[] sizes = {"big", "small", "tall", "short", "round", "square",
				 "enormous", "tiny","gargantuan", "lilliputian",
				 "numberless", "none", "vast", "miniscule"};
				 
		MyStringLinkedList l = new MyStringLinkedList();
				for(int i=0; i<sizes.length; i++) {
					l.add(sizes[i]);
				}
		l.sort();
				System.out.println("The list in sorted order:");
				System.out.println(l.toString());
				
		System.out.println();
				System.out.println("\"number\" is in the list? "+l.search("number"));
				System.out.println("\"tiny\" is in the list? "+l.search("tiny"));
		

	}
}


