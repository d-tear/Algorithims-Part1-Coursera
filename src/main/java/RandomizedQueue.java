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
    	
    	if (n == 0) throw new java.util.NoSuchElementException();
    	
    	//randomize contents of array
    	StdRandom.shuffle(a, 0, n);
    	
    	Item item = a[--n];
		a[n] = null; //Avoid loitering 
		if (n > 0 && n == a.length/4) resize(a.length/2);
		
		return item;
    	
    	
    }
	
    
    public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RandomizedQueue<String> test = new RandomizedQueue<String>();
		
		System.out.println("Begin");
		
		test.enqueue("doc");
		
		test.enqueue("Lucy");
		
		test.enqueue("chipmunk");
		
		System.out.println(test.dequeue());
		System.out.println(test.size());
		
		System.out.println("End");

	}



}
