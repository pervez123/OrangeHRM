package Arrays_Practice_Problem;

import java.util.HashSet;

public class CommonElements {
	
	public void findCommon(String[] a, String[] b)
	{
		HashSet<String> set = new HashSet<String>();
		set.isEmpty();
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<b.length; j++)
			{
				if(a[i].equals(b[j]))
				{
					set.add(a[i]);
					break;
			}
		}
		}
		
		for (String s: set)
		{
			System.out.println("Common elements are: " + s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"A", "B", "CD", "DE"};
		String[] b = {"CD", "A", "B"};
		CommonElements ce = new CommonElements();
		ce.findCommon(a, b);
	}

}
