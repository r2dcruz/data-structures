import java.util.Arrays;

public class InsertionSortDemo {
   private static void insertionSort(int[] numbers) {
      for (int i = 1; i < numbers.length; i++) {
         int j = i;
         while (j > 0 && numbers[j] < numbers[j - 1]) {
            // Swap numbers[j] and numbers [j - 1]
            int temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            j--;
         }
      }
   }

   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the insertionSort method
      insertionSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED: " + Arrays.toString(numbers));
   }
}

// review

InsertionSort(numbers, numbersSize) {
   i = 0
   j = 0
   temp = 0  // Temporary variable for swap
   
   for (i = 1; i < numbersSize; ++i) {
      j = i
      // Insert numbers[i] into sorted part
      // stopping once numbers[i] in correct position
      while (j > 0 && numbers[j] < numbers[j - 1]) {
         
         // Swap numbers[j] and numbers[j - 1]
         temp = numbers[j]
         numbers[j] = numbers[j - 1]
         numbers[j - 1] = temp
         --j
      }
   }
}

main() {
   numbers = { 10, 2, 78, 4, 45, 32, 7, 11 }
   NUMBERS_SIZE = 8
   i = 0
   
   print("UNSORTED: ")
   for(i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
   
   InsertionSort(numbers, NUMBERS_SIZE)
   
   print("SORTED: ")
   for(i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
}

// algorithm

import java.util.Arrays;

public class InsertionSortDemo {
   private static void insertionSort(int[] numbers) {
      for (int i = 1; i < numbers.length; i++) {
         int j = i;
         while (j > 0 && numbers[j] < numbers[j - 1]) {
            // Swap numbers[j] and numbers [j - 1]
            int temp = numbers[j];
            numbers[j] = numbers[j - 1];
            numbers[j - 1] = temp;
            j--;
         }
      }
   }

   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the insertionSort method
      insertionSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED: " + Arrays.toString(numbers));
   }
}

// java built in sort, putting in here for now


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class JavaBuiltInSorting {
   public static void main(String[] args) {
      int[] numbers = { 3, 7, 2, 8, 12, 4, 9, 5 };
      System.out.println("Unsorted array: " + Arrays.toString(numbers));
      Arrays.sort(numbers);
      System.out.println("Sorted array:   " + Arrays.toString(numbers));
      
      ArrayList<String> fruitList = new ArrayList<String>();
      Collections.addAll(fruitList, "grape", "banana", "apple", "strawberry", "blueberry");
      System.out.println("Unsorted list:  " + fruitList.toString());
      Collections.sort(fruitList);
      System.out.println("Sorted list:    " + fruitList.toString());
   }
}