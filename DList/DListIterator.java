/**
 * An iterator for the DList class
**/
package DList;
import java.util.ListIterator;
import Constants.Constants;
public class DListIterator<T> implements ListIterator<T>{
  DListNode<T> curr;
  DList<T> list;
  int index;
  protected DListIterator(DList<T> list){
    this.curr=list.sentinel;
    this.list=list;
    this.index=-1;
  }
  public void add(T t){
    this.curr.next.prev=new DListNode<T>(t,this.curr,this.curr.next,list);
    this.curr.next=this.curr.next.prev;
    curr=curr.next;
    list.size++;
    index++;
  }
  public void set(T t){
    if (this.curr.isInvalid){
      throw new IllegalStateException("DListIterator.set called before DListIterator.next or DListIterator.prev");
    }
    this.curr.item=t;
  }
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
  public int previousIndex(){
    if (curr.isInvalid){
      return -1;
    }
    return index;
  }
  public int nextIndex(){
    return index+1;
  }
  public T previous(){
    if (curr.isInvalid){
      return null;
    }
    index--;
    curr=curr.prev;
    return curr.next.item;
  }
  public T next(){
    if (curr.next.isInvalid){
      return null;
    }
    index++;
    curr=curr.next;
    return curr.item;
  }
  public boolean hasPrevious(){
    return !curr.isInvalid;
  }
  public boolean hasNext(){
    return !curr.next.isInvalid;
  }
}
