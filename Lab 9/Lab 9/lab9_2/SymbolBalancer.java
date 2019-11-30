package lab9_2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SymbolBalancer {
	MyStringLinkedList mss = new MyStringLinkedList();
	String ODD_DELIMITER = "" + (char)0;
	String filename;
	String text;
	char[] left;
	char[] right;
	public SymbolBalancer(String filename) {
		this.filename = filename;
		readFile();
//		text = "() asd []";
	}
	public void setText(String text) {
		this.text = text;
	}
	
	boolean symbolsBalanced(String delimiters){
		fillDelimArrays(delimiters);
		return checkDelimiters();
		
	}
	boolean checkDelimiters() {
		for(int i=0; i<text.length(); i++) {
			if(isOpen(text.charAt(i))) {
				mss.addFirst(text.charAt(i));
			}
			if(isClosed(text.charAt(i))) {
				char cr = mss.pop();
				if(cr==0) return false;
				if(!(match(cr, text.charAt(i)))) return false;
				if(mss.peek()!=0) return false;
			}
		}
	
		return true;
	}
	boolean isOpen(char c){
		return (open(c) > -1);
	}
	boolean isClosed(char c){
		return (closed(c) > -1);
	}
	int open(char c){
		for(int i = 0; i < left.length; ++i){
			if(c == left[i]) return i;
		}
		return -1;
	}
	int closed(char c){
		for(int i = 0; i < right.length; ++i){
			if(c == right[i]) return i;
		}
		return -1;
	}
	boolean match(char c, char d){
		if(isOpen(c) && isClosed(d)){
			return (open(c)==closed(d));
		}
		if(isClosed(c) && isOpen(d)){
			return (closed(c) == open(d));
		}
		return false;
	}
	
	void fillDelimArrays(String delims){
		int len = delims.length();
		left = new char[len/2];
		right = new char[len/2];
		for(int i = 0; i < len; ++i){
			if(i % 2 == 0){
				left[i/2]=delims.charAt(i);
			}
			else {
				right[i/2]=delims.charAt(i);
			}
		}
	}
	public static void main(String[] args) {
		SymbolBalancer sb = new SymbolBalancer("lab9_2\\Employee.java");
		System.out.println(sb.symbolsBalanced("[]{}<>()"));
	}
	void readFile() {
		String prefix = System.getProperty("user.dir") + "\\src\\";
		try {
			Scanner sc = new Scanner(new File(prefix + filename));
			sc.useDelimiter(ODD_DELIMITER);
			text = sc.next();
			System.out.println(text);
			sc.close();
		}
		catch(FileNotFoundException ex) {
			System.err.println("File Not Found Exception "+ex.getMessage());
		}
	}
	
}



