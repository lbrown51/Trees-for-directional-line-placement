import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;


public class testPlane extends JFrame {
	
	public testPlane() throws IOException{
		setTitle("Points");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Plane plane = new Plane();
        add(plane);
        setSize(500, 500);
        setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 	testPlane tp = new testPlane();
		 	tp.setVisible(true);
		 	
//		 	TreePrinter treePrint = new TreePrinter();
//		 	
//		 	Tree<String> tree = new Tree<String>();
//		 	
//		 	
//		 	Random rand = new Random();
//		 	
//		 	for (int i = 0; i<10; i++)
//		 		tree.insert(new Integer(rand.nextInt(100)).toString());
//		 	
//		 	
//		 	Node<String> root = tree.getRoot();
//		 	System.out.println("");
//		 	TreePrinter.printNode(root);
		 
	}
	
	

}
