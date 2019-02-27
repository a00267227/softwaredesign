package entity;

public class HNode {
	public Person getPerson() {
		return person;
	}

	int key;
	String name;
	int age;
	HNode next;
	Person person;

	HNode(int k, String nm, int a) {
		key = k;
		name = nm;
		age = a;
		next = null;
	}

	public HNode(int k, Person p) {
		person = new Person(p.getName(),p.getAge(),p.getGender());
		key = k;
	}

	public int readKey() {
		return key;
	}

	public String readName() {
		return name;
	}

	public int readAge() {
		return age;
	}
}