package DList;
import java.util.Iterator;

/**
 *  DList is an enhanced version of the homework version of DList, with generics.
 *  Can act like a DEQUE using pushFront, pushBack, popFront, popBack, getFront, and getBack.
 *  Can act like a Stack using push and pop.
 *  Can act like a Queue using enqueue and dequeue.
 *  Can act like a standard DList/SList using the ListIterator interface.
 **/
public class DList<T> implements Iterable<T>{

  /**
   *  Member Variables.
   *
   *  sentinel the head of this list which references the last and first items.
   *  size the size of this list.
   **/
  protected DListNode<T> sentinel;
  protected int size;

  /**
   *
   * DList constructor creates an empty DList.
   *
   **/
  public DList(){
    this.sentinel = new DListNode<T>(null,null,null,this,true);
    this.sentinel.prev=this.sentinel;
    this.sentinel.next=this.sentinel;
    this.size=0;
  }

  /**
   *  interator() creates an iterator for iterating over the 
   *  entries in this list.
   *
   *  @return an iterator for this DList.
   **/
  public Iterator<T> iterator(){
    return new DListIterator<T>(this);
  }
  
  /**
   *  isEmpty() indicates if this list is empty or not.
   *  Empty is defined as having no entries in this list.
   *
   *  @return whether this list is empty or not.
   **/
  public boolean isEmpty() {
    return size == 0;
  }
        
  /**
   *  pushFront() pushes an object onto the front of this list.
   *
   *  @param item the generic item being pushed to the front.
   **/ 
  public void pushFront(T item){
    this.sentinel.next = new DListNode<T>(item, this.sentinel, this.sentinel.next,this,false);
    this.sentinel.next.next.prev = this.sentinel.next;
    this.size++;
  }

  /**
   *  pushBack() pushes an object onto the back of this list.
   *
   *  @param item the generic item being pushed to the back.
   **/
  public void pushBack(T item){
    this.sentinel.prev = new DListNode<T>(item, this.sentinel.prev, this.sentinel,this,false);
    this.sentinel.prev.prev.next = this.sentinel.prev;
    this.size++;
  }

  /**
   *
   *  push() is an alias for pushback().
   *  This is so DList complies with a stack interface.
   *
   *  @param item the generic item being pushed to the back.
   *
   **/
  public void push(T item){
    this.pushFront(item);
  }

  /**
   *
   *  popFront() pops an object off the front of this list.
   *
   *  @return the generic item that is on the front of this list.
   *
   **/
  public T popFront(){
    T out = this.sentinel.next.item();
    this.sentinel.next=this.sentinel.next.next;
    this.sentinel.next.prev=this.sentinel;
    this.size--;
    return out;
  }

  /**
   *
   *  popBack() pops an object off the back of this list.
   *
   *  @return the generic item that is on the back of this list. 
   *
   **/
  public T popBack(){
    T out = this.sentinel.prev.item();
    this.sentinel.prev=this.sentinel.prev.prev;
    this.sentinel.prev.next=this.sentinel;
    this.size--;
    return out;
  }
        
  /**
   *
   *  pop() is an alias for popBack().
   *  This is so DList complies with a stack interface.
   *
   *  @return the generic item that is on the back of this list.
   *
   **/
  public T pop(){
    return this.popFront();
  }

  /**
   *
   *  enqueue() is an alias for pushFront().
   *  This is so DList complies with a queue interface.
   *
   *  @param item the generic item to add to the end of this list.
   *
   **/
  public void enqueue(T item){
    this.pushFront(item);
  }

  /**
   *
   *  dequeue() is an alias for popFront().
   *  This is so DList complies with a queue interface.
   *
   *  @return the generic item that is on the front of this list.
   *
   **/
  public T dequeue(){
    return this.popBack();
  }

  /**
   *
   *  getFront() gives the DListNode on the front of this list.
   *
   *  @return DListNode on the front of this list.
   *
   **/
  public DListNode<T> getFront(){
    if (this.sentinel.next.isInvalid){
      return null;
    }
    return this.sentinel.next;
  }

  /**
   *
   *  getBack() gives the DListNode on the back of this list.
   *
   *  @return DListNode on the back of this list.
   *
   **/
  public DListNode<T> getBack(){
    if (this.sentinel.prev.isInvalid){
      return null;
    }
    return this.sentinel.prev;
  }

  /**
   *
   *  getItem() gives the item at a given index.
   *
   *  @param index the position to select from.
   *  @return the generic object at the given index.
   *
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
    } else {
      index=size-index-1;
      curr=sentinel.prev;
      while (index-- > 0){
        curr=curr.prev;
      }
      return curr.item();
    }
  }

  /**
   *
   *  appendFront() appends two lists together.
   *
   *  @param d the DList being added to the front.
   *
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
   *
   *  appendBack() appends two lists together.
   *
   *  @param d the DList being added to the back.
   *
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
   *
   *  append() appends two lists together.
   *
   *  @param d is a DList being added to the back.
   *
   **/
  public void append(DList<T> d){
    this.appendBack(d);
  }
        
  /**
   *
   *  length() gives the length of this list
   *
   *  @return the size of this Dlist.
   *
   **/
  public int length(){
    return this.size;
  }
        
  /**
   *
   *  Returns the string representation of this DList.
   *  This follows the guidelines specified in the Java API.
   *
   *  @return the string representation of this list.
   *
   **/
  @Override
  public String toString(){
    DListNode<T> curr = sentinel.next;
    String out="[";
    while (!(curr.isInvalid)){
      out+=" "+curr.item().toString()+" ";
      curr=curr.next;
    }
    return out+"]";
  }

  /**
   *
   *  front() gives the DListNode at the front of this DList.
   *
   *  @return the DListNode at the front of this list.
   *
   **/
  public DListNode<T> front(){
    if (size==0){
      return null;
    }
    return sentinel.next();
  }

  /**
   *
   *  back() gives the DListNode at the back of this DList.
   *
   *  @return the DListNode at the back of this list.
   *
   **/
  public DListNode<T> back(){
    if (size==0){
      return null;
    }
    return sentinel.prev();
  }
}
