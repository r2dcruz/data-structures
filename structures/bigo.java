public class bigo {
    
}


// o(1), constant

FindMin(x, y) {
    if (x < y) {
       return x
    }
    else {
       return y
    }
 }

 // o(log n)

 BinarySearch(numbers, N, key) {
    mid = 0
    low = 0
    high = N - 1
    
    while (high >= low) {
       mid = (high + low) / 2
       if (numbers[mid] < key) {
          low = mid + 1
       }
       else if (numbers[mid] > key) {
          high = mid - 1
       }
       else {
          return mid
       }
    }
    
    return -1   // not found
 }

 // linear

 LinearSearch(numbers, numbersSize, key) {
   for (i = 0; i < numbersSize; ++i) {
       if (numbers[i] == key) {
          return i
       }
    }
    
    return -1 // not found
 }

 // linearathimic

 MergeSort(numbers, i, k) {
   j = 0
   if (i < k) {
      j = (i + k) / 2              // Find midpoint 
      
      MergeSort(numbers, i, j)     // Sort left part
      MergeSort(numbers, j + 1, k) // Sort right part
      Merge(numbers, i, j, k)      // Merge parts
   }
}