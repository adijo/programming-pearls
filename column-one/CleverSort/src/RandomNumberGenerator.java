import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class RandomNumberGenerator 
{
	private static Random rnd = new Random();
	public static int[] getRandomNumbers(int n, int m)
	{
		Set<Integer> set = new HashSet<>();	
		
		for(int i = n - m; i < n; i++)
		{
			int item  = rnd.nextInt(i + 1);
			if(set.contains(item))
				set.add(i);
			else
				set.add(item);
			
		}
		
		int[] arr = new int[m];
		int ctr = 0;
		for(int i : set) arr[ctr++] = i + 1;
		return arr;
	}

}
