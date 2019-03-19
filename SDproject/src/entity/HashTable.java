package entity;

public class HashTable implements MyIterator,Iterator{
	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	private int nodeNum;
	private static boolean created = false;
	private static HashTable table;
	private int keyarr[] = new int[25];
	int temp = 0;
	public int hash(int id) {
		return id % 25;
	}

	private HNode[] head = new HNode[25];

	public HashTable() {
		nodeNum = 0;
		table = this;
		for (int i = 0; i < 25; i++)
			head[i] = null;
	}

	public void insert(int k, Person p) {
		HNode temp = new HNode(k, p);
		int index = hash(k);
		temp.next = head[index];
		head[index] = temp;
		keyarr[nodeNum] = k;
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

	@Override
	public boolean hasNext() {
		return temp-1<nodeNum;
	}

	@Override
	public Object next() {
		HNode no =head[keyarr[temp]];
		temp++;
		return no;
	}

	@Override
	public Iterator iterator() {
		return this;
	}
}
