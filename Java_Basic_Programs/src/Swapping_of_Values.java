import java.util.Scanner;

public class Swapping_of_Values {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter str1: ");
		String str1 = sc.nextLine();
		System.out.print("Enter str2: ");
		String str2 = sc.nextLine();
		System.out.println(swappingWithThirdVariable(str1, str2));
		System.out.println(swappingWithoutThirdVariable(str1, str2));
		
	}
	
	//Method 1
	public static String swappingWithThirdVariable(String str1, String str2) {
		
		String temp;
		temp = str1;
		str1 = str2;
		str2 = temp;
		
		return ("Swapped values: "+str1 +"," + str2);
	}
	
	//Method 2
		public static String swappingWithoutThirdVariable(String str1, String str2) {
			
			int len_Str1 = str1.length();
			int len_Str2 = str2.length();
			
//			str1 = str1.concat(str2);
			str1 = str1+str2;
			str2 = str1.substring(0, str1.length() - len_Str2);
			str1 = str1.substring(str1.length() - len_Str2);
			
			return ("Swapped values without thrid variable : "+str1 +"," + str2);
		}
}
