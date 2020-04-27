import java.util.Iterator;


import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] a;
	private int n; // number of items
	
	
	// construct an empty randomized queue
    public RandomizedQueue() {
     a = (Item[]) new Object[1]; //stack of items. Note that we cast Object to Item. 
     n = 0;
     
    	
    }

	
	public boolean isEmpty() { return n == 0;}
	
	public int size() {return n;}
	
	
	
	
	
	//dynamic resizing. Move stack to a new array of size max.
    private void resize(int max)
    {
    	Item[] temp = (Item[]) new Object[max];
    	for (int i = 0; i < n; i++)
    	{
    		temp[i] = a[i];
    	}
    	
    	a = temp;
    }
    
    
    
    // add the item
    public void enqueue(Item item)
    {
    	if (item == null) throw new IllegalArgumentException();
    	
    	if(n == a.length) 
    	{
    		resize(2*a.length);
    		a[n++]  = item;
    	}
    	
    	else a[n++] = item;
    	
    }
    
    
    // remove and return a random item
    public Item dequeue()
    {
    	
    	if (isEmpty()) throw new java.util.NoSuchElementException();
    	
    	//select a random array index
    	int random = StdRandom.uniform(n);
    	
    	//swap the randomly chosen index and the terminal index in the array
    	swap(random, n-1);
    	
    	
    	//remove the terminal index in the array and resize if necessary
    	Item item = a[--n];
		a[n] = null; //Avoid loitering 
		if (n > 0 && n == a.length/4) resize(a.length/2);
		
		return item;
    	
    }
    
    //exchange entries at two indices in the array
    private void swap(int i, int j)
    {
    	Item temp = a[i];
    	
    	a[i] = a[j];
    	
    	a[j] = temp;
    	
    }
    
    // return a random item (but do not remove it)
    public Item sample()
    {
    	if (isEmpty()) throw new java.util.NoSuchElementException();
    	
    	Item item; 
    	
    	int random = StdRandom.uniform(n);
    	
    	item = a[random];
    	return item;
    }
    
    
	
    
    public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
    	return new RandomizedQueueIterator();
	}
    
    
    private class RandomizedQueueIterator implements Iterator<Item>{
    	
    	int i = 0;
    	
    	public RandomizedQueueIterator()
    	{
    		//randomize contents of array
        	StdRandom.shuffle(a, 0, n);
        	
    	}
    	
    	// empty method. we wont be using remove
    	public void remove() 
    	{
    		throw new UnsupportedOperationException();
    	}
    	
		public boolean hasNext() {
			//true as long as "i" isn't bigger than the size of our array
			return i < n;
		}

		public Item next() {
			
			if (!hasNext()) throw new java.util.NoSuchElementException();
			
			return a[i++];
		}
    	
    }

	public static void main(String[] args) {
		/* 
		 * Your main() method must call directly every public constructor and 
		method to verify that they work as prescribed 
		(e.g., by printing results to standard output).
		*/
		
		RandomizedQueue<String> test = new RandomizedQueue<String>();
		
		test.enqueue("doc");
		test.enqueue("Lucy");
		
		System.out.println(test.isEmpty());
		
		System.out.println(test.size());
		
		System.out.println(test.sample());
		
		System.out.println(test.dequeue());
		
		//for (String s : test) System.out.println(s);
		
		

	}



}
