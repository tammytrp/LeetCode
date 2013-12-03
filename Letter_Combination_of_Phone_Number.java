package LeetCode_practice;

import java.util.ArrayList;

/**
 * Letter Combination of Phone Number
 * 
 * Given a digit string, return all possible letter 
 * combinations that the number could represent.
 * The mapping of digit to letters is like the telephone buttons
 * so 'digits' can only be composed by number from 2 to 9
 */
public class Letter_Combination_of_Phone_Number {
	private char[][] map = {{ 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
							{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v'}, { 'w', 'x', 'y', 'z' }};
	
	//recursion
	void buildCombinations(String digits, int i, StringBuilder sb, ArrayList<String> result){
		if(i == digits.length()){
			result.add(sb.toString());
		}
		
		else{
			int index = digits.charAt(i) - '1' - 1;
			//index = Integer.parseInt(digits.charAt(i)+"") - 2;
			
			for(int j = 0; j < map[index].length; j++){
				sb.append(map[index][j]);
				buildCombinations(digits, i+1, sb, result);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	
	public static void main(String[] args){
		Letter_Combination_of_Phone_Number test = new Letter_Combination_of_Phone_Number();
		
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		test.buildCombinations("234", 0, sb, result);
		
		int count=0;
		for(int i=0; i<result.size(); i++){
			if(count<2){
				System.out.print(result.get(i)+" ");
				count++;
			}
			else{
				System.out.println(result.get(i));
				count=0;
			}
		}
	}
}
