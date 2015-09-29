import java.util.Arrays;
import java.util.Timer;


public class Main 
{
	
	public static void main(String[] args)
	{
		Timer t = new Timer();
		RandomNumberGenerator rad = new RandomNumberGenerator();;
		int[] arr = RandomNumberGenerator.getRandomNumbers(10000000, 1000000);
		Sort s = new Sort();
		long startTime = System.currentTimeMillis();
		s.sort(arr);
		System.out.println("CleverSort time:");
		System.out.println(System.currentTimeMillis() - startTime);
		arr = RandomNumberGenerator.getRandomNumbers(10000000, 1000000);
		startTime = System.currentTimeMillis();
		Arrays.sort(arr);
		System.out.println("SystemSort time:");
		System.out.println(System.currentTimeMillis() - startTime);
		
	}

}
