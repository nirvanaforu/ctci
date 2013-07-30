package Question1_5;

/**
 * 
 * @author Nirvanaforu
 *
 */
public class Question {

	public static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}

	/*
	 * if compressed length is greater than original str's length, no compression necessary
	 */
	public static int countCompression(String str) {
		if (str == null || str.isEmpty())
			return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				//the character itself length 1 + String length of counter(char)
				size += 1 + String.valueOf(count).length(); 
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

	public static String compressBad(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}	

	public static String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public static String compressBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}

	/**
	 * tricks: 
	 * 1. starting from 1st element instead of 0
	 * 2. need to convert tail array element
	 * 3. need to add function check if compression is possible
	 */
	public static int compressedLength(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		char last = s.charAt(0);
		int count =1;
		int size=0;
		for (int i=1; i<s.length(); i++) {
			if (last==s.charAt(i)) {
				count++;
			} else {
				size += 1+ String.valueOf(count).length();
				count=1;
			}
			last=s.charAt(i);
		}
		size += 1+ String.valueOf(count).length();
		return size;
	}
	public static void ylCompress(String s) {
		if (compressedLength(s)>=s.length()) {
			System.out.println("New String: " + s);
			return;
		}
		StringBuffer t = new StringBuffer();
		int count = 1;
		char prevChar = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (currChar == prevChar) {
				count++;
			} else {
				t.append(prevChar);
				t.append(count);
				prevChar = currChar;
				count = 1;
			}
		}
		t.append(prevChar);
		t.append(count);
		String convStr = t.toString();
		System.out.println("New String (len = " + convStr.length() + "): "
				+ convStr);
	}

	public static void main(String[] args) {
		String strArr[] = { "abbccccccde", "abcde", "abbccd" };
		for (String str : strArr) {
			int c = countCompression(str);
			// String str2 = compressAlternate(str);
//			String t = compressBetter(str);
			System.out.println("Old String (len = " + str.length() + "): "
					+ str);
			// System.out.println("New String (len = " + str2.length() + "): "
			// + str2);
//		    System.out.println("New String (len = " + t.length() + "): "
//			 + t);
//			System.out.println("Potential Compression: " + c);
			ylCompress(str);
		}
	}
}
