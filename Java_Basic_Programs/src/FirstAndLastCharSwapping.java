import java.util.*;

public class FirstAndLastCharSwapping {

	public static void main(String[] args) {

		String str[] = { "This", "is", "a", "Selenium" };
		for (int i = 0; i < str.length; i++) {
			str[i] = reverse(str[i]);
		}
		System.out.print("First and Last character swapped : "+Arrays.toString(str));
	}

	public static String reverse(String str) {
		String rev = "";
		if (str.length() > 1) {
			rev += str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
		} else
			rev += str;
		return rev;
	}

}
