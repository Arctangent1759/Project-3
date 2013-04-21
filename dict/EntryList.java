package dict;
import DList.DList;

/**
 *  Wrapper class for DList.DList for Entry objects.
 *  This is a work-around because Java disallows the 
 *  use of arrays containing generic objects.
 **/
class EntryList extends DList<Entry> {
  Object find(Object key) {
  }
}
