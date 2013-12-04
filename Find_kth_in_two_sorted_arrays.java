public class Find_kth_in_two_sorted_arrays {
	// assume no duplicate element in arrays
	// use two pointers to check through arr1 and arr2
	int find_kth_in_union(int[] arr1, int[] arr2, int k) {	
		if (arr1.length + arr2.length < k) {
			return Integer.MAX_VALUE;
		}
	
		int i=0, j=0, result=0;
		
		while (k>0) {
			if (i < arr1.length && j < arr2.length) {
				result = (arr1[i] < arr2[j])?arr1[i++]:arr2[j++];
			} else if (i == arr1.length) {
				result = arr2[j++];
			} else {
				result = arr1[i++];
			}
			
			k--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Find_kth_in_two_sorted_arrays test = new Find_kth_in_two_sorted_arrays();
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {0,2,4,6,8,10};
		int k = 7;
		
		int result = test.find_kth_in_union(arr1, arr2, k);
		if (result < Integer.MAX_VALUE) { 
			System.out.println("The "+k+"th element is "+result);
		} else {
			System.out.println("The "+k+"th element wasn't found!");
		}
	}
}