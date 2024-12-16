import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		
		RemoveDuplicateCharFromString("This is Selenium with Java");

	}
	
    public static void RemoveDuplicateCharFromString(String str) {
    	
	   String newStr = "";
	   char[] ch = str.toCharArray();
	   // Here we have used LinkedHashSet instead of HashSet to get the output in the same order as it was inserted  
	   //LinkedHashSet output -> this elnumwjav
	   //HashSet output -> aehijlmnstuvw
	
	   LinkedHashSet<Character> hs = new LinkedHashSet<>();
	   for(char c: ch)
	   {
		   hs.add(Character.toLowerCase(c));
	   }
	   for(char c: hs)
	   {
		   newStr += c;
	     
	    }
	   System.out.print(newStr.trim());
	}
}
