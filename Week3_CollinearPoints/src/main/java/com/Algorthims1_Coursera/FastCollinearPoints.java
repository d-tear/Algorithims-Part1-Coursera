package com.Algorthims1_Coursera;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
	
	
	private Point[] points;

	public FastCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
		
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
	
	public LineSegment[] segments() { // the line segments
		
		ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
		
		LineSegment segment = null; //use this to record the current line segment
		
		double current_slope = Double.NaN; // use this to record the current slope
		
		//for each point, treat it as the origin and sort the rest of the points by the slope they make with this point
		for (int i = 0; i < this.points.length; i ++) {

			//make point i the "origin"
			Point origin = this.points[i];

			//sort the remaining points by the slope they make with the current origin
			Arrays.parallelSort(points, origin.slopeOrder());

			
			int collinear_points = 1;
			
			//set the initial current slope value
			current_slope = origin.slopeTo(this.points[i+1]);
			
			for (int j = i +1; j < this.points.length; j++) {
				
				//the point we are comparing to the current origin
				Point current_point = this.points[j];
				
				//if slope is the same and the current point is greater than the current origin, we found a collinear point for the current collinear segment
				if (origin.slopeTo(current_point) == current_slope && current_point.compareTo(origin) == +1) {

					collinear_points++;

					j++;
					}
				
				//if the slope order has changed, then the current collinear line segment has ended
				else if(origin.slopeTo(current_point) != current_slope) {
					
					if (collinear_points >= 4){

						
						segment = new LineSegment(origin, current_point); //grab endpoints of segment
						
						segments.add(segment); //add the segment
						
						segment = null; //reset segment
						
						collinear_points = 1; //reset collinear points

						current_slope = origin.slopeTo(current_point); //update the current slope

						//j++; dont think I need to update this. its updated in for loop
					
						}

						else {

						collinear_points = 1; //reset collinear points

						current_slope = origin.slopeTo(current_point);

						//j++; dont think I need to update this. its updated in for loop

						}
					
				}
			}
			
		}
		
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
