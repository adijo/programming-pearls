
public class Rotate 
{
	
	public static void rotate(int[] arr, int pos)
	{
		pos = pos % arr.length;
		int shift = arr.length - pos;
		reverse(arr, 0, shift - 1);
		reverse(arr, shift, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}
	
	private static void reverse(int[] arr, int lo, int hi)
	{
		while(lo < hi)
		{
			int temp = arr[hi];
			arr[hi] = arr[lo];
			arr[lo] = temp;
			lo++;
			hi--;
		}
		
	}

}
