public class SinglyLinkedListDemoApp {
   public static void main(String[] args) {
      LinkedList numList = new LinkedList();
      Node nodeA = new Node(66);
      Node nodeB = new Node(99);
      Node nodeC = new Node(44);
      Node nodeD = new Node(95);
      Node nodeE = new Node(42);
      Node nodeF = new Node(17);

      numList.append(nodeB);   // Add 99
      numList.append(nodeC);   // Add 44, make the tail
      numList.append(nodeE);   // Add 42, make the tail

      numList.prepend(nodeA);  // Add 66, make the head

      numList.insertAfter(nodeC, nodeD);  // Insert 95 after 44
      numList.insertAfter(nodeE, nodeF);  // Insert 17 after tail (42)

      // Output list
      System.out.print("List after adding nodes: ");
      numList.printList();

      // Remove the tail node, then the head node
      numList.removeAfter(nodeE);
      numList.removeAfter(null);

      // Output final list
      System.out.print("List after removing nodes: ");
      numList.printList();
   }
}

ListInsertAfter(list, curNode, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else if (curNode == list⇢tail) { // Insert after tail
      list⇢tail⇢next = newNode
      list⇢tail = newNode
   }
   else {
      newNode⇢next = curNode⇢next
      curNode⇢next = newNode
   }
}

// review

ListAppend(list, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else{
      list⇢tail⇢next = newNode
      list⇢tail = newNode
   }
}

// prepend

ListPrepend(list, newNode) {
   if (list⇢head == null) { // list empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else {
      newNode⇢next = list⇢head
      list⇢head = newNode
   }
}

// insert

ListInsertAfter(list, curNode, newNode) {
   if (list⇢head == null) { // List empty
      list⇢head = newNode
      list⇢tail = newNode
   }
   else if (curNode == list⇢tail) { // Insert after tail
      list⇢tail⇢next = newNode
      list⇢tail = newNode
   }
   else {
      newNode⇢next = curNode⇢next
      curNode⇢next = newNode
   }


// error

public void removeAfter(Node currentNode) {
   if (currentNode == null && head != null) {
      // Special case: remove head
      Node succeedingNode = head.next;
      head = succeedingNode;
      if (succeedingNode == null) {
          // Last item was removed
          tail = null;
      }
   }
   else if (currentNode.next != null) {
      Node succeedingNode = currentNode.next.next;
      currentNode.next = succeedingNode;
      if (succeedingNode == null) {
         // Remove tail
         tail = currentNode;
      }
   }
}

// review

class Node {
   public int data;
   public Node next;
    
   public Node(int initialData) {
      data = initialData;
      next = null;
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
      tail = newNode;
   }
   else {
      newNode.next = currentNode.next;
      currentNode.next = newNode;
   }
}

public void removeAfter(Node currentNode) {
   if (currentNode == null && head != null) {
      // Special case: remove head
      Node succeedingNode = head.next;
      head = succeedingNode;
      if (succeedingNode == null) {
          // Last item was removed
          tail = null;
      }
   }
   else if (currentNode.next != null) {
      Node succeedingNode = currentNode.next.next;
      currentNode.next = succeedingNode;
      if (succeedingNode == null) {
         // Remove tail
         tail = currentNode;
      }
   }
}

ListInsertionSortDoublyLinked(list) {
   curNode = list⇢head⇢next
   while (curNode != null) {
      nextNode = curNode⇢next
      searchNode = curNode⇢prev
      while (searchNode != null and searchNode⇢data > curNode⇢data) {
         searchNode = searchNode⇢prev
      }
      // Remove and re-insert curNode
      ListRemove(list, curNode)
      if (searchNode == null) {
         curNode⇢prev = null
         ListPrepend(list, curNode)
      }
      else {
         ListInsertAfter(list, searchNode, curNode)
      }
      // Advance to next node
      curNode = nextNode
   }
}

// Sorting a singly-linked list with insertion sort.



ListInsertionSortSinglyLinked(list) {
   beforeCurrent = list⇢head
   curNode = list⇢head⇢next
   while (curNode != null) {
      next = curNode⇢next
      position = ListFindInsertionPosition(list, curNode⇢data)

      if (position == beforeCurrent)
         beforeCurrent = curNode
      else {
         ListRemoveAfter(list, beforeCurrent)
         if (position == null)
            ListPrepend(list, curNode)
         else
            ListInsertAfter(list, position, curNode)
      }

      curNode = next
   }
}

// insertion algorithm

ListFindInsertionPosition(list, dataValue) {
   curNodeA = null
   curNodeB = list⇢head
   while (curNodeB != null and dataValue > curNodeB⇢data) {
      curNodeA = curNodeB
      curNodeB = curNodeB⇢next
   }
   return curNodeA
}

// public void insertionSortDoublyLinked() {
   Node currentNode = m_head.next;
   while (currentNode != null) {
      Node nextNode = currentNode.next;
      Node searchNode = currentNode.previous;
         
      while (searchNode != null && searchNode.data > currentNode.data)
         searchNode = searchNode.previous;
      
      // Remove and re-insert currentNode
      remove(currentNode);
      if (searchNode == null) {
         currentNode.previous = null;
         prepend(currentNode);
      }
      else {
         insertAfter(searchNode, currentNode);
      }

      // Advance to next node
      currentNode = nextNode;
   }
}

