public class OpenAddressingHashTable {
    private int[] table;
    private int capacity;
    private int size;

    public OpenAddressingHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new int[capacity];
        this.size = 0;
    }

    public boolean insert(int key) {
        if (size == capacity)
            return false;

        int index = hash(key);

        while (table[index] != 0 && table[index] != -1) {
            index = (index + 1) % capacity;
        }

        table[index] = key;
        size++;
        return true;
    }

    public boolean search(int key) {
        int index = hash(key);

        while (table[index] != 0) {
            if (table[index] == key)
                return true;

            index = (index + 1) % capacity;
        }

        return false;
    }

    public boolean delete(int key) {

         /* write your code here */
    }

    private int hash(int key) {
        return key % capacity;
    }

    public static void main(String[] args) {

        OpenAddressingHashTable hashTable = new OpenAddressingHashTable(10);

        hashTable.insert(5);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(35);

        System.out.println("Search 15: " + hashTable.search(15));

        System.out.println("Search 20: " + hashTable.search(20));
    }
}
