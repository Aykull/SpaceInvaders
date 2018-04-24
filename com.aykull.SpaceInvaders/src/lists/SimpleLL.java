package lists;





/**
 * 
 * @author lucia
 *
 * @param <T>
 */

public class SimpleLL <T>   {
	private Node<T> head;
	private int size;
	
	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

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
			size++;
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
	 * Metodo para eliminar
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
	
	public T getData(int data) {
		Node<T> temp = this.getHead();
		int i=0;
		while(i != data) {
			temp= temp.getNext();
			i++;
		}
		return temp.getData();
		
		 
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		this.setHead(null);
		this.setSize(0);
	
	}
	 public void deleteValue(int i)
	    {
	        if (this.isEmpty()) {
	            System.out.println("");
	        }else{
	            Node temp = this.head;
	            if (i == 0){
	                this.head=this.head.getNext();
	                size--;
	            }else if(i < size){
	                int j=0;
	                while((i-1)!=j){
	                    temp=temp.getNext();
	                    j++;
	                }
	                temp.setNext(temp.getNext().getNext());
	                this.size--;
	            }else{
	                System.out.println("");
	            }
	        }

	    }




}
