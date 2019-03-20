package entity;

import java.util.ArrayList;
import java.util.List;

public class BSTree implements MyIterator, Iterator {

	private Node head;
	private Node tail;
	private int nodeNum;
	private static boolean created = false;
	private static BSTree tree;
	private int cursor = -1;
	int temp = 0;
	boolean flag = false;
	private List nodes = new ArrayList<Node>(50);

	public BSTree() {
		tree = this;
		tail = new Node(0, null, 0, 'T', null, null);
		head = new Node(-1, "head", 0, 'H', null, tail);
		nodeNum = 0;
		created = true;
		nodes.add(head);
	}

	public int insert(int k, String nm, int a, char g) {
		int step = 0;
		Node p, x;
		nodeNum++;
		p = head;
		x = head.right;
		while (x != tail) {
			p = x;
			x = (k < x.key) ? x.left : x.right;
			step++;
		}
		x = new Node(k, nm, a, g, tail, tail);
		if (step == 0) {
			p.right = x;
		} else {
			if (k < p.key)
				p.left = x;
			else
				p.right = x;
		}
		nodes.add(x);
		step++;
		System.out.println("Insert successfully");
		return step;
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

	public int searchSteps(int k) {
		int steps = 0;
		Node x = head.right;
		tail.key = k;
		boolean found = false;
		while (x != tail && found == false) {
			steps++;
			if (k == x.key)
				found = true;
			else if (k < x.key)
				x = x.left;
			else
				x = x.right;
		}
		return steps;
	}

	public int readNodeNum() {
		return nodeNum;
	}

	public static BSTree getInstance() {
		return 	tree = new BSTree();
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	@Override
	public Iterator iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return cursor + 1 < nodes.size();
	}

	@Override
	public Object next() {
		cursor++;
		return nodes.get(cursor);
	}

}