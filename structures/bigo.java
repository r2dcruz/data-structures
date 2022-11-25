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