
public class CapitalWordsInString {

	public static void main(String[] args) {
		
		findCapitalWords("This is Selenium jaVa");

	}

	public static void findCapitalWords(String str) {
		
        char[] ch = str.toCharArray();
        int count = 0;
        for(char c: ch)
        {
            if(c>='A' && c<='Z')
            {
                System.out.println("Capital word: "+c);
                count++;
            }
            
        }
        System.out.print("Total no. of capital letters: "+count);
    }
	
}

