package com.Algorthims1_Coursera;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

public class BruteCollinearPoints {

	private Point[] points;
	
	//shallow copy the array of immutable points
	public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
	
		//ensure constructor argument isn't null
		if (points == null) throw new IllegalArgumentException();
		
		//ensure no points inside contructor aregument are null
		for (Point p : points) {
			if (p == null) throw new IllegalArgumentException();
		}
		
		
		//ensure the argument to the constructor contains no repeated points
		if (BruteCollinearPoints.isRepeated(points)) throw new IllegalArgumentException("All points must be unique!");
		
		
		this.points = points.clone();
		
	}
	
	//public int numberOfSegments() { // the number of line segments
	
		
		//return segments().length;
	
	//}
	
	
	
	//are all four points collinear? 
	//This method cycles through the nested Point arrays returned from fourTuples()
	private boolean allFourCollinear(Point[] array) {
		
		Point a = array[0];
		
		Point b = array[1];
		
		Point c = array[2];
		
		Point d = array[3];
				
		if (a.slopeTo(b) == a.slopeTo(c) && a.slopeTo(c) == c.slopeTo(d)) {return true;}
		
		return false;
	}
	
	
	
	
	//are two points equal (i.e. have same x and y coordinates)
	private boolean isEqual(Point a, Point b) {
		
		if ( a.compareTo(b) == 0 ) return true;
		
		else 
			return false;
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
		

	
	
	
	
	/*
	 * public LineSegment[] segments() { // the line segments
	 * 
	 * ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
	 * 
	 * 
	 * 
	 * int segment_counter = 0;
	 * 
	 * //cycle through all tuples of size four from the Point array given to the
	 * constructor for (ArrayList<Point> point_array : fourTuples()) {
	 * 
	 * if (allFourCollinear(point_array)){
	 * 
	 * segment_counter++;
	 * 
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * //need to convert to type Array //LineSegment[] arrayLineSegments =
	 * lineSegments.toArray(new LineSegment[lineSegments.size()]);
	 * 
	 * }
	 * 
	 */
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point a = new Point(0,0);
        Point b = new Point(1,1);
        Point c = new Point(1,3);
        Point d = new Point(2,2);
        Point e = new Point(2,5);
        Point f = new Point(3,3);
        Point g = new Point(4,4);
        
        Point[] array = new Point[] {a,b,c,d,e,f,g};
        
		BruteCollinearPoints bcp = new BruteCollinearPoints(array);
		
		
		System.out.println(Arrays.toString(bcp.points));
		
		Arrays.parallelSort(bcp.points);
		
		System.out.println( Arrays.toString(bcp.points));
		
		System.out.println(Arrays.deepToString(bcp.fourTuples().toArray()));
		
		  for (Point[] p_array :bcp.fourTuples()) {
		  
		  System.out.println(bcp.allFourCollinear(p_array)); } 

			}

}
