// Recursive BST insertion and removal

BSTInsert(tree, node) {
    if (tree⇢root is null)
       tree⇢root = node
    else
       BSTInsertRecursive(tree⇢root, node)
 }
 
 BSTInsertRecursive(parent, nodeToInsert) {
    if (nodeToInsert⇢key < parent⇢key) {
       if (parent⇢left is null)
          parent⇢left = nodeToInsert
       else
          BSTInsertRecursive(parent⇢left, nodeToInsert)
    }
    else {
       if (parent⇢right is null)
          parent⇢right = nodeToInsert
       else
          BSTInsertRecursive(parent⇢right, nodeToInsert)
    }
 }
 
 BSTRemove(tree, key) {
    node = BSTSearch(tree, key)
    parent = BSTGetParent(tree, node)
    BSTRemoveNode(tree, parent, node)
 }
 
 BSTRemoveNode(tree, parent, node) {
    if (node == null)
       return false
         
    // Case 1: Internal node with 2 children
    if (node⇢left != null && node⇢right != null) {
       // Find successor and successor's parent
       succNode = node⇢right
       successorParent = node
       while (succNode⇢left != null) {
          successorParent = succNode
          succNode = succNode⇢left
       }
             
       // Copy the value from the successor node
       node = Copy succNode
             
       // Recursively remove successor
       BSTRemoveNode(tree, successorParent, succNode)
    }
 
    // Case 2: Root node (with 1 or 0 children)
    else if (node == tree⇢root) {
       if (node⇢left != null)
          tree⇢root = node⇢left
       else
          tree⇢root = node⇢right
    }
 
    // Case 3: Internal with left child only
    else if (node⇢left != null) {
       // Replace node with node's left child
       if (parent⇢left == node)
          parent⇢left = node⇢left
       else
          parent⇢right = node⇢left
    }
 
    // Case 4: Internal with right child only OR leaf
    else {
       // Replace node with node's right child
       if (parent⇢left == node)
          parent⇢left = node⇢right
       else
          parent⇢right = node⇢right
    }        
 
    return true
 }

 // insert


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

// here

if (currentNode⇢key == desiredKey) { 
   return currentNode; // The desired node was found
}
else if (desiredKey < currentNode⇢key) {
   // Visit left child, repeat
}
else if (desiredKey > currentNode⇢key) {
   // Visit right child, repeat
}

// bst search


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

// search


BTreeSearch(node, key) {
   if (node is not null) {
      if (key == node⇢A ||
          key == node⇢B ||
          key == node⇢C) {
         return node
      }
      if (key < node⇢A) {
         return BTreeSearch(node⇢left, key)
      }
      else if (node⇢B is null || key < node⇢B) {
         return BTreeSearch(node⇢middle1, key)
      }
      else if (node⇢C is null || key < node⇢C) {
         return BTreeSearch(node⇢middle2, key)
      }
      else {
         return BTreeSearch(node⇢right, key)
      }
   }
   return null
}

// trees

BTreeSplit(tree, node, nodeParent) {
   if (node is not full) {
      return null
   }

   splitLeft = new BTreeNode(node⇢A, node⇢left, node⇢middle1)
   splitRight = new BTreeNode(node⇢C, node⇢middle2, node⇢right)
   if (nodeParent is not null) {
      BTreeInsertKeyWithChildren(nodeParent, node⇢B, splitLeft, splitRight)
   }
   else {
      nodeParent = new BTreeNode(node⇢B, splitLeft, splitRight)
      tree⇢root = nodeParent
   }
   return nodeParent
}

//

BTreeInsertKeyWithChildren(parent, key, leftChild, rightChild) {
   if (key < parent⇢A) {
      parent⇢C = parent⇢B
      parent⇢B = parent⇢A
      parent⇢A = key
      parent⇢right = parent⇢middle2
      parent⇢middle2 = parent⇢middle1
      parent⇢middle1 = rightChild
      parent⇢left = leftChild
   }
   else if (parent⇢B is null || key < parent⇢B) {
      parent⇢C = parent⇢B
      parent⇢B = key
      parent⇢right = parent⇢middle2
      parent⇢middle2 = rightChild
      parent⇢middle1 = leftChild
   }
   else {
      parent⇢C = key
      parent⇢right = rightChild
      parent⇢middle2 = leftChild
   }
}

// practice

BTreeSplit(tree, node, nodeParent) {
   if (node is not full) {
      return null
   }

   splitLeft = new BTreeNode(node⇢A, node⇢left, node⇢middle1)
   splitRight = new BTreeNode(node⇢C, node⇢middle2, node⇢right)
   if (nodeParent is not null) {
      BTreeInsertKeyWithChildren(nodeParent, node⇢B, splitLeft, splitRight)
   }
   else {
      nodeParent = new BTreeNode(node⇢B, splitLeft, splitRight)
      tree⇢root = nodeParent
   }
   return nodeParent
}

