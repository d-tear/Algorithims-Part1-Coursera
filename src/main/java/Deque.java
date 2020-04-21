import java.util.Iterator;



public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int n = 0;
	
	// construct an empty deque
    public Deque() {
    	
    	
    	 
    	
    	
    }
    
    // is the deque empty?
    public boolean isEmpty()
    {
    	return first == null;
    }
    
    public int size()
    {
    	return n;
    }
    
    
 // add the item to the front
    public void addFirst(Item item)
    {
    	
    	Node oldfirst = first;
    	
    	first = new Node();
    	first.item = item;
    	first.previous = null;
    	first.next = oldfirst;
    	
    	if(isEmpty()) last = first;
    	else
    	{
    		oldfirst.previous = first;
    	}
    	
    	n++;
    	
    	

    }
    
   
    
 // add the item to the back/end of list
    public void addLast(Item item)
    {
    	Node oldlast = last;
    	last = new Node();
    	
    	last.item = item;
    	last.next = null;
    	
    	if (isEmpty()) 
    	
    	{
    		last.previous  = null;
    		first = last;
    		
    	}
    	else {
    		last.previous = oldlast; 
    		oldlast.next = last;
    	}
    	
    	//update n (i.e. size)
    	n++;  	
    }
    
    // remove and return the item from the front
    public Item removeFirst()
    {
    	Item item = first.item;
    	first = first.next;
    	n--;
    	
    	if(isEmpty()) last = null;
    	
    	return item;
    }
    
    // remove and return the item from the back
    public Item removeLast()
    {
    	Item item = last.item;
    	last = last.previous;
    	n--;
    	
    	if(isEmpty()) first = null;
    		
    	return item;
    }

    
    
	
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private class Node
	{ // nested class to define nodes
		Item item;
		Node next;
		Node previous;
		
	}
	
	public static void main(String[] args) {
		
		Deque<String> test = new Deque<String>();
		
		
		System.out.println(test.isEmpty());
		//test.addFirst("be");
		test.addLast("can");
		test.addFirst("be");
		
		System.out.println(test.removeLast());
		System.out.println(test.removeLast());
		
		
		

	}

	

}
