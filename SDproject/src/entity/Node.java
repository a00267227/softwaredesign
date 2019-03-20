package entity;

public class Node {

	int key;
	Person person;
	Node left;
	Node right;

	Node(int k, String nm, int a, char g, Node ll, Node rr) {
		key = k;
		left = ll;
		right = rr;
		person= new Person(nm,""+a,""+g);
	}

	public int readKey() {
		return key;
	}

	public Person getPerson() {
		return person;
	}

}