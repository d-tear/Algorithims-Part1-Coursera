

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

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
		if (FastCollinearPoints.isRepeated(points)) throw new IllegalArgumentException("All points must be unique!");
		
		
		this.points = points.clone();
		
		
		Arrays.sort(this.points);
				
			
		
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
	
	
	
	public int numberOfSegments() { // the number of line segments
	
		
		return segments().length;
	
	}
	

	
	public LineSegment[] segments() { // the line segments
		
		
		
		ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
		
		LineSegment segment = null; //use this to record the current line segment
		
		double current_slope = Double.NaN; // use this to record the current slope
		
		int collinear_points = 1;
		
		//for each point, treat it as the origin and sort the rest of the points by the slope they make with this point
		for (int i = 0; i < this.points.length; i++) {
			
			//remember in the constructor that we sorted our points by natural order
			//we need to clone these sorted points to ensure we don't traverse the same order of points twice once we sort by slope order
			//i.e. if I don't take this additional step, i end up with repeat line segments for some inputs
			Point [] natOrderpoints = this.points.clone();

			//make point i the "origin"
			Point origin = natOrderpoints[i];

			//sort the remaining points by the slope they make with the current origin
			Arrays.sort(natOrderpoints, origin.slopeOrder());
	
			
			
			for (int j = 1; j < natOrderpoints.length; j++) {
				
				//the point we are comparing to the current origin
				Point current_point = natOrderpoints[j];
				
				//
				current_slope = origin.slopeTo(natOrderpoints[j]);
				
				//if slope is the same and the current point is greater than the current origin, we found a collinear point for the current collinear segment
				if (origin.slopeTo(current_point) == current_slope && current_point.compareTo(origin) > 0) {

					collinear_points++;
					
					//end of inner loop with this origin
					if (j == natOrderpoints.length - 1) {
						
						if (collinear_points >= 4) {
						
						segment = new LineSegment(origin, natOrderpoints[j]); //grab endpoints of collinear segment. 
						
						segments.add(segment); //add the segment
						
						segment = null; //reset segment
						
						collinear_points = 1; //reset collinear points
					}
						
						else {
						segment = null; //reset segment
							
						collinear_points = 1; //reset collinear points
							
						}
						
					}

				
					}
				
				//if the slope order has changed, then the current collinear line segment has ended
				else if(origin.slopeTo(current_point) != current_slope) {
					
					//if we have at least 4 collinear points, we found a collinear segment
					if (collinear_points >= 4){

						
						segment = new LineSegment(origin, natOrderpoints[j-1]); //grab endpoints of collinear segment. j-1 because we need the previous current point
						
						segments.add(segment); //add the segment
						
						segment = null; //reset segment
						
						collinear_points = 1; //reset collinear points

						current_slope = origin.slopeTo(current_point); //update the current slope

						
					
						}
						
					//we don't have enough points for a collinear segment
						else {

						collinear_points = 1; //reset collinear points

						current_slope = origin.slopeTo(current_point); //update current slope

						

						}
					
				}
				
				
				
				
				//we've found a subsegment of a collinear segment we have already traversed. break and examine the next origin
				else if( origin.slopeTo(current_point) == current_slope && current_point.compareTo(origin) < 0){

					collinear_points = 1; //reset collinear points
					
					break;


				}
				
				
				
				
			}
			
			
			
		
			
		}
		
		
		
		
		//convert ArrayList to Array
		  LineSegment[] segs = new LineSegment[segments.size()];
		  
		  segs = segments.toArray(segs);
		  
		  return segs;
		
	
	
	}

	public static void main(String[] args) {
		
		
		
		
		Point a = new Point(0,0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 2);
        Point d = new Point(3, 3);
        Point e = new Point(4,4);
        
        
        
        
        Point[] points = new Point[] {a,b,c,d,e};
        

     // print and draw the line segments
        FastCollinearPoints fcp = new FastCollinearPoints(points);
        for (LineSegment segment : fcp.segments()) {
            StdOut.println(segment);
        }
        

	}

}
