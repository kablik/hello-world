package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	public ConsoleUI(Register register) {
		this.register = register;
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				return;
			}
		}
	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	private void printRegister() {
		for (int i = 0; i < register.getCount(); i++) {
			Person person = register.getPerson(i);
			System.out.println((i + 1) + "." + person);
		}
		System.out.println();
	}

	private void addToRegister() {
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
		boolean jeZhoda = true;
		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i).getName().equals(name)
					&& register.getPerson(i).getPhoneNumber().equals(phoneNumber)) {
				System.out.println(
						"Osoba s takým menom a èíslom sa už v zozname nachádza. Prosím zvo¾te iné meno a èíslo osoby!!!");
				jeZhoda = false;
				name = enterName();
				phoneNumber = enterPhoneNumber();
				register.addPerson(new Person(name, phoneNumber));
				break;
			} else if (register.getPerson(i).getName().equals(name)) {
				System.out.println("Osoba s takým menom sa už v zozname nachádza. Prosím zvo¾te iné meno osoby!!!");
				jeZhoda = false;
				name = enterName();
				register.addPerson(new Person(name, phoneNumber));
				break;
			} else if (register.getPerson(i).getPhoneNumber().equals(phoneNumber)) {
				System.out.println("Osoba s takým èíslom sa už v zozname nachádza. Prosím zvo¾te iné èíslo osoby!!!");
				jeZhoda = false;
				phoneNumber = enterPhoneNumber();
				register.addPerson(new Person(name, phoneNumber));
				break;
			}
		}
		if (jeZhoda == true) {
			register.addPerson(new Person(name, phoneNumber));
		}
	}

	private String enterPhoneNumber() {
		String phoneNumber;
		System.out.println("Enter Phone Number: ");
		phoneNumber = readLine();
		return phoneNumber;
	}

	private String enterName() {
		String name;
		System.out.println("Enter Name: ");
		name = readLine();
		return name;
	}

	private void updateRegister() {

		System.out.println("Chcete h¾adat pod¾a mena (zadajte 'M') alebo èísla (zadajte 'C'): ");
		String hladanie = readLine();
		if (hladanie.equals("M")) {
			System.out.println("Zadajte meno osoby: ");
			Person person = register.findPersonByName(readLine());
			if (person.toString().equals("XXX (000)")) {
				System.out.println("Osoba s takým menom sa v registri nenachádza!!!");
			} else {
				ZmenaUdajov(person);
			}

		} else if (hladanie.equals("C")) {
			System.out.println("Zadajte èíslo osoby: ");
			Person person = register.findPersonByPhoneNumber(readLine());
			if (person.toString().equals("XXX (000)")) {
				System.out.println("Osoba s takým èíslom sa v registri nenachádza!!!");
			} else {
				ZmenaUdajov(person);
			}
		}
	}

	private void ZmenaUdajov(Person person) {
		System.out.println("Chcete zmeni meno (zadajte 'M') alebo èíslo (zadajte 'C') alebo oba (zadajte 'MC'): ");
		String zmena = readLine();
		if (zmena.equals("M")) {
			updateName(person);

		} else if (zmena.equals("C")) {
			updatePhoneNumber(person);

		} else if (zmena.equals("MC")) {
			updateName(person);
			updatePhoneNumber(person);
		}
	}

	private void updatePhoneNumber(Person person) {
		System.out.println("Súèasné èíslo osoby je: " + person.getPhoneNumber());
		System.out.println("Zadajte nové èíslo osoby: ");
		person.setPhoneNumber(readLine());
	}

	private void updateName(Person person) {
		System.out.println("Súèasné meno osoby je: " + person.getName());
		System.out.println("Zadajte nové meno osoby: ");
		person.setName(readLine());
	}

	private void findInRegister() {
		System.out.println("Chcete h¾adat pod¾a mena (zadajte 'M') alebo èísla (zadajte 'C'): ");
		String zmena = readLine();
		if (zmena.equals("M")) {
			System.out.println("Zadajte meno osoby: ");
			String vystup = (register.findPersonByName(readLine())).toString();
			if (vystup.equals("XXX (000)")) {
				System.out.println("Osoba s takým menom sa v registri nenachádza!!!");
			} else {
				System.out.println(vystup);
			}
			System.out.println();

		} else if (zmena.equals("C")) {
			System.out.println("Zadajte èíslo osoby: ");
			String vystup = (register.findPersonByPhoneNumber(readLine())).toString();
			if (vystup.equals("XXX (000)")) {
				System.out.println("Osoba s takým èíslom sa v registri nenachádza!!!");
			} else {
				System.out.println(vystup);
			}
			System.out.println();
		}
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}
}
