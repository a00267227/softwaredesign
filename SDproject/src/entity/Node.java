package entity;


public class Node implements MyIterator,Iterator{
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

	@Override
	public boolean hasNext() {
		return (this.left !=null & this.right!= null);
	}

	@Override
	public Object next() {
		Node next = null;
		while(this != null) {
			if(this.left != null) return this.left;
			if(this.right != null )return this.right;
		}
		return next;
	}

	@Override
	public Iterator iterator() {
		return new Node(this.key,this.name,this.age,this.gender,this.left,this.right);
	}

}