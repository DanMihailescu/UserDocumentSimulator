public class Node{
  int value;
  Node next;
  
  public Node(int info){
    value = info;
    next = null;
  }
  
  public Node(int info, Node n){
    value = info;
    next = n;
  }
}