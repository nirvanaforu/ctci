package Question1_1;

import java.util.HashSet;
import java.util.Set;

public class Question {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static boolean isUniqueCharsWithHash(String str) {
		Set<Character> charSet = new HashSet<Character>();
		for (int i=0; i<str.length();i++) {
			if (charSet.contains(str.charAt(i))) {
				return false;
			} else {
				charSet.add(str.charAt(i));
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + " has unique characters or not" +
					": " + isUniqueChars(word) + " " + isUniqueChars2(word) 
					+ " " + isUniqueCharsWithHash(word));
		}
	}

}
