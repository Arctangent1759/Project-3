/**
 * An iterator for the DList class
**/
package DList;
import java.util.ListIterator;
import Constants.Constants;
public class DListIterator<T> implements ListIterator<T>{
  DListNode<T> curr;
  int index;
  protected DListIterator(DListNode<T> sentinel){
    this.curr=sentinel;
    this.index=-1;
  }
  public void add(T t){
    this.curr.next.prev=new DListNode<T>(t,this.curr,this.curr.next);
    this.curr.next=this.curr.next.prev;
    curr=curr.next;
    index++;
  }
  public void set(T t){
    if (this.curr.isSentinel){
      throw new IllegalStateException("DListIterator.set called before DListIterator.next or DListIterator.prev");
    }
    this.curr.item=t;
  }
  public void remove(){
    if (this.curr.isSentinel){
      throw new IllegalStateException("DListIterator.remove called before DListIterator.next or DListIterator.prev");
    }
    this.curr.next.prev=this.curr.prev;
    this.curr.prev.next=this.curr.next;
    this.curr=this.curr.prev;
    index--;
  }
  public int previousIndex(){
    if (curr.isSentinel){
      return -1;
    }
    return index;
  }
  public int nextIndex(){
    return index+1;
  }
  public T previous(){
    if (curr.isSentinel){
      return null;
    }
    index--;
    curr=curr.prev;
    return curr.next.item;
  }
  public T next(){
    if (curr.next.isSentinel){
      return null;
    }
    index++;
    curr=curr.next;
    return curr.item;
  }
  public boolean hasPrevious(){
    return !curr.isSentinel;
  }
  public boolean hasNext(){
    return !curr.next.isSentinel;
  }
}