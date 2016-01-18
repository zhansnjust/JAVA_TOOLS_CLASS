package collection_learing;

public class MyArrayList {
	Object  element[];
	public int size=0;
	public MyArrayList() {
		element=new Object[20];
	}
	public MyArrayList(int init)
	{
		 if (init < 0)
	            throw new IllegalArgumentException("Illegal Capacity: "+
	                                               init);
		element=new Object[init];
	}
	public boolean isEmpty()
	{
		return size==0 ? true :false;
	}
	public void add(Object o)
	{
		if(ensureCapacity())
			element[size++]=o;
		else
		{
			int len=element.length*2+2;
			Object newElement[]=new Object[len];
			System.arraycopy(element, 0, newElement, 0, element.length);
			newElement[size++]=o;
			element=newElement;
		}
	}
	public Object get(int index)
	{
		if(index<0||index>size-1)
			throw new IllegalArgumentException();
		return element[index];
	}
	public boolean ensureCapacity()
	{
		if(size==element.length)
			return false;
		else
			return true;
	}
	public int size()
	{
		return this.size;
	}
}
