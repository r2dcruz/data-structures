SelectionSort(numbers, numbersSize) {
   i = 0
   j = 0
   indexSmallest = 0
   temp = 0  // Temporary variable for swap
   
   for (i = 0; i < numbersSize - 1; ++i) {
      
      // Find index of smallest remaining element
      indexSmallest = i
      for (j = i + 1; j < numbersSize; ++j) {
         
         if ( numbers[j] < numbers[indexSmallest] ) {
            indexSmallest = j
         }
      }
      
      // Swap numbers[i] and numbers[indexSmallest]
      temp = numbers[i]
      numbers[i] = numbers[indexSmallest]
      numbers[indexSmallest] = temp
   }
}

main() {
   numbers[] = { 10, 2, 78, 4, 45, 32, 7, 11 }
   NUMBERS_SIZE = 8
   i = 0
   
   print("UNSORTED: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
   
   SelectionSort(numbers, NUMBERS_SIZE)
   
   print("SORTED: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()   
}


// selection sort algorith

import java.util.Arrays;

public class SelectionSortDemo {
   private static void selectionSort(int[] numbers) {
      for (int i = 0; i < numbers.length - 1; i++) {
         // Find index of smallest remaining element
         int indexSmallest = i;
         for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[j] < numbers[indexSmallest]) {
               indexSmallest = j;
            }
         }
         
         // Swap numbers[i] and numbers[indexSmallest]
         int temp = numbers[i];
         numbers[i] = numbers[indexSmallest];
         numbers[indexSmallest] = temp;
      }
   }

   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the selectionSort method
      selectionSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED: " + Arrays.toString(numbers));
   }
}

// review

SelectionSort(numbers, numbersSize) {
   i = 0
   j = 0
   indexSmallest = 0
   temp = 0  // Temporary variable for swap
   
   for (i = 0; i < numbersSize - 1; ++i) {
      
      // Find index of smallest remaining element
      indexSmallest = i
      for (j = i + 1; j < numbersSize; ++j) {
         
         if ( numbers[j] < numbers[indexSmallest] ) {
            indexSmallest = j
         }
      }
      
      // Swap numbers[i] and numbers[indexSmallest]
      temp = numbers[i]
      numbers[i] = numbers[indexSmallest]
      numbers[indexSmallest] = temp
   }
}

main() {
   numbers[] = { 10, 2, 78, 4, 45, 32, 7, 11 }
   NUMBERS_SIZE = 8
   i = 0
   
   print("UNSORTED: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()
   
   SelectionSort(numbers, NUMBERS_SIZE)
   
   print("SORTED: ")
   for (i = 0; i < NUMBERS_SIZE; ++i) {
      print(numbers[i] + " ")
   }
   printLine()   
}