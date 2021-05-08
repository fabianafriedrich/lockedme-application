package lockedme.com.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	//TODO sort method
	private List<User> sortAsc(){
		return null;
	}

	public List<User> listAll() {
		readFile();
		return names;
	}
}
