package entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTree implements MyIterator,Iterator{
	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

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
		tail = new Node(0, null, 0, 't', null, null);
		head = new Node(-1, "head", 0, 'N', null, tail);
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
		if(step == 0) {
			p.right = x;
		}else {
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
		if (!created) {
			tree = new BSTree();
		}
		return tree;

	}

	public Node preSearch(int key) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.head);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int temp = cur.readKey();
			if (cur.left != null) {
				if(temp==key) return cur;
				queue.add(cur.left);
			}
			if (cur.right != null) {
				if(temp==key) return cur;
				queue.add(cur.right);
			}
		}
		return null;
	}
	
	public String inSearchAvgAge() {
		double sum = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.head);
		Node cur = queue.poll();
		while(!queue.isEmpty() || cur != null) {
			while(cur != null) {
				sum += cur.readAge();
				queue.add(cur);
				cur = cur.left;
			}
			Node last = queue.poll();
			cur = last.right;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(sum/this.readNodeNum());
	}

	
	@Override
	public Iterator iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return cursor+1<nodes.size();
	}

	@Override
	public Object next() {
		cursor++;
		return nodes.get(cursor);
	}
	
	
}