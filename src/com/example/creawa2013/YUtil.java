package com.example.creawa2013;




public class YUtil {
	/** String.format分はものすごいコストが高いんです。なので自作します。
	 *  http://www.kojion.com/blog/android/string_format/
	 */
	public static String s2Currency(String value) {
		int length = value.length();
		if (length <= 3) {
			return value;
		}
		StringBuilder result = new StringBuilder();
		int count = 1;
        for (int i = length - 1; i >= 0 ; i--) {
        	result.insert(0, value.substring(i, i + 1));
        	if (count % 3 == 0) {
            	result.insert(0, ",");
        	}
        	count++;
        }
		return result.toString();
	}

	public static String f2s(float value, int keta) {
		String temp = String.valueOf(value);
		int p = temp.indexOf(".");
		if (p < 0) {
			return temp;
		}
		return temp.substring(0, p + keta + 1);
	}

}
