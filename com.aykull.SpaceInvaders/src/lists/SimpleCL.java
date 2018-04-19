package lists;

public class SimpleCL<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;	
	private int size;

	/**
	 * Get y Set
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * Constructor
	 */
	public SimpleCL() {
		head = null;
		tail =null;
		size = 0;
	}
	/**
	 * Getters y Setters
	 * @return
	 */
	public Node<T> getHead() {
		return head;
	}
	public void setHead(Node<T> head) {
		this.head = head;
	}
	public Node<T> getTail() {
		return tail;
	}
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	/**
	 * Metodo para añadir o crear
	 * @param data
	 */
	public void addSC( T data) {
		if(head == null){
			Node<T> node = new Node<T>(data);
			head=node;
			tail=node;
			tail.setNext(head);
			size++;
		}else{
			Node<T> node=new Node <T>(data);{
				tail.setNext(node);
				node.setNext(head);
				tail = node;
				size++;
			}
		}
	}
	/**
	 * Metodo que muestra la lista 
	 */
	public void showC() {
		int i = 0;
		if (size == 0) {
			System.out.println("Empty");
		} else {
			Node<T> temp = head;
			while (temp.getNext() != tail.getNext()) {
				System.out.println("Node " + i + ": " + temp.getData());
				i++;
				temp = temp.getNext();

			}
			System.out.println("Node " + i + ": " + temp.getData());
		}
	}

	/**
	 * Metodo para borrar
	 * @param erase
	 */

	public void delete (T erase){
		Node <T> temp;
		if(head.getData()==erase) {
			temp = head.getNext();
			head=temp;
			tail.setNext(head);
		}else {
			Node<T> current = this.head;
			Node <T> temp2;
			while (current.getNext() != tail.getNext()) {				
				if(current.getNext().getData()==erase) {
					temp2=current.getNext().getNext();
					current.setNext(temp2);
					break;
				} current = current.getNext();
			}
		}
	}
	

}

