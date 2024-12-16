
public class Reverse_sentense_of_a_String {
	
	public static void reverse(String str) {
		
		String[] str_arr = str.split(" ");
		String rev = "";
		for (String s: str_arr)
		{
			StringBuffer sb = new StringBuffer(s);
		    rev = new String(sb.reverse());
			System.out.print(rev + " ");
//			rev = s +" " + rev;
		}
		
	}

	public static void main(String[] args) {
		
		String str = "Selenium is a tool";
		//System.out.println(reverse(str).trim());
		reverse(str);
	}

}
