/**
 *
 * An enhanced version of the homework version of DListNode, with generics.
 * Can act like a DEQUE using pushFront, pushBack, popFront, popBack, getFront, and getBack.
 * Can act like a Stack using push and pop.
 * Can act like a Queue using enqueue and dequeue.
 * Can act like a standard DList/SList using the ListIterator interface.
 *
**/

package DList;
import java.util.Iterator;

public class DList<T> implements Iterable<T>{

  protected DListNode<T> sentinel;
  protected int size;

  /**
   *
   * DList Constructor
   *
   */
  public DList(){
    this.sentinel = new DListNode<T>(null,null,null,this,true);
    this.sentinel.prev=this.sentinel;
    this.sentinel.next=this.sentinel;
    this.size=0;
  }

  public Iterator<T> iterator(){
    return new DListIterator<T>(this);
  }
  
  /**
   *  Figures out if the function is a boolean or not.
   *  @return a boolean stating if Dlist is empty or not.
   **/
  public boolean isEmpty() {
    return size == 0;
  }
        
  /**
   *  Pushes the object to th front.
   *  @param T is item being pushed to the front.
  **/ 
  public void pushFront(T item){
    this.sentinel.next = new DListNode<T>(item, this.sentinel, this.sentinel.next,this,false);
    this.sentinel.next.next.prev = this.sentinel.next;
    this.size++;
  }

  /**
   *  Pushes the object to the back.
   *  @param T is item being pushed to the back.
  **/
  public void pushBack(T item){
    this.sentinel.prev = new DListNode<T>(item, this.sentinel.prev, this.sentinel,this,false);
    this.sentinel.prev.prev.next = this.sentinel.prev;
    this.size++;
  }

  /**
   *  Short form of pushback.
   *  @param T is item being pushed to the back.
  **/
  public void push(T item){
    this.pushBack(item);
  }

  /**
   *  Pops the object from the front.
   *  @return T object being popped.
  **/
  public T popFront(){
    T out = this.sentinel.next.item();
    this.sentinel.next=this.sentinel.next.next;
    this.sentinel.next.prev=this.sentinel;
    this.size--;
    return out;
  }

    /**
   *  Pops the object from the back.
   *  @return T object being popped.
  **/
  public T popBack(){
    T out = this.sentinel.prev.item();
    this.sentinel.prev=this.sentinel.prev.prev;
    this.sentinel.prev.next=this.sentinel;
    this.size--;
    return out;
  }
        
  /**
   *  Pops the object in the back.
   *  @param T is item being pushed to the back.
  **/
  public T pop(){
    return this.popBack();
  }

  public void enqueue(T item){
    this.pushFront(item);
  }
  public T dequeue(){
    return this.popFront();
  }

  /**
   *  Gets the DListNode in the Front.
   *  @return DListNode in the front.
  **/
  public DListNode<T> getFront(){
    if (this.sentinel.next.isInvalid){
      return null;
    }
    return this.sentinel.next;
  }

  /**
   *  Gets the DListNode in the back.
   *  @return DListNode in the back.
  **/
  public DListNode<T> getBack(){
    if (this.sentinel.prev.isInvalid){
      return null;
    }
    return this.sentinel.prev;
  }

  /**
   *  Gets the item in a certain location.
   *  @param index is the position to select from.
   *  @return a T object at the index.
  **/
  public T getItem(int index){
    DListNode<T> curr;
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " exceeds the size of the list.");
    }
    if (index < size/2){
      curr = sentinel.next;
      while (index-- > 0){
        curr=curr.next;
      }
      return curr.item();
    }else{
      index=size-index-1;
      curr=sentinel.prev;
      while (index-- > 0){
        curr=curr.prev;
      }
      return curr.item();
    }
  }

  /**
   *  Appends two lists together.
   *  @param d is a DList being added to the front.
  **/
  public void appendFront(DList<T> d){
    d.sentinel.next.prev=this.sentinel;
    d.sentinel.prev.next=this.sentinel.next;
    this.sentinel.next.prev=d.sentinel.prev;
    this.sentinel.next=d.sentinel.next;
    this.size+=d.size;
    d.sentinel.next=d.sentinel;
    d.sentinel.next=d.sentinel;
    d.size=0;
  }
        
  /**
   *  Appends two lists together.
   *  @param d is a DList being added to the back.
  **/
  public void appendBack(DList<T> d){
    d.sentinel.prev.next=this.sentinel;
    d.sentinel.next.prev=this.sentinel.prev;
    this.sentinel.prev.next=d.sentinel.next;
    this.sentinel.prev=d.sentinel.prev;
    this.size+=d.size;
    d.sentinel.next=d.sentinel;
    d.sentinel.next=d.sentinel;
    d.size=0;
  }
        
  /**
   *  Appends two lists together.
   *  @param d is a DList being added to the back.
  **/
  public void append(DList<T> d){
    this.appendBack(d);
  }
        
  /**
   *  Returns length of DList.
   *  @return the size of the Dlist.
  **/
  public int length(){
    return this.size;
  }
        
  /**
   *  Returns the toString
   *  @return the string.
  **/
  public String toString(){
    DListNode<T> curr = sentinel.next;
    String out="[";
    while (!(curr.isInvalid)){
      out+=" "+curr.item().toString()+" ";
      curr=curr.next;
    }
    return out+"]";
  }

  public DListNode<T> front(){
    if (size==0){
      return null;
    }
    return sentinel.next();
  }
  public DListNode<T> back(){
    if (size==0){
      return null;
    }
    return sentinel.prev();
  }
}
