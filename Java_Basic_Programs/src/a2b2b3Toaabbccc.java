
public class a2b2b3Toaabbccc {

	public static void main(String[] args) {
		 String str = "a1b2c4";
	        String newStr = "";
	        char[] ch = str.toCharArray();
	        for(int i=0; i<ch.length; i++)
	        {
	            if(Character.isAlphabetic(ch[i]))
	            {
	                newStr += ch[i];
	            }
	            else if (Character.isDigit(ch[i]))
	            {
	                int num = Character.getNumericValue(ch[i]);
	                for(int j=1;j<num;j++)
	                {
	                    newStr += ch[i-1];
	                }
	            }
	        }
	        System.out.print("New String: "+newStr);
	    }

	}
