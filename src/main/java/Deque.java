import java.util.Iterator;



public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int n = 0;
	
	// construct an empty deque
    public Deque() {
    	
    	first = new Node();
    	first.next = null;
    	first.previous = null;
    	last = first;
    	
    	
    	
    	
    }
    
    // is the deque empty?
    public boolean isEmpty()
    {
    	return size() == 0;
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
    	n--;
    	
    	if(isEmpty()) 
    	{
    		first = first.next;
    		last = first;
    		
    	}
    	
    	else
    	{
    	first = first.next;
        first.previous = null;
    	}
    	
    	return item;
    }
    
    // remove and return the item from the back
    public Item removeLast()
    {
    	Item item = last.item;
    	n--;
    	
    	if(isEmpty()) {
    		
    		last = last.previous;
    		first = last;
    	} 
    	
    	else
    	{	
    	last = last.previous;
    	last.next = null;
    	}
    	
    	return item;
    }

    
    
 // return an iterator over items in order from front to back
	public Iterator<Item> iterator() {
		
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item>
	{
		// initialize current to the first node of the linked list
		private Node current = first;

		public boolean hasNext() {
			
			return current != null;
		}

		// empty method. we wont be using remove
		public void remove() {}
		
		
		//return item of current node and move to next node
		public Item next() {
			
			Item item = current.item;
			current = current.next;
			return item;
			
		}
		
		
		
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
		test.addLast("can");
		test.addLast("be");
		test.addLast("to");
		test.addFirst("will");
		
		
		for (String s : test) System.out.println(s);
		
		

	}

	

}
