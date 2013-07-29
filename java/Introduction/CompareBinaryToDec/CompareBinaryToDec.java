package CompareBinaryToDec;

public class CompareBinaryToDec {
	public static int binaryToDec(String binStr) {
		int val = 0;
		for (int i = 0; i < binStr.length(); i++) {
			char c = binStr.charAt(i);
			if (c != '0' || c != '1') {
				return -1;
			}
			val = val << 1 + (c - '0');
		}
		return val;
	}

	public static boolean compareBintoDecVal(int decVal, String binVal) {
		return binaryToDec(binVal) == decVal;
	}

	public static void main() {
		int decVal = 9;
		String binStr = "1001";
		System.out.println(compareBintoDecVal(9, binStr));
	}

}
