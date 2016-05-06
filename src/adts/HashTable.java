package adts;

public abstract class HashTable {
	private static final int DEFAULT_SIZE = 128; 
	private int size;
	private HashEntry[] table;
	
	public HashTable() {
		this.size = DEFAULT_SIZE;
		this.table = new HashEntry[DEFAULT_SIZE];
	}
	
	public HashTable(int size) {
		this.size = size;
		this.table = new HashEntry[size];
	}
	
	public HashEntry find(String value) throws Exception {
		throw new Exception("Not Implemented Yet!");
	}
	
	public abstract HashEntry remove(String value);
	
	public abstract HashEntry put(String value);
	
	private int Hash(String value) {
		return (value.hashCode() & 0x7fffffff) % this.size;
	}
		
}
