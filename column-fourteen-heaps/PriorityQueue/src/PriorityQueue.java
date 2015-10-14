import java.util.Arrays;
import java.util.Iterator;


public class PriorityQueue implements Iterator<Container>
{
	private Container[] arr;
	private int length;
	private int currCount = 1;
	public PriorityQueue(int n)
	{
		length = n + 1;
		arr = new Container[length];
		
	}
	
	public PriorityQueue(Container[] arr)
	{
		//System.out.println(Arrays.toString(arr));
		this.arr = arr;
		this.length = arr.length;
		this.currCount = length;
		heapify();
		
	}
	
	
	public void add(int element, int priority) throws SizeOverflowException
	{
		if(currCount >= length)
		{
			throw new SizeOverflowException("Queue is already full.");
		}
		else
		{
			Container newEntry = new Container(element, priority);
			arr[currCount] = newEntry;
			upHeapify(currCount);
			currCount++;
		}
		
	}
	
	public Container pop() throws EmptyHeapException
	{
		if(currCount == 1)
		{
			throw new EmptyHeapException("Queue is empty. Nothing to pop.");
		}
		
		else
		{
			Container top = arr[1];
			Container last = arr[currCount - 1];
			
			int currPopulation = currCount - 1;
			if(currPopulation == 1)
			{
				arr[1] = null;
				currCount = 1;
				return top;
			}
			
			else
			{
				arr[1] = last;
				currCount--;
				downHeapify(1);
				return top;
			}
		}
	}
	private void heapify()
	{
		for(int i = length - 1; i >= 1; i--)
		{
			downHeapify(i);
		}
	}
	
	private void upHeapify(int i)
	{
		if(parent(i) >= 1)
		{
			Container current = arr[i];
			Container parent = arr[parent(i)];
			
			// if parent has a smaller priority,
			if(parent.compareTo(current) < 0)
			{
				arr[parent(i)] = current;
				arr[i] = parent;
				upHeapify(parent(i));
			}
			
		}
		
	}

	private void downHeapify(int i)
	{
	
		if(left(i) >= currCount && right(i) >= currCount)
		{
			// it is a leaf. already a heap.
			
			return;
		}
		else if(left(i) < currCount && right(i) >= currCount)
		{
			// can only happen once.
			// check condition.
			Container leftChild = arr[left(i)];
			Container current = arr[i];
			
			// if current element is smaller than left child, swap.
			if(current.compareTo(leftChild) < 0)
			{
				arr[left(i)] = current;
				arr[i] = leftChild;
			
			}
		}
		
		else if(left(i) < currCount && right(i) < currCount)
		{
			
			Container current = arr[i];
			Container leftChild = arr[left(i)];
			Container rightChild = arr[right(i)];
			
			Container candidate = leftChild;
			int index = left(i);
			if(rightChild.compareTo(leftChild) > 0)
			{
				candidate = rightChild;
				index = right(i);
			}
			
			if(current.compareTo(candidate) < 0)
			{
				arr[i] = candidate;
				arr[index] = current;
			}
			downHeapify(index);
		}
	}
	
	private int left(int i)
	{
		return 2 * i;
	}
	
	private int right(int i)
	{
		
		return (2 * i) + 1;
	}
	
	private int parent(int i)
	{
		return i / 2;
	}

	@Override
	public String toString() 
	{
		return "PriorityQueue [arr=" + Arrays.toString(arr) + "]";
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return currCount > 1;
	}

	@Override
	public Container next() 
	{
		// TODO Auto-generated method stub
		return arr[1];
	}

	@Override
	public void remove() 
	{
		// TODO Auto-generated method stub
		try {
			this.pop();
		} catch (EmptyHeapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
