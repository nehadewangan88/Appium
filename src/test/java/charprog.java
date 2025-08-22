import java.util.Scanner;

import org.testng.annotations.Test;

public class charprog {

	
	@Test
	public void countChars()
	{
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str = str1.replace(" ", "");
		
		int vowelCount=0;
		int consoCount =0;
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			c = Character.toLowerCase(c);
			if(c=='a')
			{
				vowelCount = vowelCount+1;
				str1 = 	str.replaceAll("a","");
			}
			else if(c=='e')
			{
				vowelCount = vowelCount+1;
				str1 = str.replaceAll("e","");
			}
			else if(c=='i')
			{
				vowelCount = vowelCount+1;
				str.replaceAll("i","");
			}
			else if(c=='o')
			{
				vowelCount = vowelCount+1;
				str.replaceAll("o","");
			}
			else if(c=='u')
			{
				vowelCount = vowelCount+1;
				str.replaceAll("u","");
			}
				
			else if(!(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'))
				consoCount = consoCount+1;
				
				
		}
		System.out.println("Vowels count is: "+vowelCount+" and consonant count is: "+consoCount);
		
		
	}
}
