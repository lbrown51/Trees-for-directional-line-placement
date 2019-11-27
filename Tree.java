import java.awt.Point;


public class Tree<T extends Comparable<T>> {
	private Node<T> root=null;
	
	
	
	
	public Node<T> getRoot(){
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	public boolean isEmpty(){
		return getRoot() == null;
	}
	
	public int size(Node<T> node){
		if(node == null)
			return 0;
		else
			return 1+ size(node.left) + size(node.right);
	}
	
	public T findMax() throws Exception
	{if (isEmpty()) throw new Exception();
	return findMin(getRoot()).data;
	}
	
	public void insert (T data ){

		setRoot(insert (data, getRoot()));
	}
	
	public void remove (T x)
	{
		setRoot(remove (x, getRoot()));
	}
	
	public void printTree()
	{
		if (isEmpty())
			System.out.println("Empty Tree");
		else
			printTree(getRoot());
	}
	
	private Node<T> findMin(Node<T> node){
		if(node == null)
			return null;
		else if(node.left == null)
			return node;
		return findMin(node.left);
	}
	
	private Node<T> insert (T  data, Node<T> node)
	{

		if (node == null)
			return new Node<T> (data);
		
		

		
		
		int compareResult = data.compareTo(node.data);

		if (compareResult < 0)
			node.left = insert(data, node.left);
		
		else if (compareResult > 0)
			node.right = insert (data,node.right );
		else
			;
		return node;
		
	}
	
	private Node<T> remove (T data, Node<T> node){
		if (node == null)
			return node;
		
		
		
		int compareResult = data.compareTo(node.data);
		
		if (compareResult < 0)
			node.left = remove(data, node.left);
		
		else if(compareResult > 0)
			node.right = remove(data,node.right);
		
		else if(node.left != null && node.right != null){
			node.data = findMin(node.right).data;
			node.right = remove(node.data, node.right);
		}
		
		else
			node = (node.left != null) ? node.left : node.right;
		
		return node;
		
	}
	
	private void printTree (Node<T> node){
		if (node!= null)
		{
			printTree(node.left);
			System.out.println(node.data);
			printTree(node.right);
		}
	}
	
	
	
}
