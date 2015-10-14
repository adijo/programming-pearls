
public class Main 
{
	public static void main(String[] args)
	{
		JumpLinkedList<Integer> ll = new JumpLinkedList<Integer>();
		
		ll.add(1);
		ll.add(4);
		ll.add(7);
		ll.add(123);

		for(int i = 1; i <= ll.getCount(); i++) 
			System.out.println(ll.getNode(i));
	}


}