public void insertionSortDoublyLinked() {
   Node currentNode = m_head.next;
   while (currentNode != null) {
      Node nextNode = currentNode.next;
      Node searchNode = currentNode.previous;
         
      while (searchNode != null && searchNode.data > currentNode.data)
         searchNode = searchNode.previous;
      
      // Remove and re-insert currentNode
      remove(currentNode);
      if (searchNode == null) {
         currentNode.previous = null;
         prepend(currentNode);
      }
      else {
         insertAfter(searchNode, currentNode);
      }

      // Advance to next node
      currentNode = nextNode;
   }
}

// Insertion sort algorithm for singly-linked lists

public void insertionSortSinglyLinked() {
   Node beforeCurrent = m_head;
   Node currentNode = m_head.next;
   while (currentNode != null) {
      Node nextNode = currentNode.next;
      Node position = findInsertionPosition(currentNode.data);
      if (position == beforeCurrent)
         beforeCurrent = currentNode;
      else {
         removeAfter(beforeCurrent);
         if (position == null)
            prepend(currentNode);
         else
            insertAfter(position, currentNode);
      }
      currentNode = nextNode;
   }
}

public Node findInsertionPosition(int dataValue) {
   Node positionA = null;
   Node positionB = m_head;
   while (positionB != null && dataValue > positionB.data) {
      positionA = positionB;
      positionB = positionB.next;
   }
   return positionA;
}

//

ListAppend(list, newNode) {
   list⇢tail⇢next = newNode
   list⇢tail = newNode
}


ListPrepend(list, newNode) {
   newNode⇢next = list⇢head⇢next
   list⇢head⇢next = newNode
   if (list⇢head == list⇢tail) { // empty list
      list⇢tail = newNode;
   }
}


ListInsertAfter(list, curNode, newNode) {
   if (curNode == list⇢tail) { // Insert after tail
      list⇢tail⇢next = newNode
      list⇢tail = newNode
   }
   else { 
      newNode⇢next = curNode⇢next
      curNode⇢next = newNode
   }
}


ListRemoveAfter(list, curNode) {
   if (curNode is not null and curNode⇢next is not null) {
      sucNode = curNode⇢next⇢next
      curNode⇢next = sucNode
     
      if (sucNode is null) {
         // Removed tail
         list⇢tail = curNode
      }
   }
}

// Doubly-linked list with dummy node: append, prepend, insert after, and remove operations.

ListAppend(list, newNode) {
   list⇢tail⇢next = newNode
   newNode⇢prev = list⇢tail
   list⇢tail = newNode
}


ListPrepend(list, newNode) {
   firstNode = list⇢head⇢next

   // Set the next and prev pointers for newNode
   newNode⇢next = list⇢head⇢next
   newNode⇢prev = list⇢head

   // Set the dummy node's next pointer
   list⇢head⇢next = newNode

   // Set prev on former first node
   if (firstNode is not null) {
      firstNode⇢prev = newNode
   }
}


