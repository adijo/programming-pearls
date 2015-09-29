
public class Bitmap 
{
	
	private int[] arr;
	private static final int REQUIRED_SIZE = 312500;
	private static final int RADIX = 32;

	public Bitmap()
	{
		arr = new int[REQUIRED_SIZE]; 
	}
	
	public void set(int index)
	{
		int bucket = index / RADIX;
		int value = arr[bucket];
		arr[bucket] = value  | (1 << ((index % RADIX) - 1));
	}
	
	public boolean get(int index)
	{
		/*
		 * Returns true if the i'th index is set.
		 */
		int bucket = index / RADIX;
		int value = arr[bucket];
		return (value ^ (1 << ((index % RADIX) - 1))) == 0;
	}
	

}
