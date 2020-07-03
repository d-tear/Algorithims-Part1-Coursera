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
	
	public int numberOfSegments() { // the number of line segments
	
		return segments().length;
	
	}
	
	
	
	 public LineSegment[] segments() { // the line segments
	  
		 
		 //need to convert to type Array
		 
		 LineSegment[] arrayLineSegments = lineSegments.toArray(new LineSegment[lineSegments.size()]);
	 
	 }
	 
	 
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BruteCollinearPoints bcp = new Brute

	}

}
