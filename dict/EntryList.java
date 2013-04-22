package dict;
import DList.*;

/**
 *  Wrapper class for DList.DList for Entry objects.
 *  This is a work-around because Java disallows the 
 *  use of arrays containing generic objects.
 **/
class EntryList extends DList<Entry> {

  /**
   *  find() tries to find a key within this entry list and 
   *  return its corresponding value. If the given key is not
   *  in this entry list, return null.
   *
   *  Running time: O(n), where n is the length of this entry list.
   *  @param key the key to look for.
   *  @return the value that corresponds with the given key.
   **/
  Object find(Object key) {
    for(Entry e:this) {
      if ((e.getKey()).equals(key)) {
        return e.getValue();
      }
    }
    return null;
  }

  /**
   *  remove() takes a key, finds it, and removes it from this entry list.
   *  If the given key is not in this entry list, nothing happens.
   *
   *  @param key the key of the entry to remove.
   **/
  void remove(Object key) {
    java.util.Iterator<Entry> i = this.iterator();
    //use this sytle of iteration to have access to DListIterator remove()
    while(i.hasNext()) {
      if((i.next()).getKey().equals(key)) {
        i.remove();
      }
    }
  }
}
