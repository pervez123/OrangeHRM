
public class RemoveSpacialCharsFromString {

	public static void main(String[] args) {
		
		String str = "Th)(*&^#@#$%^is is Selenium with :>< java";
		String newStr = str.replaceAll("[^a-zA-Z0-9 ]", "");
		System.out.print(newStr);
	}
}
