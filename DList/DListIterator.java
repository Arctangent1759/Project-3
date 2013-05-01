package DList;
/**
 *
 * An iterator for the DList class.
 * Allows easy for-looping
 *
**/
import java.util.ListIterator;
import Constants.Constants;
public class DListIterator<T> implements ListIterator<T>{
  DListNode<T> curr; //Pointer to the "current" node
  DList<T> list; //Pointer to the parent list
  int index; //Keeps track of the current index specified by the iterator

  /**
   *
   * Constructs a DListIterator of DList list.
   *
   * @param list some DList of generic type T
   *
   */
  protected DListIterator(DList<T> list){
    this.curr=list.sentinel;
    this.list=list;
    this.index=-1;
  }
  /**
   *
   * Adds item t after the current node.
   * Does not change the value of this.next(). 
   * Inserts t into curr's position, pushing curr back.
   *
   * @param t the generic object to be inserted
   *
   */
  public void add(T t){
    this.curr.next.prev=new DListNode<T>(t,this.curr,this.curr.next,list);
    this.curr.next=this.curr.next.prev;
    curr=curr.next;
    list.size++;
    index++;
  }
  /**
   *
   * Sets the value of te current node to t.
   *
   * @param t the generic object to set the current's node value to
   * @throws IllegalStateException if this.next() or this.prev() have not been called before invoking set.
   *
   */
  public void set(T t){
    if (this.curr.isInvalid){
      throw new IllegalStateException("DListIterator.set called before DListIterator.next or DListIterator.prev");
    }
    this.curr.item=t;
  }
 /**
   *
   * Removes the current node from the list.
   * Does not change the return value of this.next()
   *
   * @throws IllegalStateException if this.next() or this.prev() have not been called before invoking set.
   *
   */
 public void remove(){
    if (this.curr.isInvalid){
      throw new IllegalStateException("DListIterator.remove called before DListIterator.next or DListIterator.prev");
    }
    this.curr.next.prev=this.curr.prev;
    this.curr.prev.next=this.curr.next;
    this.curr=this.curr.prev;
    list.size--;
    index--;
  }

  /**
   *
   * Returns the previous index of the list.
   *
   * @return the previous index of the list, or -1 if the list bounds have been exceeded.
   *
   */
 public int previousIndex(){
    if (curr.isInvalid){
      return -1;
    }
    return index;
  }

  /**
   *
   * Returns the next index of the list.
   *
   * @return the next index of the list.
   *
   */
  public int nextIndex(){
    return index+1;
  }


  /**
   *
   * Returns the previous item of the list.
   *
   * @return the previous item of the list or null if the list bounds have been exceeded.
   *
   */
  public T previous(){
    if (curr.isInvalid){
      return null;
    }
    index--;
    curr=curr.prev;
    return curr.next.item;
  }
  /**
   *
   * Returns the next item of the list.
   *
   * @return the next item of the list or null if the list bounds have been exceeded.
   *
   */

  public T next(){
    if (curr.next.isInvalid){
      return null;
    }
    index++;
    curr=curr.next;
    return curr.item;
  }

  /**
   *
   * Returns whether or not the iterator has a previous item.
   *
   * @return true if there is a previous node, false otherwise
   *
   */
  public boolean hasPrevious(){
    return !curr.isInvalid;
  }

  /**
   *
   * Returns whether or not the iterator has a next item.
   *
   * @return true if there is a next node, false otherwise
   *
   */
  public boolean hasNext(){
    return !curr.next.isInvalid;
  }
}
