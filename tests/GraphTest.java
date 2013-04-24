package tests;

import Constants.Constants;
import graph.WUGraph;
import graph.Neighbors;

public class GraphTest{
  public static void main(String[] args){
    WUGraph w = new WUGraph();
    w.addVertex(1);
    w.addVertex(2);
    w.addVertex(3);
    w.addEdge(2,1,0);
    Constants.print(w.isEdge(1,2));
    Constants.print(w.isEdge(2,1));
    Constants.print(w.isEdge(2,3));
    Constants.print(w.isEdge(3,2));
    Constants.print(w.isEdge(3,1));
    Constants.print(w.isEdge(1,3));
    Constants.print(w.edgeCount());
    w.addEdge(3,2,0);
    Constants.print(w.isEdge(1,2));
    Constants.print(w.isEdge(2,1));
    Constants.print(w.isEdge(2,3));
    Constants.print(w.isEdge(3,2));
    Constants.print(w.isEdge(3,1));
    Constants.print(w.isEdge(1,3));
    Constants.print(w.edgeCount());
    w.addEdge(1,3,0);
    Constants.print(w.isEdge(1,2));
    Constants.print(w.isEdge(2,1));
    Constants.print(w.isEdge(2,3));
    Constants.print(w.isEdge(3,2));
    Constants.print(w.isEdge(3,1));
    Constants.print(w.isEdge(1,3));
    Constants.print(w.edgeCount());
    Constants.print(w.degree(1));
    for (Object i:w.getVertices()){
      Constants.print(i);
    }
    for (Object i:w.getNeighbors(1).neighborList){
      Constants.print(i);
    }
    Constants.print(w.isVertex(7));
    Constants.print(w.isEdge(9,7));
    w.removeEdge(1,2);
    for (Object i:w.getNeighbors(1).neighborList){
      Constants.print(i);
    }
    Constants.print(w.isEdge(1,2));
    w.removeVertex(1);
    for (Object i:w.getVertices()){
      Constants.print(i);
    }
    w.removeEdge(2,3);
    Constants.print(w.getNeighbors(7));
    w.addEdge(3,2,1759);
    Constants.print(w.weight(2,3));

  }
}
