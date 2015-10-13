import java.util.Arrays;


public class LRS 
{
	
	/*
	 * Finds the longest repeated substring in a string.
	 * @author: Aditya Joshi
	 */
	
	
	public String LRS(String query)
	{
		String[] suffixes = new String[query.length()];
		
		for(int i = 0; i < query.length(); i++)
		{
			suffixes[i] = query.substring(i);
		}
		Arrays.sort(suffixes);
		Pair answer = new Pair();
		answer.count = 0;
		for(int i = 0; i < suffixes.length - 1; i++)
		{
			Pair candidate = lcp(suffixes[i], suffixes[i + 1]);
			if(candidate.count > answer.count) answer = candidate;
		}
		
		return answer.value;
	}
	
	private Pair lcp(String a, String b)
	{
		int i = 0;
		Pair answer = new Pair();
		answer.count = 0;
		answer.value = null;
		
		while(i < a.length() && i < b.length())
		{
			if(a.charAt(i) == b.charAt(i)) 
			{
				
				answer.count++;
			}
			else 
			{
				answer.value = a.substring(0, i);
				return answer;
			}
			i++;
		}
		
		answer.value = a.substring(0, i);
		return answer;
		
	}
	
	private class Pair
	{
		int count;
		String value;
		
		@Override
		public String toString() 
		{
			return "Pair [count=" + count + ", value=" + value + "]";
		}
		
	}
	

}
