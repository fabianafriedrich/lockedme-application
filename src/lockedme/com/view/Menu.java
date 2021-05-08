package lockedme.com.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import lockedme.com.controller.Controller;

public class Menu {

	Controller ctr = new Controller();

	public Menu() {
		menu();
	}

	// Get into menu
	public void menu() {
		System.out.println("\n");
		System.out.println("1.List users name in ascending order");
		System.out.println("2.User operations");
		System.out.println("3.Close application");
		System.out.println("\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		try {

			boolean validMenu = false;

			do {
				// Performing depending on user's selection
				System.out.println("Please select a number: ");
				input = br.readLine();

				if (input.matches("[0-9]+")) {
					validMenu = true;
				} else {
					validMenu = false;
				}

			} while (validMenu == false);

		} catch (Exception e) {
			System.out.println("Error");
		}

		// Check the user number
		if (input.equals("1")) {
			System.out.println(ctr.listAll());
			menu();

		} else if (input.equals("2")) {
			operationsMenu();
		} else if (input.equals("3")) {
			System.out.println("### Application terminated ###");
			System.exit(0);
		} else {
			System.err.println("# Invalid option #");
			menu();
		}
	}
	
	// Get into operations menu
		public void operationsMenu() {
			System.out.println("\n");
			System.out.println("1.Add a user");
			System.out.println("2.Delete user");
			System.out.println("3.Search for user");
			System.out.println("4.Main menu");
			System.out.println("\n");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = "";

			try {

				boolean validMenu = false;

				do {
					// Performing depending on user's selection
					System.out.println("Please select a number: ");
					input = br.readLine();

					if (input.matches("[0-9]+")) {
						validMenu = true;
					} else {
						validMenu = false;
					}

				} while (validMenu == false);

			} catch (Exception e) {
				System.out.println("Error");
			}

			// Check the user number
			if (input.equals("1")) {
			
			} else if (input.equals("2")) {

			} else if (input.equals("3")) {

			}else if (input.equals("4")) {
				
				menu();
			} else {
				System.err.println("# Invalid option #");
				operationsMenu();
			}
		}
		
		//TODO validation inputs

}
