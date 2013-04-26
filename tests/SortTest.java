package tests;

import sort.SortEdge;
import Constants.Constants;

public class SortTest{
  public static void main(String[] args){
    Integer[] ints = new Integer[10];
    for (int i=0; i<ints.length; i++){
      ints[i]=(int)Math.floor(Math.random()*1000);
    }
    SortEdge.sort(ints);
  }
}
