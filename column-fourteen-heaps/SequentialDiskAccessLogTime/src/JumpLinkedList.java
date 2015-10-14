import java.util.Stack;


public class JumpLinkedList<T> 
{
	
	private Node<T> head;
	private int count;
	
	public JumpLinkedList()
	{
		head = null;
		count = 0;
		
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void add(T obj)
	{
		// find the location of the last element in the list.
		if(count == 0)
		{
			Node<T> newNode = new Node<T>();
			newNode.i = 1;
			newNode.obj = obj;
			head = newNode;
			count++;
		}
		
		else
		{
			// get node at (count) index.
			Node<T> place = getAt(count);
			Node<T> newNode = new Node<T>();
			newNode.i = place.i + 1;
			newNode.obj = obj;
			place.next = newNode;
			count++;
			if(count % 2 == 0)
			{
				Node<T> jumpToCurr = getAt(count / 2);
				jumpToCurr.jump = newNode;
			}
			
		}
		
		
	}
	
	public Node<T> getNode(int index)
	{
		if(index <= count) return getAt(index);
		else throw new IndexOutOfBoundsException("Index is out of bounds.");
		
	}
	
	public Node<T> getAt(int index)
	{
		Stack<Integer> plan = makePlan(index);
		plan.pop();
		Node<T> curr = head;
		while(!plan.isEmpty())
		{
			if(curr.i == index) return curr;
			else
			{
				int nextIndex = plan.pop();
				if(nextIndex == curr.i + 1)
				{
					curr = curr.next;
				}
				else
				{
					curr = curr.jump;
				}
			}
		}
		
		return curr;
	}
	
	private Stack<Integer> makePlan(int index)
	{
		Stack<Integer> ans = new Stack<Integer>();
		while(index > 0)
		{
			ans.add(index);
			if(index % 2 == 0) index = index / 2;
			else index--;
		}
		return ans;
	}
	
	

}
