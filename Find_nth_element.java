public class Find_nth_element{
	//------------------- partial selection sort ----------------------
	int naive_search(int[] arr, int k) {
		int minIndex = 0, i=0;
		
		for (i = 0; i < k; i++) {
			minIndex = i;
			
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			// swap arr[i] and arr[minIndex]
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		} 
		
		return arr[k-1];
	}
	
	//------------ selection algorithm (partial quick sort) ----------------
	// 1. recursion
	int selection_alg_re(int[] arr, int left, int right, int k) {
		int pivot = (left+right)/2;
		int newPivot = partition(arr, left, right, pivot);
		
		if (newPivot+1 == k) {
			return arr[newPivot];
		} else if (newPivot+1 > k) {
			return selection_alg_re(arr, left, newPivot-1, k);
		} else {
			return selection_alg_re(arr, newPivot+1, right, k);
		}
	}

	// 2. iteration
	int selection_alg_it(int[] arr, int k) {
		int left = 0, right = arr.length-1;
		
		while (true) {
			int pivot = (left + right)/2;
			int newPivot = partition(arr, left, right, pivot);
			
			if (newPivot+1 == k) {
				return arr[newPivot];
			} else if (newPivot+1 > k) {
				right = newPivot-1;
			} else {
				left = newPivot+1;
			}	
		}
	}
	
	//----------------------- helper functions -------------------------
	private int partition(int[] arr, int left, int right, int pivot) {
		// swap arr[pivot] to the right
		swap(arr, pivot, right);
		int storeIndex = left;
		
		// loop from left to right-1, since arr[pivot] is at the right end 
		for (int i = left; i < right; i++) {
			if (arr[i] < arr[right]) {
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}
		swap(arr, storeIndex, right);  //swap pivot value to the storeIndex'th position
	
		return storeIndex;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
	}
	//------------------------------------------------------------------
	
	public static void main(String[] args) {
		int[] array = {6, -5, 4, 3, 2, -1, 0};
		Find_nth_element test = new Find_nth_element();
		
		System.out.println(test.naive_search(array, 3));  //0
		System.out.println(test.selection_alg_re(array, 0, array.length-1, 3));  
		System.out.println(test.selection_alg_it(array, 3)); 		
	}
}