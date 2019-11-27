import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

import org.omg.CORBA.Current;

public class Plane extends JPanel implements MouseMotionListener, MouseListener{
	Tree<String> tree = new Tree<String>();
	double[] startX;
 	double[] startY;
 	double[] endX;
 	double[] endY;
	public Plane() throws IOException{
		
		try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/Brown/workspace/CSC172Project3/src/points.txt"))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	       
	        	
	        	 startX = new double[Integer.parseInt(line)];
        		 startY = new double[Integer.parseInt(line)];
        		 endX = new double[Integer.parseInt(line)];
        		 endY = new double[Integer.parseInt(line)];
        		 
	        	 for (int i = 0; i<= startX.length-1;i++){
	        		 line = br.readLine();
	        	
		        	String[] toDrawStrings = line.split(" ");
	 	        	startX[i] = Double.parseDouble(toDrawStrings[0])*500;
	 	        	startY[i] = 500-Double.parseDouble(toDrawStrings[1])*500;
	 	        	endX[i] = Double.parseDouble(toDrawStrings[2])*500;
	 	        	endY[i] = 500-Double.parseDouble(toDrawStrings[3])*500;
		        	

	        	 }
	        	 
	        	
	      
	        
	    }
		insert();
	}
	

	
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

		
        g2d.setColor(Color.blue);
        
        for (int i = 0; i<= startX.length-1;i++){
			g2d.drawLine((int)startX[i], (int)startY[i],(int) endX[i], (int)endY[i]);
        }
        
        
		
		
        Dimension size = getSize();
        Insets insets = getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

       
    }
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
        addMouseListener(this);
        
        //addMouseMotionListener(this);
        
    }


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		int x = e.getX();
		int y = e.getY();
		
		
		
		g2d.fillRect(x-3,y-4,4,4);
		g2d.drawString("(" + x +","+ y+")", x+8, y+8);		
		repaint();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	int pointsEntered = 0;
	int x = 0;
	int y = 0;

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		if (pointsEntered == 0){ 
		
		x = e.getX();
		y = e.getY();
		System.out.println(x);
		System.out.println(y);
		g2d.drawLine(x,y,x,y);
		pointsEntered +=1;
		}
		
		else{
			g2d.drawLine(e.getX(),e.getY(),x,y);
			pointsEntered = 0;
			x = 0;
			y = 0;
			
		}
	}

Geometry g = new Geometry();

	
	public void insert(){				
		int k = 0;
				
								tree.setRoot(new Node<String>((startX[k] + " " + startY[k] + 
									" " + endX[k] + " " + endY[k])));
								
								k++;
							
					
					Node<String> current = tree.getRoot();

					String[] currentNodeString = current.data.split(" ");
					double[] currentNode = new double[currentNodeString.length];
					for (int j = 0; j<currentNodeString.length; j++ ){
						currentNode[j] = Double.parseDouble(currentNodeString[j]);}
					
						insert(current,
							   new Point((int) currentNode[0],(int) currentNode[1]), 
							   new Point((int) currentNode[2], (int) currentNode[3]),
							   new Point((int)startX[k],(int)startY[k]),
							   new Point ((int) endX[k], (int)endY[k]));
						
					
						
				TreePrinter treePrint = new TreePrinter();
				TreePrinter.printNode(tree.getRoot());
			}
	
	
	
	
	private void insert(Node<String> current, Point line1Start, Point line1End, Point line2Start, Point line2End){
		
		String[] intersect = g.intersect(line1Start, line1End, line2Start, line2End);
		if (intersect.length == 1){
			System.out.println(intersect[0]);
			
			
				if (g.ccw(line2Start, line1Start, line1End) == -1){
					if (current.left == null){
						current.left = new Node<String>("" + line2Start.x + " " + line2Start.y
					+ " " + line2End.x + " " + line2End.y);}
				
					else{
						
						
					}
				}
				
				else if(g.ccw(line2Start, line1Start, line1End) == 1){
					if (current.right == null){
						current.right = new Node<String>("" + line2Start.x + " " + line2Start.y
								+ " " + line2End.x + " " + line2End.y);}
					else{
						
						
					}
					
				}
					
			
			else{
				
				

			}
		}
		
		
		else if(intersect.length ==2){
		System.out.println(intersect[0]);
		System.out.println(intersect[1]);
		Point line2_1End = new Point((int) Double.parseDouble(intersect[0])
				, (int) Double.parseDouble(intersect[1]));
		
		System.out.println(line2_1End);
		//insert(current, line1Start, line1End, line2_1End, line2End);		
		//insert(current, line1Start, line1End, line2Start, line2_1End);


		
		}
		
	}
		

//						k++;	
//
//						
//						int compareResult = data.compareTo(node.data);
//
//						if (compareResult < 0)
//							node.left = insert(data, node.left);
//						
//						else if (compareResult > 0)
//							node.right = insert (data,node.right );
//						else
//							;
//						return node;
				
		
			//(int)startX[i], (int)startY[i],(int) endX[i], (int)endY[i]);
	
	
	
	
	

	}
	
	
	    
    


