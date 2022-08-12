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