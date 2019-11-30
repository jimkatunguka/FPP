package lab4_3;
import java.util.Arrays;

import lab4_3.employeeinfo.Account;

public class AccountList {
	
	private Account[] accountArray;
	private int size;
	private int arraySize;
	
	public AccountList() {
		accountArray = new Account[3];
		size = 0;
	}
	
	public AccountList(int arraySize) {
		this.arraySize = arraySize;
		accountArray = new Account[arraySize];
		size = 0;
	}
	
	public Account[] getAccountArray() {
		return accountArray;
	}

	public void add(Account acc) {
		if(size < accountArray.length) {
			accountArray[size] = acc;
			size++;
		}else {
			resize();
			accountArray[size] = acc;
			size++;
		}
	}
	
	public Account get(int i) {
		return accountArray[i];
	}
	
	public boolean find(Account acc) {
		for(Account x : accountArray) {
			if(x.equals(acc))
				return true;
		}
		return false;
	}
	
	public boolean remove(String s) {
		for(int i = 0; i < size; i++) {
			if(s.equals(accountArray[i])) {
				//shifting elements
				for(int j = i; j < size-1; j++) {
					accountArray[i] = accountArray[i+1];
				}
				accountArray[size-1] = null;
				size = size - 1;
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		if(size != accountArray.length) {
			String[] newArray = new String[size];
			System.arraycopy(accountArray, 0, newArray, 0, size);
			return Arrays.toString(newArray);
		}else
			return Arrays.toString(accountArray);
	}
	
	public int size() {
		return size;
	}
	
	private void resize() {
		System.out.println("Resizing...");
		Account[] newArray = new Account[accountArray.length * 2];
		System.arraycopy(accountArray, 0, newArray, 0, size);
		accountArray = newArray;
	}

}
