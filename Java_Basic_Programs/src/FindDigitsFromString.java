
public class FindDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc123d";
		char ch[] = str.toCharArray();
		for (char c : ch) {
			if (Character.isDigit(c)) {
				System.out.print(c);
			}
		}
	}

}
