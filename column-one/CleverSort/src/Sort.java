
public class Sort 
{
	private static final int MAX_INT = 10000000;
	public int[] sort(int[] arr)
	{
		Bitmap bitmap = new Bitmap();
		for(int i : arr)
			bitmap.set(i);
		
		int ctr = 0;
		for(int i = 1; i < MAX_INT; i++)
		{
			if(bitmap.get(i))
				arr[ctr++] = i;
		}
		
		return arr;
	}

}
