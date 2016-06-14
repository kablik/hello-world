package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Register register = new ArrayRegister(20);

		register.addPerson(new Person("Janko Hrasko", "0900000000"));
		register.addPerson(new Person("Slavo Barilla", "0900111111"));
		register.addPerson(new Person("Tomas Polkabla", "0900222222"));
		register.addPerson(new Person("Janko Fazula", "0900333333"));

		ConsoleUI ui = new ConsoleUI(register);
		ui.run();
	}
}
