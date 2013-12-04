/**
 * Input is a NxN matrix which contains only 0′s and 1′s. 
 * The condition is no 1 will occur in a row after 0. 
 * Find the index of the row which contains maximum number of zeros.
 */
public class Find_row_of_max_zeros{
	/* 
	 * Approach 1:
	 * loop through every row, for each row, use binary search to find the first occurrence of 0
	 * runtime - O(nlogn)
	 */
	int find_row_binary(int[][] matrix) {
		int n = matrix.length;
		int row = -1, first_occur_of_zero = n;
		
		for (int i = 0; i < n; i++) {
			int left = 0, right = n-1;
			boolean found = false;
			
			while (true){
				int mid = (left+right)/2;
				
				if (matrix[i][mid] == 1) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
				
				if (right < left) {
					int temp = (matrix[i][mid] == 1)?mid+1:mid;
					if (temp < first_occur_of_zero) {
						first_occur_of_zero = temp;
						row = i;
						
						//System.out.println("first_occur_of_zero "+first_occur_of_zero+" row "+row);
					}
					
					break;
				}
			}
		}
		
		return row;
	}
	
	// Approach 2: runtime - O(n)
	int find_row(int[][] matrix) {
		int n = matrix.length-1;
		int j = n;
		int row = -1;
		
		for (int i = n; i >= 0; i--) {
			while (j >= 0) {
				if (matrix[i][j] == 0) {
					row = i;
					j--;
				} else {
					break;
				}
			}
			
			if (j < 0) {
				return i;
			} 
		}
		
		return row;
	}
	
	public static void main(String[] args) {
		Find_row_of_max_zeros test = new Find_row_of_max_zeros();
		int[][] matrix = {{0,0,0,0},{1,1,0,0},{1,0,0,0},{1,1,1,0}};
		//int[][] matrix = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		
		System.out.println("1. The row is row:"+test.find_row_binary(matrix));
		System.out.println("2. The row is row:"+test.find_row(matrix));
	}
}