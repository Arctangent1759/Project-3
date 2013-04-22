package DList;
/**
 *
 *  A single node in the DList datastructure.
 *  Now with generics!
 *
**/
import Constants.Constants;

public class DListNode<T>{
  protected DListNode<T> prev;
  protected DListNode<T> next;
  protected T item;
  protected boolean isInvalid;
  protected DList<T> myList;

  /**
   *
   *  Constructs a DListNode.
   *  @param obj the object to be stored in this node
   *  @param prev the previous node
   *  @param next the next node
   *  @param isInvalid whether this node is the sentinel
   *
  **/
  public DListNode(T obj, DListNode<T> prev, DListNode<T> next, DList<T> myList, boolean isInvalid){
    this.prev=prev;
    this.next=next;
    this.item=obj;
    this.myList=myList;
    this.isInvalid=isInvalid;
  }
  public DListNode(T obj, DListNode<T> prev, DListNode<T> next, DList<T> myList){
    this(obj, prev, next, myList, false);
  }
  public boolean isInvalid(){
    return isInvalid;
  }

  /**
   *
   * Returns the item contained by this DListNode.
   * @return the item contained by this DListNode.
   *
  **/
  public T item(){
    if (this.isInvalid){
      throw new RuntimeException("item() called on Sentinel or invalid node.");
    }
    return item;
  }

  /**
   *
   *  Gets the next node.
   *  @return this node's previous node, or null if this is the sentinel node.
   *
  **/
  public DListNode<T> prev(){
    if (prev.isInvalid){
      return null;
    }
    return prev;
  }

  /**
   *
   *  Gets the previous node.
   *  @return this node's next node, or null if this is the sentinel node.
   *
  **/
  public DListNode<T> next(){
    if (next.isInvalid){
      return null;
    }
    return next;
  }

  public T remove(){
    if (this.isInvalid){
      throw new RuntimeException("remove() called on Sentinel or invalid node.");
    }
    this.myList.size--;
    this.next.prev=this.prev;
    this.prev.next=this.next;
    this.isInvalid=true;
    return item;
  }
}
