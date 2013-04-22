package tests;

import Constants.*;
import dict.*;

public class HashtableTest {
  public static void insertFind() {
    Hashtable h = new Hashtable();
    for(int i=1;i<=1024;i=i<<1) {
      h.insert(i,i<<3);
      System.out.println("find "+i+": "+h.find(i));
    }
    System.out.println(h);
    System.out.println("collisions:"+h.getCollisions());
  }
  public static void invalidFind() {
    Hashtable h = new Hashtable();
    System.out.println("find(13) should be null: "+h.find(13));
    System.out.println("find(14) should be null: "+h.find(14));
    System.out.println("find(15) should be null: "+h.find(15));
  }
  public static void remove() {
    Hashtable h = new Hashtable();
    for(int i=1;i<1024;i=i<<1) {
      h.insert(i,i<<3);
      System.out.println("remove() "+i);
      h.remove(i);
    }
    System.out.println(h);
    System.out.println("collisions:"+h.getCollisions());
  }
  public static void invalidRemove() {
    Hashtable h = new Hashtable();
    h.remove(100);
    h.remove(101);
    h.remove(102);
    System.out.println(h);
  }
  public static void collisions(int entries) {
    Hashtable h = new Hashtable(entries);
    for(int i=0;i<entries;i++) {
      h.insert(Math.random(),i);
    }
    System.out.println(entries+" entries: collisions:"+h.getCollisions());
    System.out.println("loadFactor: "+h.getLoadFactor());
  }
  public static void overload() {
    Hashtable h = new Hashtable(1000);
    for(int i=0;i<2500;i++) {
      h.insert(Math.random(),i);
    }
    System.out.println("MAXLOAD:"+Constants.MAX_LOAD);
    System.out.println("loadFactor: "+h.getLoadFactor());
  }
  public static void main(String argv[]) {
    System.out.println("Hashtable tests");
    insertFind();
    invalidFind();
    remove();
    invalidRemove();
    collisions(1000);
    overload();
  }
}