ListInsertAfter(list, curNode, newNode) {
   if (curNode == list⇢tail) { // Insert after tail
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


ListRemove(list, curNode) {
   if (curNode == list⇢head) {
      // Dummy node cannot be removed
      return
   }

   sucNode = curNode⇢next 
   predNode = curNode⇢prev 
  
   if (sucNode is not null) {
      sucNode⇢prev = predNode   
   }
  
   // Predecessor node is always non-null
   predNode⇢next = sucNode
  
   if (curNode == list⇢tail) { // Removed tail
      list⇢tail = predNode
   }
}

//

ListAppend(list, newNode) {
   newNode⇢prev = list⇢tail⇢prev
   newNode⇢next = list⇢tail
   list⇢tail⇢prev⇢next = newNode
   list⇢tail⇢prev = newNode
}

ListPrepend(list, newNode) {
   firstNode = list⇢head⇢next
   newNode⇢next = list⇢head⇢next
   newNode⇢prev = list⇢head
   list⇢head⇢next = newNode
   firstNode⇢prev = newNode
}

// part 2

ListInsertAfter(list, curNode, newNode) {
   if (curNode == list⇢tail) {
      // Can't insert after dummy tail
      return
   }
   
   sucNode = curNode⇢next
   newNode⇢next = sucNode
   newNode⇢prev = curNode
   curNode⇢next = newNode
   sucNode⇢prev = newNode
}

ListRemove(list, curNode) {
   if (curNode == list⇢head || curNode == list⇢tail) {
      // Dummy nodes cannot be removed
      return
   }

   sucNode = curNode⇢next 
   predNode = curNode⇢prev 
  
   // Successor node is never null
   sucNode⇢prev = predNode
  
   // Predecessor node is never null
   predNode⇢next = sucNode
}

// recursion

ListTraverse(list) {
   ListTraverseRecursive(list⇢head)
}

ListTraverseRecursive(node) {
   if (node is not null) {
      Visit node
      ListTraverseRecursive(node⇢next)
   }
}

//

ListSearch(list, key) {
   return ListSearchRecursive(key, list⇢head)
}

ListSearchRecursive(key, node) {
   if (node is not null) {
      if (node⇢data == key) {
         return node
      }
      return ListSearchRecursive(key, node⇢next)
   }
   return null
}

// traverse

ListTraverseReverse(list) {
   ListTraverseReverseRecursive(list⇢head)
}

ListTraverseReverseRecursive(node) {
   if (node is not null) {
      ListTraverseReverseRecursive(node⇢next)
      Visit node
   }
}

// stack linkedlist


StackPush(stack, item) {
   newNode = Allocate new linked list node
   newNode⇢next = null
   newNode⇢data = item

   // Insert as list head (top of stack)
   ListPrepend(stack, newNode)
}

StackPop(stack) {
   headData = stack⇢head⇢data
   ListRemoveAfter(stack, null)
   return headData
} 

// queue linkedlist

// QueueEnqueue(queue, item) {
   newNode = Allocate new linked list node
   newNode⇢next = null
   newNode⇢data = item

   // Insert node as list tail (end of queue)
   ListAppend(queue, newNode)
}

QueueDequeue(queue) {
   headData = queue⇢head⇢data
   ListRemoveAfter(queue, null)
   return headData
}

// stack linkedlist

class Stack {
   private LinkedList linkedList;
    
   Stack() {
      linkedList = new LinkedList();
   }
   
   public void push(int newData) {
      // Create a new node and prepend
      Node newNode = new Node(newData);
      linkedList.prepend(newNode);
   }
   
   public int pop() {
      // Copy list head's data
      int poppedItem = linkedList.getHeadData();
      
      // Remove list head
      linkedList.removeAfter(null);
      
      // Return popped item
      return poppedItem;
   }
   
   public void print() {
      linkedList.printList();
   }
}

public class StackDemo {
   public static void main(String[] args) {
      int[] numbers = { 91, 66, 9, 46, 23, 65, 6, 77 };
      
      // Initialize a new Stack and add numbers
      Stack numStack = new Stack();
      for (int number : numbers) {
          numStack.push(number);
      }

      // Output stack
      System.out.print("Stack after push: ");
      numStack.print();
      
      // Pop 77 and print
      numStack.pop();
      System.out.print("Stack after first pop: ");
      numStack.print();
      
      // Pop 6 and print
      numStack.pop();
      System.out.print("Stack after second pop: ");
      numStack.print();
   }
}

// queue implementation

class Queue {
   private LinkedList linkedList;
    
   Queue() {
      linkedList = new LinkedList();
   }
   
   public void enqueue(int newData) {
      // Create a new node
      Node newNode = new Node(newData);
       
      // Insert as list tail (end of queue)
      linkedList.append(newNode);
   }
   
   public int dequeue() {
      // Copy list head's data
      int dequeuedItem = linkedList.getHeadData();
      
      // Remove list head
      linkedList.removeAfter(null);
      
      // Return dequeued item
      return dequeuedItem;
   }
   
   public void print() {
      linkedList.printList();
   }
}

public class QueueDemo {
   public static void main(String[] args) {
      int[] numbers = { 83, 4, 57, 6, 92, 49, 64, 5 };
      
      // Initialize a new Queue and add numbers
      Queue numQueue = new Queue();
      for (int number : numbers) {
          numQueue.enqueue(number);
      }

      // Output queue
      System.out.print("Queue after initial enqueues: ");
      numQueue.print();
      
      // Dequeue 83 and print
      numQueue.dequeue();
      System.out.print("Queue after first dequeue:    ");
      numQueue.print();
      
      // Enqueue 99 and print
      numQueue.enqueue(99);
      System.out.print("Queue after enqueueing 99:    ");
      numQueue.print();
      
      // Dequeue 4 and print
      numQueue.dequeue();
      System.out.print("Queue after second dequeue:   ");
      numQueue.print();
   }
}

// doubting zybooks...

class Queue {
   private LinkedList linkedList;
    
   Queue() {
      linkedList = new LinkedList();
   }
   
   public void enqueue(int newData) {
      // Create a new node
      Node newNode = new Node(newData);
       
      // Insert as list tail (end of queue)
      linkedList.append(newNode);
   }
   
   public int dequeue() {
      // Copy list head's data
      int dequeuedItem = linkedList.getHeadData();
      
      // Remove list head
      linkedList.removeAfter(null);
      
      // Return dequeued item
      return dequeuedItem;
   }
   
   public void print() {
      linkedList.printList();
   }
}

public class QueueDemo {
   public static void main(String[] args) {
      int[] numbers = { 83, 4, 57, 6, 92, 49, 64, 5 };
      
      // Initialize a new Queue and add numbers
      Queue numQueue = new Queue();
      for (int number : numbers) {
          numQueue.enqueue(number);
      }

      // Output queue
      System.out.print("Queue after initial enqueues: ");
      numQueue.print();
      
      // Dequeue 83 and print
      numQueue.dequeue();
      System.out.print("Queue after first dequeue:    ");
      numQueue.print();
      
      // Enqueue 99 and print
      numQueue.enqueue(99);
      System.out.print("Queue after enqueueing 99:    ");
      numQueue.print();
      
      // Dequeue 4 and print
      numQueue.dequeue();
      System.out.print("Queue after second dequeue:   ");
      numQueue.print();
   }
}

// array base


ArrayListAppend(list, newItem) {
   if (list⇢allocationSize == list⇢length) {
      ArrayListResize(list, list⇢length * 2)
   }
   list⇢array[list⇢length] = newItem
   list⇢length = list⇢length + 1
}

ArrayListResize(list, newAllocationSize) {
   newArray = new array of size newAllocationSize
   Copy all elements from list⇢array to newArray
   list⇢array = newArray
   list⇢allocationSize = newAllocationSize
}

// prepend


ArrayListPrepend(list, newItem) {
   if (list⇢allocationSize == list⇢length) {
      ArrayListResize(list, list⇢length * 2)
   }
   for (i = list⇢length; i > 0; i--) {
      list⇢array[i] = list⇢array[i - 1]
   }
   list⇢array[0] = newItem
   list⇢length = list⇢length + 1
}

ArrayListInsertAfter(list, index, newItem) {
   if (list⇢allocationSize == list⇢length) {
      ArrayListResize(list, list⇢length * 2)
   }
   for (i = list⇢length; i > index + 1; i--) {
      list⇢array[i] = list⇢array[i - 1]
   }
   list⇢array[index + 1] = newItem
   list⇢length = list⇢length + 1
}

// array search


ArrayListSearch(list, item) {
   for (i = 0; i < list⇢length; i++) {
      if (list⇢array[i] == item) {
         return i
      }
   }
   return -1 // not found
}
 
ArrayListRemoveAt(list, index) {
   if (index >= 0 && index < list⇢length) {
      for (i = index; i < list⇢length - 1; i++) {
         list⇢array[i] = list⇢array[i + 1]
      }
      list⇢length = list⇢length - 1
   }
}  

// arraylist

class ArrayList {
   // Private members
   private int[] arrayData;
   private int arrayListLength;

   // The default constructor initializes the list with a capacity of 4
   public ArrayList() {
      this(4);
   }
   
   public ArrayList(int capacity) {
      this.arrayData = new int[capacity];
      this.arrayListLength = 0;
   }
}

// . 

public void append(int newItem) {
   // Resize if the array is full
   if (arrayData.length == arrayListLength) {
      resize(arrayListLength * 2);
   }

   // Insert the new item at index arrayListLength
   arrayData[arrayListLength] = newItem;

   // Increment the array's length
   ++arrayListLength;
}
   
public void resize(int newAllocationSize) {
   // Create a new array with the indicated size
   int[] newArray = new int[newAllocationSize];

   // Copy items in current array into the new array
   for (int i = 0; i < arrayListLength; ++i) {
      newArray[i] = arrayData[i];
   }

   // Assign the arrayData member with the new array
   arrayData = newArray;
}