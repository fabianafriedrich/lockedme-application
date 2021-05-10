package lockedme.com.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lockedme.com.model.User;

public class Controller {

	final String PATH = "src/files/users.txt";
	List<User> names = new ArrayList<User>();

	private void readFile() {
		// -----------------------
		// Read the file
		// -----------------------
		try {
			BufferedReader br = new BufferedReader(new FileReader(PATH));
			while (br.ready()) {
				names.add(new User(br.readLine()));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("It was not possible read this file");
			e.printStackTrace();
		}
	}

	private void writeFile(User user) {
		// -----------------------
		// Write into the file
		// -----------------------
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
			bw.newLine();
			bw.write(user.getName());
			bw.close();
		} catch (IOException e) {
			System.out.println("It was not possible write into this file");
			e.printStackTrace();
		}
	}
	
	private void deleteUserOnFile(String name) {
		// -----------------------
		// Delete user on the file
		// -----------------------
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
//			bw.newLine();
//			bw.write(user.getName());
//			bw.close();
//		} catch (IOException e) {
//			System.out.println("It was not possible write into this file");
//			e.printStackTrace();
//		}
	}

	// Sorting using TreeSet Data Structure, the order of elements is maintained 
	private void sortAsc() {
		Set<User> set = new TreeSet<User>(names);
		names = new ArrayList<User>();
		names.addAll(set);
	}

	// TODO improve search to be able to look for name or last name 
	// binary search technique algorithm complexity  is O(log n) time O(1) space 
	public User searchUsers(String name) {
		readFile();
		sortAsc();
		int first = 0;
		int last = names.size() - 1;
		int mid = (first + last) / 2;
		while (first <= last && !names.get(mid).getName().equalsIgnoreCase(name)) {
			if (names.get(mid).getName().compareTo(name) < 0) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			return null;
		}
		return names.get(mid);
	}
	
	public void deleteUsers(String name) {
		readFile();
		if(searchUsers(name) == null) {
			System.out.println(name + " not found");
		}
		
	}

	public List<User> listAll() {
		readFile();
		sortAsc();
		return names;
	}

	public void addUser(User user) {
		readFile();
		if(searchUsers(user.getName()) != null) {
			System.out.println("\n");
			System.out.println(user.getName() + " already exist");
		}else {
			writeFile(user);
			System.out.println(user.getName() + " was added to the file");
		}
	}

}
