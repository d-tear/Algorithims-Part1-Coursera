import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String[] args) {
		
		//k is the number of items to sample
		int k = Integer.parseInt(args[0]);
		
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		
		while (!StdIn.isEmpty())
		{
			
			String item = StdIn.readString();
			
			q.enqueue(item);
			
		}
		
	 Iterator<String> iterator = q.iterator();
	 
	 int i = 0;
	 
	 while (i <= k) System.out.println(iterator.hasNext());

	}

}
