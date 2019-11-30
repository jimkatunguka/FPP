package lab9_1;

public class MyStringStack {
	private MyStringLinkedList list;
	public MyStringStack() {
		list = new MyStringLinkedList();
	}
	
	public String pop() {
		//implement
		if(list.header.next == null) return "";
		String str = list.get(0);
		list.remove(str);
		return str;
	}
	public String peek() {
		//implement
		return(list.get(0));

	}
	
	public void push(String s) {
		//implement
		list.addFirst(s);
	}
	public static void main(String[]args){
	
	MyStringStack stack = new MyStringStack();
	stack.push("Bob");
	stack.push("Harry");
	stack.push("Alice");
	System.out.println("Popping…"+stack.pop());
	System.out.println("Peeking…."+stack.peek());
	System.out.println("Popping…"+stack.pop());
	
	}
}
