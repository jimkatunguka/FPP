package lab3_3;

import java.util.Arrays;

public class MyStringList {
	private static String [] strArray;
	private static int size;
	
	public MyStringList() {
		strArray = new String [2];
		size = 0;
	}
	
	public void add(String s) {
		if(size<strArray.length) {
			strArray[size] = s;
			size++;
		}else {
			resize();
			strArray[size] = s;
			size++;
		}
		
	}
	public String get(int i) {
		return strArray[i];
	}
	public boolean find(String s) {
		for(int i=0; i<strArray.length; i++) {
			if(s.equalsIgnoreCase(strArray[i])) return true;
		}
		return false;
	}
	public boolean remove(String s) {
		for(int i=0; i<strArray.length; i++) {
			if(s.equalsIgnoreCase(strArray[i])) {
				strArray[i] = null;
				for(int j=0; j<strArray.length; j++) {
					strArray[i] = strArray[i+1];
				}
				strArray[size-1] = null;
				size--;
				return true;
			}
		} 
		return false;
	}
	public String toString() {
		if(size != strArray.length) {
			String[] newArray = new String[size];
			System.arraycopy(strArray, 0, newArray, 0, size);
			return Arrays.toString(newArray);
		}else
			return Arrays.toString(strArray);
	}
	
	public int size() {
		return size;
	}
	private void resize() {
		String[]newArray = new String[strArray.length * 2];
		System.arraycopy(strArray, 0, newArray, 0, strArray.length);
		strArray = newArray;
		System.out.println("Resizing...");
	}

	public static void main(String[] args) {
	
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);

	}
	

}
