String longestCommonSubstring(String str1, String str2) {
   // Allocate the matrix.
   int[][] matrix = new int[str1.length()][str2.length()];
      
   // Variables to remember the largest value, and the position it 
   // occurred at.
   int maxValue = 0;
   int maxValueRow = 0;
   int maxValueCol = 0;
   for (int row = 0; row < str1.length(); row++) {
      for (int col = 0; col < str2.length(); col++) {
         // Check if the characters match
         if (str1.charAt(row) == str2.charAt(col)) {
            // Get the value in the cell that's up and to the 
            // left, or 0 if no such cell
            int upLeft = 0;
            if (row > 0 && col > 0) {
               upLeft = matrix[row - 1][col - 1];
            }
                
            // Set the value for this cell
            matrix[row][col] = 1 + upLeft;
            if (matrix[row][col] > maxValue) {
               maxValue = matrix[row][col];
               maxValueRow = row;
               maxValueCol = col;
            }
         }
         else {
            matrix[row][col] = 0;
         }
      }
   }

   // Return the longest common substring
   int startIndex = maxValueRow - maxValue + 1;
   return str1.substring(startIndex, startIndex + maxValue);
}

