class Entry {
    int key;
    int value;

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTable {
    private Entry[] arr;
    private int capacity;
    private int size;
    private Entry dummy = new Entry(-1, -1);
    
        public HashTable(int capacity) {
            this.capacity = capacity;
            this.arr = new Entry[capacity];
            this.size = 0;
    
        }
    
        public boolean insert(int key, int value) {
            if (size == capacity)
                return false;
    
            int index = hash(key);
    
            while (arr[index] != null && arr[index].key != -1) {
                if (arr[index].key == key) {
                    // Update the value if the key already exists
                    arr[index].value = value;
                    return true;
                }
                index = (index + 1) % capacity;
            }
    
            arr[index] = new Entry(key, value);
            size++;
            return true;
        }
    
        public Integer search(int key) {
            int index = hash(key);
    
            while (arr[index] != null) {
                if (arr[index].key == key)
                    return arr[index].value;
    
                index = (index + 1) % capacity;
            }
    
            return null; // Return null if the key is not found
        }
    
        public boolean delete(int key) {
            int hashIndex = hash(key);
             while (this.arr[hashIndex] != null) {
                if (this.arr[hashIndex].key == key) {
                    Entry temp = this.arr[hashIndex];
                    this.arr[hashIndex] = this.dummy;
                this.size--;
                return true;
            }
            hashIndex++;
            hashIndex %= this.capacity;
        }
        return false;
    }
        

    

    private int hash(int key) {
        return key % capacity;
    }

    public static void main(String[] args) {
        HashTable hashtable = new HashTable(10);

        hashtable.insert(5, 100);
        hashtable.insert(15, 200);
        hashtable.insert(25, 300);
        hashtable.insert(35, 400);

        System.out.println("Search 15: " + hashtable.search(15)); 
        System.out.println("Search 20: " + hashtable.search(20)); 

        hashtable.delete(15);
        System.out.println("Search 15 after deletion: " + hashtable.search(15)); 
        hashtable.insert(15, 70);

    }
}

