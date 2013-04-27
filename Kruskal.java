/* Kruskal.java */

import graph.*;
import set.*;
import dict.*;
import DList.*;
import Constants.*;
import sort.*;

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
    //Create a hashtable to map vertices to integers in the DisjointSets object
    Hashtable vertexToInt = new Hashtable(g.vertexCount());

    //Create a graph with the same vertices as g.
    WUGraph out = new WUGraph();
    Object[] vertices = g.getVertices();
    for (int i = 0; i < vertices.length; i++){
      out.addVertex(vertices[i]);
      vertexToInt.insert(vertices[i],i);
    }

    //Get and sort all the edges of g
    EdgeWrapper[] edges = getEdges(g);
    SortEdge.sort(edges);

    //Map the vertices of g to a DisjointSets object
    DisjointSets sets=new DisjointSets(vertices.length);
    for (EdgeWrapper edge:edges){
      int root1=sets.find((int)vertexToInt.find(edge.v1));
      int root2=sets.find((int)vertexToInt.find(edge.v2));
      if (root1!=root2){
        out.addEdge(edge.v1,edge.v2,edge.weight);
        sets.union(root1,root2);
      }
    }

    return out;
  }
 

  private static EdgeWrapper[] getEdges(WUGraph g){
    Object[] vertices = g.getVertices();  // list of vertices
    Hashtable visited = new Hashtable();  // list of visited edges
    EdgeWrapper[] edges = new EdgeWrapper[g.edgeCount()]; // list of edges to be returned
    int index = 0;
    for(Object v : vertices){
      Neighbors neighbors = g.getNeighbors(v);
      for(int i = 0; i < neighbors.neighborList.length; i++){
        EdgeWrapper curr = new EdgeWrapper(v,neighbors.neighborList[i], neighbors.weightList[i]); 
        // if the edge hasn't been visited, add it to the list
        if(visited.find(curr) == null){ 
          visited.insert(curr,neighbors.weightList[i]); 
          edges[index] = curr;
          index += 1;
        }
      }
    }
    return edges;
  }

  public static void main(String[] args){
    WUGraph w = new WUGraph();
    w.addVertex(1);
    w.addVertex(2);
    w.addVertex(3);
    w.addVertex(4);
    w.addEdge(4,3,4);
    w.addEdge(1,4,3);
    w.addEdge(1,3,2);
    w.addEdge(1,2,1);

    minSpanTree(w);
  }
}

class EdgeWrapper implements Comparable{
  public Object v1;
  public Object v2;
  public int weight;
  public EdgeWrapper(Object v1, Object v2, int weight){
    this.v1=v1;
    this.v2=v2;
    this.weight=weight;
  }
  public int hashCode() {
    if (v1.equals(v2)) {
      return v1.hashCode() + 1;
    } else {
      return v1.hashCode() + v2.hashCode();
    }   
  }

  /** 
   * equals() returns true if this VertexPair represents the same unordered
   * pair of objects as the parameter "o".  The order of the pair does not
   * affect the equality test, so (u, v) is found to be equal to (v, u).
   */
  public boolean equals(Object o) {
    if (o instanceof EdgeWrapper) {
      return ((v1.equals(((EdgeWrapper) o).v1)) &&
              (v2.equals(((EdgeWrapper) o).v2))) ||
             ((v1.equals(((EdgeWrapper) o).v2)) &&
              (v2.equals(((EdgeWrapper) o).v1)));
    } else {
      return false;
    }   
  }
  
  public int compareTo(Object c){
    if (((EdgeWrapper) c).weight==this.weight){
      return 0;
    }
    return (((EdgeWrapper) c).weight>this.weight)?-1:1;
  }
}
