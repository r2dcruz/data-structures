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

// review


HashInsert(hashTable, item) {
   if (HashSearch(hashTable, item⇢key) == null) {
      bucketList = hashTable[Hash(item⇢key)]
      node = Allocate new linked list node
      node⇢next = null
      node⇢data = item
      ListAppend(bucketList, node)
   }
}

HashSearch(hashTable, key) {
   bucketList = hashTable[Hash(key)]
   itemNode = ListSearch(bucketList, key)
   if (itemNode is not null)
      return itemNode⇢data
   else
      return null
}

// hash insert

ashInsert(hashTable, item) {
   if (HashSearch(hashTable, item⇢key) == null) {
      bucketList = hashTable[Hash(item⇢key)]
      node = Allocate new linked list node
      node⇢next = null
      node⇢data = item
      ListAppend(bucketList, node)
   }
}

HashRemove(hashTable, item) {
   bucketList = hashTable[Hash(item⇢key)]
   itemNode = ListSearch(bucketList, item⇢key)
   if (itemNode is not null) {
      ListRemove(bucketList, itemNode)
   } 
}

HashSearch(hashTable, key) {
   bucketList = hashTable[Hash(key)]
   itemNode = ListSearch(bucketList, key)
   if (itemNode is not null)
      return itemNode⇢data
   else
      return null
}

// linear probing

HashInsert(hashTable, item) {
   // Hash function determines initial bucket
   bucket = Hash(item.key)    
   bucketsProbed = 0
   //N = hashTable's size
   while (bucketsProbed < N) {
      // Insert item in next empty bucket
      if (hashTable[bucket] is Empty) {
         hashTable[bucket] = item
         return true 
      }

      // Increment bucket index
      bucket = (bucket + 1) % N

      // Increment number of buckets probed
      ++bucketsProbed
   }

   return false      
}

// linear probing


HashRemove(hashTable, key) {  
   // Hash function determines initial bucket
   bucket = Hash(key)
   bucketsProbed = 0

   while ((hashTable[bucket] is not EmptySinceStart) and
         (bucketsProbed < N)) {

      if ((hashTable[bucket] is not Empty) and
         (hashTable[bucket]⇢key == key)) {
         hashTable[bucket] = EmptyAfterRemoval
         return
      }

      // Increment bucket index
      bucket = (bucket + 1) % N

      // Increment number of buckets probed
      ++bucketsProbed
   }
}

// search

HashSearch(hashTable, key) {
   // Hash function determines initial bucket
   bucket = Hash(key)
   bucketsProbed = 0

   while ((hashTable[bucket] is not EmptySinceStart) and
         (bucketsProbed < N)) {

      if ((hashTable[bucket] is not Empty) and
         (hashTable[bucket]⇢key == key)) {
         return hashTable[bucket]
      }

      // Increment bucket index
      bucket = (bucket + 1) % N

      // Increment number of buckets probed
      ++bucketsProbed
   }

   return null  // Item not found
}

// insert

HashInsert(hashTable, item) {
   i = 0
   bucketsProbed = 0

   // Hash function determines initial bucket
   bucket = Hash(item⇢key) % N
   while (bucketsProbed < N) {
      // Insert item in next empty bucket 
      if (hashTable[bucket] is Empty) {
         hashTable[bucket] = item
         return true  
      }

      // Increment i and recompute bucket index
      // c1 and c2 are programmer-defined constants for quadratic probing
      i = i + 1
      bucket = (Hash(item⇢key) + c1 * i + c2 * i * i) % N

      // Increment number of buckets probed
      bucketsProbed = bucketsProbed + 1
   }
   return false       
}

// having trouble

