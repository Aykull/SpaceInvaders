package lists;
/**
 * 
 * @author lucia
 * Nodo para las listas enlazadas
 * 
 * @param <T>
 */

public class Node<T> {
	
	private Node<T> next;
	private Node<T> previous;
	private T data;
	
	public Node(T data) {
		this.data= data;
		this.next = null;
		this.previous = null;
	}

	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	
	
	

}
