package lab4_3;

import java.util.Arrays;

public class MyStringList {
	
	private String[] strArray;
	private int size;
	private int arraySize;
	
	public MyStringList() {
		strArray = new String[3];
		size = 0;
	}
	
	public MyStringList(int arraySize) {
		this.arraySize = arraySize;
		strArray = new String[arraySize];
		size = 0;
	}
	
	public void add(String s) {
		if(size < strArray.length) {
			strArray[size] = s;
			size++;
		}else {
			resize();
			strArray[size] = s;
			size++;
		}
	}
	
	public String[] getStrArray() {
		return strArray;
	}

	public String get(int i) {
		return strArray[i];
	}
	
	public boolean find(String s) {
		for(String c : strArray) {
			if(c.equals(s))
				return true;
		}
		return false;
	}
	
	public boolean remove(String s) {
		for(int i = 0; i < size; i++) {
			if(s.equals(strArray[i])) {
				//shifting elements
				for(int j = i; j < size-1; j++) {
					strArray[i] = strArray[i+1];
				}
				strArray[size-1] = null;
				size = size - 1;
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
		System.out.println("Resizing...");
		String[] newArray = new String[strArray.length * 2];
		System.arraycopy(strArray, 0, newArray, 0, size);
		strArray = newArray;
	}
	
/*	public static void main(String[] args) {
		MyStringList l = new MyStringList(2);
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
	}*/

}
