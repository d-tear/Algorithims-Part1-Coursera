package com.Algorthims1_Coursera;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

public class BruteCollinearPoints {

	private Point[] points;
	
	//shallow copy the array of immutable points
	public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
	
		this.points = points.clone();
		
	}
	
	//public int numberOfSegments() { // the number of line segments
	
		
		//return segments().length;
	
	//}
	
	
	//is the given point inside a given array of points
	private boolean insidePointArray(Point[] inPoints, Point point) {
		
		for (Point p : inPoints) {
	    	  if (p.equals(point)) {
	    	  return true;
	    	  }
	}
		return false;
		}
	
	//are two points collinear
	private boolean isCollinear(Point a, Point b) {
		
		if ( a.compareTo(b) == 0 ) return true;
		
		else 
			return false;
	}
	
	
	//finds all tuples of size four
	private ArrayList<ArrayList<Point>> fourTuples() {
		
		ArrayList<Point> innerList = new ArrayList<Point>();
		
		ArrayList<ArrayList<Point>> outerList = new ArrayList<ArrayList<Point>>();
		
		for (int i = 0; i < points.length; i ++) {
			
			
			
			
			
			 for (int j = i+1; j < points.length; j++){
				 
				 
				 
				 
				 for (int k = j+1; k < points.length; k++) {
					 
					 
					 for (int z = k + 1; z < points.length; z++) {
				 
					 
					 innerList = new ArrayList<Point>();
				 
					 innerList.add(points[i]);
				 	 
				 	 innerList.add(points[j]);
				 	 
					 innerList.add(points[k]);
					 
					 innerList.add(points[z]);
					 
					 outerList.add(innerList);
					 }
				 }
						 
			 }
			 }
		return outerList;
		}
		

	
	
	
	
	 //public LineSegment[] segments() { // the line segments
	  
		 //ArrayList<LineSegment> str = new ArrayList<LineSegment>();
				 
		 
		 //need to convert to type Array
		 
		 //LineSegment[] arrayLineSegments = lineSegments.toArray(new LineSegment[lineSegments.size()]);
	 
	 //}
	 
	 
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point a = new Point(0,0);
        Point b = new Point(1,1);
        Point c = new Point(1,3);
        Point d = new Point(1,1);
        Point e = new Point(2,5);
        
        Point[] array = new Point[] {a,b,c,d,e};
        
		BruteCollinearPoints bcp = new BruteCollinearPoints(array);
		
		bcp.fourTuples();
		
		System.out.println(Arrays.deepToString(bcp.fourTuples().toArray()));

	}

}
