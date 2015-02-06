import java.util.ArrayList;

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {

	public static ArrayList<Integer> stringToIntArray(String s){
		ArrayList<Integer> result = new ArrayList<>();
		String[] sSplit = s.split("");
		for (int i = 1; i < sSplit.length; i++) { // ignore sSplit[0], not an int.
			result.add(Integer.parseInt(sSplit[i]));
		}
		return result; 
	}
	
	public String countAndSay(int n){
		String result = "1";
		if (n == 1) {
			return result;
		}else {
			String temp = countAndSay(n-1);
			int head = 0, tail = 0;
			for (int i = 0; i < temp.length(); i++) {
				for (int j = 0; j < temp.length(); j++) {
					
				}
			}
			return result;
		}		
	}
	public static void main(String[] args) {
		String s = "1234";
		ArrayList<Integer> arrOfInt = stringToIntArray(s);
		for (int i = 0; i < arrOfInt.size(); i++) {
			System.out.println(arrOfInt.get(i));
		}

	}

}
