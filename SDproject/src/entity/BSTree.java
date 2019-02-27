package entity;

public class BSTree {
	private Node head;
	private Node tail;
	private int nodeNum;
	private static boolean created = false;
	private static BSTree tree;

	public BSTree() {
		tree = this;
		tail = new Node(0, null, 0, 't', null, null);
		head = new Node(-1, null, 0, 't', null, tail);
		nodeNum = 0;
		created = true;
	}

	public void insert(int k, String nm, int a, char g) {
		Node p, x;
		nodeNum++;
		p = head;
		x = head.right;
		while (x != tail) {
			p = x;
			x = (k < x.key) ? x.left : x.right;
		}
		x = new Node(k, nm, a, g, tail, tail);
		if (k < p.key)
			p.left = x;
		else
			p.right = x;
		System.out.println("Insert successfully");
	}

	public Node search(int k) {
		Node x = head.right;
		tail.key = k;
		boolean found = false;
		while (x != tail && found == false) {
			if (k == x.key)
				found = true;
			else if (k < x.key)
				x = x.left;
			else
				x = x.right;
		}
		if (x == tail)
			return null;
		else
			return x;
	}

	public int readNodeNum() {
		return nodeNum;
	}

	public static BSTree getInstance() {
		if (!created) {
			tree = new BSTree();
		}
		return tree;

	}
}