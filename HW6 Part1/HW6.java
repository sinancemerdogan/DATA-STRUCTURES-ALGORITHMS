 
// Class to represent entire hash table 
class HashMap
{ 	
    private BinarySearchTree bst; // the bst used to sort your elements
    private HashNode[] bucketArray; // the array to store the front of each LinkedList 
    private int numBuckets = 10; // the size of the array 
    private int size; // the total number of elements in the HashMap
    private int hashing; // defines which hashing function to use, since there are 2, can be either 0 or 1
    
    public HashMap(int hashing) 
    { 
    	this.hashing = hashing;
      bst = new BinarySearchTree();
      bucketArray = new HashNode[numBuckets];
      size = 0;
    } 
  
    public int size() { return size; } 
    
    public boolean isEmpty() { return size() == 0; } 
    //Returns the ID of a Student
    private int hashFirst(Student key) {
    	return key.id;
    }
    //Return sum of the ASCII value of first and last character of a Student's name and his/her id times GPA 
    private int hashSecond(Student key) {
      String string = key.name;
      char chatAtLast = string.charAt(string.length() - 1);
      char chatAtFirst = string.charAt(0);

      return (int) ((chatAtFirst + chatAtLast + key.id) * key.gpa);
    }
    //Returns the corresponding index of a Student using hash functions
    private int getBucketIndex(Student key) 
    {
	    if (hashing == 0) {
	      return hashFirst(key) % numBuckets;
	    } else if (hashing == 1) {
	      return hashSecond(key) % numBuckets;
	    } else {
	        return 0;
	    }
    }
    //Removes a Student from HashMap
    public Advisor remove(Student key) 
    {  
    	bst.delete(key);

    	int index = getBucketIndex(key);
      HashNode currentNode = bucketArray[index];

      if (currentNode != null && currentNode.key == key) {
        bucketArray[index] = currentNode.next;
        size--;
        return currentNode.value; 
      }
      HashNode previousNode = null;  
      while (currentNode != null && currentNode.key != key) { 
        previousNode = currentNode; 
        currentNode = currentNode.next; 
      }
      if(currentNode != null) {
        previousNode.next =  currentNode.next;
        size--;
        return currentNode.value;
      }
      return null; 
    } 
    //Returns the Advisor of a specified Student
    public Advisor get(Student key) 
    {
      int index = getBucketIndex(key);
      for (HashNode node = bucketArray[index]; node != null; node = node.next) {
        if(node.key == key) {
          return node.value;
        }
      }
      return null;   
    }
    //Check if the given Student is present in the HashMap
    public boolean isPresent(Student key) {

      int index = getBucketIndex(key);
      for (HashNode node = bucketArray[index]; node != null; node = node.next) {
        if(node.key.id == key.id) {
          return true;
        }
      }
      return false;  
    } 
    //Adds a Student to the HashMap 
    public void add(Student key, Advisor value) 
    {  
    	bst.add(key);

      if(!isPresent(key)) { 
        size++;
        HashNode hashNode = new HashNode(key,value);
        int index = getBucketIndex(key);

        if(bucketArray[index] == null) {
          bucketArray[index] = hashNode;
        }
        else {
          HashNode node = bucketArray[index];
          while(node.next != null) {
            node = node.next;
        }
          node.next = hashNode;
       }
     }
      return;
  }
  //Prints the sorted HashMap in terms of Students' IDs
	public void printSorted() {
      bst.printBst();
	}
}
public class HW6 {
    // Driver method to test Map class 
    public static void main(String[] args) 
    {
    	HashMap map = new HashMap(0); 
      map.add(new Student("Ahmet", 1, 3.91), new Advisor("Mehmet", "Mathematics")); 
      Student harry = new Student("Harry", 2, 3.22);
      Advisor dumbledore = new Advisor("Dumbledore", "Wizardy");
      map.add(harry, dumbledore); 
      map.add(new Student("Hermione", 3, 4.0), dumbledore); 
      map.printSorted(); 
      map.remove(harry); 
      map.add(new Student("Jesse", 4, 2.17), new Advisor("Walter White", "Chemistry")); 
      System.out.println(map.size()); 
      map.printSorted(); 
      System.out.println(map.isEmpty()); 
    } 
} 