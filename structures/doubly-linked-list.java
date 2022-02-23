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

