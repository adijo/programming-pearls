import java.util.Arrays;


public class Main 
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};
		Rotate.rotate(arr, 1);
		System.out.println(Arrays.toString(arr));
	}
}
