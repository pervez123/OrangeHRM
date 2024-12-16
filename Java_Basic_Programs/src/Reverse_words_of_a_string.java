import java.util.Scanner;

public class Reverse_words_of_a_string {
	
	public static void main(String[] args) {
		
		/*  Ques 1: As asked in the above question, we need to reverse a String. For Ex:
			The Input is : "RahulShettyAcademy"
			Output should be : "ymedacAyttehSluhaR" */
		
		System.out.print("Enter String to Reverse: ");
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		Reverse_words_of_a_string reverse = new Reverse_words_of_a_string();
		System.out.println(reverse.reverseStringUsingIteration(string));
		System.out.println(reverse.reverseStringUsingStringBuffer(string));
		System.out.println(reverse.reverseStringUsingStringBuilder(string));
	}

	// Method 1
	public String reverseStringUsingIteration(String string) {
		String rev = "";
		
		for (int i=string.length()-1; i>=0; i--) {
			
			rev = rev+string.charAt(i);
			
			
		}
		return ("Reversed string: "+rev);
	}
	
	
	// Method 2
	public String reverseStringUsingStringBuffer(String string) {
		
		StringBuffer sb = new StringBuffer(string);
		return ("Reversed string by StringBuffer: "+ sb.reverse());
	}
	
	
	// Method 3
	public String reverseStringUsingStringBuilder(String string) {
		
		StringBuilder sb = new StringBuilder(string);
		return ("Reversed string by StringBuilder: "+ sb.reverse());
	}
	
	
}
