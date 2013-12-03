import java.util.ArrayList;

public class Generate_gray_code{
	/* 
	 * Use mathematical way to generate
	 * the ith gray code = (i>>1)^i
	 */
	ArrayList<Integer> generate_math(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int num = 1<<n;   //for n-bit, there are in total 2^n gray codes
		for (int i=0; i<num; i++) {
			int gray_code = (i>>1)^i;
			result.add(gray_code);
		}
		
		return result;
	}
	
	/*
	 * A recursive solution, better for interview
	 * The list of gray codes of n-bit is:
	 *  - all (n-1)-bit codes, with inserting to MSB 0s
	 *  - reverse the list of (n-1)-bit codes and insert to MSB 1s
	 */
	ArrayList<Integer> generate_re(int n) {
		ArrayList<Integer> result_list = new ArrayList<Integer>();
		
		// base case
		if (n == 0) {
			result_list.add(0);
			return result_list;
		} else if (n == 1) {
			result_list.add(0);
			result_list.add(1);
			return result_list;
		}
		
		// recursive call
		ArrayList<Integer> prevList = generate_re(n-1);
		
		result_list.addAll(prevList);
		//result_list = new ArrayList<Integer>(prevList);
		
		int msb = 1<<(n-1);  //an n-bit number with MSB=1 and all other bits = 0
		for (int i=prevList.size()-1; i>=0; i--) {
			result_list.add(prevList.get(i)+msb);
		}	
		
		return result_list;	
	} 
	
	// An iterative solution
	ArrayList<Integer> generate_it(int n) {
		ArrayList<Integer> result_list = new ArrayList<Integer>();
		
		// base case
		if (n == 0) {
			result_list.add(0);
			return result_list;
		} 
		
		// for n>=1
		result_list.add(0);
		result_list.add(1);
		for (int i=1; i<n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(result_list);
			int msb = 1<<i;
			for (int j = temp.size()-1; j>=0; j--) {
				temp.add(temp.get(j) + msb);
			}
			result_list = temp;
		}
		
		return result_list;
	}

	public static void main(String[] args) {
		Generate_gray_code test = new Generate_gray_code();
		int n = 3;
		
		System.out.println("math");
		ArrayList<Integer> result = test.generate_math(n);
		for (int i=0; i<result.size(); i++) {
			System.out.println(Integer.toBinaryString(result.get(i)));
		}
		
		System.out.println("recursive");
		result = test.generate_re(n);
		for (int i=0; i<result.size(); i++) {
			System.out.println(Integer.toBinaryString(result.get(i)));
		}
		
		System.out.println("iterative");
		result = test.generate_it(n);
		for (int i=0; i<result.size(); i++) {
			System.out.println(Integer.toBinaryString(result.get(i)));
		}
	}
}
