public class HashTablesDemo {
   public static void main(String[] args) {
      String[] keys = {
         "Los Angeles", "Houston", "Washington",
         "Chicago", "San Francisco", "Dallas",
         "Tokyo", "New York", "Vancouver"
      };
      String[] values = { 
         "LAX", "IAH", "IAD",
         "ORD", "SFO", "DAL",
         "NRT", "JFK", "YVR"
      };
      
      final int initialCapacity = 11;

      // Initialize the four types of hash tables
      HashTable[] tables = {
         new ChainingHashTable(initialCapacity),
         new LinearProbingHashTable(initialCapacity),
         new QuadraticProbingHashTable(1, 1, initialCapacity),
         new DoubleHashingHashTable(initialCapacity)
      };
      
      // Add the same content to each hash table
      for (int i = 0; i < keys.length; i++) {
         // Insert the item into each hash table
         for (int j = 0; j < tables.length; j++) {
            tables[j].insert(keys[i], values[i]);
         }
      }
      
      // Print each table's buckets
      String[] tableNames = {
         "Chaining",
         "Linear probing",
         "Quadratic probing",
         "Double hashing"
      };
      for (int j = 0; j < tables.length; j++) {
         System.out.printf("%s: initial table:\n", tableNames[j]);
         System.out.println(tables[j]);
      }
      
      // Remove the 3 oldest keys from each hash table
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < tables.length; j++) {
            tables[j].remove(keys[i]);
         }
      }
      
      // Print each table's buckets again
      System.out.println();
      for (int j = 0; j < tables.length; j++) {
         System.out.printf("%s after removal:\n", tableNames[j]);
         System.out.println(tables[j]);
      }
   }
}

// hash remove

HashRemove(hashTable, key) {
   i = 0
   bucketsProbed = 0

   // Hash function determines initial bucket
   bucket = Hash(key) % N

   while ((hashTable[bucket] is not EmptySinceStart) and (bucketsProbed < N)) {
      if ((hashTable[bucket] is Occupied) and (hashTable[bucket]???key == key)) {
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
      if ((hashTable[bucket] is Occupied) and (hashTable[bucket]???key == key)) {
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