// insert


BTreeInsert(node, key) {
   if (key is in node) {
      return null // duplicates not allowed
   }
   if (node is full) {
      node = BTreeSplit(tree, node, nodeParent)
   }
   if (node is not leaf) {
      if (key < node⇢A)
         return BTreeInsert(node⇢left, key)
      else if (node⇢B is null || key < node⇢B)
         return BTreeInsert(node⇢middle1, key)
      else if (node⇢C is null || key < node⇢C)
         return BTreeInsert(node⇢middle2, key)
      else
         return BTreeInsert(node⇢right, key)
   }
   else {
      BTreeInsertIntoLeaf(node, key)
      return node
   }
}

// run it


BTreeRemoveKey(node, keyIndex) {
   if (keyIndex == 0) {
      node⇢A = node⇢B
      node⇢B = node⇢C
      node⇢C = null
      node⇢left = node⇢middle1
      node⇢middle1 = node⇢middle2
      node⇢middle2 = node⇢right
      node⇢right = null
   }
   else if (keyIndex == 1) {
      node⇢B = node⇢C
      node⇢C = null
      node⇢middle2 = node⇢right
      node⇢right = null
   }
   else if (keyIndex == 2) {
      node⇢C = null
      node⇢right = null
   }
}

// tree review

BTreeRotateLeft(node) {
   leftSibling = BTreeGetLeftSibling(node)
   keyForLeftSibling = BTreeGetParentKeyLeftOfChild(node⇢parent, node)
   BTreeAddKeyAndChild(leftSibling, keyForLeftSibling, node⇢left)
   BTreeSetParentKeyLeftOfChild(node⇢parent, node, node⇢A)     
   BTreeRemoveKey(node, 0)
}

// go back to reviewing trees

if (currentNode⇢key == desiredKey) { 
   return currentNode; // The desired node was found
}
else if (desiredKey < currentNode⇢key) {
   // Visit left child, repeat
}
else if (desiredKey > currentNode⇢key) {
   // Visit right child, repeat
}

// ano

if (currentNode⇢key == desiredKey) { 
   return currentNode; // The desired node was found
}
else if (desiredKey < currentNode⇢key) {
   // Visit left child, repeat
}
else if (desiredKey > currentNode⇢key) {
   // Visit right child, repeat
}

// csc130

public class AVLTree {
   private Node root;
   
   private class Node {
       int data;
       Node left;
       Node right;
       int height;
       
       Node(int data) {
           this.data = data;
           this.height = 1;
       }
   }
   
   private int height(Node node) {
       if (node == null) {
           return 0;
       }
       return node.height;
   }
   
   private int balanceFactor(Node node) {
       if (node == null) {
           return 0;
       }
       return height(node.left) - height(node.right);
   }
   
   private Node rotateLeft(Node node) {
       Node newRoot = node.right;
       node.right = newRoot.left;
       newRoot.left = node;
       node.height = Math.max(height(node.left), height(node.right)) + 1;
       newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
       return newRoot;
   }
   
   private Node rotateRight(Node node) {
       Node newRoot = node.left;
       node.left = newRoot.right;
       newRoot.right = node;
       node.height = Math.max(height(node.left), height(node.right)) + 1;
       newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
       return newRoot;
   }
   
   public void insert(int data) {
       root = insert(root, data);
   }
   
   private Node insert(Node node, int data) {
       if (node == null) {
           return new Node(data);
       }
       if (data < node.data) {
           node.left = insert(node.left, data);
       } else if (data > node.data) {
           node.right = insert(node.right, data);
       } else {
           return node;
       }
       node.height = Math.max(height(node.left), height(node.right)) + 1;
       int balanceFactor = balanceFactor(node);
       if (balanceFactor > 1 && data < node.left.data) {
           return rotateRight(node);
       }
       if (balanceFactor < -1 && data > node.right.data) {
           return rotateLeft(node);
       }
       if (balanceFactor > 1 && data > node.left.data) {
           node.left = rotateLeft(node.left);
           return rotateRight(node);
       }
       if (balanceFactor < -1 && data < node.right.data) {
           node.right = rotateRight(node.right);
           return rotateLeft(node);
       }
       return node;
   }
   
   public void inorderTraversal() {
       inorderTraversal(root);
   }
   
   private void inorderTraversal(Node node) {
       if (node != null) {
           inorderTraversal(node.left);
           System.out.print(node.data + " ");
           inorderTraversal(node.right);
       }
   }
}

public int minHeight() {
   return minHeight(root);
}

private int minHeight(Node node) {
   if (node == null) {
       return 0;
   }
   return 1 + Math.min(minHeight(node.left), minHeight(node.right));
}

public int maxHeight() {
   return maxHeight(root);
}

private int maxHeight(Node node) {
   if (node == null) {
       return 0;
   }
   return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
}
