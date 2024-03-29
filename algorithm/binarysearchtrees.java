BSTSearch(tree, key) {
   cur = tree⇢root
   while (cur is not null) {
      if (key == cur⇢key) {
         return cur // Found
      }
      else if (key < cur⇢key) {
         cur = cur⇢left
      }
      else {
         cur = cur⇢right
      }
   }
   return null // Not found
}


BSTInsert(tree, node) {
   if (tree⇢root is null) {
      tree⇢root = node
   }
   else {
      currentNode = tree⇢root
      while (currentNode is not null) {
         if (node⇢key < currentNode⇢key) {
            if (currentNode⇢left is null) {
               currentNode⇢left = node
               currentNode = null
            }
            else {
               currentNode = currentNode⇢left
            }
         }
         else {
            if (currentNode⇢right is null) {
               currentNode⇢right = node
               currentNode = null
            }
            else {
               currentNode = currentNode⇢right
            }
         }
      }
   }
}

BSTRemove(tree, key) {
   par = null
   cur = tree⇢root
   while (cur is not null) { // Search for node
      if (cur⇢key == key) { // Node found
         if (cur⇢left is null && cur⇢right is null) { // Remove leaf
            if (par is null) // Node is root
               tree⇢root = null
            else if (par⇢left == cur)
               par⇢left = null
            else
               par⇢right = null
         }
         else if (cur⇢right is null) {                // Remove node with only left child
            if (par is null) // Node is root
               tree⇢root = cur⇢left
            else if (par⇢left == cur)
               par⇢left = cur⇢left
            else
               par⇢right = cur⇢left
         }
         else if (cur⇢left is null) {                // Remove node with only right child
            if (par is null) // Node is root
               tree⇢root = cur⇢right
            else if (par⇢left == cur)
               par⇢left = cur⇢right
            else
               par⇢right = cur⇢right
         }
         else {                                      // Remove node with two children
            // Find successor (leftmost child of right subtree)
            suc = cur⇢right
            while (suc⇢left is not null)
               suc = suc⇢left
            successorData = Create copy of suc's data
            BSTRemove(tree, suc⇢key)     // Remove successor
            Assign cur's data with successorData
         }
         return // Node found and removed
      }
      else if (cur⇢key < key) { // Search right
         par = cur
         cur = cur⇢right
      }
      else {                     // Search left
         par = cur
         cur = cur⇢left
      }
   }
   return // Node not found
}


BSTPrintInorder(node) {
   if (node is null)
      return                     // "Ret"

   BSTPrintInorder(node⇢left)   // "L"  
   Print node                    // "Cur"
   BSTPrintInorder(node⇢right)  // "R"
}

<<<<<<< HEAD
import java.util.Scanner;

public class BinarySearchTreeDemo {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      BinarySearchTree tree = new BinarySearchTree();

      // Ask user for values to insert
      System.out.print("Enter values to insert with spaces between: ");
      String userValues = scnr.nextLine();
      System.out.println();

      // Add each value to the tree
      for (String value : userValues.split(" ")) {
         int key = Integer.parseInt(value);
         tree.insert(new Node(key));
      }

      // Show the tree
      System.out.println("Initial tree:");
      System.out.println(BSTPrint.treeToString(tree.getRoot()));
      System.out.println();

      // Ask the user for a value to remove
      System.out.print("Enter value to remove: ");
      String removeValueString = scnr.nextLine();
      int removeValue = Integer.parseInt(removeValueString);
      System.out.println();

      System.out.printf("Tree after removing %d:%n", removeValue);
      tree.remove(removeValue);
      System.out.println(BSTPrint.treeToString(tree.getRoot()));
   }
}
=======

TrieInsert(root, string) {
   node = root
   for (character in string) {
      if (character is not in node⇢children) {
         node⇢children[character] = new TrieNode()
      }
      node = node⇢children[character]
   }

   if (0 is not in node⇢children) {
      node⇢children[0] = new TrieNode()
   }
   return node⇢children[0]
}

trieRoot = new TrieNode()
TrieInsert(trieRoot, "APPLE")
TrieInsert(trieRoot, "APPLY")
TrieInsert(trieRoot, "APP")
>>>>>>> 326a3f54f40b1749f2b96c6799d5ba5ee5b55655


// search

LinearSearch(numbers, numbersSize, key) {
   i = 0

   for (i = 0; i < numbersSize; ++i) {
      if (numbers[i] == key) {
         return i
      }
   }
      
   return -1 // not found
}
   
