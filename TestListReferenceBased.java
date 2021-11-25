public class TestListReferenceBased{

  private Node head;
  private Node tail;
  
  public TestListReferenceBased(){
    head = null;
    tail = null;
  }
  
  public boolean isEmpty() {               //Determines if the linked list is empty
    if (head == null) return true;
    return false;
  }
  
  public int size(){                       //Gets size of the linked list
    int size = 1;
    for (Node n = this.head; n.next != null; n = n.next) size++;
    return size;
  }
    
  public void add(Object info) {               //Adds element to the end
    if (this.head == null) this.head = this.tail = new Node(info);
    else{ 
      this.tail.next = new Node(info);
      this.tail = this.tail.next;
    }
  }
  
  public void add(int value, int index) {    //Adds elements at index
    if (index == 0) {
      Node temp = this.head;
      this.head = new Node(value, temp);
    } else {
      Node current = this.get(index-1);
      Node newNode = new Node(value, current.next);
      current.next = newNode;
    }
  }
  
  public Node get(int index) {     //Gets node at index i
    Node current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }
  
  public void remove(int index) {        //Removes element at the index
    if (index == 0) {
      this.head = this.head.next;
    } 
    else {
      Node current = this.get(index-1);    //Gets node
      current.next = current.next.next;    //Removes node
    }
  } 
  
  public void removeAll(){                 //Sets head to null; making the entire linked list null
    this.head = null;
  }
  
  public String toString() {               //Turns list to a string to be printed
    String s = "";
    Node tmp = this.head;
    while (tmp != null) {
      s += tmp.value;
      if (tmp.next != null)
        s += ", ";
      tmp = tmp.next;
    }
    return s;
  }
  
  public static void main (String[] args) {
  
  //Create a linked list
  TestListReferenceBased list = new TestListReferenceBased();

  //Add some integers to rear of list
  list.add(12);
  list.add(3);
  list.add(25);
  list.add(18);
  int s = list.size();
  System.out.println(s + " Items in the linked list: " + list);
  
  //Add node at front
  list.add(13,0);
  s = list.size();
  System.out.println(s + " Items in the linked list: " + list);
  
  //Add node at index 2
  list.add(17,2);
  s = list.size();
  System.out.println(s + " Items in the linked list: " + list);
  
  //Removes node at index 4
  list.remove(4);
  s = list.size();
  System.out.println(s + " Items in the linked list: " + list);
  
  }
}