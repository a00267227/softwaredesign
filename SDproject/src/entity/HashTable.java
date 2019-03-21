package entity;

public class HashTable implements MyIterator, Iterator {


	private int nodeNum;
	private static boolean created = false;
	private static HashTable table;
	private int keyarr[] = new int[300];
	int temp = 0;
	private HNode[] head = new HNode[300];
	public int hash(int key) {
		return key % 20;
	}

	

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
	
	public int searchSteps(int k) {
		int num = 0;
		int index = hash(k);
		HNode temp = head[index];
		boolean found = false;
		while (temp != null && found == false) {
			if (temp.key == k) {
				found = true;
				break;
			}
			temp = temp.next;
			num++;
		}
		return num;
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

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	@Override
	public boolean hasNext() {
		return temp - 1 < nodeNum;
	}

	@Override
	public Object next() {
		HNode no = head[keyarr[temp]];
		temp++;
		return no;
	}

	@Override
	public Iterator iterator() {
		return this;
	}
	
}
