package entity;

public class HNode {
	int key;
	HNode next;
	Person person;

	public Person getPerson() {
		return person;
	}

	public HNode(int k, Person p) {
		person = new Person(p.getName(), "" + p.getAge(), "" + p.getGender());
		key = k;
		next = null;
	}

	public int readKey() {
		return key;
	}

}