class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

class LinkedList {
   private Node head;
   private Node tail;
    
   public LinkedList() {
      head = null;
      tail = null;
   }
}

public void append(Node newNode) {
   if (head == null) {
      head = newNode;
      tail = newNode;
   }
   else {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
   }
}

public void prepend(Node newNode) {
   if (head == null) {
      head = newNode;
      tail = newNode;
   }
   else {
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
   }
}

public void insertAfter(Node currentNode, Node newNode) {
   if (head == null) {
      head = newNode;
      tail = newNode;
   }
   else if (currentNode == tail) {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
   }
   else {
      Node successor = currentNode.next;
      newNode.next = successor;
      newNode.previous = currentNode;
      currentNode.next = newNode;
      successor.previous = newNode;
   }
}

public void remove(Node currentNode) {
   Node successor = currentNode.next;
   Node predecessor = currentNode.previous;
      
   if (successor != null)
      successor.previous = predecessor;
         
   if (predecessor != null)
      predecessor.next = successor;
         
   if (currentNode == head)
      head = successor;
         
   if (currentNode == tail)
      tail = predecessor;
}

public class DoublyLinkedListDemoApp {
   public static void main(String[] args) {
      LinkedList numList = new LinkedList();
      Node nodeA = new Node(14);
      Node nodeB = new Node(2);
      Node nodeC = new Node(20);
      Node nodeD = new Node(31);
      Node nodeE = new Node(16);
      Node nodeF = new Node(55);

      numList.append(nodeA);   // Add 14
      numList.append(nodeB);   // Add 2, make the tail
      numList.append(nodeC);   // Add 20, make the tail

      numList.prepend(nodeD);  // Add 31, make the head

      numList.insertAfter(nodeB, nodeE);  // Insert 16 after 2
      numList.insertAfter(nodeC, nodeF);  // Insert 55 after tail, 55 becomes new tail

      // Output list
      System.out.print("List after adding nodes: ");
      numList.printList();

      // Remove the tail node, then the head node
      numList.remove(nodeF);
      numList.remove(nodeD);

      // Output final list
      System.out.print("List after removing nodes: ");
      numList.printList();
   }
}

// review


ListAppend(list, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else {
      list⇢tail⇢next = newNode
      newNode⇢prev = list⇢tail
      list⇢tail = newNode
   }
}

// searching through a linkedlist

ListSearch(list, key) {
   curNode = list⇢head
   while (curNode is not null) {
      if (curNode⇢data == key) {
         return curNode
      }
      curNode = curNode⇢next
   }
   return null
}

// real commit review

ListAppend(list, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else {
      list⇢tail⇢next = newNode
      newNode⇢prev = list⇢tail
      list⇢tail = newNode
   }
}

ListPrepend(list, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else {
      newNode⇢next = list⇢head
      list⇢head⇢prev = newNode
      list⇢head = newNode
   }
}

// insert review

ListInsertAfter(list, curNode, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else if (curNode == list⇢tail) { // Insert after tail
      list⇢tail⇢next = newNode
      newNode⇢prev = list⇢tail
      list⇢tail = newNode
   }
   else {
      sucNode = curNode⇢next
      newNode⇢next = sucNode
      newNode⇢prev = curNode
      curNode⇢next = newNode
      sucNode⇢prev = newNode
   }
}

// remove

ListRemove(list, curNode) {
   sucNode = curNode⇢next
   predNode = curNode⇢prev

   if (sucNode is not null) {
      sucNode⇢prev = predNode
   }

   if (predNode is not null) {
      predNode⇢next = sucNode
   }

   if (curNode == list⇢head) { // Removed head
      list⇢head = sucNode
   }

   if (curNode == list⇢tail) { // Removed tail
      list⇢tail = predNode
  

      // that doubly

      class Node {
         public int data;
         public Node next;
         public Node previous;
      
         public Node(int initialData) {
            data = initialData;
            next = null;
            previous = null;
         }
      }

      class LinkedList {
         private Node head;
         private Node tail;
          
         public LinkedList() {
            head = null;
            tail = null;
         }
      }

      public void append(Node newNode) {
         if (head == null) {
            head = newNode;
            tail = newNode;
         }
         else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
         }
      }

      public void prepend(Node newNode) {
         if (head == null) {
            head = newNode;
            tail = newNode;
         }
         else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
         }
      }

      public void insertAfter(Node currentNode, Node newNode) {
         if (head == null) {
            head = newNode;
            tail = newNode;
         }
         else if (currentNode == tail) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
         }
         else {
            Node successor = currentNode.next;
            newNode.next = successor;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            successor.previous = newNode;
         }
      }

      public void remove(Node currentNode) {
         Node successor = currentNode.next;
         Node predecessor = currentNode.previous;
            
         if (successor != null)
            successor.previous = predecessor;
               
         if (predecessor != null)
            predecessor.next = successor;
               
         if (currentNode == head)
            head = successor;
               
         if (currentNode == tail)
            tail = predecessor;
      }

// linkedlist traversals

ListTraverse(list) {
   curNode = list⇢head // Start at head

   while (curNode is not null) { 
      Print curNode's data        
      curNode = curNode⇢next
   }
}

// reverse traversal algorithm

ListTraverseReverse(list) {
   curNode = list⇢tail // Start at tail

   while (curNode is not null) { 
      Print curNode's data        
      curNode = curNode⇢prev
   }
}

// leetcode

class Solution {
   public:
       ListNode* reverseList(ListNode* head) {
           if (head == NULL || head->next == NULL) {
               return head;
           }
           
           ListNode* prev = NULL;
           ListNode* curr = head;
           ListNode* next = curr->next;
           
           while (curr != NULL) {
               next = curr->next;
               curr->next = prev;
               prev = curr;
               curr = next;
           }
           
           return prev;
       }
   };