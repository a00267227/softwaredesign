package entity;

public class Node {
	int key;
	String name;
	int age;
	char gender;
	Node left;
	Node right;

	Node(int k, String nm, int a, char g, Node ll, Node rr) {
		key = k;
		name = nm;
		age = a;
		left = ll;
		right = rr;
		gender = g;
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

	public char readGender() {
		return gender;
	}

}