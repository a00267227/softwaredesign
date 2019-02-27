package entity;

public class HashTable {
	private int nodeNum;
	private static boolean created = false;
	private static HashTable table;

	public int hash(int id) {
		return id % 20;
	}

	private HNode[] head = new HNode[20];

	public HashTable() {
		nodeNum = 0;
		table = this;
		for (int i = 0; i < 20; i++)
			head[i] = null;
	}

	public void insert(int k, Person p) {
		HNode temp = new HNode(k, p);
		int index = hash(k);
		temp.next = head[index];
		head[index] = temp;
		nodeNum++;
	}

	public HNode search(int k) {
		int index = hash(k);
		HNode temp = head[index];
		boolean found = false;
		while (temp != null && found == false) {
			if (temp.key == k) {
				found = true;
				break;
			}
			temp = temp.next;
		}
		return temp;
	}

	public int readNodeNum() {
		return nodeNum;
	}

	public static HashTable getInstance() {
		if (!created) {
			table = new HashTable();
		}
		return table;

	}
}