HashRemove(hashTable, key) {
   i = 0
   bucketsProbed = 0

   // Hash function determines initial bucket
   bucket = Hash(key) % N

   while ((hashTable[bucket] is not EmptySinceStart) and (bucketsProbed < N)) {
      if ((hashTable[bucket] is Occupied) and (hashTable[bucket]⇢key == key)) {
         hashTable[bucket] = EmptyAfterRemoval
         return true
      }

      // Increment i and recompute bucket index
      // c1 and c2 are programmer-defined constants for quadratic probing
      i = i + 1
      bucket = (Hash(key) + c1 * i + c2 * i * i) % N

      // Increment number of buckets probed
      bucketsProbed = bucketsProbed + 1
   }
   return false // key not found
}


HashSearch(hashTable, key) {
   i = 0
   bucketsProbed = 0

   // Hash function determines initial bucket
   bucket = Hash(key) % N

   while ((hashTable[bucket] is not EmptySinceStart) and (bucketsProbed < N)) {
      if ((hashTable[bucket] is Occupied) and (hashTable[bucket]⇢key == key)) {
         return hashTable[bucket]
      }

      // Increment i and recompute bucket index
      // c1 and c2 are programmer-defined constants for quadratic probing
      i = i + 1
      bucket = (Hash(key) + c1 * i + c2 * i * i) % N

      // Increment number of buckets probed
      bucketsProbed = bucketsProbed + 1
   }
   return null  // key not found
}

// resize


HashResize(hashTable, currentSize) {
   newSize = nextPrime(currentSize * 2)

   newArray = Allocate new array of size newSize
   Set all entries in newArray to EmptySinceStart

   bucket = 0
   while (bucket < currentSize) {
      if (hashTable[bucket] is not Empty) {
         key = hashTable[bucket]
         HashInsert(newArray, key)
      }
      bucket = bucket + 1
   }

   return newArray
}

Hash(key, tableSize) {
   return key % tableSize
}

// abstract

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

// another class

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

// open address


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

//

ublic abstract class OpenAddressingHashTable extends HashTable {
   protected OpenAddressingBucket[] table;

   public OpenAddressingHashTable(int initialCapacity) {
      table = new OpenAddressingBucket[initialCapacity];
      for (int i = 0; i < table.length; i++) {
         table[i] = OpenAddressingBucket.EMPTY_SINCE_START;
      }
   }

   protected abstract int probe(Object key, int i);

   // Inserts the specified key/value pair. If the key already exists, the 
   // corresponding value is updated. If inserted or updated, true is returned. 
   // If not inserted, then false is returned.   
   @Override
   public boolean insert(Object key, Object value) {
      // First search for the key in the table. If found, update bucket's value.
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         
         // An empty-since-start bucket implies the key is not in the table
         if (table[bucketIndex] == OpenAddressingBucket.EMPTY_SINCE_START) {
            break;
         }
         
         if (table[bucketIndex] != OpenAddressingBucket.EMPTY_AFTER_REMOVAL) {
            // Check if the non-empty bucket has the key
            if (key.equals(table[bucketIndex].key)) {
               // Update the value
               table[bucketIndex].value = value;
               return true;
            }
         }
      }
      
      // The key is not in the table, so insert into first empty bucket
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         if (table[bucketIndex].isEmpty()) {
            table[bucketIndex] = new OpenAddressingBucket(key, value);
            return true;
         }
      }
      
      return false; // no empty bucket found
   }

   // Searches for the specified key. If found, the key/value pair is removed 
   // from the hash table and true is returned. If not found, false is returned.   
   @Override
   public boolean remove(Object key) {
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         
         // An empty-since-start bucket implies the key is not in the table
         if (table[bucketIndex] == OpenAddressingBucket.EMPTY_SINCE_START) {
            return false;
         }
         
         if (table[bucketIndex] != OpenAddressingBucket.EMPTY_AFTER_REMOVAL) {
            // Check if the non-empty bucket has the key
            if (key.equals(table[bucketIndex].key)) {
               // Remove by setting the bucket to empty-after-removal
               table[bucketIndex] = OpenAddressingBucket.EMPTY_AFTER_REMOVAL;
               return true;
            }
         }
      }

      return false; // key not found
   }
   
   // Searches for the key, returning the corresponding value if found, null if 
   // not found.
   @Override
   public Object search(Object key) {
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         
         // An empty-since-start bucket implies the key is not in the table
         if (table[bucketIndex] == OpenAddressingBucket.EMPTY_SINCE_START) {
            return null;
         }
         
         if (table[bucketIndex] != OpenAddressingBucket.EMPTY_AFTER_REMOVAL) {
            // Check if the non-empty bucket has the key
            if (key.equals(table[bucketIndex].key)) {
               return table[bucketIndex].value;
            }
         }
      }

      return null; // key not found
   }
}

