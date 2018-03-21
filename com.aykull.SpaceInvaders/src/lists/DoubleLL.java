package lists;
/**
 * 
 * @author lucia
 *
 * @param <T>
 */

public class DoubleLL<T extends Comparable<T>> {
	
	private Node<T> head;
	private Node<T> tail;	
	private int size;
	/**
	 * Constructor
	 */
	public DoubleLL() {
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * Getters y setters
	 * @return
	 */
	public Node<T> getTail() {
		return tail;
	}
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setHead(Node<T> head) {
		this.head = head;
	}
	public Node<T> getHead(){

		return head;
	}
	
	/**
	 * Añadir nodo
	 * @param data
	 * @return
	 */
	public boolean addDLL( T data) {
		if(head ==null){
			Node<T> node = new Node<T>(data);{
				head=node;
				tail=node;
				head.setNext(null);
				head.setPrevious(null);
				tail.setNext(null);
				tail.setPrevious(null);
				
				}
				size++;
		}else{
			Node<T> node=new Node <T>(data);{
				tail.setNext(node);
				node.setNext(null);
				node.setPrevious(tail);
				tail = node;			
			}
		
		}
	return true;
    
	}
	/**
	 * Metodo para mostrar o imprimir el o los nodos
	 */
	public void showDLL() {
		int i = 0;
		if (size == 0) {
			System.out.println("Empty");
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				System.out.println("Node " + i + ": " + temp.getData());
				i++;
				temp = temp.getNext();
			}
			System.out.println("Node " + i + ": " + temp.getData());

		}
	}

	/**
	 * 
	 * @param erase
	 */
	public void delete (T erase){
		Node <T> temp;
		Node<T> current = this.head;
		if(head.getData()==erase) {
			temp = head.getNext();
			head=temp;
			temp.setPrevious(null);			
		}else if(tail.getData()==erase) {
			temp=tail.getPrevious();
			temp.setNext(null);
		}else {
			while (current != null) {	
				if(current.getNext().getData()==erase) {
					temp=current.getNext().getNext();
					current.setNext(temp);
					temp.setPrevious(current);
					break;
				}
				current= current.getNext();

			}

		}	
	}


}
