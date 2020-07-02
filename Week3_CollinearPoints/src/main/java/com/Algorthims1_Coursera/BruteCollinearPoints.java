package com.Algorthims1_Coursera;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Selection;

public class BruteCollinearPoints {

	public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
	Selection.sort(points, points[0].slopeOrder());
		
	}
	
	public int numberOfSegments() { // the number of line segments
	return 0; //code to do
	
	}
	
	 public LineSegment[] segments() { // the line segments
	 
		 ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();
		 
		 //need to convert to type Array
		 
		 LineSegment[] arrayLineSegments = lineSegments.toArray(new LineSegment[lineSegments.size()]);
	 
	 }
	 
	 
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BruteCollinearPoints bcp = new Brute

	}

}
