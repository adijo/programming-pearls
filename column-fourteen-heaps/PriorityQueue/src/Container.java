public class Container implements Comparable<Container>
{
	int object;
	int priority;
	
	public Container(int obj, int priority)
	{
		this.object = obj;
		this.priority = priority;
	}
	@Override
	public int compareTo(Container arg0) 
	{
		// TODO Auto-generated method stub
		if(this.priority > arg0.priority) return 1;
		else if(this.priority < arg0.priority) return -1;
		else return 0;
	}
	@Override
	public String toString() 
	{
		return "Container [object=" + object + ", priority=" + priority + "]";
	}
	
	
}