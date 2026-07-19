import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                
                
                if (j == 0 || j == i) {
                    row.add(1);
                } 
                else {
                    // ye wali line previous row ko laati  maan lo agr i=3 chahiye to u need i=2
                    List<Integer> prevRow = triangle.get(i - 1);
                    
                    
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }
}