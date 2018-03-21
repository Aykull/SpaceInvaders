package lists;
/**
 * 
 * @author lucia
 *
 * @param <T>
 */

public class SimpleLL <T extends Comparable<T>> {
	private Node<T> head;
	private int size;

	/**
	 * Constructor de la clase
	 */
	public SimpleLL() {
		head = null;
		size = 0;
	}
	
	public Node<T> getHead(){
		return head;
	}


	/**
	 * Método para agregar Nodo
	 * 
	 * @param data
	 * @return 
	 * 
	 */
	public boolean add(T data) {
		Node<T> node = new Node <T>(data);
		if (size == 0) {
			head = node;
			size++;
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		return true;
	}

	/**
	 * Metodo para mostrar el o los nodos
	 * 
	 */
	public void show() {
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
	 * Metodopara eliminar
	 * @param erase
	 */
	public void delete (T erase){
		if(head.getData()==erase) {
			head = head.getNext();
		}else {
			Node<T> current = this.head;
			while ( current != null) {
				if(current.getNext().getData()==erase) { 
				current.setNext(current.getNext().getNext());	
				break;
				}
			current= current.getNext();
			}
		}
	}
	


}
