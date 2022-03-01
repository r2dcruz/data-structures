// Abstract class for a hash table that supports the insert, remove, and search 
// operations.
public abstract class HashTable {
   // Returns a non-negative hash code for the specified key.
   protected int hash(Object key) {
      long keyHash = key.hashCode();
      
      // Java's hashCode() method may return a negative number
      if (keyHash < 0) {
         keyHash += 2147483648L;
      }
      
      return (int)keyHash;
   }
   
   // Inserts the specified key/value pair. If the key already exists, the 
   // corresponding value is updated. If inserted or updated, true is returned. 
   // If not inserted, then false is returned.
   public abstract boolean insert(Object key, Object value);
   
   // Searches for the specified key. If found, the key/value pair is removed 
   // from the hash table and true is returned. If not found, false is returned.
   public abstract boolean remove(Object key);
   
   // Searches for the key, returning the corresponding value if found, null if 
   // not found.
   public abstract Object search(Object key);
}

class ChainingHashTableItem {
   public Object key;
   public Object value;
   public ChainingHashTableItem next;

   ChainingHashTableItem(Object itemKey, Object itemValue) {
      key = itemKey;
      value = itemValue;
      next = null;
   }
}

public class ChainingHashTable extends HashTable {
   private ChainingHashTableItem[] table;

   public ChainingHashTable(int initialCapacity) {
      table = new ChainingHashTableItem[initialCapacity];
   }
   
   public ChainingHashTable() {
      // Initialize with an initial capacity of 11
      this(11);
   }

   // Inserts the specified key/value pair. If the key already exists, the 
   // corresponding value is updated. If inserted or updated, true is returned. 
   // If not inserted, then false is returned.
   public boolean insert(Object key, Object value) {
      // Hash the key to get the bucket index
      int bucketIndex = hash(key) % table.length;
      
      // Traverse the linked list, searching for the key. If the key exists in 
      // an item, the value is replaced. Otherwise a new item is appended.
      ChainingHashTableItem item = table[bucketIndex];
      ChainingHashTableItem previous = null;
      while (item != null) {
         if (key.equals(item.key)) {
            item.value = value;
            return true;
         }
         
         previous = item;
         item = item.next;
      }
      
      // Append to the linked list
      if (table[bucketIndex] == null) {
         table[bucketIndex] = new ChainingHashTableItem(key, value);
      }
      else {
         previous.next = new ChainingHashTableItem(key, value);
      }
      return true;
   }
   
   // Searches for the specified key. If found, the key/value pair is removed 
   // from the hash table and true is returned. If not found, false is returned.
   public boolean remove(Object key) {
      // Hash the key to get the bucket index
      int bucketIndex = hash(key) % table.length;
      
      // Search the bucket's linked list for the key
      ChainingHashTableItem item = table[bucketIndex];
      ChainingHashTableItem previous = null;
      while (item != null) {
         if (key.equals(item.key)) {
            if (previous == null) {
               // Remove linked list's first item
               table[bucketIndex] = item.next;
            }
            else {
               previous.next = item.next;
            }
            return true;
         }
         
         previous = item;
         item = item.next;
      }
      
      return false; // key not found
   }
   
   // Searches for the key, returning the corresponding value if found, null if 
   // not found.
   public Object search(Object key) {
      // Hash the key to get the bucket index
      int bucketIndex = hash(key) % table.length;
      
      // Search the bucket's linked list for the key
      ChainingHashTableItem item = table[bucketIndex];
      while (item != null) {
         if (key.equals(item.key)) {
            return item.value;
         }
         item = item.next;
      }
      
      return null; // key not found
   }
}

class OpenAddressingBucket {
   public Object key;
   public Object value;
   
   public static final OpenAddressingBucket EMPTY_SINCE_START = new OpenAddressingBucket(null, null);
   public static final OpenAddressingBucket EMPTY_AFTER_REMOVAL = new OpenAddressingBucket(null, null);

   OpenAddressingBucket(Object bucketKey, Object bucketValue) {
      key = bucketKey;
      value = bucketValue;
   }
   
   boolean isEmpty() {
      return this == EMPTY_SINCE_START || this == EMPTY_AFTER_REMOVAL;
   }
}