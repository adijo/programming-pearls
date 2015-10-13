import java.util.Arrays;


public class StringSearch 
{
	private String[] suffixes;
	private String input;
	
	public StringSearch(String input)
	{
		this.input = input;
		buildSuffixArray(input);
		
	}
	
	public Pair find(String needle)
	{
		return search(needle);
	}
	
	private Pair search(String needle)
	{
		int lo = 0;
		int hi = suffixes.length - 1;
		Pair answer = new Pair();
		answer.count = 0;
		
		while(lo <= hi)
		{
			if(lo == hi)
			{
				Pair candidate = match(needle, suffixes[lo]);
				if(candidate.count > answer.count) answer = candidate;
				return answer;
			
			}
			
			else if(lo + 1 == hi)
			{
				Pair candidate = match(needle, suffixes[lo]);
				if(candidate.count > answer.count) answer = candidate;
				
				candidate = match(needle, suffixes[hi]);
				if(candidate.count > answer.count) answer = candidate;
			
				return answer;
			}
			
			else
			{
				int mid = (lo + hi) / 2;
				Pair candidate = match(needle, suffixes[mid]);
				if(candidate.count > answer.count) answer = candidate;
				if(candidate.count == needle.length()) return answer;
				
				if(needle.compareTo(suffixes[mid]) > 0) lo = mid + 1;
				else hi = mid - 1;
				
			}
			
		}
		
		return answer;
		
	}
	
	private Pair match(String input, String suffix)
	{
		int maxLimit = Math.min(input.length(), suffix.length());
		
		int i = 0;
		Pair pair = new Pair();
		pair.count = 0;
		
		while(i < maxLimit)
		{
			if(input.charAt(i) == suffix.charAt(i)) pair.count++;
			else
			{
				pair.value = suffix;
				return pair;
			}
			i++;
		}
		pair.value = suffix;
		return pair;
		
	}
	
	private void buildSuffixArray(String input)
	{
		suffixes = new String[input.length()];
		for(int i = 0; i < input.length(); i++)
		{
			suffixes[i] = input.substring(i);
		}
		
		Arrays.sort(suffixes);
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
