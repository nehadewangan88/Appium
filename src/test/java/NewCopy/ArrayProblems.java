package NewCopy;

import java.util.*;

import org.testng.annotations.Test;

public class ArrayProblems {

	
	@Test
	public void findSecLargest()
	{
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(12,44,32,31,23,44,30,30,56,2,2,0,9));
		
		Collections.sort(intList); //0, 2, 2, 9, 12, 23, 30, 30, 31, 32, 44, 44, 56
		int listSize = intList.size(); // 13  13
		for(int i=0;i<intList.size();i++)
		{
		
			int count = Collections.frequency(intList, intList.get(i)); //1  2
			System.out.println("Count of num is:"+count); //1  2
			if(count>1)
			{
				while(count!=1)
				{
					intList.remove(intList.get(i));
					count = Collections.frequency(intList, intList.get(i)); 
					System.out.println("Removed: "+intList.get(i)+" and new count is: "+count);
					System.out.println("New list size is:"+intList.size());
				}
			}
			System.out.println(intList);
		}	
			
		
		System.out.println("Second Largest is:"+intList.get(1));
		
	}
	
	@Test
	public void removeContigiousDuplicates()
	{
		 List<Integer> intList = new ArrayList<Integer>(Arrays.asList(12,12,11,11,11,22,22,11,10,10,23,23,4,23,5,6,7,7,8,1,7,20,23,29,29,29));
	        
	        for(int i=0;i<=intList.size()-1;i++)
	        {
	            if(intList.get(i)==intList.get(i+1))
	            { 
	                int val1 = intList.get(i);
	                int val2 = intList.get(i+1);
	                intList.remove(Integer.valueOf(val1));
	                intList.remove(Integer.valueOf(val2));
	                System.out.println(val1+" is removed!!");
	                System.out.println(val2+" is removed!!");
	                if(i==intList.size()-1)
	                    i=i;
	                else
	                    i--;
	               
	            }
	             System.out.println(intList);
	        }
	}
	
	@Test
	public void threeGreatElements()
	{
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(12,4,3,1,0,9,5));
		Collections.sort(intList,Collections.reverseOrder());
		System.out.println(intList.get(0)*intList.get(1)*intList.get(2));
		
	}
	
	@Test
	public void maxConsecutiveNumbers()
	{
		List<Integer> binList = new ArrayList<Integer>(Arrays.asList(0,0,1,1,1,0,0,0,0,1,1,1,1,1));
		int count=0;
		Set<String> result = new HashSet<String>();
		int num = binList.get(0);
		for(int i=0;i<=binList.size()-1;i++)
		{
			int val=i;//0 1
			while(binList.get(val)==num)
			{
				count++;
				val++;
			}
			num=binList.get(val); //1
			if(count>0)
				result.add(binList.get(val-1)+"-"+count); //0-2
			count=0;
			System.out.println(result);
		}
		
	}
}
