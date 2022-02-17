public class ArrayPriorityQueue
{
	private Player[] heap;
  private int capacity;
	private int size;
	private boolean min;

	public ArrayPriorityQueue(int capacity,boolean min)
	{
    this.capacity = capacity;
		heap = new Player[capacity+1];
		size = 0;
		this.min = min;
    	//assinging the heap[0] element according to the type of the heap
    	  if(min) {
      		Player player1 = new Player(-1,-9999999);
      		heap[0] = player1;
    		}
    		else {
      		Player player2 = new Player(-1,9999999);
      		heap[0] = player2;
    		}
	}
  //helper methods of the heap
  	private boolean hasParent(int i){return i > 0;}
  	private int leftIndex(int i){return i * 2;}
  	private int rightIndex(int i){return i * 2 + 1;}
  	private boolean hasLeftChild(int i){return leftIndex(i) <= size;}
  	private boolean hasRightChild(int i){return rightIndex(i) <= size;}
  	private int parentIndex(int i){return   i / 2;}
  	private Player parent(int i){return heap[parentIndex(i)];}
	
  //returns the heap array
	public Player[] getHeap()
	{
		return heap;
	}
  //function that arranges the maxIndex and minIndex a pleyer when we swap the players to keep track of the indexes
  public void arrangeIndexes(int index, int newIndex){
      if(heap[index] == null) {
          return;
        }
			if(min){
				heap[index].setMinIndex(newIndex);
			}else{
				heap[index].setMaxIndex(newIndex);
			}
		}
  //swaps the two elements at the given indexes
	private void swap(int index1, int index2)
	{
    arrangeIndexes(index1,index2);
    arrangeIndexes(index2,index1);
		Player temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
  //adds a player to the heap
	public void add(Player value)
	{
		size++;
		heap[size] = value;
		heapifyUp();
	}
  //removes the player at index i
  public void removeAtIndex(int i)
	{
		swap(i, size);
		heap[size] = null;
		size--;
		heapifyDown();
	}
  //polls a player 
	public Player poll()
	{
		Player result = peek();

		swap(1, size);
		heap[size] = null;
		size--;
		heapifyDown();
		return result;
	}
  //peeks the player
	public Player peek()
	{
		return heap[1];
	}
  //when a new player removed this function arranges the heap accordign to heap property from up to down
	public void heapifyDown()
	{
		int index = 1;
    //for min heap
		if (min) 
		{
			while (hasLeftChild(index))
			{
				int temp = leftIndex(index);
				if (hasRightChild(index) && heap[leftIndex(index)].points > heap[rightIndex(index)].points)
				{
					temp = rightIndex(index);
				}
				if (heap[index].points > heap[temp].points)
				{
					swap(index, temp);
				}
				else break;
				index = temp;
			}				
		} 
    //for max heap
		else 
		{
			while (hasLeftChild(index))
			{
				int temp = leftIndex(index);
				if (hasRightChild(index) && heap[leftIndex(index)].points < heap[rightIndex(index)].points)
				{
					temp = rightIndex(index);
				}
				if (heap[index].points < heap[temp].points)
				{
					swap(index, temp);
				}
				else break;
				index = temp;
			}				
		}
	}
	//when a new player added this function arranges the heap accordign to heap property from down to up
	public void heapifyUp()
	{
		int temp = size;
		if (min)
		{
			while (hasParent(temp) && parent(temp).points > heap[temp].points)
			{
				swap(temp, parentIndex(temp));
				temp = parentIndex(temp);
			}	
		}
		else
		{
			while (hasParent(temp) && parent(temp).points < heap[temp].points)
			{
				swap(temp, parentIndex(temp));
				temp = parentIndex(temp);
			}	
		}
	}
}