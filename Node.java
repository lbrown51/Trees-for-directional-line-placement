
public class Node<T extends Comparable<T>> {
	T data;
	Node<T> parent;
	Node<T> left;
	Node<T> right;
	Node(T data)
	{
		this(data, null, null);

	}
	
	Node (T data, Node<T> left, Node<T> right){
		this.data = data; 
		this.left = left; 
		this.right = right;
	}
	

}
