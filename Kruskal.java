/* Kruskal.java */

import graph.*;
import set.*;
import dict.*;
import DList.*;

/**
 * The Kruskal class contains the method minSpanTree(), which implements
 * Kruskal's algorithm for computing a minimum spanning tree of a graph.
 */

public class Kruskal {
  /**
   * minSpanTree() returns a WUGraph that represents the minimum spanning tree
   * of the WUGraph g.  The original WUGraph g is NOT changed.
   */
  public static WUGraph minSpanTree(WUGraph g) {
    //Create a graph with the same vertices as g.
    WUGraph out = new WUGraph();
    for (Object o:g.getVertices()){
      out.addVertex(o);
    }
    DList<EdgeWrapper> edges = getEdges(g.getVertices()[0],g,new Hashtable(g.vertexCount()),new DList<EdgeWrapper>());
    //TODO: implement implementation
    return null;
  }

  private static DList<EdgeWrapper> getEdges(Object curr, WUGraph g, Hashtable visited, DList<EdgeWrapper> out){
    //TODO: This is wrong.
    visited.insert(curr,"Alan Turing Lives.");
    Object[] neighbors=g.getNeighbors(curr).neighborList;
    for (int i = 0; i < neighbors.length; i++){
      if (visited.find(neighbors[i])==null){
        out.push(new EdgeWrapper(curr,neighbors[i],g.weight(curr,neighbors[i])));
      }
    }
    return out;
  }
  
}

class EdgeWrapper{
  Object v1;
  Object v2;
  int weight;
  public EdgeWrapper(Object v1, Object v2, int weight){
    this.v1=v1;
    this.v2=v2;
    this.weight=weight;
  }
}
