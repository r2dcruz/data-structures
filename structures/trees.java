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