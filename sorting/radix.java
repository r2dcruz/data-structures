import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortDemo {
   // Returns the maximum length, in number of digits, out of all array elements
   private static int radixGetMaxLength(int[] numbers) {
      int maxDigits = 0;
      for (int i = 0; i < numbers.length; i++) {
         int digitCount = radixGetLength(numbers[i]);
         if (digitCount > maxDigits) {
             maxDigits = digitCount;
         }
      }
      return maxDigits;
   }
   
   private static int radixGetLength(int value) {
      if (value == 0) {
         return 1;
      }
      
      int digits = 0;
      while (value != 0) {
         digits++;
         value /= 10;
      }
      return digits;
   }
   
   private static void radixSort(int[] numbers) {
      ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < 10; i++) {
         buckets.add(new ArrayList<Integer>());
      }
      
      int copyBackIndex = 0;
      
      // Find the max length, in number of digits
      int maxDigits = radixGetMaxLength(numbers);
      
      int pow10 = 1;
      for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
         for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int bucketIndex = (Math.abs(num) / pow10) % 10;
            buckets.get(bucketIndex).add(num);
         }
         
         // Copy buckets back into numbers array
         copyBackIndex = 0;
         for (int i = 0; i < 10; i++) {
            ArrayList<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
               numbers[copyBackIndex] = bucket.get(j);
               copyBackIndex++;
            }
            bucket.clear();
         }
         
         pow10 *= 10;
      }
      
      ArrayList<Integer> negatives = new ArrayList<Integer>();
      ArrayList<Integer> nonNegatives = new ArrayList<Integer>();
      for (int num : numbers) {
         if (num < 0) {
            negatives.add(num);
         }
         else {
            nonNegatives.add(num);
         }
      }
      
      // Copy sorted content to array - negatives in reverse, then non-negatives
      copyBackIndex = 0;
      for (int i = negatives.size() - 1; i >= 0; i--) {
         numbers[copyBackIndex] = negatives.get(i);
         copyBackIndex++;
      }
      for (int i = 0; i < nonNegatives.size(); i++) {
         numbers[copyBackIndex] = nonNegatives.get(i);
         copyBackIndex++;
      }
   }
    
   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = { -9, 47, 81, 101, -5, 38, -99, 96, 51, -999, -11, 64 };
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the radixSort method
      radixSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED:   " + Arrays.toString(numbers));
   }
}

// non-negative integers


RadixSort(array, arraySize) {
   buckets = create array of 10 buckets

   // Find the max length, in number of digits
   maxDigits = RadixGetMaxLength(array, arraySize)
      
   // Start with the least significant digit
   pow10 = 1
   for (digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
      for (i = 0; i < arraySize; i++) {
         bucketIndex = abs(array[i] / pow10) % 10
         Append array[i] to buckets[bucketIndex]
      }
      arrayIndex = 0
      for (i = 0; i < 10; i++) {
         for (j = 0; j < buckets[i]⇢size(); j++)
            array[arrayIndex++] = buckets[i][j]
      }
      pow10 = 10 * pow10
      Clear all buckets
   }
}

// Returns the maximum length, in number of digits, out of all elements in the array
RadixGetMaxLength(array, arraySize) {
   maxDigits = 0
   for (i = 0; i < arraySize; i++) {
      digitCount = RadixGetLength(array[i])
      if (digitCount > maxDigits)
         maxDigits = digitCount
   }
   return maxDigits
}

// Returns the length, in number of digits, of value
RadixGetLength(value) {
   if (value == 0)
      return 1

   digits = 0
   while (value != 0) {
      digits = digits + 1
      value = value / 10
   }
   return digits
}

// radix sort algorithm

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortDemo {
   // Returns the maximum length, in number of digits, out of all array elements
   private static int radixGetMaxLength(int[] numbers) {
      int maxDigits = 0;
      for (int i = 0; i < numbers.length; i++) {
         int digitCount = radixGetLength(numbers[i]);
         if (digitCount > maxDigits) {
             maxDigits = digitCount;
         }
      }
      return maxDigits;
   }
   
   private static int radixGetLength(int value) {
      if (value == 0) {
         return 1;
      }
      
      int digits = 0;
      while (value != 0) {
         digits++;
         value /= 10;
      }
      return digits;
   }
   
   private static void radixSort(int[] numbers) {
      ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < 10; i++) {
         buckets.add(new ArrayList<Integer>());
      }
      
      int copyBackIndex = 0;
      
      // Find the max length, in number of digits
      int maxDigits = radixGetMaxLength(numbers);
      
      int pow10 = 1;
      for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
         for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int bucketIndex = (Math.abs(num) / pow10) % 10;
            buckets.get(bucketIndex).add(num);
         }
         
         // Copy buckets back into numbers array
         copyBackIndex = 0;
         for (int i = 0; i < 10; i++) {
            ArrayList<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
               numbers[copyBackIndex] = bucket.get(j);
               copyBackIndex++;
            }
            bucket.clear();
         }
         
         pow10 *= 10;
      }
      
      ArrayList<Integer> negatives = new ArrayList<Integer>();
      ArrayList<Integer> nonNegatives = new ArrayList<Integer>();
      for (int num : numbers) {
         if (num < 0) {
            negatives.add(num);
         }
         else {
            nonNegatives.add(num);
         }
      }
      
      // Copy sorted content to array - negatives in reverse, then non-negatives
      copyBackIndex = 0;
      for (int i = negatives.size() - 1; i >= 0; i--) {
         numbers[copyBackIndex] = negatives.get(i);
         copyBackIndex++;
      }
      for (int i = 0; i < nonNegatives.size(); i++) {
         numbers[copyBackIndex] = nonNegatives.get(i);
         copyBackIndex++;
      }
   }
    
   public static void main(String[] args) {
      // Create an array of numbers to sort
      int[] numbers = { -9, 47, 81, 101, -5, 38, -99, 96, 51, -999, -11, 64 };
      
      // Display the contents of the array
      System.out.println("UNSORTED: " + Arrays.toString(numbers));
      
      // Call the radixSort method
      radixSort(numbers);
      
      // Display the sorted contents of the array
      System.out.println("SORTED:   " + Arrays.toString(numbers));
   }
}