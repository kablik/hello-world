package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	private Person[] persons;

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getSize()
	 */
	@Override
	public int getSize() {
		return persons.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {

		Person person = new Person("XXX", "000");

		for (int i = 0; i < getCount(); i++) {
			if (name.equals(getPerson(i).getName())) {
				person = getPerson(i);
			}
		}
		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {

		Person person = new Person("XXX", "000");

		for (int i = 0; i < getCount(); i++) {
			if (phoneNumber.equals(getPerson(i).getPhoneNumber())) {
				person = getPerson(i);
			}
		}
		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#removePerson(register.Person)
	 */
	@Override
	public void removePerson(Person person) {
		for (int i = 0; i < getCount(); i++) {
			Person onDelete = getPerson(i);
			if (onDelete.equals(person)) {
				for (int j = i + 1; j < getCount(); j++) {
					Person docasna = getPerson(j - 1);
					Person docasna2 = getPerson(j );
					docasna.setName(docasna2.getName());
					docasna.setPhoneNumber(docasna2.getPhoneNumber());
				}
			}
		}count--;
	}
}
