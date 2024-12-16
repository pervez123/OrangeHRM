
public class UpperCaseToLower {

	public static void main(String[] args) {
		 String str = "Try programiz.Pro";
	        String newStr = "";
	        char[] ch = str.toCharArray();
	        for(char c: ch)
	        {
	            if(c>='A' && c<='Z')
	            {
	                newStr += Character.toLowerCase(c);
	                boolean result = Character.isAlphabetic(c);
	                System.out.print(result);
	            }
	            else
	            {
	                newStr += Character.toUpperCase(c);
	          
	            }
	        }
	        System.out.print("New String: "+newStr);
	    }

	}

