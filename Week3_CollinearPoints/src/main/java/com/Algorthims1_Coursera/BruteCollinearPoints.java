package com.Algorthims1_Coursera;


import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.SET;

public class BruteCollinearPoints {

	private Point[] points;
	
	//shallow copy the array of immutable points
	public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
	
		//ensure constructor argument isn't null
		if (points == null) throw new IllegalArgumentException();
		
		//ensure no points inside constructor argument are null
		for (Point p : points) {
			if (p == null) throw new IllegalArgumentException();
		}
		
		
		//ensure the argument to the constructor contains no repeated points
		if (BruteCollinearPoints.isRepeated(points)) throw new IllegalArgumentException("All points must be unique!");
		
		
		this.points = points.clone();
		
		//Initially sorting this array by y-value will ensure that the tuples returned by fourTuples will also be sorted by 
		//y-value.
		
		Arrays.parallelSort(this.points);
		
		//Arrays.parallelSort(this.points, this.points[0].slopeOrder());
		
		
		
		
		
		
	}
	
	public int numberOfSegments() { // the number of line segments
	
		
		return segments().length;
	
	}
	
	
	
	//are all four points collinear? 
	//This method cycles through the nested Point arrays returned from fourTuples()
	private boolean allFourCollinear(Point[] array) {
		
		Point a = array[0];
		
		Point b = array[1];
		
		Point c = array[2];
		
		Point d = array[3];
				
		if (a.slopeTo(b) == a.slopeTo(c) && a.slopeTo(c) == a.slopeTo(d)) {return true;}
		
		else {
		return false;
		}
	}
	
	
		
	
	//finds all tuples of size four. This is used in the constructor with the given points array. 
	//That's why it takes no arguments
	private ArrayList<Point[]> fourTuples() {
		
		
		ArrayList<Point[]> outerList = new ArrayList<Point[]>();
		
		for (int i = 0; i < points.length; i ++) {
			
			
			
			
			
			 for (int j = i+1; j < points.length; j++){
				 
				 
				 
				 
				 for (int k = j+1; k < points.length; k++) {
					 
					 
					 for (int z = k + 1; z < points.length; z++) {
				 
					 
					 Point [] innerList = new Point[4];
					 
					 innerList[0] = points[i];
					 
					 innerList[1] = points[j];
					 
					 innerList[2] = points[k];
					 
					 innerList[3] = points[z];
					 
	
					 outerList.add(innerList);
					 }
				 }
						 
			 }
			 }
		return outerList;
		}
	
	
	//determines if all points are equal (i.e. if any points have the same x AND y values)
	//this is useful inside the constructor
	private static boolean isRepeated(Point[] points ) {
		
		for (int i = 0; i < points.length; i ++) {
			
			for (int j = i + 1; j < points.length; j ++) {
				
				if ( points[i].compareTo(points[j]) == 0 ) {return true;}
				
				
			}
		}
		
		return false;
		
	}
		

	
	/**
     * Returns a LineSegment of the first and last points in the given Point array
     * Assumes point array is only of length 4
     *
     * @param points an array of points
     * @return a line segment of the first and last points in the given Point array
     */
	private LineSegment getEndPoints(Point[] points) {
		
		return new LineSegment(points[0], points[3]);
	}
	
	
	
	public LineSegment[] segments() { // the line segments
		
	
	  
	  ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
	  
	  //record origin/base point
	  Point origin = this.points[0];//overall lowest point bc we ordered the points by natural order in the constructor
	  
	  int counter = 0; //useful for finding the very first collinear line segment

	  double current_slope = Double.NaN; // use this to record the current slope
	  
	  LineSegment maxsegment = null; //use this to record the current max line segment
	  	  
	  //cycle through all tuples of size four from the Point array given to the constructor 	
	  //remember that these points are already sorted by natural order because we did this in the constructor
	  for (Point[] point_array : fourTuples()) {
		  
	
		
	  
	  if (allFourCollinear(point_array)){
		  
	
	  //Arrays.parallelSort(point_array, origin.slopeOrder());

		if (counter == 0) { //only enter if its the very first collinear segment
			
			counter++;
			
			if (point_array[0] == origin) { //check if overall lowest point is the origin for this segment
				maxsegment = getEndPoints(point_array);
				current_slope = origin.slopeTo(point_array[1]);
			}
			
			else { //if we passed the overall lowest point, update origin to reflect that
				origin = point_array[0];
				maxsegment = getEndPoints(point_array);
				current_slope = origin.slopeTo(point_array[1]);
				
			}
		}
		
		
		
		//given the same origin and slope, this is the largest segment seen so far bc of ordering in constructor
		else if (point_array[0] == origin && point_array[0].slopeTo(point_array[1]) == current_slope){
			
			maxsegment = getEndPoints(point_array);
			
		}
		
		
		else if(point_array[0] != origin && point_array[0].slopeTo(point_array[1]) == current_slope) {
			//do nothing. if this code block is tripped, it means we found a subsegment of the current maxsegment
		}
		  
		
		//this is a new line segment with the existing origin. We can add the existing maxsegment to the array and update maxsegment
		else if(point_array[0] == origin && point_array[0].slopeTo(point_array[1]) != current_slope) {
			
			segments.add(maxsegment);
			maxsegment = getEndPoints(point_array);
			current_slope = origin.slopeTo(point_array[1]);
			
		}
	 
		//new origin with new slope
		else {
			segments.add(maxsegment);
			origin = point_array[0];
			maxsegment = getEndPoints(point_array);
			current_slope = origin.slopeTo(point_array[1]);
		}
	  
	  
	  
	  } 
	  
	  
	  }
	  
	  if (segments.size() == 0) { //ensures we add the maxsegment if there's only one unique collinear segment
	  segments.add(maxsegment);
	  }
	  
	  //convert ArrayList to Array
	  LineSegment[] segs = new LineSegment[segments.size()];
	  
	  segs = segments.toArray(segs);
	  
	  return segs;
	  
	  
	  
	  }
	  
	 
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point a = new Point(10000,0);
        Point b = new Point(0, 10000);
        Point c = new Point(3000, 7000);
        Point d = new Point(7000, 3000);
        Point e = new Point(20000,21000);
        Point f = new Point(3000, 4000);
        Point g = new Point(14000,15000);
        Point h = new Point(6000,7000);
        
        
        Point[] array = new Point[] {a,b,c,d,e,f,g,h};
        
		BruteCollinearPoints bcp = new BruteCollinearPoints(array);
		
		System.out.println(Arrays.deepToString(bcp.fourTuples().toArray()));
		
		//System.out.println(bcp.fourTuples().size());
		
		//System.out.println(Arrays.toString(bcp.points));
		
		//Arrays.parallelSort(bcp.points, bcp.points[0].slopeOrder());
		
		//System.out.println(Arrays.toString(bcp.points));
		
		
		//System.out.println( Arrays.toString(bcp.points));
		
		for (Point[] p_array : bcp.fourTuples()) {
			
			if (bcp.allFourCollinear(p_array)) {
	 		  System.out.println(Arrays.toString(p_array));
	 		  }
			
			

	 	}
		
		System.out.println(Arrays.toString(bcp.segments()));
		
		 }
}
