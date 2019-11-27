import java.awt.Point;


public class Geometry {
	public int ccw(Point p0, Point p1, Point p2) {
		 double dx1 = p1.x - p0.x;
		 double dy1 = p1.y - p0.y;
		 double dx2 = p2.x - p0.x;
		 double dy2 = p2.y - p0.y;
		 if (dx1*dy2 > dy1*dx2) return 1;
		 else if (dx1*dy2 < dy1*dx2) return -1;
		 else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return -1;
		 else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return 1;
		 else return 0;
		}
	
	public String[] intersect(Point line1Start, Point line1End, Point line2Start,
			Point line2End){		
		if (line1Start.x == line1End.x || line2Start.x == line2End.x)
			if(line1Start.x == line1End.x &&  line2Start.x == line2End.x  && line1Start.x != line2Start.x)
				return new String[]{"false"};
			else if (line1Start.x == line1End.x &&  line2Start.x == line2End.x && line1Start.x != line2Start.x )
				return new String[]{"Overlap"};
			else if (line1Start.x == line1End.x ){
				
			} 
			else if (line2Start.x == line2End.x){
				
			}
		;
		double slope1 = 0;
		if ((line1End.x - line1Start.x) == 0){
			 slope1 = (line1End.y - line1Start.y)/(.00000000000000000000000000001);
			}
		else{
			 slope1 = (line1End.y - line1Start.y)/(line1End.x - line1Start.x);

		}
		
		double slope2 = 0;
		if ((line2End.x - line2Start.x) == 0){
			 slope2 = (line2End.y - line2Start.y)/(.00000000000000000000000000001);
			}
		else{
			 slope2 = (line2End.y - line2Start.y)/(line2End.x - line2Start.x);

		}
			
		
		
		double  intercept1 = line1Start.y - slope1*line1Start.x;
		
		double  intercept2 = line2Start.y - slope2*line2Start.x;
		
		if(slope1 == slope2)
			if(intercept1 == intercept2)
				if(line1Start.x <= line2Start.x || line2Start.x  <= line1End.x 
				|| line1Start.x <= line2End.x || line2End.x <= line1End.x  )
					return new String[]{"Overlap"};
				else;
			else
			return new String[] {"Parallel"};
		
		double x0 = ( intercept1- intercept2) / (slope2 - slope1);
		double y0 = slope2*x0 + intercept2;
		if (Math.min(line1Start.x,line1End.x) < x0
				&& Math.max(line1Start.x, line1End.x) > x0 
				&& Math.min(line2Start.x,line2End.x) < x0
				&& Math.max(line2Start.x, line2End.x) > x0)
			return new String[]{""+x0,""+y0};
					

		
		
		return new String[]{"false"};
	}
	
	
	
	
	
	
	

}


