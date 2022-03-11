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
