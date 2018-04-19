package lists;


public  class BubbleSort <T extends Comparable <T>> {

//clase que realiza el algoritmo de bubblesort
	@SuppressWarnings("rawtypes")
	public  void bubbleSort(SimpleCL list ) {

		if (list.getSize() > 1) {

			for (int i = 0; i < list.getSize(); i++ ) {

				Node <T> current = list.getHead();
				Node <T> next = list.getHead().getNext();
				for (int j = 0; j < list.getSize() - 1; j++) {

					if (current.getData().compareTo(next.getData()) == 1) {

						T temp = current.getData();
						current.setData(next.getData());
						next.setData(temp);

					} 

					current = next;
					next = next.getNext();   
				}
			}
		}
	}
}