main() {
   numbers = {2, 4, 7, 10, 11, 32, 45, 87}
   NUMBERS_SIZE = 8
   i = 0
   key = 0
   keyIndex = 0
      
   print("NUMBERS: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
      
   print("Enter a value: ")
   key = getIntFromUser()
      
   keyIndex = LinearSearch(numbers, NUMBERS_SIZE, key)
      
   if (keyIndex == -1) {
      printLine(key + " was not found.")
   } 
   else {
      printLine("Found " + key + " at index " + keyIndex + ".")
   }
}

// linear search

LinearSearch(numbers, numbersSize, key) {
   i = 0

   for (i = 0; i < numbersSize; ++i) {
      if (numbers[i] == key) {
         return i
      }
   }
      
   return -1 // not found
}
   
main() {
   numbers = {2, 4, 7, 10, 11, 32, 45, 87}
   NUMBERS_SIZE = 8
   i = 0
   key = 0
   keyIndex = 0
      
   print("NUMBERS: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
      
   print("Enter a value: ")
   key = getIntFromUser()
      
   keyIndex = LinearSearch(numbers, NUMBERS_SIZE, key)
      
   if (keyIndex == -1) {
      printLine(key + " was not found.")
   } 
   else {
      printLine("Found " + key + " at index " + keyIndex + ".")
   }
}

// 

BinarySearch(numbers, numbersSize, key) {
   mid = 0
   low = 0
   high = numbersSize - 1
   
   while (high >= low) {
      mid = (high + low) / 2
      if (numbers[mid] < key) {
         low = mid + 1
      }
      else if (numbers[mid] > key) {
         high = mid - 1
      }
      else {
         return mid
      }
   }
   
   return -1 // not found
}

// binary

main() {
   numbers = { 2, 4, 7, 10, 11, 32, 45, 87 }
   NUMBERS_SIZE = 8
   i = 0
   key = 0
   keyIndex = 0
   
   print("NUMBERS: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
   
   print("Enter a value: ")
   key = getIntFromUser()
   
   keyIndex = BinarySearch(numbers, NUMBERS_SIZE, key)
   
   if (keyIndex == -1) {
      printLine(key + " was not found.")
   }
   else {
      printLine("Found " + key + " at index " + keyIndex + ".")
   }
}

// linear

import java.util.Scanner;

public class LinearSearchDemo {
   private static int linearSearch(int[] numbers, int key) {
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == key) {
            return i;
         }
      }
      return -1; // not found
   }

   // Main program to test the linearSearch() method
   public static void main(String[] args) {
      int[] numbers = { 2, 4, 7, 10, 11, 32, 45, 87 };
      System.out.print("NUMBERS: ");
      for (int i = 0; i < numbers.length; i++) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
      
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter an integer value: ");
      int key = scnr.nextInt();
      int keyIndex = linearSearch(numbers, key);
      
      if (keyIndex == -1) {
         System.out.println(key + " was not found.");
      }
      else {
         System.out.printf("Found %d at index %d.\n", key, keyIndex);
      }
   }
}

// binary search 

import java.util.Scanner;

public class BinarySearchDemo {
   private static int binarySearch(int[] numbers, int key) {
      // Variables to hold the low, middle and high indices
      // of the area being searched. Starts with entire range.
      int low = 0;
      int mid = numbers.length / 2;
      int high = numbers.length - 1;
   
      // Loop until "low" passes "high"
      while (high >= low) {
         // Calculate the middle index
         mid = (high + low) / 2;

         // Cut the range to either the left or right half,
         // unless numbers[mid] is the key
         if (numbers[mid] < key) {
            low = mid + 1;
         }
         else if (numbers[mid] > key) {
            high = mid - 1;
         }
         else {
            return mid;
         }
      }
   
      return -1; // not found
   }

   // Main program to test the binarySearch() method
   public static void main(String[] args) {
      int[] numbers = { 2, 4, 7, 10, 11, 32, 45, 87 };
      System.out.print("NUMBERS: ");
      for (int i = 0; i < numbers.length; i++) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();
      
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter an integer value: ");
      int key = scnr.nextInt();
      int keyIndex = binarySearch(numbers, key);
      
      if (keyIndex == -1) {
         System.out.println(key + " was not found.");
      }
      else {
         System.out.printf("Found %d at index %d.\n", key, keyIndex);
      }
   }
}