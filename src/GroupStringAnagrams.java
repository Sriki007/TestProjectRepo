import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GroupStringAnagrams {
	
	/**
     * Groups the Anagram string.
     * @param inputString
     *            The Array of String.
     * @return {@link Map} of {@link ArrayList} which has grouped Anagram string.            
     */
	static Map<Integer, ArrayList<String>> groupStringAnagram(final String[] inputString)
	{
		final String[] sortedStringArray = new String[inputString.length];
		final Map<Integer, ArrayList<String>> groupedStringAnagram = new HashMap<Integer, ArrayList<String>>();
		
		// Sorts the individual string. -- START
		for(int i = 0; i< inputString.length; i++)
		{
			final char[] c1 = inputString[i].toCharArray();
			Arrays.sort(c1);
			final String s1 = new String(c1);
			sortedStringArray[i] = s1;
		}
		// Sorts the individual string. -- END
	
		final ArrayList<String> arrString = new ArrayList<>();
		
		// Compare all the string and build the Grouped string anagram -- START
		for(int i = 0; i< inputString.length; i++)
		{
			final ArrayList<String> tempArrayListString = new ArrayList<>();
			
			for(int j= i+1 ; j< inputString.length ; j++)
			{
				if(sortedStringArray[i].compareTo(sortedStringArray[j]) == 0)
				{
					if(!arrString.contains(inputString[i]))
					{
						arrString.add(inputString[i]);
						tempArrayListString.add(inputString[i]);
					}
					
					if(!arrString.contains(inputString[j]))
					{
						arrString.add(inputString[j]);
						tempArrayListString.add(inputString[j]);
					}
				}
			}
			
			// Builds the grouped string Anagram in a Map.
			groupedStringAnagram.put(i, tempArrayListString);
		}
		// Compare all the string and build the Grouped string anagram -- END
		
		// If there are no groups and it is single or left out item building and adding it to Map. -- START
		if(arrString.size() != inputString.length)
		{
			for(int i = 0; i< inputString.length; i++)
			{
				final ArrayList<String> tempArrayListString = new ArrayList<>();
				if(!arrString.contains(inputString[i]))
				{
					arrString.add(inputString[i]);
					tempArrayListString.add(inputString[i]);
					groupedStringAnagram.put(i, tempArrayListString);
				}
			}
		}
		// If there are no groups and it is single or left out item building and adding it to Map. -- END
		
		return groupedStringAnagram;
	}
	
	
	public static void main(String[] args)
	{
		//Input
		final String[] string = {"DOG", "GOD", "ACT", "TAC", "CAT"};
		//Output
		/*
		 [DOG, GOD]
		 [ACT, TAC, CAT]
		 */
		
		//Input
		// final String[] string = {"ACT", "GOD", "CAT", "TAC", "DOG"};
		//Output
		/*
		[ACT, CAT, TAC]
		[GOD, DOG]
		*/

		//Input
		//final String[] string = {"CAT", "DOG", "TAC", "MAD", "DAM", "AMD", "GOD", "SET"};
		//OutPut
		/*
		[CAT, TAC]
		[DOG, GOD]
		[MAD, DAM, AMD]
		[SET]
		*/
				
		 Map<Integer, ArrayList<String>> outputResult = groupStringAnagram(string);
		 
		 for (Entry<Integer, ArrayList<String>> entry : outputResult.entrySet())
			 
			 if(!entry.getValue().isEmpty())
			 {
				 System.out.println(entry.getValue());
			 }
	}
}
