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
