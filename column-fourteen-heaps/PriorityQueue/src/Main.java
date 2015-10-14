
public class Main 
{
	
	public static void main(String[] args) throws EmptyHeapException, SizeOverflowException
	{
		Container[] arr = new Container[4];
		Container one = new Container(1, 1);
		Container two = new Container(2, 2);
		Container three = new Container(3, 3);
		arr[1] = one;
		arr[2] = two;
		arr[3] = three;
		
		PriorityQueue q = 
				new PriorityQueue(arr);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.add(5, 1);
		q.add(6, 4);
		System.out.println(q.pop());
		q.add(1, 10);
		q.add(5, 44);
	
		while(q.hasNext())
		{
			System.out.println(q.next());
			q.remove();
		}
	}


}
