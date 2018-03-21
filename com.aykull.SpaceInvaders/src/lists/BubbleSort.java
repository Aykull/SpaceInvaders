package lists;


public class BubbleSort <T extends Comparable <T>> {


	@SuppressWarnings("rawtypes")
	public static void bubbleSort(SimpleCL list ) {
		if (list.getSize() > 1) {
			for (int i = 0; i < list.getSize(); i++ ) {
				Node current = list.getHead();
				Node next = list.getHead().getNext();
				for (int j = 0; j < list.getSize() - 1; j++) {
					//hacer el comparable... da -1.0.+1
					if (current.getData().compareTo(next.getData()) == 0) {
					}
				}
			}
		}
		
	}
	void printList(int arr[])    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

	


}