// linear probing

public class LinearProbingHashTable extends OpenAddressingHashTable {
   public LinearProbingHashTable(int initialCapacity) {
      super(initialCapacity);
   }
   
   public LinearProbingHashTable() {
      // Initialize with an initial capacity of 11
      this(11);
   }
   
   // Returns the bucket index for the specified key and i value using the 
   // linear probing sequence.
   @Override
   protected int probe(Object key, int i) {
      return (hash(key) + i) % table.length;
   }
}

// fall 2022

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

// addressing hashtag

public abstract class OpenAddressingHashTable extends HashTable {
   protected OpenAddressingBucket[] table;

   public OpenAddressingHashTable(int initialCapacity) {
      table = new OpenAddressingBucket[initialCapacity];
      for (int i = 0; i < table.length; i++) {
         table[i] = OpenAddressingBucket.EMPTY_SINCE_START;
      }
   }

   protected abstract int probe(Object key, int i);

   // Inserts the specified key/value pair. If the key already exists, the 
   // corresponding value is updated. If inserted or updated, true is returned. 
   // If not inserted, then false is returned.   
   @Override
   public boolean insert(Object key, Object value) {
      // First search for the key in the table. If found, update bucket's value.
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         
         // An empty-since-start bucket implies the key is not in the table
         if (table[bucketIndex] == OpenAddressingBucket.EMPTY_SINCE_START) {
            break;
         }
         
         if (table[bucketIndex] != OpenAddressingBucket.EMPTY_AFTER_REMOVAL) {
            // Check if the non-empty bucket has the key
            if (key.equals(table[bucketIndex].key)) {
               // Update the value
               table[bucketIndex].value = value;
               return true;
            }
         }
      }
      
      // The key is not in the table, so insert into first empty bucket
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         if (table[bucketIndex].isEmpty()) {
            table[bucketIndex] = new OpenAddressingBucket(key, value);
            return true;
         }
      }
      
      return false; // no empty bucket found
   }

   // Searches for the specified key. If found, the key/value pair is removed 
   // from the hash table and true is returned. If not found, false is returned.   
   @Override
   public boolean remove(Object key) {
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         
         // An empty-since-start bucket implies the key is not in the table
         if (table[bucketIndex] == OpenAddressingBucket.EMPTY_SINCE_START) {
            return false;
         }
         
         if (table[bucketIndex] != OpenAddressingBucket.EMPTY_AFTER_REMOVAL) {
            // Check if the non-empty bucket has the key
            if (key.equals(table[bucketIndex].key)) {
               // Remove by setting the bucket to empty-after-removal
               table[bucketIndex] = OpenAddressingBucket.EMPTY_AFTER_REMOVAL;
               return true;
            }
         }
      }

      return false; // key not found
   }
   
   // Searches for the key, returning the corresponding value if found, null if 
   // not found.
   @Override
   public Object search(Object key) {
      for (int i = 0; i < table.length; i++) {
         int bucketIndex = probe(key, i);
         
         // An empty-since-start bucket implies the key is not in the table
         if (table[bucketIndex] == OpenAddressingBucket.EMPTY_SINCE_START) {
            return null;
         }
         
         if (table[bucketIndex] != OpenAddressingBucket.EMPTY_AFTER_REMOVAL) {
            // Check if the non-empty bucket has the key
            if (key.equals(table[bucketIndex].key)) {
               return table[bucketIndex].value;
            }
         }
      }

      return null; // key not found
   }
}